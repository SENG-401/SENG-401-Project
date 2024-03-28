"use client";

import { ScrollArea } from "@radix-ui/react-scroll-area";
import { Separator } from "@radix-ui/react-separator";

import Calendar from "@/public/icons/calendar/calendar-100.png";
import Help from "@/public/icons/help/help-100.png";
import Teach from "@/public/icons/teach/teach-100.png";
import Student from "@/public/icons/student/student-100.png";
import Tutor from "@/public/icons/tutor/tutor-100.png";

import Image from "next/image";

import { usePathname } from "next/navigation";
import Link from "next/link";

import { cn } from "@/lib/utils";

export default function SideArea() {

    const pathname = usePathname();
    

    return (
        <ScrollArea className="min-h-[calc(100vh-60px)]  h-full overflow-scroll w-[18rem] rounded-md border fixed">
            <div>
                <Link href={"/feed/help"}>
                    <div className={cn("flex items-center justify-between p-2", {
                        "bg-primary": pathname === "/feed/help"
                    })}>
                        <Image src={Help} alt="help" className="w-14"/>
                        <p className="leading-7">Get Help</p>
                    </div>
                </Link>
                <Separator className="border-spacing-1 border-b border-gray-200" />
                <Link href={"/feed/teach"}>
                    <div className={cn("flex items-center justify-between p-2", {
                        "bg-primary": pathname === "/feed/teach"
                    })}>
                        <Image src={Teach} alt="teach" className="w-14" />
                        <p className="leading-7">Help Someone</p>
                    </div>
                </Link>
                <Separator className="border-spacing-1 border-b border-gray-200" />
                <Link href={"/feed/student-posts"}>
                    <div className={cn("flex items-center justify-between p-2", {
                        "bg-primary": pathname === "/feed/student-posts"
                    })}>
                        <Image src={Student} alt="calendar" className="w-14" />
                        <p className="leading-7">Student Posts</p>
                    </div>
                </Link>
                <Separator className="border-spacing-1 border-b border-gray-200" />
                <Link href={"/feed/tutor-posts"}>
                    <div className={cn("flex items-center justify-between p-2", {
                        "bg-primary": pathname === "/feed/tutor-posts"
                    })}>
                        <Image src={Tutor} alt="calendar" className="w-14" />
                        <p className="leading-7">Tutor Posts</p>
                    </div>
                </Link>
            </div>
        </ScrollArea>
    )
}