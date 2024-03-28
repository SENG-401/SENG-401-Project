"use client"

import Link from "next/link"
import { zodResolver } from "@hookform/resolvers/zod"
import { useFieldArray, useForm } from "react-hook-form"
import { z } from "zod"

import { cn } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage 
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue, }
from "@/components/ui/select"

import { Textarea } from "@/components/ui/textarea"

import { useToast } from "@/components/ui/use-toast"


const profileFormSchema = z.object({
    title: z
        .string()
        .min(5, {
        message: "Title must be at least 2 characters.",
        })
        .max(30, {
        message: "Title must not be longer than 30 characters.",
        }),
    message: z
        .string({
        required_error: "Please select an email to display.",
        }),
    bio: z.string().max(160).min(4),
    urls: z
        .array(
        z.object({
            value: z.string().url({ message: "Please enter a valid URL." }),
        })
        )
        .optional(),
})

type ProfileFormValues = z.infer<typeof profileFormSchema>

// This can come from your database or API.
const defaultValues: Partial<ProfileFormValues> = {

}

export default function ProfileForm() {
    const form = useForm<ProfileFormValues>({
        resolver: zodResolver(profileFormSchema),
        defaultValues,
        mode: "onChange",
    })

    function onSubmit(data: ProfileFormValues) {
        console.log(data)
    }

    return (
        <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
            <FormField
            control={form.control}
            name="title"
            render={({ field }) => (
                <FormItem>
                <FormLabel>Title</FormLabel>
                <FormControl>
                    <Input placeholder="Ex: Experienced Tutor for Calc I & II" {...field} />
                </FormControl>
                <FormMessage />
                </FormItem>
            )}
            />
            <FormField
            control={form.control}
            name="message"
            render={({ field }) => (
                <FormItem>
                    <FormLabel>Message</FormLabel>
                    <FormControl>
                        <Textarea
                        placeholder="Give a brief description of your services."
                        className="resize-none"
                        {...field}
                        />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            )}
            />
            <Button type="submit">Make Post</Button>
        </form>
        </Form>
    )
}