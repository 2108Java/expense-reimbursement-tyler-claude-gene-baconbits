console.log("present!");
console.log(new Date());

const BASE_URL = "https://127.0.0.1";

function Ticket(TicketId, empId, amount, description, requestType, status, ticketHistory, date) {
    this.TicketId = TicketId;
    this.empId = empId;
    this.amount = amount;
    this.description = description;
    this.requestType = requestType;
    this.status = status;
    this.ticketHistory = ticketHistory;
    this.date = date;
    
}

function GetTicket(){

    console.log("getting a ticket...");

    

    const FULL_URL = BASE_URL + "/viewTickets";


    fetch(FULL_URL)
    .then(
        function(response) {
            if(!response.ok) {
                throw new Error(`Error in the System! Status: ${response.status}, ${response.statusText()}`);

            }

            response.json().then(
                function(data) {
                    console.log(data);

                    let EmpTicket  = {
                        id: data.ticketid,
                        empId: data.empId,
                        amount: data.amount,
                        description: data.description,
                        requestType: data.requestType,
                        status: data.status,
                        ticketHistory: data.ticketHistory,
                        date: data.date
                    }
                        
                    DomManupulation(EmpTicket);
               
                    



                }
            )
        }
    )

    
}

function PostTicket() {

    console.log("posting ticket...");
    const initPost = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept' : 'application/json'
        },
        body: JSON.parse(data),
        cache: 'default'
    };

    const FULL_URL = BASE_URL + "/newTicket";

    fetch(FULL_URL, initPost) .then(
        function(response) {
            if(!response.ok) {
                throw new Error(`Error in posting data: ${response.status}, ${response.statusText()}`);
            }
            response.json().then (
                function(data) {
                    console.log(data);
                    console.log(`${data.description} has been put in with an id of ${data.id}`);
                }
            )
        }
    )

}

function PutTicket() {
    console.log("Putting ticket...");

    const initPut = {
        method: 'PUT',
        headers: {
            'Content-Type' : 'application/json'
        },
        body: JSON.parse(data),
        cache: 'default'
    };
 
    const FULL_URL = BASE_URL + "/changeTicketStatus";
    fetch(FULL_URL,initPut).then (

        function(response) {
            if(!response.ok) {
                throw new Error(`Error updating the ticket: ${response.status}, ${response.statusText}`);
            }
            response.json().then(
                console.log(`${data.description} is updated to ${data.status}`)
            );
        }
    )

}

function DeleteTicket() {

    console.log("deleting ticket...")
    const initDelete = {
        method: 'DELETE',
        headers: {
            'Accept' : 'text/json'
        },
        body: '',
        cache: 'default'
    };

    fetch(FULL_URL, initDelete).then(
        function(response) {
            if(!response.ok) {
                throw new Error(`Error in deleting the ticket: ${response.status}, ${response.statusText}`);
            }
        }
    )
}

function addRow() {
    
   
}


function DomManupulation(Ticket) {

    let ticketMaker = document.getElementById("ticket_wizard");

    ticketMaker.addEventListener('click', GetTicket);

    let ticketGetter = document.getElementById("get_tickets");

    ticketGetter.addEventListener('click',)


    let ticket = document.createElement("tr");

    let ticketNumberData = document.createElement("td");
    let ticketDateData = document.createElement("td");
    let ticketRequestData = document.createElement("td");
    let ticketDescriptionData = document.createElement("td");
    let ticketStatusData = document.createElement("td");
    let ticketAmountData = document.createElement("td");

                    ticketNumberData.innerText = EmpTicket.ticketId;
                    ticketDateData.innerText = EmpTicket.data.
                    ticketRequestData.innerText = EmpTicket.requestType;
                    ticketDescriptionData.innerText = EmpTicket.description;
                    ticketStatusData.innerText = EmpTicket.status;
                    ticketAmountData.innerText = EmpTicket.amount;

                    ticket.appendChild(ticketNumberData);
                    ticket.appendChild(ticketDateData);
                    ticket.appendChild(ticketRequestData);
                    ticket.appendChild(ticketDescriptionData);
                    ticket.appendChild(ticketStatusData);
                    ticket.appendChild(ticketAmountData);

                    ticketMaker.appendChild(ticket);

    
}