
//will receive form input and send to authentication controller


console.log("login.js is running");



function Employee(empId,firstName,lastName,userName,email){
    this.empId = empId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	// this.password = password; don't want to keep password in JS after authenticated
	this.email = email;
	// this.isManager = isManager;  // don't need to keep because isManager will be stored as ctx.session attribute
    }


function Credential(username,password){
    this.username = username;
    this.password = password;
}



    
function manipulateDOM(Employee) {
    console.log("the manipulateDOM function just started");
        // document.appendChild // this will be series of appends to display the logged in user
	Window.alert("Your login was successful!");
}
   

let theButton = document.getElementById("loginButton");

theButton.addEventListener('click', loginUser);




function loginUser(){
    
    console.log("the loginUser function just started");
    // first, grab info from user
    // we'll use the input tags on html page
    let theName = document.getElementById("username").value;
    let thePass = document.getElementById("password").value;

    let loginAttempt = new Credential(theName,thePass);


    //then specify the URL we want to trigger


    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        
        console.log("I'm changing readystate");
        if(this.readyState == 4 && this.status == 200)  {
            console.log(this.responseText); //may look like JSON, but is only text representation
            let responseObject = JSON.parse(this.responseText);
            
            let loginObject = {
                "empId": responseObject.empId,
                "firstname": responseObject.firstName, //not sure of whether it'll be returned as camelcase yet
                "lastname": responseObject.lastName,
                "username": responseObject.userName,
                "email": responseObject.email

                }
            
            authorizedUser = new Employee(
                loginObject.empId,
                loginObject.firstName,
                loginObject.lastName,
                loginObject.userName,
                loginObject.email
                );
            
            manipulateDOM(authorizedUser);

        } else if (this.readyState == 4 && this.status == 404) {
            console.log(this.responseText);
            console.log("This request was not found by server");
        }

            /* return authorizedUser; */
                 
    }

    let data = JSON.stringify(loginAttempt);

    xhttp.open("POST", "http://localhost:8000/login");
    console.log("xhttp is open");
    xhttp.send(data);
    console.log("xhttp has sent");
 
    
}


