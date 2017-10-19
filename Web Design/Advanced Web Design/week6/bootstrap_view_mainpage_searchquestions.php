<?php
    include('bootstrap_view_mainpage.php');  // view_mainpage.php
    
    echo "<script>";
    echo "  var result_pane = document.getElementById('result-pane');";  // the id of the result pane in view_mainpage.php
    echo "  result_pane.innerHTML = 'Testing:<br><br>';";
    echo "  result_pane.innerHTML += 'Username = " . $username . "<br>';";
    echo "  result_pane.innerHTML += 'Password = " . $password . "<br><br>';";
    if (isset($search_terms))
        echo "  result_pane.innerHTML += 'Search terms = " . $search_terms . "<br>';";
    echo "</script>";
?>

