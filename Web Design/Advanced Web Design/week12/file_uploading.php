<?php
	$directory = "uploaded_files/";  
	echo "The number of files to upload is " . count($_FILES['fileToUpload']['name']) . '.<br>';  

	for ($i = 0; $i < count($_FILES['fileToUpload']['name']); $i++) {
		$file = $directory . basename($_FILES['fileToUpload']['name'][$i]);  
		if (!file_exists($file)) {
			if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"][$i], $file)){
				echo "The file " . basename( $_FILES["fileToUpload"]["name"][$i]) . " has been successfully uploaded.<br>";
			}
			else{
				echo "There was an error uploading your file.<br>";
			}
		} else
			echo $file . ' already exists.<br>';
	}
?>
