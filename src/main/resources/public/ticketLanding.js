
//will receive form input and send to authentication controller


console.log("ticketLanding.js is running");



function Ticket(id,empId,amount,description,type,status){
    this.id = id;
    this.empId = empId;
    this.amount = amount;
    this.description = description;
    this.type = type;
    this.status = status;
	// private ArrayList<TicketStatusEvent> ticketHistory; //will display this separately, I think
    }


app.put("/m/{id}")

    
function manipulateDOM(Ticket) { //remember to add Ticket param after test
    console.log("the manipulateDOM function just started");
        let theRow = document.createElement("TR");
            let theId = document.createElement("TD");
                theId.innerText = Ticket.id;
                // theId.innerText = "105";

            let theEmpId = document.createElement("TD");
                theEmpId.innerText = Ticket.empId;
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

        theRow.appendChild(theId);
        theRow.appendChild(theEmpId);
        theRow.appendChild(theAmount);
        theRow.appendChild(theDesc);
        theRow.appendChild(theType);
        theRow.appendChild(theStatus);

        document.getElementById("landingTableBody").appendChild(theRow); //keep appending properties as child rows to table
        
}



let theNewTicketButton = document.getElementById("ticket_maker");
theNewTicketButton.addEventListener('click', makeNewTicket);


//for testing the manipulateDOM without XHR
// theNewTicketButton.addEventListener('click', manipulateDOM);



function makeNewTicket(){
    
    console.log("the makeNewTicket function just started");
 
    let theFormAmount = document.getElementById("post_amount").value;
    let theFormDesc = document.getElementById("describe").value;
    let theFormType = document.getElementById("request").value;
    let theFormStatus = "pending";

    let submissionDetails = new Ticket(-1,-1,theFormAmount,theFormDesc,theFormType,theFormStatus)


    console.log(`The user entered ${theFormAmount}, ${theFormDesc}, and ${theFormType}`);
    
    //testing whether submission form made new Ticket object
    let detailsString = JSON.stringify(submissionDetails);
    console.log(`The submissionDetails is a Ticket object with these values: ${detailsString}`);

manipulateDOM(submissionDetails);
   
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        
        console.log("I'm changing readystate");
        if(this.readyState == 4 && this.status == 200)  {
            console.log(this.responseText); //may look like JSON, but is only text representation
            let responseObject = JSON.parse(this.responseText);
            
            let submissionResults = new Ticket(
                responseObject.id, 
                responseObject.empId, 
                responseObject.amount,
                responseObject.description,
                responseObject.type,
                responseObject.status
                )

            
            Window.alert(`Your new ticket was submitted! Here are the details: ${submissionResults}`); //how?

        } else if (this.readyState == 4 && this.status == 404) {
            console.log(this.responseText);
            console.log("This request was not found by server");
        }

            return submissionResults;
                 
    }

  let data = JSON.stringify(submissionDetails);

    xhttp.open("POST", "/newTicket"); //config the url and the method // full enough
    console.log("xhttp is open");
    xhttp.send(data);
    console.log("xhttp has sent");   
 
    
}


