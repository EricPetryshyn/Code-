<?php
	
	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";

	$conn = mysqli_connect($server, $user, $pass, $database);

	include('module_users.php');

	$r = users();
	mysqli_query($conn, $r);
	

    if (empty($_POST['page'])) 
        $page = 'StartPage';  
    else 
        $page = $_POST['page'];  
    if (empty($_POST['command'])) 
        $command = '';  
    else
        $command = $_POST['command'];

    
    if ($page == 'StartPage')
    {
        switch($command) 
        {
        // If it is the first time, then display the 'Start' page. In this exercise, the 'Start' page display the 'SignIn' form.
        case '':  
            $display_type = 'Start';
            include('view.php');  
            exit();
            
        // It is not the first time. The user sent data.
        case 'SignIn':  // 'SignIn' action
            if (empty($_POST['username']))  // If username is empty
                $error_msg_username = '*required'; 
            else  // username
                $username = $_POST['username'];  // in order to redisplay
            
            // Get password
            if (empty($_POST['password']))  // If password is empty
                $error_msg_password = '*required';  // error message for the missing password 
            else
                $password = $_POST['password'];

            if (empty($error_msg_username) && empty($error_msg_password))  
		if(validate($username, $password)){
			$display_type = 'SignIn';
			echo "You have successfully used the sign in functionality";
                	include('view.php'); 
		}
		else{
			echo "Username and/or password is invalid";
			$display_type = 'SignIn';
                	include('view.php'); 
		}
            
            // If anyone of them is missing, then redisplay with the 'SignIn' box
            else {
                $display_type = 'SignIn';  // If anyone of them is missing, then redisplay the StartPage with the 'SignIn' form having error messages.
                include('view.php');  
            }
            
            exit();  // exit

        case 'Join':
		if (empty($_POST['username']))  // If username is empty
                $error_msg_username = '*required'; 
            else  // username
                $username = $_POST['username'];  // in order to redisplay
            
            // Get password
            if (empty($_POST['password']))  // If password is empty
                $error_msg_password = '*required';  // error message for the missing password 
            else
                $password = $_POST['password'];

	    $fullname = $_POST['fullname'];
	    $email = $_POST['email'];
            
            // If anyone of them is not missing
            if (empty($error_msg_username) && empty($error_msg_password)){ 
                $s = insert($_POST['username'], $_POST['password'], $_POST['fullname'], $_POST['email']);
		if(mysqli_query($conn, $s)){
			echo "New user created successfully";
			$display_type = 'SignIn';
		}
		else{
			echo "Error: " . $sql . "<br>" . mysqli_error($conn);
			$display_type = 'Join';
		}
		
		include('view.php');  // Main page
            }
            // If anyone of them is missing, then redisplay with the 'Join' box
            else {
                $display_type = 'Join'; 
                include('view.php');  
            }
            exit();

        case 'Unsubscribe':
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
            if (empty($error_msg_username) && empty($error_msg_password)){  
                if(delete($username, $password)){
			$sql = "delete from Users where Username='" . $username . "'";
			echo "User successfully removed";
	
			mysqli_query($conn, $sql);
			$display_type = 'SignIn';
                	include('view.php'); 
		}
		else{
			echo "Username and/or password is invalid";
			$display_type = 'Unsubscribe';
                	include('view.php'); 
		}
            }
            // If anyone of them is missing, then redisplay with the 'Unsubscribe' box
            else {
                $display_type = 'Unsubscribe'; 
                include('view.php');  
            }
            exit();

        default:
            $display_type = 'Start';
            include('view.php');  
            exit();
        }
    }
    

    mysqli_close($conn);

?>