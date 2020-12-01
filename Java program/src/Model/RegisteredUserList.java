package Model;

import java.util.ArrayList;

public class RegisteredUserList {
	
	ArrayList<RegisteredUser> registeredUsers;
	
	public RegisteredUserList() {
		registeredUsers= new ArrayList<RegisteredUser>();
	}
	
	public void addUser(User user, String password) {
		//creates copy of user and 
		
		RegisteredUser userCopy = new RegisteredUser(user,password);
		
		registeredUsers.add(userCopy);
		
	}
	
	public void addRegisteredUser(RegisteredUser rUser) {
		registeredUsers.add(rUser);
	}
	
	public RegisteredUser checkLogin(String email, ) {
		
	}

}
