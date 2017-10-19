<?php
	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";
	
	$conn = mysqli_connect($server, $user, $pass, $database);

	$Answer = $_POST['Answer'];
	$Date = date("Ymd");
	$Username = $_POST['Username'];
	$Question = $_POST['Question'];
	
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
	
	$sql = "select Question, QuestionID from Questions";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['Question'] == $Question){
				$QuestionID = $row['QuestionID'];
				break;
			}
		}
	}
	
	$add = true;
	$sql = "select Answer, QuestionID from Answers";
	$result = mysqli_query($conn, $sql);

	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if(($row['Answer'] == $Answer) && ($row['QuestionID'] == $QuestionID)){
				$add = false;
				break;
			}
		}
	}
	
	if($Answer == ""){
		$add = false;
	}
	
	if($add == true){
		$sql = "insert into Answers values (Null, $QuestionID, $UserID, '$Answer', $Date )";
		mysqli_query($conn, $sql);
		echo "Answer successfully posted!";
	}
	else{
		echo "Answer already exists or contains no content!";
	}
	
	mysqli_close($conn);
	
?>