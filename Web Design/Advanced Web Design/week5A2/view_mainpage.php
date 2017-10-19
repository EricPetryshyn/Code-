<!doctype html>
<html>
<head>
    <script>
		// 2 minute Timeout
        var timer = setTimeout(timeout, 2 * 60 * 1000);  
        window.addEventListener('mousemove', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 2 * 60 * 1000);
        });
        window.addEventListener('keydown', function() {   
            clearTimeout(timer);
            timer = setTimeout(timeout, 2 * 60 * 1000);
        });
        window.addEventListener('unload', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 2 * 60 * 1000);
        });
        function timeout() {
            document.getElementById('signout').submit();  
        }
    </script>
</head>

<body>
    <h1>MainPage</h1>
    <hr>
    
    <form id='signout' method='post' action='controller.php'>
        <input type='hidden' name='page' value='MainPage'>
        <input type='hidden' name='command' value='SignOut'>
        <input type='submit' value='Sign Out'>
    </form>
</body>
</html>
