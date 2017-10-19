<?php
	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";
	
	$conn = mysqli_connect($server, $user, $pass, $database);
	
	$table = array();  
    $table['Questions'] = array();
	
	$sql = "select UserID, Username from Users";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['Username'] == $_SESSION['username']){
				$UserID = $row['UserID'];
				break;
			}
		}
	}
	
	$sql = "select * from Questions";
	$result = mysqli_query($conn, $sql);
	$i = 0;
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['UserID'] == $UserID){
				$table['Questions'][$i++] = array("Question" => $row['Question'], "Date" => $row['Date'], "Username" => $_SESSION['username']);
			}
		}
	}
	
	mysqli_close($conn);
	echo json_encode($table); 
?>