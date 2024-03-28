import { Button } from "@/components/ui/button"
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import {
  Tabs,
  TabsContent,
  TabsList,
  TabsTrigger,
} from "@/components/ui/tabs"
import LoginForm from "./LoginForm"
import RegisterForm from "./RegisterForm"
 
export default function TabsDemo() {

	return (
		<div className="mt-10 flex flex-col items-center">
			<Tabs defaultValue="login" className="w-[400px]">
				<TabsList className="grid w-full grid-cols-2">
					<TabsTrigger value="login">Login</TabsTrigger>
					<TabsTrigger value="register">Register</TabsTrigger>
				</TabsList>
				<TabsContent value="login">
					<Card>
						<CardHeader>
							<CardTitle>Login</CardTitle>
							<CardDescription>
							Sign Into your account here.
							</CardDescription>
						</CardHeader>
						<CardContent className="space-y-2">
							<LoginForm />
						</CardContent>
					</Card>
				</TabsContent>
				<TabsContent value="register">
					<Card>
						<CardHeader>
							<CardTitle>Register</CardTitle>
							<CardDescription>
							To create an account, fill in the form below.
							</CardDescription>
						</CardHeader>
						<CardContent className="space-y-2">
							<RegisterForm />
						</CardContent>
					</Card>
				</TabsContent>
			</Tabs>
		</div>
	)
}