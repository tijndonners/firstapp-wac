function addToDisplay(value) {
	document.getElementById("display").innerHTML = document.getElementById("display").innerHTML + value;
}

function calculate() {
	result = eval(document.getElementById("display").innerHTML);
	document.getElementById("display").innerHTML = result;
}

function clean() {
	document.getElementById("display").innerHTML = "";
}