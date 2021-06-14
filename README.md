
## Vending-Machine-Software

## General info
* This program imitates a Vending Machine that takes user input for money, initiates a transaction,
provides a selection of items with a defined quantity, and machine settings options. This program was coded in Java.

* The application will receive a JSON file at any given time and will update the functionality of the machine. 
When a consumer enters a selection, it should report what was selected.
### Requirements:
- Provide a loading option for new product lists to update.
- User must be able to enter a selection.
- Machine must prompt the user for payment and amount in US dollars.
- If user enters in payment, calculation must occur and be reported.
- Machine must state the current state of the transaction.
- Actions must be cleanly logged for audit purposes.

### Bonus features:
- Unit testing.
- UI/UX for the user entry and product loading.
	
## Technologies
Project is created with:
* Java version: 15
* Spring
	
## Setup
To run this project, install it locally:

* Download ZIP https://github.com/020010898/Vending-Machine-Software.git
* Use TomCat (https://tomcat.apache.org/download-90.cgi)
* In the VendingMachineDaoInMemImpl class, specify the path to the JSON file
* Please use this format:{
	"items": [{
		"name": "Snickers",
		"amount": 10,
		"price": "$1.35"
	}, {
		"name": "Hersheys",
		"amount": 10,
		"price": "$2.25"
	}, {
		"name": "Hersheys Almond",
		"amount": 10,
		"price": "$1.80"
	}, {
		"name": "Hersheys Special Dark",
		"amount": 10,
		"price": "$1.75"
	}, {
		"name": "Milka",
		"amount": 10,
		"price": "$9.05"
	}, {
		"name": "Nutrageous",
		"amount": 10,
		"price": "$1.30"
	}, {
		"name": "Baby Ruth",
		"amount": 10,
		"price": "$2.50"
	}, {
		"name": "Milky Way",
		"amount": 10,
		"price": "$1.00"
	}, {
		"name": "Lindt",
		"amount": 10,
		"price": "$1.00"
	}]
}

*
*	Run 'TomCat'

