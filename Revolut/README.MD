READ ME
The application uses Undertow embedded server for API calls.
Request Object (Json)
{
  	"transfer_amout": "1008.00",
  	"senders_account_number": "12345",
  	"recepients_account_number":"54321"
	}
  
  Response:
  {
    "transfer_amout": "1008.0",
    "senders_balance": "400.0",
    "recepients_balance": "250.23"
}
