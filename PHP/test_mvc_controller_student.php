<!-- Controller -->

<?php
    // $page - To distinguish StartPage and MainPage
    if (empty($_POST['page']))  // If it is empty
        $page = 'StartPage';  // Let's start with the StartPage.
    else 
        $page = $_POST['page'];  // StartPage or MainPage

    // commands or actions sent from StartPage or MainPage
    if (empty($_POST['command'])) // If it is empty
        $command = '';  // No command was sent
    else
        $command = $_POST['command'];
    
    if ($page == 'StartPage')
    {
        switch($command) 
        {
        // If it is the first time, then display the 'Start' page. In this exercise, the 'Start' page display the 'SignIn' form.
        case '':  // No command was sent
            $display_type = 'Start';
            // Display the 'StartPage' page with the display type 'Start'
            include('test_mvc_view_start_student.php');  // Start page
            exit();
            
        // It is not the first time. The user sent data.
        case 'SignIn':  // 'SignIn' action
            // Get username
            if (empty($_POST['username']))  // If username is empty
                $error_msg_username = '*required'; 
            else  // username
                $username = $_POST['username'];  // in order to redisplay
            
            // Get password
            if (empty($_POST['password']))  // If password is empty
                $error_msg_password = '*required';  // error message for the missing password 
            else
                $password = $_POST['password'];
            
            // If anyone of them is not missing
            if (empty($error_msg_username) && empty($error_msg_password))  // If none of them is missing, then display the main page.
                include('test_mvc_view_main_student.php');  // Main page
            
            // If anyone of them is missing, then redisplay with the 'SignIn' box
            else {
                $display_type = 'SignIn';  // If anyone of them is missing, then redisplay the StartPage with the 'SignIn' form having error messages.
                include('test_mvc_view_start_student.php');  // Start page
            }
            
            exit();  // exit

        case 'Join':
            exit();

        case 'ForgotPassword':
            exit();

        default:
            $display_type = 'Start';
            include('test_mvc_view_start_student.php');  // ViewStart
            exit();
        }
    }
    
    else if ($page == 'MainPage') {
        ;  // implemented later
    }
    
    else {
        echo 'Unknown page: ' . $page;
    }
?>
