package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Control.DBController;

public class AppSeting {

	public static String option="Buy";
	public static String userType = "UN";
	public static User user = new OrdinaryUser();
	public static Movie movie = new Movie();
	public static ShowTime showTime = new ShowTime();
	public static Seat seat = new Seat();
	public static Payment payment = new Payment();
	public static Ticket ticket = new Ticket();

	public static int saveDataToDB() {
		int ticketNum = (int) (Math.random() * (100000 - 999) + 1000);
		String userid = user.getUserId() == 0 ? "N/A" : user.getUserId() + "";
		int sshowid = showTime.getStid();
		if (sshowid == 0) {
			return 0;
		}

		if (seat.getSeatId() != 0) {
			
			String sql ="insert into ticket(ticketid,mid,userid,sshowid,seatid,buyTime)values("+ticketNum+","+
			movie.getMovieId()+",'"+userid+"',"+sshowid+","+seat.getSeatId()+",now())";
			System.out.println(sql);
			DBController db = new DBController();
			int num = db.insertToTable(sql);
			if(num!=-1) {
				return ticketNum;
			}
		}
		return 0;
	}
	
	public static List<String> getSeatIdsByMovieId(){
		List<String> seats=new ArrayList<String>();
		int mid = movie.getMovieId();
		int showtimeId= showTime.getStid();
		if(mid==0) {
			return null;
		}
		String sql="select seatid from ticket where mid="+mid+" and sshowid="+showtimeId;
		System.out.println(sql);
		DBController db = new DBController();
		ResultSet rs = db.readFromTable(sql);
		try {
			while(rs.next()) {
				seats.add(rs.getString("seatid"));
			}
		} catch (SQLException e) {
			return null;
		}
		return seats;
	}
}
