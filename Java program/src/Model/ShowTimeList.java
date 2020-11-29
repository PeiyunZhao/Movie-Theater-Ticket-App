package Model;

import java.util.ArrayList;

public class ShowTimeList {
	

	private ArrayList<ShowTime> ShowTimeList;
	
	public ShowTimeList (ArrayList <ShowTime> ShowTimeList) {
		this.ShowTimeList = ShowTimeList;
	}
	public ArrayList<ShowTime> getShowTimeList (){
		return ShowTimeList;
	}
	public void setShowTimeList (ArrayList <ShowTime>ShowTimes){
		ShowTimeList = ShowTimes;
	}
	
	public ShowTime findShowTimeById(int showtimeId) {
		for (ShowTime s :ShowTimeList) {
			if (s.getShowTimeId()==showtimeId)
				return s;
		}
		return null;
	}
	
	public ArrayList<ShowTime> findShowTimeByMovieId(int movieId) {
		ArrayList<ShowTime> sList = new ArrayList<ShowTime>();
		for (ShowTime s : sList) {
			if (s.getMovieId()==movieId)
				sList.add(s);
		}
		
		return sList;
	}


}
