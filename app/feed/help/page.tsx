import ProfileForm from "./HelpForm";

export default async function Help() {
    return (
        <div className="flex flex-col items-center w-full">
            <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl">Help</h1>
            <div className="w-[40vw] pt-5">
                <ProfileForm />
            </div>
        </div>
    )
}