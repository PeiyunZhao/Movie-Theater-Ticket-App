package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import Control.DBController;
import Control.TicketPurchaseController;
import Model.Movie;


public class TicketPurchaseGUI extends JFrame implements ItemListener{
	private String roomNum="room1";
	private JTextField seatNum=null;
	private String selectTime="9:30:00";
	private JButton nextBtn,backBtn;
	private JComboBox<String> movieCbx,roomCbx,startTime;
	private JList movieJList;
	
	private String[] time = { "9:30:00","12:00:00", "14:40:00", "17:20:00"};

	public TicketPurchaseGUI() {
		this.setTitle("Buy Tickets");
		this.setLocation(325, 125);
		this.setResizable(false);
		this.setSize(535, 549);
		this.setLayout(null); 
		
		JLabel title = new JLabel ("Buy Tickets");
		title.setBounds(180, 20, 570, 26);
		title.setFont(new Font("Courier New", Font.BOLD,26));
		this.add(title);
		
		JLabel selMovie = new JLabel ("Select movie:");
		selMovie.setBounds(55, 70, 150, 26);
		selMovie.setFont(new Font("Courier New", Font.BOLD,16));
		this.add(selMovie); 
		
		movieCbx= new JComboBox<String>();
		movieCbx.setBounds(230, 70, 140, 30);
		this.add(movieCbx);
		movieCbx.addItem("Movie List"); 
		
		JLabel selRoom = new JLabel ("Select Room:");
		selRoom.setBounds(55, 120, 150, 26);
		selRoom.setFont(new Font("Courier New", Font.BOLD,16));
		this.add(selRoom); 
		
		roomCbx= new JComboBox<String>();
		roomCbx.setBounds(230, 120, 140, 30);
		this.add(roomCbx);
		roomCbx.addItemListener(this);
		roomCbx.addItem("Room List"); 
		
		JLabel seltime = new JLabel ("Showtime:");
		seltime.setBounds(55, 170, 140, 26);
		seltime.setFont(new Font("Courier New", Font.BOLD,16));
		this.add(seltime);
		startTime= new JComboBox<String>();
		startTime.setBounds(230, 170, 140, 30);
		this.add(startTime);
		startTime.addItemListener(this);
		for (int m = 0; m <4; m++) {
			startTime.addItem(time[m]); 
		}
		
		JLabel seatNumLbl = new JLabel ("Seat Number:");
		seatNumLbl.setBounds(55, 210, 140, 26);
		seatNumLbl.setFont(new Font("Courier New", Font.BOLD,16));
		this.add(seatNumLbl);
		
		seatNum = new JTextField();
		seatNum.setBounds(230, 210, 80, 26);
		seatNum.setText("01");
		seatNum.setEditable(false);
		this.add(seatNum);
		
		JButton seatBtn = new JButton("Choose The Seat");
		seatBtn.setBounds(325, 210, 150, 26);
		this.add(seatBtn);
		seatBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SeatingGUI(); 
			}
		});
		
		JLabel priceLbl = new JLabel ("Price:");
		priceLbl.setBounds(55, 250, 140, 26);
		priceLbl.setFont(new Font("Courier New", Font.BOLD,16));
		this.add(priceLbl);
		
		JTextField priceTxt = new JTextField();
		priceTxt.setBounds(230, 250, 80, 26);
		this.add(priceTxt);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(0, 290, 518, 220);
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.add(infoPanel);
		infoPanel.setBorder(new TitledBorder("UserInfo"));
		infoPanel.setLayout(null);
		
		JLabel nameLbl = new JLabel ("UserName:");
		nameLbl.setBounds(55, 20, 140, 26);
		nameLbl.setFont(new Font("Courier New", Font.BOLD,16));
		infoPanel.add(nameLbl);
		
		JTextField nameTxt = new JTextField();
		nameTxt.setBounds(230, 20, 120, 26);
		infoPanel.add(nameTxt);
		
		JLabel cardLbl = new JLabel ("Credit Card:");
		cardLbl.setBounds(55, 50, 140, 26);
		cardLbl.setFont(new Font("Courier New", Font.BOLD,16));
		infoPanel.add(cardLbl);
		
		JTextField cardTxt = new JTextField();
		cardTxt.setBounds(230, 50, 120, 26);
		infoPanel.add(cardTxt);
		
		JLabel pwdLbl = new JLabel ("PassWord:");
		pwdLbl.setBounds(55, 80, 140, 26);
		pwdLbl.setFont(new Font("Courier New", Font.BOLD,16));
		infoPanel.add(pwdLbl);
		
		JTextField pwdTxt = new JTextField();
		pwdTxt.setBounds(230, 80, 120, 26);
		infoPanel.add(pwdTxt);
		
		JLabel emailLbl = new JLabel ("Email:");
		emailLbl.setBounds(55, 110, 140, 26);
		emailLbl.setFont(new Font("Courier New", Font.BOLD,16));
		infoPanel.add(emailLbl);
		
		JTextField emailTxt = new JTextField();
		emailTxt.setBounds(230, 110, 120, 26);
		infoPanel.add(emailTxt);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(240, 165, 100, 26);
		infoPanel.add(backBtn);
		
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(370, 165, 100, 26);
		infoPanel.add(nextBtn);

		//this.setVisible(true);
	}

	
	public static void main(String[] args) {
		DBController theModel = new DBController();
		theModel.populateList();
		TicketPurchaseGUI theView = new TicketPurchaseGUI();
		TicketPurchaseController theController = new TicketPurchaseController(theModel,theView);
		theView.pack();
		theView.setVisible(true);

	
	}

	

	public void setMovieJList(JList movieJList) {
		// TODO Auto-generated method stub
		
	}

	public void addBackBtnListener(ActionListener listenForBackBtn) {
		// TODO Auto-generated method stub
	
		backBtn.addActionListener(listenForBackBtn);
	}

	public void addNextBtnListener(ActionListener listenForNextBtn) {
		// TODO Auto-generated method stub
	
		backBtn.addActionListener(listenForNextBtn);
	}

	public void addSeatBtnListener(ActionListener listenForSeatBtn) {
		// TODO Auto-generated method stub
	
		backBtn.addActionListener(listenForSeatBtn);
	}
	
	public void addMovieListListener(ListSelectionListener listenerForJList) {
		movieJList.addListSelectionListener(listenerForJList);
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void displayInfo(Movie tempClient) {
		seatNum.setText("A1");
		
	}
}
