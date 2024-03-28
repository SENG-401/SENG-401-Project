import { Card, CardHeader, CardTitle, CardDescription, CardContent, CardFooter } from "@/components/ui/card";
import { posts } from "@/lib/posts";

export default function CardsPage() {
  return (
    <div className="flex flex-col justify-center items-center space-y-4 h-full overflow-y-auto">
            <h1 className="scroll-m-20 text-4xl font-extrabold tracking-tight lg:text-5xl">Student Posts</h1>
      {posts.map((card) => (
        <Card key={card.id} className="w-full max-w-md">
          <CardHeader>
            <CardTitle>{card.title}</CardTitle>
            <CardDescription>{card.description}</CardDescription>
          </CardHeader>
          <CardContent>
            <p>{card.content}</p>
          </CardContent>
          <CardFooter>
            <p>Can populate this with more stuff.</p>
          </CardFooter>
        </Card>
      ))}
    </div>
  );
}
