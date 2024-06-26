"use client"
import Image, { StaticImageData } from "next/image";
import StudentProfilePic from "./anonpic.jpg";
import Link from "next/link";
import { getStudentInfo } from "@/utils/supabase/apiFunctions";
import { StudentInfo } from "./types";
import { Badge } from "@/components/ui/badge";

// interface Props {
//     params: {
//         id: string;
//     };
// }

// export default async function StudentProfilePage({ params }: Props) {
//     const studentId = params.id;

//     // Sample variable
//     const studentInfo: StudentInfo = {
//         firstName: "Jane",
//         lastName: "Doe",
//         email: "jane.doe@gmail.com",
//         image: StudentProfilePic,
//         bio: "Hi, I am Jane Doe. I'm a student seeking help in various subjects. I am particularly interested in Computer Science, Math, and Biology. I'm looking forward to learning more with the help of dedicated tutors.",
//         subjects: ["Computer Science", "Math", "Biology"],
//     }

//     // Get student info from API

//     return (
//         <div className="flex items-center w-full flex-col p-5">
//             <h1 className="text-4xl font-extrabold tracking-tight lg:text-5xl">{studentInfo.firstName} {studentInfo.lastName}</h1>
//             <div className="flex flex-wrap items-center justify-center">
//                 {studentInfo.subjects && studentInfo.subjects.map((subject, index) => (
//                     <Badge variant={"outline"} key={index} className="m-1">{subject}</Badge>
//                 ))}
//             </div>
//             <Link href={`mailto:${studentInfo.email}`} className="pt-2"><p className="text-blue-500">{studentInfo.email}</p></Link>
//             <Image src={studentInfo.image} alt="Profile Picture" width={200} height={200} />
//             {studentInfo.bio &&
//                 <div className="flex w-[60%] flex-col items-center">
//                     <p className="text-2xl font-extrabold tracking-tight lg:text-3xl">About Me</p>
//                     <p>{studentInfo.bio}</p>
//                 </div>
//             }
        
//         </div>
//     );
// }


import { useEffect, useState } from "react";

interface Props {
    params: {
        id: string;
    };
}

export default function StudentProfilePage({ params }: Props) {
    const studentId = params.id;
    const [studentInfo, setStudentInfo] = useState<StudentInfo | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getStudentInfo("1");//please modify this to use the actual data 
                if (response && response.ok) {
                    const data = await response.json();
                    setStudentInfo(data);
                } else {
                    throw new Error('Failed to fetch student info');
                }
            } catch (error) {
                console.error('Error fetching student info:', error);
            }
        };

        fetchData();
    }, []);


    return (
        <div className="flex items-center w-full flex-col p-5">
            <h1 className="text-4xl font-extrabold tracking-tight lg:text-5xl">
                {studentInfo ? `${studentInfo.firstName} ${studentInfo.lastName}` : "Student first name, last name is empty"}
            </h1>
            <div className="flex flex-wrap items-center justify-center">
                {studentInfo && studentInfo.subjects && studentInfo.subjects.map((subject, index) => (
                    <Badge variant={"outline"} key={index} className="m-1">{subject}</Badge>
                ))}
            </div>
            {studentInfo &&
                <>
                    <Link href={`mailto:${studentInfo.email}`} className="pt-2"><p className="text-blue-500">{studentInfo.email}</p></Link>
                    <Image src={StudentProfilePic} alt="Profile Picture" width={200} height={200} />
                    <div className="flex w-[60%] flex-col items-center">
                        <p className="text-2xl font-extrabold tracking-tight lg:text-3xl">About Me</p>
                        <p>{studentInfo.bio}</p>
                    </div>
                </>
            }
        </div>
    );
}
