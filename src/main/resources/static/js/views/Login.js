export default function Login(props) {
    return `<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Log In</title>
</head>
<body>
<h1>Log In</h1>

<form id="login-form">
    <label for="username">Username</label>
    <input id="username" name="username" type="text"/>
    <label for="password">Password</label>
    <input id="password" name="password" type="password"/>
    <hr>
    <button class="btn btn-success" type="submit" id="login-post">Login</button>
</form>
</body>
</html>`;

}


