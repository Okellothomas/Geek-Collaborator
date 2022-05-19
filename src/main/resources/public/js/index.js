function more() {
  var x = document.getElementById("more");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more1() {
  var x = document.getElementById("more1");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more2() {
  var x = document.getElementById("more2");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more3() {
  var x = document.getElementById("more3");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more4() {
  var x = document.getElementById("more4");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more4() {
  var x = document.getElementById("more4");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more5() {
  var x = document.getElementById("more5");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function more6() {
  var x = document.getElementById("more6");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

//
// document.getElementById("btn").onclick = function () {
//        location.href = "/projects/students";}
//
// document.getElementById("btn1").onclick = function () {
//        location.href = "/projects/developers";}


function fg(){
var name = document.getElementById("name").value;
alert("Hey " + name + " wait for 24 hours and we will reach out to you concerning the collaboration. Thanks")
}





//function check(){
//var res = document.getElementById("res");
//var email = document.getElementById("email").value;
//
//res.innerHTML = "email";
//}
//
////function check() {
////  let x = document.forms["myform"]["email"].value;
////  let x = document.forms["myform"]["psw"].value;
////
////  if (x == ""||y == "") {
////    alert("Name must be filled out");
////    return false;
////  }
////}

//
// Set the date we're counting down to
var countDownDate = new Date("July 5, 2022 15:37:25").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

  // Get today's date and time
  var now = new Date().getTime();

  // Find the distance between now and the count down date
  var distance = countDownDate - now;

  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);

  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = days + "d " + hours + "h "
  + minutes + "m " + seconds;

  // If the count down is over, write some text
  if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
  }
}, 1000);