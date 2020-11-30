package Model;

import Control.DBController;

public class FinancialInstitute {

	private String bankName;
	private String userName;
	private double cardNumber;
	private String userAddress;
	private DBController db;
	public FinancialInstitute() {
		this.db = new DBController();
		
	
	}

	public int updateBalance(double price,String creditCard) {
		String sql = "update bankaccount set balance=balance-" + price + " where acard=" + creditCard;
		System.out.println(sql);
		int num = db.insertToTable(sql);
		return num;
		
	}
	
	
	public boolean validate() {
		return true;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(double cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
