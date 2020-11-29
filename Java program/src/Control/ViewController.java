package Control;

import java.awt.event.ActionEvent;
import java.util.List;

import Model.Seat;
import View.LoginGUI;
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
	private MainController mainControl;
	private SeatingGUI seatingGUI;

	public void actionPerformed(ActionEvent e) {

	}

	public void showLoginGUI() {

	}

	public void showPaymentGUI() {

	}

	public void showSeatingGUI() {
		Seat seat = new Seat();
		List<Seat> seats = seat.getAllSeat();
		System.out.println(seats);
		int seatNums = seats.size();
		seatingGUI = new SeatingGUI(seatNums,seats);
	}

	public void showRegisteredUserGUI() {

	}

	public void showOrdinaryUserGUI() {

	}

	public void showRefundGUI() {

	}

}
