package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Control.DBController;
import utils.DateUtils;

public class Ticket {
	private int ticketId;
	private User user;
	private String userId;
	private int movieId;
	private boolean isReservation;
	private ShowTime showtime;
	private Seat seat;

	public Ticket() {
		user = new RegisteredUser();
		showtime = new ShowTime();
		seat = new Seat();
	}

	public void takeSeat() {

	}

	public boolean refund(String showTime) {
		boolean isRefund = false;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		String nowTime = sd.format(new Date());
		Long dateDiff = DateUtils.dateDiff(showTime,nowTime,"yyyy/MM/dd hh:mm", "h");
		if(dateDiff>72) {
			return true;
		}
		return isRefund;
	}

	public Ticket getTicketById(String tkId) {
		Ticket ticket = null;
		String sql = "select * from ticket where ticketid=" + tkId;
		System.out.println(sql);
		DBController db = new DBController();
		ResultSet rs = db.readFromTable(sql);
		try {
			if (rs.next()) {
				ticket = new Ticket();
				ticket.setTicketId(rs.getInt("ticketId"));
				ticket.setMovieId(rs.getInt("mid"));
				ticket.setUserId(rs.getString("userid"));
				ticket.getShowtime().setStid(rs.getInt("sshowid"));
			}
		} catch (SQLException e) {
			return null;
		}
		return ticket;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isReservation() {
		return isReservation;
	}

	public void setReservation(boolean isReservation) {
		this.isReservation = isReservation;
	}

	public ShowTime getShowtime() {
		return showtime;
	}

	public void setShowtime(ShowTime showtime) {
		this.showtime = showtime;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
