package Model;

import java.util.ArrayList;

public class Theater {
	
	private ArrayList<ShowTime> shows;
	private String name;
	private int theaterId;
	
	
	@Override
	public String toString() {
		String theater="";
		return theater;
	}
	
	public String displayShowtimes() {
		return shows.toString();
	}
	
	
	
	public ArrayList<ShowTime> getShows() {
		return shows;
	}
	public void setShows(ArrayList<ShowTime> shows) {
		this.shows = shows;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	
	
	

}
