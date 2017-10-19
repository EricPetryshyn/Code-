<?php
	
	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";

	$conn = mysqli_connect($server, $user, $pass, $database);

	include('project_module.php');

	$sql = create_Table();
	mysqli_query($conn, $sql);
	
	$sql = create_QTable();
	mysqli_query($conn, $sql);
	
	$sql = create_ATable();
	mysqli_query($conn, $sql);
	

    if (empty($_POST['page'])){		
        $page = 'StartPage';
	}		
    else{ 
        $page = $_POST['page']; 
	}		
    if (empty($_POST['command'])){ 
        $command = '';
	}		
    else{
        $command = $_POST['command'];
	}
   
    session_start();
   
    if ($page == 'StartPage'){
        switch($command){
        
        case '':  
            $display_type = 'Start';
            include('project_view.php');  
            exit();
            
        case 'SignIn':
            if (empty($_POST['username'])){  
                $error_msg_username = '*required'; 
				$_SESSION['username'] = null;
			}
            else{  
                $username = $_POST['username']; 
				$_SESSION['username'] = $username;
			}
            if (empty($_POST['password'])){
                $error_msg_password = '*required'; 
			}
            else{
                $password = $_POST['password'];
			}
			
            if (empty($error_msg_username) && empty($error_msg_password)){  
				if(validation($username, $password)){
					$display_type = 'SignIn';
					include('project_main_view.php'); 
				}
				else{
					$message = "Username and/or password is invalid";
					$display_type = 'SignIn';
					include('project_view.php'); 
				}
			}
            else {
                $display_type = 'SignIn';  
                include('project_view.php');  
            }
            
            exit();  

        case 'Join':
			if (empty($_POST['username'])){
                $error_msg_username = '*required'; 
				$_SESSION['username'] = null;
			}
            else{
                $username = $_POST['username']; 
				$_SESSION['username'] = $username;				
			}
            if (empty($_POST['password'])){
                $error_msg_password = '*required';  
			}
            else{
                $password = $_POST['password'];
			}
			$fullname = $_POST['fullname'];
			$email = $_POST['email'];
			$_SESSION['username'] = $username;

            if (empty($error_msg_username) && empty($error_msg_password)){ 
                $sql = insert($_POST['username'], $_POST['password'], $_POST['fullname'], $_POST['email']);
				if(mysqli_query($conn, $sql)){
					$message = "User Has Successfully Joined";
					$display_type = 'Start';
				}
				else{
					echo "Error: " . $sql . "<br>" . mysqli_error($conn);
					$display_type = 'Join';
				}
				include('project_view.php'); 
            }
            else {
                $display_type = 'Join'; 
                include('project_view.php');  
            }
			
            exit();

        case 'Unsubscribe':
			if (empty($_POST['username'])){
                $error_msg_username = '*required'; 
				$_SESSION['username'] = null;
			}
            else{
                $username = $_POST['username']; 
				$_SESSION['username'] = $username;
			}
            if (empty($_POST['password'])){
                $error_msg_password = '*required'; 
			}
            else{
                $password = $_POST['password'];
			}
			$_SESSION['username'] = $username;
            if (empty($error_msg_username) && empty($error_msg_password)){  
                if(delete($username, $password)){
					$sql = "delete from Users where Username='" . $username . "'";
					$message = "User Successfully Deleted";
	
					mysqli_query($conn, $sql);
					$display_type = 'Start';
                	include('project_view.php'); 
				}			
				else{
					$message = "Username and/or password is invalid";
					$display_type = 'Unsubscribe';
					include('project_view.php'); 
				}
            }
            else{
                $display_type = 'Unsubscribe'; 
                include('project_view.php');  
            }
            exit();

        default:
            $display_type = 'Start';
            include('project_view.php');  
            exit();
        }
    }
	
	if($page == 'MainPage'){
		
		switch($command){
        
			case 'SignOut':  
				$display_type = 'Start';
				include('project_view.php');  
				
				exit();
				
			case 'SearchQuestions':
				$search_terms = $_POST['search-terms'];
				include('project_searchquestions.php');
				
				exit();
				
			case 'ListQuestions':
				include('project_listquestions.php');
				
				exit();
				
			case 'ListAnswers':
				$question = $_POST['question'];
				include('project_listanswers.php');
				
				exit();
				
			case 'DeleteQuestion':
				$question = $_POST['question'];
				include('project_deletequestion.php');
				
				exit();
				
			case 'DeleteAnswer':
				$answer = $_POST['answer'];
				include('project_deleteanswer.php');
				
				exit();
				
			case 'ListUserAnswers':
				include('project_listuseranswers.php');
				
				exit();
				
			exit();

		}
	}
    
    mysqli_close($conn);

?>