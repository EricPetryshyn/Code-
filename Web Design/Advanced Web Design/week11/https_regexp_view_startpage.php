<!doctype html>
<html>
<head>
</head>

<body>
    <h1>Test - HPPTS and RegExp - StartPage</h1>
    <hr>
    
    <form id='form-join' method='POST' action='https_regexp_controller.php'>
        <input type='hidden' name='page' value='StartPage'>
        <input type='hidden' name='command' value='Join'>
        Username: <input type='text' name='username' required><br>  <!-- It should be entered. -->
        Password: <input type='password' name='password' required><br>  <!-- It should be entered. -->
        <input type='submit'>
    </form>
</body>
</html>
