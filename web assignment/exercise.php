<?php

	require('module.php');

	include('module_users.php');
	include('module_questions.php');
	include('module_answers.php');

	$r = users();
	$s = questions();
	$t = answers();

	if(mysqli_query( $conn, $r)){
		echo "Table Users Successfully Created";	
	}
	else{
		echo "Error Creating Table Users" . mysqli_error($conn);
	}
	
	if(mysqli_query( $conn, $s)){
		echo "</br>"."Table Questions Successfully Created";	
	}
	else{
		echo "</br>"."Error Creating Table Questions" . mysqli_error($conn);
	}
	
	if(mysqli_query( $conn, $t)){
		echo "</br>"."Table Answers Successfully Created";	
	}
	else{
		echo "</br>"."Error Creating Table Answers" . mysqli_error($conn);
	}

	mysqli_close($conn);

?>