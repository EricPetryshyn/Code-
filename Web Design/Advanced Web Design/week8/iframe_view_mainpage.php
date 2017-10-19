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
        <form id='form-signout' method='post' action='iframe_controller.php'>
            <input type='hidden' name='page' value='MainPage'>
            <input type='hidden' name='command' value='SignOut'>
            <input type='submit' value='Submit'>
        </form>
    </div>
    
    <script>
        $('#menu-signout').click(function() {
            $('#form-signout').submit();  // Submit the above form
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
                    <!-- Change the target to the ifram below -->
                    <form id='form-search-questions' method='POST' action='iframe_controller.php' target='target-iframe'>
                        <input type='hidden' name='page' value='MainPage'>
                        <input type='hidden' name='command' value='SearchQuestions'>
                        <div class="form-group">
                            <label for="search-terms">Search terms:</label>
                            <input type="text" class="form-control" id="search-terms" name='search-terms'>
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <!-- iframe to get the data sent from the server -->
    
    <iframe id='iframe-data-from-server' style='display:none' name='target-iframe'></iframe>  <!-- It should be not visible to the user -->
    <script>
        $('#iframe-data-from-server').on('load', function() {  // On the load event
            $('#modal-search-questions').modal('toggle');  // Open/close a modal window; 
                                                           // When 'target' is included',
                                                           //   somehow 'submit' button does not close the modal window.
                                                           // It may be a bug in Bootstrap.
            $('#result-pane').html(this.contentWindow.document.body.innerHTML);  // The HTML content of the div with id='result-pane' is replaced.
        });
    </script>
    
    <!-- Exercise for module pattern -->
    <!--   You need to design a function prototype that keeps private properties. -->
    
    <script>
        function Car(mkr, mdl, yr, clr)
        {
            var maker = mkr;
            var model = mdl;
            var year = yr;
            var color = clr;
            
            return{  // Return this object
                getMaker: function() { return maker; },
                getModel: function() { return model; },
                getYear: function() { return year; },
                getColor: function() { return color; },
                setMaker: function(m) { maker = m; },
                setModel: function(m) { model = m; },
                setYear: function(y) { year = y; },
                setColor: function(c) { color = c; },
                print: function() { return "Maker: " + maker + "\nModel: " + model + "\nYear: " + year + "\nColor: " + color; }  // This function returns a string.
            };
        }
        
        var car = new Car('VW', 'Golf', '2010', 'Silver');  // Create a car - 'VW', 'Golf', '2010', 'Silver';
        alert(car.print());
        alert(car.maker);
        car.setYear('1996');  // Set a new year
        car.setColor('Blue');  // Set a new color
        alert(car.print());
    </script>
</body>
</html>
