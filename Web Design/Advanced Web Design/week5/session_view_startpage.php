<!doctype html>
<html>
<head>
</head>

<body>
    <h1>Test - Session - StartPage</h1>
    <hr>
    
    <form id='form-signin' method='POST' action='session_controller.php'>
        <input type='hidden' name='page' value='StartPage'>
        <input type='hidden' name='command' value='SignIn'>
        Username: <input type='text' name='username'><br>
        Password: <input type='password' name='password'><br>
        <input type='submit'>
    </form>
</body>
</html>
