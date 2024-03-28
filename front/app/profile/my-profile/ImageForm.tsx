"use client";

import Image from "next/image"

import { Button } from "@/components/ui/button"
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"

import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"

interface Props {
    imageData: any
}

export default function ImageForm({ imageData }: Props) {

    async function handleClick() {
        // Do something with the form values.
        // ✅ This will be type-safe and validated.

        // Get 'link' data
        const link = document.getElementById("link") as HTMLInputElement
        console.log(link.value)

        //TODO: Send 'link' data to backend
    }
    return (
        <div>
            <div className="flex justify-center">
                <Image src={imageData} alt="Profile Picture" width={200} height={200} />
            </div>
            <Dialog>
                <DialogTrigger asChild>
                    <div className="flex justify-center">
                        <Button>Change Image</Button>
                    </div>
                </DialogTrigger>
                <DialogContent className="sm:max-w-md">
                    <DialogHeader>
                        <DialogTitle>Change Icon</DialogTitle>
                        <DialogDescription>
                            Anyone will be able to see your image.
                        </DialogDescription>
                    </DialogHeader>
                    <div className="flex items-center space-x-2">
                        <div className="grid flex-1 gap-2">
                            <Label htmlFor="link" className="sr-only">
                            Link
                            </Label>
                            <Input
                            id="link"
                            defaultValue={imageData}
                            />
                        </div>
                        <Button type="submit" size="sm" className="px-3" onClick={handleClick}>
                            Submit
                        </Button>
                    </div>
                    <DialogFooter className="sm:justify-start">
                    <DialogClose asChild>
                        <Button type="button" variant="secondary">
                        Close
                        </Button>
                    </DialogClose>
                    </DialogFooter>
                </DialogContent>
            </Dialog>
        </div>
    )
}