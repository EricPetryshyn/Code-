<?php
//session_start();

$pattern_username = '/^(?!.*[0-9])(?=.*[0-9a-zA-Z_]){4,}/';
$pattern_password = '/^[0-9](?=.*[a-zA-Z!@#$%^&*]){6,}(?=.*[!@#$%^&*]).{1,}[a-zA-Z]$/';

$username = $_SESSION['username'];
$password = $_SESSION['password'];

if (preg_match($pattern_username, $username))
    echo "Good username<br>";
else
    echo "Bad username<br>";

if (preg_match($pattern_password, $password))
    echo "Good password<br>";
else
    echo "Bad password<br>";
?>
