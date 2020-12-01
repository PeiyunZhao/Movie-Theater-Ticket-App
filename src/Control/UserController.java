package Control;


import Model.RegisteredUser;
import Model.Ticket;
import Model.User;

public class UserController {
		
	private User user;
	private MainController MainController;
	
	public UserController (User u) {
		this.user=u;
	}
	
	public Ticket selectTicket() {
		
		Ticket ticket= null;
		return ticket;
	}
	
	public void makePayment() {
		
	}
	
	public void getRefund(int receiptId) {
		
	}
	
	public void colletUserInformation() {
		//
		
	}
	public void selectUserType() {
		//login gui to use this method to create user as ordinary user, or search for registered 
		//user from list 
	}
	
	

}
