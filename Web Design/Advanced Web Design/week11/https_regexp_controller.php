<?php
/*
*   Redirection to a secure channel
*/
if(!isset($_SERVER['HTTPS'])){
	$url = 'https://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];
	header("Location: " . $url);
	exit;
}
  
/*
*   When controller.php is accessed for the first time
*/

if (empty($_POST['page'])) {
    include ('https_regexp_view_startpage.php');
    exit;
}

/*
*
*/

session_start();

$page = $_POST['page'];
$command = $_POST['command'];

if ($page == 'StartPage') 
{
    switch ($command) {
    case 'Join':
        $username = $_POST['username'];
        $password = $_POST['password'];
        $_SESSION['username'] = $username;
        $_SESSION['password'] = $password;
        include('https_regexp_module_join.php');
        break;
    }
}
?>