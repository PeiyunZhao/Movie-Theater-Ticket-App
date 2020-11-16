# Movie-Theater-Ticket-App
a movie theater ticket registration app designed for ENSF 619 final project

###List of Actors:
_1. Un-registered users
	
	users who have downloaded the app but have not registered with username/email and password. Have capabilities to:
		- search for a movie
		- select an specify theater
		- view available show times, 
		- view graphically available seats and select the desired seat,
		- make payment by credit card, receive a copy of ticket and the receipt, via email.
		- Users also should be able to cancel their ticket only up to 72 hours prior to show
		- receives a credit with %15 administration fee for future purchase up maximum of one-year expiration date when canceling. 
		
_2. Registered users

	users who have downloaded the app and registered with username/email and password. In addition to regular user capabilities, registered users have:
		- to pay $20 annual fee,
		- free cancellation, 
		- early access to movie news,
		- and 10% of seats prior to public announcement.
	
_3. Theater Database Engine
	
	Database which the app back-end code interacts with, store and extract information.
		- list movies available and up-coming
		- list theaters
		- list theater showings/rooms and seats
		- list tickets/seats sold 

###Use Cases:

- User searches/browse for movies available
	
	Senario: The use case begins when the user enters the app and searches/brows for movies 	available.	
		Objects:
		- application
		Potential Operations:
		- search_movie


- User searches/browse for theaters available

	Scenario: The user logs in to the application, searches, or browse for theatres that are available around his/her location.
		Objects:
		- application
		Potential Operations:
		- search_theater


- User selects theater

	Scenario: The user opens the app, after browsing the theatres available, the user selects one theater that he/she wants to watch the movie at.
	Objects:
	- application
	- theater
	Potential Operations:
	- select_theater


- User selects movie 

	Scenario: the user opens the application,. After selecting theater and browsing movies available at the theater he is able to select a movie.
	Objects:
	- application
	- theater	
	- movie

	Potential Operations:
	- Select_movie



- User selects movie show-time

	Scenario: the user opens the application and after browsing movie and theater, a list of movie show-times are available for the user to select.
	Objects:
	- movie
	- theater
	- showtime

	Potential Operations:
	- select_showtime


- Views and select the seat     

	Scenario: After selecting movie show-time the user views  seats available graphically, selects the seat that he/she wants to sit in for the movie.
	Objects:
	- seatsAvailableGUI
	- seat

	Potential Operations:
	- select_seat


- Purchase the ticket and check out
	
	Scenario:At this point the system asks the user to select his financial institute, enter user-information, enter card-information. When he submits the payment, the system confirms the completion of the process. For registered-users the system sends the confirmation and a receipt to his/her email address. 
	Objects:
	- payment
	- userInfromation
	- cardInformation
	- financialInstitute
	- receipt
	- userType

	Potential Operations:
	- Submit_payment
	- Confirm_payment
	- Email_confimation
	- check_userType
	- retrieve_userInfo



- User cancels previous purchased ticket
	
	Scenario: If the user regrets purchasing the ticket, he will send a cancellation request to the system. Once the system processes and approves the cancellation, the refund will be processed to the original payment institution that the user entered. 
	Objects:
	- cancellation
	- receipt

	Potential Operations:
	- Cancel_ticket
	- Submit_cancellation
	- confirm _cancellation
	- Email_confirmation
	- update _information (ex. Update_seat)
	- Retrieve_userInfo

