var nummers = [0,1,2,3,4,5,6,7,8,9,"/","+","-","*"];

for (const nummer of nummers){
	document.getElementById(String(nummer)).addEventListener("click", function()
			{addToDisplay(String(nummer))});
}

document.getElementById("eq").addEventListener("click", calculate)
document.getElementById("clear").addEventListener("click", clean)

function addToDisplay(value) {
	document.getElementById("display").innerHTML += value;
}

function calculate() {
	result = eval(document.getElementById("display").innerHTML);
	document.getElementById("display").innerHTML = result;
}

function clean() {
	document.getElementById("display").innerHTML = "";
	}