package Model;

import java.time.*;

public class RegisteredUser extends User{
	private LocalDateTime lastpaid;
	private String password;
	
	public RegisteredUser(User user, String password) {
		// TODO Auto-generated constructor stub
		
		
	}

	public boolean paidAnnual() {
		LocalDateTime from = lastpaid;
        LocalDateTime to = LocalDateTime.now();

        Duration duration = Duration.between(from, to);
		
        if (duration.toDays()>365) return true;
		
		else return false;
	}

	@Override
	public void makePayment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRefund(int receiptId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUserInformation() {
		// TODO Auto-generated method stub
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
