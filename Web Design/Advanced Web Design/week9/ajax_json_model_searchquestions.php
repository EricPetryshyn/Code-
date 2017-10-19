<?php
    $file = fopen('search_questions.json', 'r');  // open your json file for reading
    $table = array();  // []
    $table['Questions'] = array();  // {"caption" => []}
    $i = 0;
    while(!feof($file)) {  // eof: end of file
        $row = fgets($file);  // read a line from the file
        if (strlen($row) > 0) {
            $row = json_decode($row);  // convert a JSON string to an associative array
            $table['Questions'][$i++] = $row;  // add it 
        }
    }

    echo json_encode($table);  // Convert the associative array to a JSON string, and send it back to the client
?>

