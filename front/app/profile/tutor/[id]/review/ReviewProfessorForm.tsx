"use client"

import React from "react";
// import { Input, Textarea, Button } from "./ui-components"; 

import Link from "next/link"
import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
 
import { Button } from "@/components/ui/button"
import {
	Form,
	FormControl,
	FormDescription,
	FormField,
	FormItem,
	FormLabel,
	FormMessage,
} from "@/components/ui/form"
import {
	Select,
	SelectContent,
	SelectItem,
	SelectTrigger,
	SelectValue,
} from "@/components/ui/select"

import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea";


const formSchema = z.
    object({
        review: z.string().min(20, "Review must be at least 20 characters long."),
		rating: z.string({
			required_error: "Please select an email to display.",
		  })
    })

export default function ReviewProfessorForm() {
	const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        
    });

	function onSubmit(values: z.infer<typeof formSchema>) {
        // Do something with the form values.
        // ✅ This will be type-safe and validated.

		//TODO: Send values to API
        console.log(values)
    };

	return (
		<Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8 w-full">
                <div>
					<FormField
					control={form.control}
					name="rating"
					render={({ field }) => (
						// <div>
							<FormItem>
								<FormLabel>Rating</FormLabel>
								<Select onValueChange={field.onChange}>
									<FormControl>
										<SelectTrigger>
											<SelectValue placeholder="Select a rating" />
										</SelectTrigger>
									</FormControl>
									<SelectContent>
										<SelectItem value="1">1</SelectItem>
										<SelectItem value="2">2</SelectItem>
										<SelectItem value="3">3</SelectItem>
										<SelectItem value="4">4</SelectItem>
										<SelectItem value="5">5</SelectItem>
									</SelectContent>
								</Select>
								<FormMessage />
							</FormItem>
						// </div>
					)}
					/>
                </div>
                <FormField
                    control={form.control}
                    name="review"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Bio</FormLabel>
                            <FormControl>
                                <Textarea className="min-h-[150px]"{...field} />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <div className="flex justify-center">
                    <Button type="submit">Submit</Button>
                </div>
            </form>
        </Form>
	);	
}
