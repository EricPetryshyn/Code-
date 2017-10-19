<?php

/*
*   When controller.php is accessed for the first time
*/

if (empty($_POST['page'])) {
    $display_type = 'no-signin';
    include ('session_view_startpage.php');
    exit;
}

/*
*   When commands come from StartPage or MainPage
*

require ('module.php');  // connect to MySQL database
require ('module_users.php');  // functions to use Users table
require ('module_questions.php');  // functions to use Questions table
require ('module_answers.php');  // functions to use Answers table
*/

session_start();

$page = $_POST['page'];
$command = $_POST['command'];

if ($page == 'StartPage') 
{
    switch ($command) {
    case 'SignIn':
        $username = $_POST['username'];
        $password = $_POST['password'];
        // For testing, let's assume that they are valid.
        // Session variables
        $_SESSION['signedin'] = 'YES';
        $_SESSION['username'] = $username;
        $_SESSION['password'] = $password;
        include('session_view_mainpage.php');  // your main page

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

// Command coming from MainPage
else if ($page == 'MainPage') 
{
    if (!isset($_SESSION['signedin'])) {  // if 'signein' is not set; it is set at SignIn
        $display_type = 'no-signin';
        include ('session_view_startpage.php');  // your start page
        exit;
    }
    
    $username = $_SESSION['username'];  // get username stored in a session variable

    switch ($command) {
    case 'SignOut':  // 'SignOut' menu item, or timeout
        session_unset();  // session unset
        session_destroy();  // session destroy; It does not unset session variables. session_unset() is needed.
        
        $display_type = 'no-signin';
        include('session_view_startpage.php');  // your start page
        break;

    case 'SearchQuestions':
        echo 'Search term = ' . $_POST['terms'];
        break;
    }
}
?>