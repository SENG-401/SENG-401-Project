import Image, { StaticImageData } from "next/image";
import Profile from "@/public/icons/profile.jpg"
import Link from "next/link";

import { TutorInfo } from "@/lib/types"

import { Badge } from "@/components/ui/badge"


interface Props {
    params: {
        id: string
    }
}

export default async function Page({ params }: Props) {

    const tutorId = params.id;

    // Sample variable
    const tutorInfo: TutorInfo = {
        firstName: "John",
        lastName: "Doe",
        email: "john.doe@gmail.com",
        image: Profile,
        bio: "Hi, I am Joe Doe. I am a tutor at XYZ. I have been teaching for 5 years. I have a degree in Computer Science. I am passionate about teaching and helping students. I am available for tutoring on weekdays and weekends. I am also available for online tutoring. I am looking forward to helping you.",
        tags: ["Computer Science", "Math", "Physics", "Chemistry", "Biology"]
    }

    // Get tutor info from API

    return (
        <div className="flex items-center w-full flex-col p-5">
            <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl">{tutorInfo.firstName} {tutorInfo.lastName}</h1>
            {/* <p>Tutor ID: {tutorId}</p> This is just for testing */}
            <div className="flex flex-wrap items-center justify-center">
                {tutorInfo.tags && tutorInfo.tags.map((tag, index) => (
                    <Badge variant={"outline"} key={index} className="m-1">{tag}</Badge>
                ))}
            </div>
            <Link href={`mailto:${tutorInfo.email}`} className="pt-2"><p className="text-blue-500">{tutorInfo.email}</p></Link>
            <Image src={tutorInfo.image} alt="Profile Picture" width={200} height={200} />
            {tutorInfo.bio &&
                <div className="flex w-[60%] flex-col items-center">
                    <p className="scroll-m-20 text-2xl font-extrabold tracking-tight lg:text-3xl">About Me</p>
                    <p>{tutorInfo.bio}</p>
                </div> 
            }

        </div>
    )
}