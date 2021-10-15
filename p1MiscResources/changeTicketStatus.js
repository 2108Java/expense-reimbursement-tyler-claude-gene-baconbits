
//will receive form input and send to authentication controller


console.log("changeTicketStatus.js is running");



function Ticket(id,empId,amount,description,type,status){
    this.id = id;
    this.empId = empId;
    this.amount = amount;
    this.description = description;
    this.type = type;
    this.status = status;
	// private ArrayList<TicketStatusEvent> ticketHistory;
    }



    
function manipulateDOM(Employee) {
    console.log("the manipulateDOM function just started");
        // document.appendChild // this will be series of appends to display the logged in user

}
   

let theButton = document.getElementById("loginButton");

theButton.addEventListener('click', searchTickets);




function searchTickets(){
    
    console.log("the searchTickets function just started");
    // first, grab info from user
    // we'll use the input tags on html page
    let theName = document.getElementById("username").value;
    let thePass = document.getElementById("password").value;


    //then specify the URL we want to trigger
    const theURL = "https://"; //finish link? local uri? unneccessary?


    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function(){
        
        console.log("I'm changing readystate");
        if(this.readyState == 4 && this.status == 200)  {
            console.log(this.responseText); //may look like JSON, but is only text representation
            let responseObject = JSON.parse(this.responseText);
            
            let searchResponse = {
                    responseObject//finish
                    this.responseText

                }
            
            searchResults = new Ticket[] ( //wanna make a new ticket array somehow

                );
            
            manipulateDOM(searchResults);

        } else if (this.readyState == 4 && this.status == 404) {
            console.log(this.responseText);
            console.log("This request was not found by server");
        }

            return searchResults;
                 
    }

    let data = JSON.stringify(); //pass in args from form

    xhttp.open("POST", "/changetickets"); //config the url and the method
    console.log("xhttp is open");
    xhttp.send(data);
    console.log("xhttp has sent");   
 
    
}


