<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script>
		// 5 minute Timeout
        var timer = setTimeout(timeout, 5 * 60 * 1000);  
        window.addEventListener('mousemove', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 5 * 60 * 1000);
        });
        window.addEventListener('keydown', function() {   
            clearTimeout(timer);
            timer = setTimeout(timeout, 5 * 60 * 1000);
        });
        window.addEventListener('unload', function() {
            clearTimeout(timer);
            timer = setTimeout(timeout, 5 * 60 * 1000);
        });
        function timeout() {
            document.getElementById('signout').submit();  
        }
    </script>
</head>

<body>
    <div class='container'>
		<div class='row'>
			<div class='col-md-1'>
				<div class='dropdown' style='top:20px'>
					<button class='btn btn-primary dropdown-toggle' type='button' data-toggle='dropdown'>
						<span class='glyphicon glyphicon-menu-hamburger'></span>
						Menu
					</button>
					<ul class='dropdown-menu'>
						<li><a href='#modal-post-questions' data-toggle='modal'>Post Questions</a></li>
						<li id='form-list-questions'><a href='#form-list-questions'>List Questions</a></li>
						<li><a href='#modal-search-questions' data-toggle='modal'>Search Questions</a></li>
						<li id='form-list-answers'><a href='#form-list-answers'>List Answers</a></li>
						<li id='form-signout'><a href='#form-signout'>Sign Out</a></li>
					</ul>
				</div>
			</div> 
        </div>
			
		<div>	
			<div class='col-md-11'>
				<h1 style='text-align:center'>Welcome <?php echo ($_SESSION['username']); ?></h1>
			</div>
			
			<div id='result-pane' class='col-md-10'> 
            </div>
		</div>		
	</div>
	
	<div id="modal-post-questions" class="modal fade">
    
        <div class="modal-dialog">
        
            <div class="modal-content">
                        
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Post Questions</h4>
                </div>
                              
                <div class="modal-body">
                    <form id='form-post-questions'>
                        <div class="form-group">
                            <label for="search_terms">Question:</label>
                            <input type="text" class="form-control" id="input-post-questions">
                        </div>
                        <!-- type should be 'button'. If it is deleted, then 'submit' is assumed. This is important. -->
                        <button type='button' id="button-post-questions" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div id="modal-post-answers" class="modal fade">
    
        <div class="modal-dialog">
        
            <div class="modal-content">
                        
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Post Answers</h4>
                </div>
                              
                <div class="modal-body">
                    <form id='form-post-answers'>
                        <div class="form-group">
							<input type="hidden" id="q" value="" />
                            <label for="search_terms">Answer:</label>
                            <input type="text" class="form-control" id="input-post-answers">
                        </div>
                        <!-- type should be 'button'. If it is deleted, then 'submit' is assumed. This is important. -->
                        <button type='button' id="button-post-answers" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
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

                        <button type='button' id="button-search-questions" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
	
	<script>
		$('#form-list-questions').click(function(){
            $.post('project_controller.php',
               {
                   page: "MainPage",
                  command: "ListQuestions",
               },
  
                function(result, status) {
                    $('#result-pane').html(construct_table(result));
                });
		});
		
		$('#form-list-answers').click(function(){
            $.post('project_controller.php',
               {
                   page: "MainPage",
                  command: "ListUserAnswers",
               },
  
                function(result, status) {
                    $('#result-pane').html(construct_table_answers(result));
                });
		});
		
		$('#modal-post-questions').keypress(function(e){
			if(e.which == 13){
				$('#modal-post-questions').modal('toggle');   
                                                         
				$.ajax({
					type: 'POST',
					data: {"Question": $('#input-post-questions').val(), "Username": "<?php echo $_SESSION['username'] ?>" },
					url: 'project_postquestions.php',	
					success: function(data){
						alert(data);
					}
				});
				return false;
			}
		});
		
		$('#modal-post-answers').keypress(function(e){
			if(e.which == 13){
				$('#modal-post-answers').modal('toggle');                                   

				$.ajax({
					type: 'POST',
					data: {"Answer": $('#input-post-answers').val(), "Username": "<?php echo $_SESSION['username'] ?>", "Question": $('#q').val()},
					url: 'project_postanswers.php',	
					success: function(data){
						alert(data);
					}
				});	
				return false;
			}				
        });
		
		$('#modal-search-questions').keypress(function(e){
			if(e.which == 13){
				$('#modal-search-questions').modal('toggle'); 
                                                          
				var search_terms = $('#input-search-questions-terms').val();
				// send ajax POST request
				$.post('project_controller.php',
					{
						page: "MainPage",
						command: "SearchQuestions",
						'search-terms': search_terms  
					},
					
					function(result, status) {
						$('#result-pane').html(construct_table(result));
					});
					return false;
			}
        });
	</script>
    
    <script>
        function construct_table(data)  
        {
            var obj = JSON.parse(data);  
            var j = 0;
			var a = new Array();
			
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
                for (var p in obj[caption][i]){
                    table += '<td>' + obj[caption][i][p] + '</td>';
					a[j] = obj[caption][i][p];
					j++;
				}
				table += '<td>' + "<input type='submit' id=" + a[j-3] + " value='Post Answer' onClick='postAnswers(this.id)' >" + '</td>';
				table += '<td>' + "<input type='submit' id=" + a[j-3] + " value='View Answers' onClick='displayAnswers(this.id)' >" + '</td>';
				table += '<td>' + "<input type='submit' id=" + a[j-3] + " value='Delete Question' onClick='deletequestion(this.id)' >" + '</td>';
				
				table += '</tr>';
            }
            // table end tag
            table += '</table>';

            return table;

        }
		
		function construct_table_answers(data)  
        {
            var obj = JSON.parse(data);  
            var j = 0;
			var a = new Array();

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
                for (var p in obj[caption][i]){
                    table += '<td>' + obj[caption][i][p] + '</td>';
					a[j] = obj[caption][i][p];
					j++;
				}
				table += '<td>' + "<input type='submit' id=" + a[j-3] + " value='Delete Answer' onClick='deleteanswer(this.id)' >" + '</td>';
				
				table += '</tr>';
            }
            // table end tag
            table += '</table>';

            return table;

        }
		
	
        $('#button-post-questions').on('click', function() {
            $('#modal-post-questions').modal('toggle');   
                                                         
            $.ajax({
				type: 'POST',
				data: {"Question": $('#input-post-questions').val(), "Username": "<?php echo $_SESSION['username'] ?>" },
				url: 'project_postquestions.php',	
				success: function(data){
					alert(data);
				}
			});
        });
		
		function displayAnswers(id){
			var id = id;
			
			$.post('project_controller.php',
               {
                   page: "MainPage",
                   command: "ListAnswers",
				   'question': id
               },
  
                function(result, status) {
                    $('#result-pane').html(construct_table_answers(result));
                });		  
		}
		
		function deletequestion(id){
			var id = id;
			
			$.post('project_controller.php',
               {
                   page: "MainPage",
                   command: "DeleteQuestion",
				   'question': id
               },
  
               function(result, status) {
                    $('#result-pane').html(construct_table(result));
                });	  
		}
		
		function deleteanswer(id){
			var id = id;
			
			$.post('project_controller.php',
               {
                   page: "MainPage",
                   command: "DeleteAnswer",
				   'answer': id
               },
  
               function(result, status) {
                    $('#result-pane').html(construct_table_answers(result));
                });	  
		}

		$('#button-post-answers').on('click', function() {
            $('#modal-post-answers').modal('toggle');                                   

            $.ajax({
				type: 'POST',
				data: {"Answer": $('#input-post-answers').val(), "Username": "<?php echo $_SESSION['username'] ?>", "Question": $('#q').val()},
				url: 'project_postanswers.php',	
				success: function(data){
					alert(data);
				}
			});		
        });
		
		function postAnswers(id){
			$id = id;
			
			$('#q').val($id);
			$('#modal-post-answers').modal('show');
			  
		}
		
        $('#button-search-questions').on('click', function() {
            $('#modal-search-questions').modal('toggle');   
                                                           
       
            var search_terms = $('#input-search-questions-terms').val();
            // send ajax POST request
            $.post('project_controller.php',
                {
                    page: "MainPage",
                    command: "SearchQuestions",
                    'search-terms': search_terms  
                },
                
                function(result, status) {
                    $('#result-pane').html(construct_table(result));
                });
        });
    </script>
	
	<!-- signout -->
	
	<div style='display:none'>
		<form id='signout' method='post' action='project_controller.php'>
			<input type='hidden' name='page' value='MainPage'>
			<input type='hidden' name='command' value='SignOut'>
			<input type='submit' value='Submit'>
		</form>
	</div>
	
	<script>
		$('#form-signout').click(function(){
			$('#signout').submit();
		});
	</script>
	
</body>
</html>