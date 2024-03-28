"use client"
import Profile from "@/public/icons/profile.jpg"
import { TutorInfo } from "@/lib/types"

import { Button } from "@/components/ui/button"

import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
  } from "@/components/ui/card"

// import ProfileForm from "./Form"

// import ImageForm from "./ImageForm"
import { getTutorInfo } from "@/utils/supabase/apiFunctions"

// export default async function Page() {

//     await getTutorInfo("1234");
//     const tutorInfo: TutorInfo = {
//         firstName: "John",
//         lastName: "Doe",
//         email: "john.doe@gmail.com",
//         image: Profile,
//         bio: "Hi, I am Joe Doe. I am a tutor at XYZ. I have been teaching for 5 years. I have a degree in Computer Science. I am passionate about teaching and helping students. I am available for tutoring on weekdays and weekends. I am also available for online tutoring. I am looking forward to helping you.",
//         tags: ["Computer Science", "Math", "Physics", "Chemistry", "Biology"]
//     }


//     return(
//         <div className="flex items-center justify-center w-full flex-col p-5 min-h-[calc(100vh-60px)]">
//             <Card className="shadow-xl min-w-[300px] w-[75%]"> 
//                 <CardHeader className="text-center">
//                     <CardTitle>Profile</CardTitle>
//                     <CardDescription>
//                         Edit your profile here.
//                     </CardDescription>
//                 </CardHeader>
//                 <div className="flex flex-col sm:flex-col md:flex-row lg:flex-row justify-around">
//                     <CardContent className="">
//                         <ProfileForm data={tutorInfo!}/>
//                     </CardContent>
//                     <CardContent>
//                         <ImageForm imageData={tutorInfo.image}/>
//                     </CardContent>
//                 </div>
//             </Card>
//         </div>
//     )
// }
import { useState, useEffect } from 'react';
// import { TutorInfo } from "@/lib/types";
// import { getTutorInfo } from "@/lib/api";
import ProfileForm from "./Form";
import ImageForm from "./ImageForm";

export default function Page() {
    const [tutorInfo, setTutorInfo] = useState<TutorInfo | null>(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getTutorInfo("1234");//PLEASE MODIFY THIS TO USE ACTUAL VALUES NOT 1234
                if (!response || !response.ok) {
                    throw new Error('Failed to fetch tutor info');
                }
                const data = await response.json();
                setTutorInfo(data);
            } catch (error) {
                console.error('Error fetching tutor info:', error);
            }
        };
    
        fetchData();
    }, []);

    if (!tutorInfo) {
        return <div>No Tutor Info to fetch...</div>;
    }

    return (//This may need modifiyng i dont think its working with the lines 96 and 99
        <div className="flex items-center justify-center w-full flex-col p-5 min-h-[calc(100vh-60px)]">
            <Card className="shadow-xl min-w-[300px] w-[75%]">
                <CardHeader className="text-center">
                    <CardTitle>Profile</CardTitle>
                    <CardDescription>
                        Edit your profile here.
                    </CardDescription>
                </CardHeader>
                <div className="flex flex-col sm:flex-col md:flex-row lg:flex-row justify-around">
                    <CardContent className="">
                        <ProfileForm data={tutorInfo}/>
                    </CardContent>
                    <CardContent>
                        <ImageForm imageData={tutorInfo.image}/>
                    </CardContent>
                </div>
            </Card>
        </div>
    );
}
