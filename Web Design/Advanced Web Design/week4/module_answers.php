<?php

	function answers(){

		$sql = 'Create table Answers(
		AnswerID int AUTO_INCREMENT PRIMARY KEY,
		QuestionID int,
		UserID int,
		Answer varchar(32) NOT NULL,
		Date int)';
		
		return $sql;

	}

?>