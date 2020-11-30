package Model;

public class Coupon {
	
	private int couponId;
	private double credit;
	 
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public int generateCouponId() {
		int couponNum = (int) (Math.random() * (1000000 - 1999) + 1000);
		return couponNum;
	}
	
}
