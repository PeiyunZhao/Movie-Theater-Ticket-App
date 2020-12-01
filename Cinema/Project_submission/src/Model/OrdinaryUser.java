package Model;

import javax.swing.JOptionPane;

import Control.DBController;

public class OrdinaryUser extends User{

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
	
	public boolean refund(int couponNum) {
		double price = AppSeting.movie.getPrice();
		double couponPrice = price - price * 0.15;

		DBController db = new DBController();
		String sql = "insert into coupon(couponId,credit)values(" + couponNum + "," + couponPrice + ")";
		System.out.println(sql);
		int num = db.insertToTable(sql);
		if (num == -1) {
			return false;
		}

		String sql2 = "delete from ticket where ticketid=" + AppSeting.ticket.getTicketId();
		System.out.println(sql2);
		num = db.insertToTable(sql2);
		if (num == -1) {
			return false;
			
		}
		return true;
	}
	@Override
	public boolean checkUserInfo(String username, String card, String pwd, String email) {
		
			if (!username.equals(AppSeting.user.getName())||!pwd.equals(AppSeting.user.getPwd())||(!card.equals(AppSeting.user.getCreditCard() + ""))||!email.equals(AppSeting.user.getEmail())) {
			
				return false;
			}
			return true;
		

}
}