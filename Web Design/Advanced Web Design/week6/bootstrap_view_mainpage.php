<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <!-- for sending commands -->
    <div style='display:none'>  <!-- should not be displayed -->
        <!-- form for SignOut -->
        <form id='form-signout' method='post' action='bootstrap_controller.php'>
            <input type='hidden' name='page' value='MainPage'>
            <input type='hidden' name='command' value='SignOut'>
            <input type='submit' value='Submit'>
        </form>
    </div>
    
    <div class='container'>  <!-- container type -->
        <div class='row' style='background-color:Lavender'>
            <h1 style='text-align:center'>TRU Questions & Answers</h1>
        </div>
        
        <div class='row'>  <!-- row -->
            <!-- navigatin tabs -->
            <div id='nav-pane' class='col-md-1' style='background-color:LavenderBlush'>
                <ul class='nav nav-pills nav-stacked'>  <!-- nav, nav-pills, nav-stacked -->
                    <li><a href='#'>List questions that I posted</a></li>
                    <li><a href='#modal-search-questions' data-toggle='modal'>Search questions</a></li>  <!-- modal window for SearchQuestions -->
                    <li id='menu-signout'><a href='#menu-signout'>Signout</a></li>
                </ul>
            </div>
            
            <!-- main content -->
            <div id='result-pane' class='col-md-1'>  <!-- innerHTML will be filled from view_mainpage_*.php -->
            </div>
        </div>
    </div>


    <!-- Modal for SearchQuestions --> <!-- You can check view_startpage.php for hints for ??? -->
    <div id="modal-search-questions" class="modal fade">  <!-- modal -->
    
        <div class="container">
        
            <div class="row">
                        
                <div class="col-md-1">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Search Questions</h4>
                </div>
                              
                <div class="modal-body">
                    <form id='form-search-questions' method='POST' action='bootstrap_controller.php'>
                        <input type='hidden' name='page' value='MainPage'>
                        <input type='hidden' name='command' value='SearchQuestions'>
                        <div class="form-group">
                            <label for="search_terms">Search terms:</label>
                            <input type="text" class="form-control" id="search-terms" name='search-terms'>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        $('#menu-signout').click(function() {  // click
            $('#form-signout').submit();  // submit the form
        });
    </script>
</body>
</html>
