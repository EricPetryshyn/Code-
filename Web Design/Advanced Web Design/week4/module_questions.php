<?php

	function questions(){

		$sql = 'Create table Questions(
		QuestionID int AUTO_INCREMENT PRIMARY KEY,
		UserID int NOT NULL,
		Question varchar(32) NOT NULL,
		Date int)';

		return $sql;
	}

?>