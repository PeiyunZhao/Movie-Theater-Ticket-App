package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Control.ViewController;
import Model.AppSeting;

public class WelcomeGUI extends JFrame{

	public WelcomeGUI() {
		this.setTitle("Welcome");
		this.setSize(635, 339);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(359, 230);
		this.setResizable(false);
		this.setLayout(null); 
		
		JLabel title = new JLabel ("Welcome To The Movie Ticket System");
		title.setBounds(25, 20, 570, 26);
		title.setFont(new Font("Courier New", Font.BOLD,26));
		this.add(title); 
		
		JButton buyBtn = new JButton("Buy Tickets");
		buyBtn.setBounds(50, 90, 237, 43);
		this.add(buyBtn);
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppSeting.option="buy";
				setVisible(false);
				ViewController viewController = new ViewController();
				viewController.showLogisticGUI();
			}
		});
		
		JButton bookBtn = new JButton("Book The Tickets");
		bookBtn.setBounds(345, 90, 237, 43);
		this.add(bookBtn);
		bookBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AppSeting.option="booking";
				setVisible(false);
				ViewController viewController = new ViewController();
				viewController.showBTTLogisticGUI();
			}
		});
		
		JButton regBtn = new JButton("User Register");
		regBtn.setBounds(50, 190, 237, 43);
		this.add(regBtn);
		regBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new NewUserRegisterGUI();
			}
		});
		
		JButton refundBtn = new JButton("Refund Tickets");
		refundBtn.setBounds(345, 190, 237, 43);
		this.add(refundBtn);
		refundBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new RefundGUI();
			}
		});
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new WelcomeGUI();
	}
}
