# Movie-Theater-Ticket-App
a movie theater ticket registration app designed for ENSF 619 final project

###List of Actors:
1. Un-registered users
	
	users who have downloaded the app but have not registered with username/email and password. Have capabilities to:
		- search for a movie
		- select an specify theater
		- view available show times, 
		- view graphically available seats and select the desired seat,
		- make payment by credit card, receive a copy of ticket and the receipt, via email.
		- Users also should be able to cancel their ticket only up to 72 hours prior to show
		- receives a credit with %15 administration fee for future purchase up maximum of one-year expiration date when canceling. 
		
2. Registered users

	users who have downloaded the app and registered with username/email and password. In addition to regular user capabilities, registered users have:
		- to pay $20 annual fee,
		- free cancellation, 
		- early access to movie news,
		- and 10% of seats prior to public announcement.
	

3. Theater Systems Database (Engine?)
	
	Database which the app back-end code interacts with, store and extract information.
		- list movies available and up-coming
		- list theaters
		- list theater showings/rooms and seats
		- list tickets/seats sold 

###Use Cases:

1. User searches for movies available

2. user searches for theaters available

3. User searches for movies at theaters, selects theater, selects movie and show-time, selects seat and purchase/receive tickets for showing

4. User cancels previous purchased ticket

5. ...
