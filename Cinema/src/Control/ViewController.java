package Control;

import java.util.List;

import Model.MovieList;
import Model.Seat;
import Model.ShowTimeList;
import View.BTTLogisticsGUI;
import View.LoginGUI;
import View.LogisticsGUI;
import View.OrdinaryUserGUI;
import View.PaymentGUI;
import View.RefundGUI;
import View.RegisteredUserGUI;
import View.SeatingGUI;

public class ViewController {
	private LoginGUI loginGUI;
	private RegisteredUserGUI registeredUserGUI;
	private OrdinaryUserGUI ordinaryUserGUI;
	private PaymentGUI paymentGUI;
	private RefundGUI refundGUI;
	private SeatingGUI seatingGUI;

	public void showLoginGUI() {
		loginGUI = new LoginGUI();
	}

	public void showPaymentGUI() {
		paymentGUI = new PaymentGUI();
	}

	public void showSeatingGUI() {
		Seat seat = new Seat();
		List<Seat> seats=seat.getAllSeat();
		System.out.println(seats);
		int seatNums=seats.size();
		seatingGUI = new SeatingGUI(seatNums,seats);
	}

	public void showRegisteredUserGUI() {
		registeredUserGUI = new RegisteredUserGUI();
	}

	public void showOrdinaryUserGUI() {
		ordinaryUserGUI = new OrdinaryUserGUI();
	}

	public void showRefundGUI() {
		refundGUI = new RefundGUI();
	}

	public LoginGUI getLoginGUI() {
		return loginGUI;
	}

	public void setLoginGUI(LoginGUI loginGUI) {
		this.loginGUI = loginGUI;
	}

	public RegisteredUserGUI getRegisteredUserGUI() {
		return registeredUserGUI;
	}

	public void setRegisteredUserGUI(RegisteredUserGUI registeredUserGUI) {
		this.registeredUserGUI = registeredUserGUI;
	}

	public OrdinaryUserGUI getOrdinaryUserGUI() {
		return ordinaryUserGUI;
	}

	public void setOrdinaryUserGUI(OrdinaryUserGUI ordinaryUserGUI) {
		this.ordinaryUserGUI = ordinaryUserGUI;
	}

	public PaymentGUI getPaymentGUI() {
		return paymentGUI;
	}

	public void setPaymentGUI(PaymentGUI paymentGUI) {
		this.paymentGUI = paymentGUI;
	}

	public RefundGUI getRefundGUI() {
		return refundGUI;
	}

	public void setRefundGUI(RefundGUI refundGUI) {
		this.refundGUI = refundGUI;
	}

	public SeatingGUI getSeatingGUI() {
		return seatingGUI;
	}

	public void setSeatingGUI(SeatingGUI seatingGUI) {
		this.seatingGUI = seatingGUI;
	}
	
	public void showLogisticGUI() {
		MovieList movieList = new MovieList();
		ShowTimeList showList = new ShowTimeList();

		new LogisticsGUI(movieList,showList,showList.getRooms());
	}
	
	public void showBTTLogisticGUI() {
		MovieList movieList = new MovieList();
		ShowTimeList showList = new ShowTimeList();
		new BTTLogisticsGUI(movieList,showList,showList.getRooms());
	}
}
