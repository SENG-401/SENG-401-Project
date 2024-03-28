"use client"
import ReviewProfessorForm from "./ReviewProfessorForm";
import { getTutorInfo } from "@/utils/supabase/apiFunctions";
// Get tutor Name from Backend

// export default async function Page() {
//     return (
//         <div className="flex flex-col items-center  justify-center m-3">
//             <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl m-2">Review *Tutor Name*</h1>
//             <div className="min-w-[50vw]">
//                 <ReviewProfessorForm />
//             </div>
//         </div>
//     );
// }
import { useEffect, useState } from 'react';

export default function Page() {
    const [tutorName, setTutorName] = useState<string>("no name found");

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getTutorInfo("1");//please modify this so that it uses the correct ID needed for a successfull api call
                if (response && response.ok) {
                    const tutorInfo = await response.json();
                    if (tutorInfo.firstName && tutorInfo.lastName) {
                        setTutorName(`${tutorInfo.firstName} ${tutorInfo.lastName}`);
                    }
                } else {
                    throw new Error('Failed to fetch tutor info');
                }
            } catch (error) {
                console.error('Error fetching tutor info:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div className="flex flex-col items-center  justify-center m-3">
            <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl m-2">Review {tutorName}</h1>
            <div className="min-w-[50vw]">
                <ReviewProfessorForm />
            </div>
        </div>
    );
}