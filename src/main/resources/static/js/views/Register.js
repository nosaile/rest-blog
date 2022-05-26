import createView from "../createView.js";

export default function Register(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>

<form id="register-form">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <br>
    <label for="email">Email</label>
    <input id="email" name="email" type="text"/>
    <br>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <hr>
    <button class="btn btn-success" type="submit" id="register-btn">Login</button>
</form>
</body>
</html>`;

}

export function RegisterEvent() {
    console.log("entered addRegisterEvent")
    $(document).on("click", "#register-btn", function () {
        let user = {
            id: 6,
            username: document.querySelector("#username").value,
            email: document.querySelector("#email").value,
            password: document.querySelector("#password").value,
        }
        console.log(user)
        console.log("got to register event")
        let request = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(user)
        };

        fetch("http://localhost:8080/api/users", request)
            .then((response) => {
                console.log(response.status)
                createView("/");
            });
    });
}

