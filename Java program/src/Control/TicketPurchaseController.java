package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Model.Movie;
import View.TicketPurchaseGUI;

public class TicketPurchaseController {
	
	private DBController movieModel;
	private TicketPurchaseGUI movieView;
	
	private DefaultListModel<Movie> movieList;
	private Movie selectedMovie;
	private int selectedIndex;
	
	public TicketPurchaseController(DBController movieModel, TicketPurchaseGUI movieView) {
	    this.movieModel=movieModel;
		this.movieView = movieView;
	
		
		movieView.addBackBtnListener(new BackBtnListener());
		movieView.addNextBtnListener(new NextBtnListener());
		movieView.addSeatBtnListener(new SeatBtnListener());
		movieView.addMovieListListener(new MovieListListener());

	}
	
	class BackBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
	class NextBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
	class SeatBtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
	class MovieListListener implements ListSelectionListener{
		@Override
		public void valueChanged(ListSelectionEvent evt) {
		
			selectedMovie = (Movie) movieJList.getSelectedValue();
			if(selectedMovie !=null) {
				selectedIndex = movieJList.getSelectedIndex();
				movieView.displayInfo(selectedMovie);
			}
			
		}



	}
	

}
