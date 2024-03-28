import Link from "next/link";
import { Button } from "@/components/ui/button";


export default function StudentHomePage() {
    return (
        <div className="h-screen flex flex-col justify-top items-center">
            <div className="h-[60px] z-50 w-full bg-white flex justify-center items-center px-4 text-primary fixed border-b border-gray-200">
                <h1 className="text-2xl font-bold">Welcome To the Student Home Page</h1>
            </div>
            <div className="flex-grow flex flex-col justify-center items-center">
                <div className="mb-4">Please Make a Selection</div>
                <div className="flex flex-row items-center space-x-10"> 
                    <Link href={"/posts"}>
                        <Button variant="default" size="default" className="bg-primary text-primary-foreground hover:bg-primary/90">
                            Go to Posts 
                        </Button>
                    </Link>
                    <Link href={"/"}>
                        <Button variant="default" size="default" className="bg-primary text-primary-foreground hover:bg-primary/90">
                            Rate a Prof
                        </Button>
                    </Link>
                    <Link href={"/"}>
                        <Button variant="default" size="default" className="bg-primary text-primary-foreground hover:bg-primary/90">
                            Modify Profile
                        </Button>
                    </Link>
                    <Link href={"/"}>
                        <Button variant="default" size="default" className="bg-primary text-primary-foreground hover:bg-primary/90">
                            Message a Tutor
                        </Button>
                    </Link>
                </div>
            </div>
        </div>
    );
}
