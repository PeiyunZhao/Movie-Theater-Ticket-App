package Model;

import java.util.ArrayList;

public class ReceiptList {
	private ArrayList<Receipt> receipts;
	
	public ReceiptList() {
		receipts = new ArrayList<Receipt>();
	}
	
	public void add(Receipt r) {
		receipts.add(r);
	}
	
	public Receipt searchId( int id ) {
		for (Receipt r: receipts) {
			if(r.getReceiptId()==id) {
				return r;
			}
		}
		return null;
	}

}
