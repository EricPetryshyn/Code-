<?php
	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";
	
	$conn = mysqli_connect($server, $user, $pass, $database);

	$Question = $_POST['Question'];
	$Date = date("Ymd");
	$Username = $_POST['Username'];
	
	$sql = "select UserID, Username from Users";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['Username'] == $Username){
				$UserID = $row['UserID'];
				break;
			}
		}
	}
	
	$add = true;
	$sql = "select Question from Questions";
	$result = mysqli_query($conn, $sql);

	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['Question'] == $Question){
				$add = false;
				break;
			}
		}
	}
	
	if($Question == ""){
		$add = false;
	}
	
	if($add == true){
		$sql = "insert into Questions values (Null, $UserID, '$Question', $Date )";
		mysqli_query($conn, $sql);
		echo "Question successfully posted!";
	}
	else{
		echo "Question already exists or contains no content!";
	}
	
	mysqli_close($conn);
?>