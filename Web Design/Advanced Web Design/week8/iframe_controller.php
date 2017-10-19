<?php

/*
*   When controller.php is accessed for the first time
*/

if (empty($_POST['page'])) {
    $display_type = 'no-signin';
    include ('iframe_view_startpage.php');
    exit;
}

/*
*   When commands come from StartPage or MainPage
*/

// Let's not use these for testing.
/*
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
        // Let's assume that they are valid for testing.
        $_SESSION['signedin'] = 'YES';  // session variable
        $_SESSION['username'] = $username;  // session variable
        $_SESSION['password'] = $password;  // session variable
        include ('iframe_view_mainpage.php');
        
        /* Commented out for testing
        // When the user is valid,
        if (isValid(???, ???) {  // it is in module_users.php
            setcookie('username', $username, time() + 24 * 60 * 60);  // Set a cookie for a welcoming message
            $_SESSION['signedin'] = 'YES';  // session variable
            $???['username'] = $username;  // session variable
            $???['password'] = $password;  // session variable
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

else if ($page == 'MainPage') 
{
    if (!isset($_SESSION['signedin'])) {
        $display_type = 'no-signin';
        include ('iframe_view_startpage.php');
        exit;
    }
    
    $username = $_SESSION['username'];
    $password = $_SESSION['password'];

    switch ($command) {
    case 'SignOut':  // 'SignOut' menu item, or timeout
        session_unset();
        session_destroy();  // It does not unset session variables. session_unset() is needed.
        $display_type = 'no-signin';
        include ('iframe_view_startpage.php');
        break;
    case 'SearchQuestions':
        $search_terms = $_POST['search-terms'];
        include ('iframe_view_mainpage_searchquestions.php');
        break;
    default:
        echo 'Unknown command = ' . $command . '<br>';
    }
}

else {
}
?>