import { Button } from "../ui/button";
import MovingText from "./MovingText";
import Link from "next/link";

export default async function Hero() {
    return (
       <div className="flex flex-col justify-center items-center h-[100vh] [&>*]:m-1">
            <h1 className="scroll-m-20 text-5xl font-extrabold tracking-tight lg:text-7xl">UTutor</h1>
            <div className="flex flex-row">
            <MovingText /> <p>a Tutor</p>
            </div>
            <Link href="/feed">
                <Button size={"default"}>Get Started</Button>
            </Link>
            <Link href="/student-home-page">
                <Button size={"default"}>Go to student home page</Button>
            </Link>
       </div>
    )
}