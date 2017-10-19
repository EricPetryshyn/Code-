<!doctype html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <div class='container'>
        <div class='row'>
            <div class='col-md-1'>
                <div class="dropdown" style='top: 20px'>  <!-- dropdown -->
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-menu-hamburger"></span>
                        Menu
                    </button>
                    <ul class="dropdown-menu">  <!-- dropdown-menu  -->
                        <li><a href='#modal-signin' data-toggle='modal'>Sign In</a></li>  <!-- modal -->
                        <li><a href="#">Join</a></li>
                        <li><a href="#">Unsubscribe</a></li>
                        <li class='divider'></li>
                        <li><a href="#">About Us</a></li>
                    </ul>
                </div>
            </div>
            
            <div class='col-md-11'>
                <h1 style='text-align: center'>TRU Questions & Answers</h1>
            </div>
        </div>
    </div>

    <!-- Modal for SignIn -->
    <div id="modal-signin" class="modal fade">
    
        <div class="modal-dialog">
        
            <div class="modal-content">
                        
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sign In</h4>
                </div>
                              
                <div class="modal-body">
                    <form id='form-signin' method='POST' action='bootstrap_controller.php'>
                        <input type='hidden' name='page' value='StartPage'>
                        <input type='hidden' name='command' value='SignIn'>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name='username'>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name='password'>
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
