<!DOCTYPE html>

<html>
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
			<div class='col1'>
				<div class='dropdown' style='top:20px'>
					<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>
						<span class="glyphicon glyphicon-menu-hamburger"></span>
						Menu
					</button>
					<ul class='dropdown-menu'>
						<li><a href='#modal-signin' data-toggle='modal'>Sign In</a></li>
						<li><a href='#modal-join' data-toggle='modal'>Join</a></li>
						<li><a href='#modal-unsubscribe' data-toggle='modal'>Unsubscribe</a></li>
					</ul>
				</div>
			</div>
			
			<div class='col2'>
				<h1 style='text-align:center'>General Questions & Answers: Become Smart</h1>
			</div>
		</div>
	</div>
	
	<div>
		<h4 style='text-align:center; color:blue; margin-top: 60px'><?php if (!empty($message)) {echo $message; $message = '';} ?></h4>
	</div>
	
	<div id='modal-signin' class='modal fade'>
		<div class='modal-dialog'>
			<div class='modal-content'>
				<div class='modal-header'>
					<button type='button' class='close' data-dismiss='modal'>&times;</button>
					<h4 class='modal-title'>Sign In</h4>
				</div>
				<div class="modal-body">
                    <form id='form-signin' method='POST' action='project_controller.php'>
                        <input type='hidden' name='page' value='StartPage'>
                        <input type='hidden' name='command' value='SignIn'>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name='username' 
								value='<?php if (!empty($_SESSION['username'])) echo $_SESSION['username']; ?>'>
								<?php if (!empty($error_msg_username)) echo $error_msg_username; ?>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name='password' 
								value='<?php if (!empty($password)) echo $password; ?>'>
								<?php if (!empty($error_msg_password)) echo $error_msg_password; ?>
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
	<div id='modal-join' class='modal fade'>
		<div class='modal-dialog'>
			<div class='modal-content'>
				<div class='modal-header'>
					<button type='button' class='close' data-dismiss='modal'>&times;</button>
					<h4 class='modal-title'>Join</h4>
				</div>
				<div class="modal-body">
                    <form id='form-join' method='POST' action='project_controller.php'>
                        <input type='hidden' name='page' value='StartPage'>
                        <input type='hidden' name='command' value='Join'>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name='username'
								value='<?php if (!empty($_SESSION['username'])) echo $_SESSION['username']; ?>'>
								<?php if (!empty($error_msg_username)) echo $error_msg_username; ?>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name='password'
								value='<?php if (!empty($password)) echo $password; ?>'>
								<?php if (!empty($error_msg_password)) echo $error_msg_password; ?>
                            </div>
							<div class="form-group">
                                <label for="fullname">Name:</label>
                                <input type="text" class="form-control" id="fullname" name='fullname'>
                            </div>
                            <div class="form-group">
                                <label for="email">Email:</label>
                                <input type="email" class="form-control" id="email" name='email'>
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
	<div id='modal-unsubscribe' class='modal fade'>
		<div class='modal-dialog'>
			<div class='modal-content'>
				<div class='modal-header'>
					<button type='button' class='close' data-dismiss='modal'>&times;</button>
					<h4 class='modal-title'>Unsubscribe</h4>
				</div>
				<div class="modal-body">
                    <form id='form-unsubscribe' method='POST' action='project_controller.php'>
                        <input type='hidden' name='page' value='StartPage'>
                        <input type='hidden' name='command' value='Unsubscribe'>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" id="username" name='username'
								value='<?php if (!empty($_SESSION['username'])) echo $_SESSION['username']; ?>'>
								<?php if (!empty($error_msg_username)) echo $error_msg_username; ?>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" name='password'
								value='<?php if (!empty($password)) echo $password; ?>'>
								<?php if (!empty($error_msg_password)) echo $error_msg_password; ?>
                            </div>
                            <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
	
</body>
				
</html>