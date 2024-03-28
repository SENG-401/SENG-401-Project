
// This file will be modified to fetch the actual stored posts from the data base, process it so that it can be displayed

interface Post {
    id: number;
    title: string;
    description: string;
    content: string;
  }

export const posts = [
    {
      id: 1,
      title: "MATH 211",
      description: "Ex-Prof offering math 211 tutoring",
      content: "Hi ! I offer math 211 tutoring as an ex-prof from University of MagicLand. Email me at: temp@temp.com",
    },
    {
      id: 2,
      title: "ENME 589",
      description: "Electrical Engg Tutor offering electrical courses tutoring.",
      content: "I am an electrical engineer of 30 years, I offer tutoring services. Email me at new@gmail.com",
    },
    {
      id: 3,
      title: "CPSC 357",
      description: "Tutoring for the most complicated comp sci courses!",
      content: "I am offering tutoring services for any comp sci related courses, please hit me up at prof@gmail.com",
    },
    {
        id: 4,
        title: "SENG 256",
        description: "seng 256 tutoring",
        content: "Email me at hotmail@gmail.com for more info",
    },
    {
        id: 5,
        title: "CHEM 377",
        description: "Chemistry tutoring of all kinds available!",
        content: "Our tutoring services for chemistry and science related courses are top of the line! email us at chem@gmail.com",
    },
  ];
