import Link from "next/link";
import { Button } from "./ui/button";
import AuthButton from "./AuthButton";

export default async function NavBar() {
    return (
        <div className="h-[60px] z-50 w-full bg-white flex justify-between items-center px-4 text-primary fixed border-b border-gray-200">
            <div>
                <Link href={"/"}>
                    <h1 className="text-2xl font-bold">UTutor</h1>
                </Link>
                
            </div>
            
            <div>
                {/* <Link href={"/login"}> */}
                    {/* <Button className="text-black" variant={"outline"}>Log In</Button> */}
                    <AuthButton />
                {/* </Link> */}
            </div>
        </div>
    )
   
}