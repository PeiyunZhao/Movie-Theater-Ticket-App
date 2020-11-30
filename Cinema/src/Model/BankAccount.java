package Model;

import Control.DBController;

public class BankAccount {

	private int accountId;
	private String card;
	private String pwd;
	private Double balance;
	
	public BankAccount() {
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public int downBalance(Double balance,String card) {
		DBController db = new DBController();
		String sql = "update bankaccount set balance=balance-" + balance + " where acard=" + card;
		System.out.println(sql);
		return db.insertToTable(sql);
	}
	
}
