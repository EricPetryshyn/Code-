<!doctype html>
<html>
<head>
</head>

<body>
    <h1>Test - Cookies - StartPage</h1>
    <hr>
    
    <h2 id='welcome-message' style='display:none'></h2>
    <script>
        <?php
            if (!empty($_COOKIE['username'])) {  // COOKIE super global array
                echo "document.getElementById('welcome-message').innerHTML = 'Welcome back, " . 
                    $_COOKIE['username'] . "!';";
                echo "document.getElementById('welcome-message').style.display = 'block';";
            }
        ?>
    </script>
    <hr>
    
    <form id='form-signin' method='post' action='cookie_controller.php'>
        <input type='hidden' name='page' value='StartPage'>
        <input type='hidden' name='command' value='SignIn'>
        Username: <input type='text' name='username'><br>
        Password: <input type='password' name='password'><br>
        <input type='submit'>
    </form>
</body>
</html>
