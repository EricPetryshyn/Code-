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

	function insert($username, $password, $fullname, $email){

		$server = "localhost";
		$user = "epetryshyn";
		$pass = "epetryshyn";
		$database = "COMP3540_epetryshyn";

		$conn = mysqli_connect($server, $user, $pass, $database);

		$date = date(Ymd);
		$add = true;
		$sql = "select Username from Users";
		$result = mysqli_query($conn, $sql);

		if(mysqli_num_rows($result)>0){
			while($row = mysqli_fetch_assoc($result)){
				if($row['Username'] == $username){
					$add = false;
					break;
				}
			}
		}

		mysqli_close($conn);

		if($add == true){
			$sql = "insert into Users values (Null, '$username', '$password', '$fullname', '$email', $date)";
			return $sql;
		}
	}

	function validate($username, $password){

		$server = "localhost";
		$user = "epetryshyn";
		$pass = "epetryshyn";
		$database = "COMP3540_epetryshyn";

		$conn = mysqli_connect($server, $user, $pass, $database);

		$in = false;
		$sql = "select Username, Password from Users";
		$result = mysqli_query($conn, $sql);

		if(mysqli_num_rows($result)>0){
			while($row = mysqli_fetch_assoc($result)){
				if(($row['Username'] == $username) && ($row['Password'] == $password)){
					$in = true;
					break;
				}
			}
		}

		mysqli_close($conn);

		return $in;
	}

	function delete($username, $password){

		$server = "localhost";
		$user = "epetryshyn";
		$pass = "epetryshyn";
		$database = "COMP3540_epetryshyn";

		$conn = mysqli_connect($server, $user, $pass, $database);

		$delete = false;
		$sql = "select Username, Password from Users";
		$result = mysqli_query($conn, $sql);

		if(mysqli_num_rows($result)>0){
			while($row = mysqli_fetch_assoc($result)){
				if(($row['Username'] == $username) && ($row['Password'] == $password)){
					$delete = true;
					break;
				}
			}
		}

		mysqli_close($conn);

		return $delete;
	}	

		


?>