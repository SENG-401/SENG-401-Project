import Hero from "@/components/home/Hero";
import WalkThrough from "@/components/home/WalkThrough";
import Image from "next/image";

export default function Home() {
	return (
		<main className="">
			<div className="">
				<Hero />
				<WalkThrough />
			</div>
		</main>
	);
}
