<!DOCTYPE html>

<html>
<head>
</head>

<body>

    <button
        style="display: <?php if ($display_type == 'Start') echo 'block'; else echo 'none'; ?>" 
        onclick="document.getElementById('signin').style.display='block'">Click me to sign in!</button>
    <br>

    <button
        style="display: <?php if ($display_type == 'Start') echo 'block'; else echo 'none'; ?>" 
        onclick="document.getElementById('join').style.display='block'">Click me to join as new user!</button>
    <br>

    <button
        style="display: <?php if ($display_type == 'Start') echo 'block'; else echo 'none'; ?>" 
        onclick="document.getElementById('unsubscribe').style.display='block'">Click me to unsubscribe :(</button>
    <br>
    <br>
    
  
    <form id='signin'  
        style="display: <?php if ($display_type == 'SignIn') echo 'block'; else echo 'none'; ?>"                                       
        method="post"                                               
        action="controller.php">
        <input type='hidden' name='page' value='StartPage'>         
        <input type='hidden' name='command' value='SignIn'>                
        Username: <input type='text' name='username'                     
                    value="<?php if (!empty($username)) echo $username ?>"> 
                  <?php if (!empty($error_msg_username)) echo $error_msg_username; ?> <br>
        Password: <input type='password' name='password'                
                    value="<?php if (!empty($password)) echo $password ?>"> 
                  <?php if (!empty($error_msg_password)) echo $error_msg_password; ?> <br>
        <input type='submit' value='Sign In'>                          
    </form>

    <form id='join'  
        style="display: <?php if ($display_type == 'Join') echo 'block'; else echo 'none'; ?>"                                       
        method="post"                                               
        action="controller.php">
        <input type='hidden' name='page' value='StartPage'>         
        <input type='hidden' name='command' value='Join'>               
	Username: <input type='text' name='username'                     
                    value="<?php if (!empty($username)) echo $username ?>"> 
                  <?php if (!empty($error_msg_username)) echo $error_msg_username; ?> <br>
        Password: <input type='password' name='password'                
                    value="<?php if (!empty($password)) echo $password ?>"> 
                  <?php if (!empty($error_msg_password)) echo $error_msg_password; ?> <br>
	Full Name: <input type='text' name='fullname'                     
                    value="<?php if (!empty($fullname)) echo $fullname ?>"> 
                   <br>
        Email: <input type='email' name='email'                
                    value="<?php if (!empty($email)) echo $email ?>"> 
                  <br>
        <input type='submit' value='Join'>                          
    </form>

    <form id='unsubscribe'  
        style="display: <?php if ($display_type == 'Unsubscribe') echo 'block'; else echo 'none'; ?>"                                       
        method="post"                                               
        action="controller.php">
        <input type='hidden' name='page' value='StartPage'>       
        <input type='hidden' name='command' value='Unsubscribe'>                
        Username: <input type='text' name='username'                     
                    value="<?php if (!empty($username)) echo $username ?>"> 
                  <?php if (!empty($error_msg_username)) echo $error_msg_username; ?> <br>
        Password: <input type='password' name='password'                
                    value="<?php if (!empty($password)) echo $password ?>"> 
                  <?php if (!empty($error_msg_password)) echo $error_msg_password; ?> <br>
        <input type='submit' value='Unsubscribe'>                         
    </form>

</body>
</html>