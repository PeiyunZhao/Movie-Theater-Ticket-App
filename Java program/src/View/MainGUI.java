package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainGUI extends JFrame{

	public MainGUI() {
		this.setTitle("Welcome");
		this.setSize(635, 339);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(359, 230);
		this.setResizable(false);
		this.setLayout(null); 
		
		JLabel title = new JLabel ("Welcome To G15 Movie Theatre");
		title.setBounds(100, 20, 570, 26);
		title.setFont(new Font("Courier New", Font.BOLD,26));
		this.add(title); 
		
		JButton buyBtn = new JButton("Ticket Purchase");
		buyBtn.setBounds(50, 90, 237, 43);
		this.add(buyBtn);
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				dispose();
//				BuyTickets view = new BuyTickets();
//				view.setVisible(true);
			}
		});
		
		JButton bookBtn = new JButton("Ticket Reservation (RU)");
		bookBtn.setBounds(345, 90, 237, 43);
		this.add(bookBtn);
		bookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				dispose();
//				BuyTickets view = new BuyTickets();
//				view.setVisible(true);
			}
		});
		
		JButton regBtn = new JButton("RU Registration");
		regBtn.setBounds(50, 190, 237, 43);
		this.add(regBtn);
		regBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton refundBtn = new JButton("Ticket Refund");
		refundBtn.setBounds(345, 190, 237, 43);
		this.add(refundBtn);
		refundBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				dispose();
//				RefundGUI view = new RefundGUI();
//				view.setVisible(true);
			}
		});
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainGUI();
	}
}
