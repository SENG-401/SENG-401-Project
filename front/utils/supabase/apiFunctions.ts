export async function postUserRegistration(firstName : string, lastName : string, email : string, password: string) {
    let response;
    try {
      
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                "firstName": firstName,
                "lastName": lastName,
                "email": email,
                "password": password,
                "isTutor": "true",
                "isStudent": "false"
            }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in post user registration request:', error);
    }
};

export async function postUserLogin(email : string, password: string) {
    let response;
    try {
     
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                "email": email,
                "password": password,     
            }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in post user login:', error);
    }
};


export async function getTutorInfo(id: any) {
    let response;
    try {
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/tutor?id=${id}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            // body: JSON.stringify({
            //    
            // }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in get tutor info:', error);
    }
};

export async function getStudentInfo(id: any) {
    let response;
    try {
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/student?id=${id}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            // body: JSON.stringify({
            //    
            // }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in get student info:', error);
    }
};

export async function putStudentInfo(email : string, helpList: string[]) {
    let response;
    try {
     
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/student/edit`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                "email": email,
                "helpList": helpList,     
            }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in put student info:', error);
    }
};

export async function putTutorInfo(email : string, ableToTeach: string[]) {
    let response;
    try {
     
        response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/student/edit`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                "email": email,
                "ableToTeach": ableToTeach,     
            }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in put tutor info:', error);
    }
};

export async function getInfoFromEmail(someEmail : string) {
    let response;
    try {
        response = await fetch(`/api/v1/login/userInfo?email=${someEmail}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            // body: JSON.stringify({
            //    
            // }),
        });
        if (!response.ok) {
        }
        const data = await response.json();
        console.log('The response was:', data);
        return response;

    } catch (error) {
        console.error('Error in get info from email:', error);
    }
};
// export async function getStudentProfile(id: any) {
//     let response;
//     try {
//         response = await fetch(`https://ututor-backend-816f9a0da7be.herokuapp.com/api/v1/student?id=${id}`, {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             // body: JSON.stringify({
//             //    
//             // }),
//         });
//         if (!response.ok) {
//             throw new Error('Failed to send message to tutor');
//         }
//         const data = await response.json();
//         console.log('The response was:', data);
//         return response;

//     } catch (error) {
//         console.error('Error sending message to tutor:', error);
//     }
// };

