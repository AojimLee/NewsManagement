function showwarming(){
	var a = document.getElementById("password1").value;
	var b = document.getElementById("password2").value;
	
	if(a!=b){
		document.getElementById("warming").style.display = "block";
	}
	
}

function hidewarming(){
	document.getElementById("warming").style.display = "none";
}

function testphonenum(){
    var c = document.getElementById("phonenumber").value;
    if(c.length!=11){
        document.getElementById("phonewarming").style.display = "block";
    }
//	if(c.length!=)
}

function turnoffwarming(){
    document.getElementById("phonewarming").style.display = "none";
}
