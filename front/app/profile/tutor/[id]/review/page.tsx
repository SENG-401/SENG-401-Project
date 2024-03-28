import ReviewProfessorForm from "./ReviewProfessorForm";

// Get tutor Name from Backend

export default async function Page() {
    return (
        <div className="flex flex-col items-center  justify-center m-3">
            <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl m-2">Review *Tutor Name*</h1>
            <div className="min-w-[50vw]">
                <ReviewProfessorForm />
            </div>
        </div>
    );
}