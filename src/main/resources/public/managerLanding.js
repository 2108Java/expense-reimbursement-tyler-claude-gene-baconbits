
//this is managerLanding.js. based on testList.js

//will receive form input and send to authentication controller


console.log("managerLanding.js is running");


//constructors for each type, I think
    //but let's just get Ticket to display first
function Ticket(id,employeeId,amount,description,type,status,date){
    this.id = id;
    this.employeeId = employeeId;
    this.amount = amount;
    this.description = description;
    this.type = type;
    this.status = status;
    this.date = date;
    }






    
function manipulateDOM(Ticket) { //remember to add Ticket param after test
    console.log("the manipulateDOM function just started");
        let theRow = document.createElement("TR");
            let theId = document.createElement("TD");
                theId.innerText = Ticket.id;
                // theId.innerText = "105";

            let theEmployeeId = document.createElement("TD");
                theEmployeeId.innerText = Ticket.employeeId;
                // theEmpId.innerText = "31";

            let theAmount = document.createElement("TD");
                theAmount.innerText = Ticket.amount;
                // theAmount.innerText = "436.87";

            let theDesc = document.createElement("TD");
                theDesc.innerText = Ticket.description;
                // theDesc.innerText = "Hotel for conference";

            let theType = document.createElement("TD");
                theType.innerText = Ticket.type;
                // theType.innerText = "Lodging";

            let theStatus = document.createElement("TD");
                theStatus.innerText = Ticket.status;
                // theStatus.innerText = "Pending";

            let theDate = document.createElement("TD");
                theDate.innerText = Ticket.date;
        
        theRow.appendChild(theId);
        theRow.appendChild(theEmployeeId);
        theRow.appendChild(theAmount);
        theRow.appendChild(theDesc);
        theRow.appendChild(theType);
        theRow.appendChild(theStatus);
        theRow.appendChild(theDate);

        document.getElementById("landingTableBody").appendChild(theRow); //keep appending properties as child rows to table
        
}







   
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        
        console.log("I'm changing readystate");
        if(this.readyState == 4 && this.status == 200)  {
            console.log("The response text is " + this.responseText); //may look like JSON, but is only text representation
            let responseObject = JSON.parse(this.responseText);
            console.log("The responseObject is " + responseObject);  

            responseObject.forEach(element => {
		        		let x = new Ticket(
							element.id,
							element.employeeId,
							element.amount,
							element.description,
							element.type,
							element.status,
							element.date
							)
						manipulateDOM(x)})
						      
            } else if (this.readyState == 4 && this.status == 404) {
            console.log(this.responseText);
            console.log("This request was not found by server");
        	}
        	}
            
    xhttp.open("POST", "http://localhost:8000/changeTicket"); //try with extra / if troubel
    xhttp.send();
    console.log("xhttp is open");
   