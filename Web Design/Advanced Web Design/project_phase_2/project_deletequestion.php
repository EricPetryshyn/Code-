<?php

	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";
	
	$conn = mysqli_connect($server, $user, $pass, $database);
	
	$table = array();  
    $table['Questions'] = array();
	
	$sql = "select QuestionID, Question from Questions";
	$result = mysqli_query($conn, $sql);
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			if($row['Question'] == $question){
				$QuestionID = $row['QuestionID'];
				break;
			}
		}
	}
	
	$sql = "delete from Questions where QuestionID = $QuestionID";
	$result = mysqli_query($conn, $sql);
	
	$sql = "delete from Answers where QuestionID = $QuestionID";
	$result = mysqli_query($conn, $sql);
	
	$sql = "select * from Questions";
	$result = mysqli_query($conn, $sql);
	$i = 0;
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			$table['Questions'][$i++] = array("Question" => $row['Question'], "Date" => $row['Date'], "Username" => $_SESSION['username']);			
		}
	}
	
	mysqli_close($conn);
	echo json_encode($table);
	
?>