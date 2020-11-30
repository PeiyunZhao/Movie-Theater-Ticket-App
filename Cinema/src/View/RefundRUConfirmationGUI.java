package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Control.DBController;
import Model.AppSeting;
import Model.Movie;

import javax.swing.JButton;

public class RefundRUConfirmationGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefundRUConfirmationGUI window = new RefundRUConfirmationGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RefundRUConfirmationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Registered User Refund Confirmation");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(64, 31, 336, 28);
		this.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("A full refund is issued back to your credit card...");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 111, 382, 44);
		this.getContentPane().add(lblNewLabel_1);

		AppSeting.movie = new Movie().getMovieById(AppSeting.ticket.getMovieId());
		if (AppSeting.movie == null) {
			JOptionPane.showMessageDialog(this, "System Error......");
		} else {
			double price = AppSeting.movie.getPrice();
			String creditCard = AppSeting.user.getCreditCard();

			DBController db = new DBController();
			String sql = "update bankaccount set balance=balance+" + price + " where acard="+creditCard;
			System.out.println(sql);
			int num = db.insertToTable(sql);
			if (num == -1) {
				JOptionPane.showMessageDialog(this, "System Error......");
			}

			String sql2 = "delete from ticket where ticketid=" + AppSeting.ticket.getTicketId();
			System.out.println(sql2);
			num = db.insertToTable(sql2);
			if (num == -1) {
				JOptionPane.showMessageDialog(this, "System Error......");
			}
		}
		JButton backBtn = new JButton("Back To Main Page");
		backBtn.setBounds(139, 219, 160, 28);
		this.getContentPane().add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new WelcomeGUI();
			}
		});
		this.setVisible(true);
	}

}
