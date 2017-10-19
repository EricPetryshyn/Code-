<?php

	$server = "localhost";
	$user = "epetryshyn";
	$pass = "epetryshyn";
	$database = "COMP3540_epetryshyn";
	
	$conn = mysqli_connect($server, $user, $pass, $database);
	
	$table = array();  
    $table['Answers'] = array();
	
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
	$sql = "select * from Answers";
	$result = mysqli_query($conn, $sql);
	$i = 0;
	if(mysqli_num_rows($result)>0){
		while($row = mysqli_fetch_assoc($result)){
			$UserID = $row['UserID'];
			$sql2 = "select UserID, Username from Users";
			$result2 = mysqli_query($conn, $sql2);
			if(mysqli_num_rows($result2)>0){
				while($row2 = mysqli_fetch_assoc($result2)){
					if($row2['UserID'] == $UserID){
						$Username = $row2['Username'];
						break;
					}
				}
			}
			
			if($row['QuestionID'] == $QuestionID){
				$table['Answers'][$i++] = array("Answer" => $row['Answer'], "Date" => $row['Date'], "Username" => $Username);
			}
		}
	}
	
	mysqli_close($conn);
	echo json_encode($table);
	
?>