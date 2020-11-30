package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.AppSeting;
import Model.Movie;
import Model.Room;
import Model.Seat;
import Model.ShowTime;

public class BTTLogisticsGUI extends JFrame implements ActionListener{
	private String roomNum = "room1";
	private String selectTime = "9:30:00";
	private JButton nextBtn = null;
	private List<Movie> movieList = null;
	private List<Room> rooms = null;
	private List<ShowTime> showtimes = null;
	private JComboBox<String> movieCbx, roomCbx;
	private JComboBox<ShowTime> startTime;

	public BTTLogisticsGUI(ArrayList<Movie> movies, List<ShowTime> showtimes, List<Room> rooms) {
		this.movieList = movies;
		this.rooms = rooms;
		this.showtimes = showtimes;
		this.setTitle("Choose a movie");
		this.setLocation(325, 125);
		this.setResizable(false);
		this.setSize(535, 349);
		this.setLayout(null);

		JLabel title = new JLabel("Select movie,Room,Showtime");
		title.setBounds(25, 20, 570, 26);
		title.setFont(new Font("Courier New", Font.BOLD, 26));
		this.add(title);

		JLabel selMovie = new JLabel("Select movie:");
		selMovie.setBounds(55, 70, 150, 26);
		selMovie.setFont(new Font("Courier New", Font.BOLD, 16));
		this.add(selMovie);

		movieCbx = new JComboBox<String>();
		movieCbx.setBounds(230, 70, 140, 30);
		this.add(movieCbx);
		if (this.movieList == null && this.movieList.size() == 0) {
			movieCbx.addItem("select movie");
		} else {
			movieCbx.addItem("select movie");
			for (Movie movie : movieList) {
				movieCbx.addItem(movie.getTitle());
			}
		}

		JLabel selRoom = new JLabel("Select Room:");
		selRoom.setBounds(55, 120, 150, 26);
		selRoom.setFont(new Font("Courier New", Font.BOLD, 16));
		this.add(selRoom);

		roomCbx = new JComboBox<String>();
		roomCbx.setBounds(230, 120, 140, 30);
		this.add(roomCbx);
		//roomCbx.addItemListener(this);
		if (this.rooms == null && this.rooms.size() == 0) {
			roomCbx.addItem("select room");
		} else {
			roomCbx.addItem("select room");
			for (Room room : rooms) {
				roomCbx.addItem(room.getRoomNumber());
			}
		}
		roomCbx.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				startTime.removeAllItems();
				DefaultComboBoxModel<ShowTime> timeModel =  new DefaultComboBoxModel<ShowTime>();
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selRoom = e.getItem().toString();
					for (ShowTime showTime : showtimes) {
						Room room = showTime.getRoom();
						if (room.getRoomNumber().equals(selRoom)) {
							timeModel.addElement(showTime);
						}
					}
					startTime.setModel(timeModel);
				}
			}
		});
		;
		JLabel seltime = new JLabel("Showtime:");
		seltime.setBounds(55, 170, 140, 26);
		seltime.setFont(new Font("Courier New", Font.BOLD, 16));
		this.add(seltime);
		startTime = new JComboBox<ShowTime>();
		startTime.setBounds(230, 170, 140, 30);
		this.add(startTime);
		//startTime.addItemListener(this);

		JButton seatBtn = new JButton("Choose The Seat");
		seatBtn.setBounds(325, 260, 170, 40);
		this.add(seatBtn);
		seatBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 需要判断各个下拉数据是否选择
				String movieTitle = movieCbx.getSelectedItem().toString();
				if(movieTitle==null&&"select movie".equals(movieTitle)) {
					displayMessage("Please select movie!");
					return;
				}
				String roomTitle = roomCbx.getSelectedItem().toString();
				if(roomTitle==null&&"select room".equals(roomTitle)) {
					displayMessage("Please select room!");
					return;
				}
				setGloabData(movieTitle,roomTitle);
				List<Seat> seats=new Seat().getAllSeat();
				int seatNums=seats.size();
				new SeatingGUI2(seatNums,seats);
				setVisible(false);
			}
		});
		this.setVisible(true);
	}

	protected void setGloabData(String movieTitle, String roomTitle) {
		AppSeting.movie.setTitle(movieTitle);
		for (Movie movie : movieList) {
			if(movie.getTitle().equals(movieTitle)) {
				AppSeting.movie.setMovieId(movie.getMovieId());
				AppSeting.movie.setPrice(movie.getPrice());
				break;
			}
		}
		AppSeting.showTime.getRoom().setRoomNumber(roomTitle);
		AppSeting.showTime = (ShowTime) startTime.getSelectedItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getSelectTime() {
		return selectTime;
	}

	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}

	public JButton getNextBtn() {
		return nextBtn;
	}

	public void setNextBtn(JButton nextBtn) {
		this.nextBtn = nextBtn;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public JComboBox<String> getMovieCbx() {
		return movieCbx;
	}

	public void setMovieCbx(JComboBox<String> movieCbx) {
		this.movieCbx = movieCbx;
	}

	public JComboBox<String> getRoomCbx() {
		return roomCbx;
	}

	public void setRoomCbx(JComboBox<String> roomCbx) {
		this.roomCbx = roomCbx;
	}

	public JComboBox<ShowTime> getStartTime() {
		return startTime;
	}

	public void setStartTime(JComboBox<ShowTime> startTime) {
		this.startTime = startTime;
	}
}
