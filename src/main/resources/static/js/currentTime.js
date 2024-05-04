function currentTime(){
	var nowDate = new Date();
	var nowTime = nowDate.toLocaleTimeString();
	
	document.querySelector("#current").innerHTML = nowTime;
}