package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import Control.DBController;

public class Payment {
	
	private User user;
	private Ticket ticket;
	private Receipt receipt;
	private boolean annualFee;
	private DBController db;
	
	public Payment() {
		this.db = new DBController();
	}
	

	public void generateReceipt() {
		
	}
	
	public void generateTicket() {
		
	}
	
	
	public boolean requestRefund() {
		return true;
	}
	
	public boolean checkCard(String creditCard, String pwd) {

		
		String sql = "select * from  bankaccount where acard='" + creditCard + "' and apassword='" + pwd+"'";
		System.out.println(sql);
		try {
			ResultSet rs = db.readFromTable(sql);
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void useCoupons(String couponId) {
		
			String sql = "delete from coupon where couponId=" + couponId;
			System.out.println(sql);
			 db.insertToTable(sql);
		}
	
	public double testCoupon(int cpNum) {
		double credit=0;
		DBController db = new DBController();

		String sql = "select * from coupon where couponId=" + cpNum;
		System.out.println(sql);
		try {
			ResultSet rs = db.readFromTable(sql);
			if(rs.next()) {
				credit = rs.getDouble("credit");
				return credit;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	public boolean isAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(boolean annualFee) {
		this.annualFee = annualFee;
	}
	
	

}
