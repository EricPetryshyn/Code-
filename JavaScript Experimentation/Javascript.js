function game(){
	var tries = 3;
	var ans = Math.floor(Math.random()*11);
	var dif;
	var guess;
	while(tries>0){
		guess = parseInt(prompt("Guess a number between 1 and 10: ","5"));
		var output = document.getElementById("output");
		if (guess==ans){
			alert("You Win");
			tries=0;
		}
		else if(tries==3){
			output.value = "Not Matched";
			tries -= 1;
			dif = Math.abs(guess-ans);
		}
		else if(Math.abs(guess-ans)<dif){
			output.value = "Warmer";
			tries -= 1;
			dif = Math.abs(guess-ans);
		}
		else{
			output.value = "Not Warmer";
			tries -= 1;
			dif = Math.abs(guess-ans);
		}
		if (tries==0&&guess!=ans){
			alert("You Lose")
		}
	}
}

function date(){
	var output = document.getElementById("output");
	var date = new Date();
	document.getElementById("output").value = "Today's Date: " + date.getDate()
					+ "\nMonth: " + date.getMonth()
					+ "\nYear: " + date.getFullYear()
					+ "\nTime: " + date.getHours();
}

function color(){
	var color = prompt("Background Color: ", "white");
	document.body.style.backgroundColor = color;
}

function triangleArea(){
	document.write("Let's find the area of a triangle!<br><br>");
	var a = parseInt(prompt("Enter the length of side 1: ","3"));
	var b = parseInt(prompt("Enter the length of side 2: ","4"));
	var c = parseInt(prompt("Enter the length of side 3: ","5"));
	
	var s = (a + b + c)/2;
	var A = Math.sqrt(s*(s-a)*(s-b)*(s-c));
	document.write("The area is " + A);
}

function encrypt(){
	var e = prompt("Enter a string to be encrypted: ","Taco");	
	
	var temp = "a";
	var i;
	for (i=e.length-1;i>=0;i--){
		temp += e.charAt(i);
	}
	temp += "e";
	
	document.write("The encrypted message is " + temp);	
}