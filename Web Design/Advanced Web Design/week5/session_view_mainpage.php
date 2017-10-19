<!doctype html>
<html>
<head>
    <script>
        var timer = setTimeout(timeout, 1 * 60 * 1000);  // one time timer
        window.addEventListener('mousemove', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 1 * 60 * 1000);
        });
        window.addEventListener('keydown', function() {  // 
            clearTimeout(timer);
            timer = setTimeout(timeout, 1 * 60 * 1000);
        });
        window.addEventListener('unload', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 1 * 60 * 1000);
        });
        function timeout() {
            document.getElementById('form-signout').submit();  // send the form
        }
    </script>
</head>

<body>
    <h1>Test - Session - MainPage</h1>
    <hr>
    
    <form id='form-signout' method='POST' action='session_controller.php'>
        <input type='hidden' name='page' value='MainPage'>
        <input type='hidden' name='command' value='SignOut'>
        <input type='submit' value='SignOut'>
    </form>
    <br>
    <form id='form-search' method='POST' action='session_controller.php'>
        <input type='hidden' name='page' value='MainPage'>
        <input type='hidden' name='command' value='SearchQuestions'>
        Search term: <input type='text' name='terms'><br>
        <input type='submit' value='Submit search terms'>
    </form>
</body>
</html>
