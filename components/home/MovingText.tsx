"use client";

import { TypeAnimation } from "react-type-animation";

export default function MovingText() {
    return (
        <TypeAnimation 
                sequence={[
                    'Find',
                    1500,
                    'Become',
                    1500,
                  ]}
                speed={50}
                className=" "
                repeat={Infinity}
        />
    )
}