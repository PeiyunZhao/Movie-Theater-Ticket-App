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
import Model.Coupon;
import Model.Movie;
import Model.OrdinaryUser;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RefundOUConfirmationGUI extends JFrame {

	private JTextField couponNumTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefundOUConfirmationGUI window = new RefundOUConfirmationGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RefundOUConfirmationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 630, 412);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Ordinary User Refund Confirmation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(151, 23, 312, 32);
		this.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("15% Administration Fee Deducted...");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1.setBounds(58, 94, 284, 32);
		this.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Your Coupon Number is ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setBounds(58, 151, 209, 25);
		this.getContentPane().add(lblNewLabel_2);

		couponNumTxt = new JTextField();
		couponNumTxt.setBounds(298, 151, 278, 26);
		this.getContentPane().add(couponNumTxt);
		couponNumTxt.setEditable(false);
		couponNumTxt.setColumns(10);

		//int couponNum = (int) (Math.random() * (1000000 - 1999) + 1000);
		Coupon coupon = new Coupon();
		int couponNum=coupon.generateCouponId();
		couponNumTxt.setText(couponNum + "");

		AppSeting.movie = new Movie().getMovieById(AppSeting.ticket.getMovieId());
		if (AppSeting.movie == null) {
			JOptionPane.showMessageDialog(this, "System Error......");
		} else {
			
		   OrdinaryUser ou=new OrdinaryUser();
		   boolean successRefund=ou.refund(couponNum);
		  if(successRefund==false) {
			  JOptionPane.showMessageDialog(this, "System Error......");
		  }
//
//			double price = AppSeting.movie.getPrice();
//			double couponPrice = price - price * 0.15;
//
//			DBController db = new DBController();
//			String sql = "insert into coupon(couponId,credit)values(" + couponNum + "," + couponPrice + ")";
//			System.out.println(sql);
//			int num = db.insertToTable(sql);
//			if (num == -1) {
//				JOptionPane.showMessageDialog(this, "System Error......");
//			}
//
//			String sql2 = "delete from ticket where ticketid=" + AppSeting.ticket.getTicketId();
//			System.out.println(sql2);
//			num = db.insertToTable(sql2);
//			if (num == -1) {
//				JOptionPane.showMessageDialog(this, "System Error......");
//			}
		}

		JLabel lblNewLabel_1_1 = new JLabel("Coupon is valid for 1 year");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(58, 213, 202, 32);
		this.getContentPane().add(lblNewLabel_1_1);

		JButton backBtn = new JButton("Back To Main Page");
		backBtn.setBounds(237, 310, 173, 37);
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
