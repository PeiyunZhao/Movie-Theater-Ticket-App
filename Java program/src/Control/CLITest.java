package Control;

import java.io.IOException;
import java.util.ArrayList;

import Model.Movie;
import Model.MovieList;
import Model.ShowTime;

public class CLITest {
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		LogisticsController lc = new LogisticsController();
		DBController dbc = new DBController(lc);
		lc.getMovieList().listRegularMovies();
		Movie movie= lc.getMovieList().searchMovieId(3001);
		System.out.println(movie.getShowTimes());
	//	lc.getShowTimeList().findShowTimeByMovieId(3001);
		//ArrayList<ShowTime> showtimelist=lc.getShowTimeList().findShowTimeByMovieId(3001);
		//System.out.println(showtimelist);
		
//		dbc.getShowTime();
//		
//		MovieList allmovies= dbc.getMovies();
//		dbc.get
//		ArrayList<Movie> allmovies=dbc.getMovies();
//		allmovies.listRegularMovies();
//		LogisticsController logisticConrol=new LogisticsController();
//		logisticConrol.run();
		
		
	}

}
