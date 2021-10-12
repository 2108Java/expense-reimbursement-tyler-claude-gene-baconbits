
//do I even need a function, since HTML <input> has "action" and "method" attributes?
function sendLogin(){
    
    //first, grab info from user
    //we'll use the input tags on html page
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhttp = XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        console.log("I'm changing readystate");
        if(this.readyState == 4 && this.status == 200)  {
            console.log(this.responseText); //may look like JSON, but is only text representation
            let responseObject = JSON.parse(this.responseText);
        } else if (this.readyState == 4 && this.status == 404) {
            console.log(this.responseText);
            console.log("This request was not found by server");
        }

    xhttp.open("GET",swURL);
    xhttp.send();  
                }
}


//as reminder for writing the functions for other endpoints
function DOMManip(){

let tableRow= document.getElementById("_")
let tableRow = document.createElement();
let idColumn = document.createElement();


}