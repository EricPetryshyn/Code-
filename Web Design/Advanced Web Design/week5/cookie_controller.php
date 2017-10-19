<?php

/*
*   When controller.php is accessed for the first time
*/

if (empty($_POST['page'])) {
    $display_type = 'no-signin';
    include ('cookie_view_startpage.php');
    exit;
}

/*
*   When commands come from StartPage or MainPage
*

require ('module.php');  // connect to MySQL database
require ('module_users.php');  // functions to use Users table
require ('module_questions.php');  // functions to use Questions table
require ('module_answers.php');  // functions to use Answers table

session_start();
*/

$page = $_POST['page'];
$command = $_POST['command'];

if ($page == 'StartPage') 
{
    switch ($command) {
    case 'SignIn':
        $username = $_POST['username'];
        $password = $_POST['password'];
        // For testing, let's assume that they are valid.
        setcookie('username', $username, time() + 60);  // set cookie just for 1 minute
        include('cookie_view_mainpage.php');
        /*
        // When the user is valid,
        if (isValid(???, ???) {  // it is in module_users.php
            $_SESSION['signedin'] = 'YES';
            $_SESSION['username'] = $username;
            $_SESSION['password'] = $password;
            include('view_mainpage.php');
        } 
        // When invalid
        else {
            $display_type = 'signin';
            $error_msg_username = '* Wrong username, or';
            $error_msg_password = '* Wrong password';
            include('view_startpage.php');
        }
        */
        break;
    }
}

/*
else if ($page == 'MainPage') 
{
    if (!isset($_SESSION['signedin'])) {
        $display_type = 'no-signin';
        include ('view_startpage.php');
        exit;
    }
    
    $username = $_SESSION['username'];

    switch ($command) {
    case 'SignOut':  // 'SignOut' menu item, or timeout
        session_unset();
        session_destroy();  // It does not unset session variables. session_unset() is needed.
        ...
        break;
    case 'Query':
        ...;
        break;
    ...
    }
}

else {
    ...
}
*/
?>