package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GenerateTicketNumberGUI extends JFrame{

	private int ticketNum=0;
	private JTextField tickNumTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateTicketNumberGUI window = new GenerateTicketNumberGUI(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param ticketNum 
	 */
	public GenerateTicketNumberGUI(int ticketNum) {
		this.ticketNum = ticketNum;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 584, 344);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Ticket Purchase Successful...");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(36, 24, 395, 33);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblYourTicketNumber = new JLabel("Your Ticket Number Is:");
		lblYourTicketNumber.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblYourTicketNumber.setBounds(36, 91, 203, 33);
		this.getContentPane().add(lblYourTicketNumber);
		
		tickNumTxt = new JTextField();
		tickNumTxt.setBounds(251, 95, 304, 26);
		tickNumTxt.setEditable(false);
		this.getContentPane().add(tickNumTxt);
		tickNumTxt.setColumns(10);
		tickNumTxt.setText(ticketNum+"");
		
		JButton tomainBtn = new JButton("To Main Page");
		tomainBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		tomainBtn.setBounds(218, 262, 129, 33);
		this.getContentPane().add(tomainBtn);
		tomainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new WelcomeGUI();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Copies of your ticket and receipt are sent to your email");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(36, 173, 442, 33);
		this.getContentPane().add(lblNewLabel_1);
		this.setVisible(true);
	}
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(GenerateTicketNumberGUI.this, errorMessage);
	}
}
