<?php

	function users(){

		$sql = 'Create table Users(
		UserID int AUTO_INCREMENT PRIMARY KEY,
		Username varchar(32) NOT NULL,
		Password varchar(32) NOT NULL,
		Fullname varchar(32),
		Email varchar(32),
		Date int)';
		
		return $sql;

	}

?>