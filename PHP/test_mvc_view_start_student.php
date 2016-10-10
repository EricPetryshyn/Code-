<!-- View: Start -->

<!DOCTYPE html>

<html>
<head>
</head>

<body>
    <h1>View-Start</h1>
    <p>
        <?php
            echo 'Display type = ' . $display_type . '<br><br>';

            if ($display_type == 'Start') {
                echo 'StartPage<br>';
            }
            else if ($display_type == 'SignIn') {
                echo "StartPage with 'SignIn' popup box<br>"; 
            }
            else if ($display_type == 'Join') {
                echo "StartPage with 'Join' popup box<br>"; 
            }
            else if ($display_type == 'ForgotPassword') {
                echo "StartPage with 'ForgotPassword' popup box<br>"; 
            }
            else {
                echo 'StartPage with no popup box<br>'; 
            }
        ?>
    </p>

    <!-- Only when the display_type is 'Start', this button is displayed. -->
    <button
        style="display: <?php if ($display_type == 'Start') echo 'block'; else echo 'none'; ?>" 
        onclick="document.getElementById('signin').style.display='block'">Click me to sign in!</button>
    <br>
    <br>
    
    <!-- Only when the display_type is 'SignIn', this button is displayed. -->
    <form id='signin'  
        style="display: <?php if ($display_type == 'SignIn') echo 'block'; else echo 'none'; ?>"                                       
        method="post"                                               
        action="test_mvc_controller_student.php">
        <input type='hidden' name='page' value='StartPage'>         <!-- to distinguish pages -->
        <input type='hidden' name='command' value='SignIn'>                <!-- to distinguish commands -->
        Username: <input type='text' name='username'                     
                    value="<?php if (!empty($username)) echo $username ?>"> 
                  <?php if (!empty($error_msg_username)) echo $error_msg_username; ?> <br>
        Password: <input type='password' name='password'                
                    value="<?php if (!empty($password)) echo $password ?>"> 
                  <?php if (!empty($error_msg_password)) echo $error_msg_password; ?> <br>
        <input type='submit' value='Sign In'>                          <!-- submit button -->
    </form>
</body>
</html>
