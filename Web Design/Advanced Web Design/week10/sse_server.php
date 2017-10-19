<?php
	$data_from_client = $_GET['message'];  // The name of the date used by the client
                                       // It will be sent back in the below
	
	header("Content-Type: text/event-stream");  // text/event-stream
	header("Cache-Control: no-cache");  // no-cache

	echo "retry: 1000\n";  // Every 1000 milliseconds
                         // If you use 'retry: 1000\n', then \n will not be interpreted as the newline character.
	
	$count = 0;
	while ($count < 600) {  // Just for 10 minutes
		if ($count++ % 2 == 1)  // At odd count
            echo "event: newevent\n";  // User defined SSE event name
        else
            ;  // Default SSE event name will be assumed.
            
		$time = date('r');  // formated date
		echo "data: The message from the client = $data_from_client; $time\n";  // "???: message to the client = ...\n"
        echo "data: Eat Tacos!\n";  // Some other message you want to include
        
        echo "\n";  // The end of the message
        
		ob_flush();  // Flush the output buffer and system buffer
		flush();
		
		sleep(1);  // Sleep 1 second
        
        $count += 1;
	}
?>