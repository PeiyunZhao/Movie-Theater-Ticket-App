package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.AppSeting;
import Model.RegisteredUser;
import Model.ShowTime;
import Model.Ticket;

public class RefundGUI extends JFrame {
	private JLabel tipMesg;
	private JTextField tkNumTxt;

	public RefundGUI() {
		this.setTitle("Ticket Refund");
		this.setSize(485, 360);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(359, 230);
		this.setResizable(false);
		this.setLayout(null);
		JLabel title = new JLabel("Ticket Refund");
		title.setBounds(105, 20, 260, 26);
		title.setFont(new Font("Courier New", Font.BOLD, 26));
		this.add(title);

		JLabel tip = new JLabel("Please Enter Ticket Number:");
		tip.setBounds(15, 60, 360, 26);
		tip.setFont(new Font("Courier New", Font.BOLD, 22));
		this.add(tip);

		tkNumTxt = new JTextField();
		tkNumTxt.setBounds(140, 100, 200, 26);
		this.add(tkNumTxt);

		tipMesg = new JLabel();
		tipMesg.setBounds(15, 145, 450, 50);
		tipMesg.setFont(new Font("Courier New", Font.BOLD, 18));
		tipMesg.setForeground(Color.RED);
		this.add(tipMesg);

		JButton backBtn = new JButton("Back");
		backBtn.setBounds(120, 265, 105, 33);
		this.add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tipMesg.setText("");
				setVisible(false);
				new WelcomeGUI();
			}
		});

		JButton refundBtn = new JButton("Refund");
		refundBtn.setBounds(270, 265, 105, 33);
		this.add(refundBtn);
		refundBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Can't find ficket,try again....");
				String tkNum = tkNumTxt.getText().trim();
				if ("".equals(tkNum)) {
					displayMessage("Please Enter Ticket Number!");
					return;
				}
				Ticket ticket = new Ticket();
				AppSeting.ticket =  ticket.getTicketById(tkNum);
				if(AppSeting.ticket==null) {
					tipMesg.setText("Can't find ficket,try again....");
				}else {
				
					ShowTime showTime = new ShowTime();
					AppSeting.showTime=	showTime.getTicketById(AppSeting.ticket.getShowtime().getStid()+"");
					boolean isrefund = ticket.refund(AppSeting.showTime.getDateTime());
					if(isrefund) {
						if("N/A".equals(AppSeting.ticket.getUserId())){
							AppSeting.userType="NU";
							setVisible(false);
							new RefundOUConfirmationGUI();
						}else {
							AppSeting.userType="RU";
							AppSeting.user = new RegisteredUser().getUserById(AppSeting.ticket.getUserId());
							setVisible(false);
							new RefundRUConfirmationGUI();
						}
					}else {
						tipMesg.setText("<html>The film cannot be refunded within 72 hours of opening....</html>");
					}
				}
			}
		});

		this.setVisible(true);
	}

	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	public void addRefundListener(ActionListener listenForCalcButton) {
		
	}

	public static void main(String[] args) {
		new RefundGUI();
	}
}
