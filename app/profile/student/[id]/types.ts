import { StaticImageData } from "next/image";


export interface StudentInfo {
    firstName: string;
    lastName: string;
    email: string;
    image: StaticImageData;
    bio: string;
    subjects: string[]; // Subjects the student is interested in
}
