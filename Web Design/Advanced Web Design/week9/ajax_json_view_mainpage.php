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
    <div class='container-fluid'>
        <div class='row' style='background-color:Lavender'>
            <h1 style='text-align:center'>TRU Questions & Answers</h1>
        </div>
        
        <div class='row'>
            <div id='nav-pane' class='col-md-2' style='background-color:LavenderBlush'>
                <ul class='nav nav-pills nav-stacked'>
                    <li><a href='#'>List questions that I posted</a></li>
                    <li><a href='#modal-search-questions' data-toggle='modal'>Search questions</a></li>
                    <li id='menu-signout'><a href='#'>Signout</a></li>
                </ul>
            </div>
            
            <div id='result-pane' class='col-md-10'>  <!-- innerHTML will be filled from view_mainpage_*.php -->
            </div>
        </div>
    </div>

    <!-- form for 'SignOut' -->
    
    <div style='display:none'>
        <form id='form-signout' method='post' action='ajax_json_controller.php'>
            <input type='hidden' name='page' value='MainPage'>
            <input type='hidden' name='command' value='SignOut'>
            <input type='submit' value='Submit'>
        </form>
    </div>
    
    <script>
        $('#menu-signout').click(function() {
            $('#form-signout').submit();
        });
    </script>
    
    <!-- Modal for 'SearchQuestions' -->
    
    <div id="modal-search-questions" class="modal fade">
    
        <div class="modal-dialog">
        
            <div class="modal-content">
                        
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Search Questions</h4>
                </div>
                              
                <div class="modal-body">
                    <form id='form-search-questions'>
                        <div class="form-group">
                            <label for="search-terms">Search terms:</label>
                            <input type="text" class="form-control" id="input-search-questions-terms">
                        </div>
                        <!-- type should be 'button'. If it is deleted, then 'submit' is assumed. This is important. -->
                        <button type='button' id="button-search-questions" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        function construct_table(data)  // data: '{"caption":[{...}, ...]}'
        {
            // Convert the JSON string to an object
            var obj = JSON.parse(data);  
            
            // table tag
            var table = '<table class="table">';
            // table caption
            var caption;
            for (caption in obj) {
                table += '<caption>' + caption + '</caption>';
                break;
            }
            // table head
            table += '<tr>';
            for (var p in obj[caption][0])
                table += '<th>' + p + '</th>';
            table += '</tr>';
            // table data
            for (var i = 0; i < obj[caption].length; i++) {
                table += '<tr>';
                for (var p in obj[caption][i])
                    table += '<td>' + obj[caption][i][p] + '</td>';
                table += '</tr>';
            }
            // table end tag
            table += '</table>';

            return table;
        }

        // when the form button is clicked
        $('#button-search-questions').on('click', function() {
            $('#modal-search-questions').modal('toggle');  // Open/close a modal window; 
                                                           // Somehow 'button' button does not close the modal window.
            // get the search terms
            var search_terms = $('#input-search-questions-terms').val();
            // send ajax POST request
            $.post('ajax_json_controller.php',
                {
                    page: "MainPage",
                    command: "SearchQuestions",
                    'search-terms': search_terms  // the property named search-terms should be a string here. Otherwise, syntax error.
                },
                // result comes back here
                function(result, status) {
                    $('#result-pane').html(construct_table(result));
                });
        });
    </script>
</body>
</html>
