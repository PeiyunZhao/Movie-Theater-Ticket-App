package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import Control.DBController;
import Model.AppSeting;
import Model.Coupon;
import Model.FinancialInstitute;
import Model.Payment;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PaymentGUI extends JFrame {

	private JTextField mntxt;
	private JTextField timeTxt;
	private JTextField roomTxt;
	private JTextField seatTxt;
	private JTextField priceTxt;
	private JTextField userNameTxt;
	private JTextField cardTxt;
	private JTextField pwdTxt;
	private JTextField emilTxt;
	private JTextField couponTxt;
	private String userName;
	private String card;
	private String pwd;
	private String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI window = new PaymentGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 740, 468);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);

		JLabel lblNewLabel = new JLabel("Ticket Purchase");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel.setBounds(311, 20, 141, 16);
		this.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Movie");
		lblNewLabel_1.setBounds(27, 92, 53, 16);
		this.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Showtime");
		lblNewLabel_2.setBounds(27, 146, 76, 16);
		this.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Room");
		lblNewLabel_3.setBounds(27, 197, 61, 16);
		this.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Seat Number");
		lblNewLabel_4.setBounds(27, 253, 92, 16);
		this.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setBounds(27, 306, 61, 16);
		this.getContentPane().add(lblNewLabel_5);

		mntxt = new JTextField();
		mntxt.setBounds(126, 87, 173, 26);
		this.getContentPane().add(mntxt);
		mntxt.setText(AppSeting.movie.getTitle());
		mntxt.setEditable(false);
		mntxt.setColumns(10);

		timeTxt = new JTextField();
		timeTxt.setBounds(126, 141, 173, 26);
		timeTxt.setText(AppSeting.showTime.getDateTime());
		timeTxt.setEditable(false);
		this.getContentPane().add(timeTxt);
		timeTxt.setColumns(10);

		roomTxt = new JTextField();
		roomTxt.setBounds(126, 192, 173, 26);
		roomTxt.setText(AppSeting.showTime.getRoom().getRoomNumber());
		roomTxt.setEditable(false);
		this.getContentPane().add(roomTxt);
		roomTxt.setColumns(10);

		seatTxt = new JTextField();
		seatTxt.setBounds(126, 248, 173, 26);
		seatTxt.setText(AppSeting.seat.getSeatId() + "");
		seatTxt.setEditable(false);
		this.getContentPane().add(seatTxt);
		seatTxt.setColumns(10);

		priceTxt = new JTextField();
		priceTxt.setBounds(126, 301, 173, 26);
		priceTxt.setText(AppSeting.movie.getPrice() + "");
		priceTxt.setEditable(false);
		this.getContentPane().add(priceTxt);
		priceTxt.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("User Name");
		lblNewLabel_6.setBounds(395, 92, 76, 16);
		this.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Credit Card");
		lblNewLabel_7.setBounds(395, 146, 80, 16);
		this.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setBounds(395, 197, 67, 16);
		this.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setBounds(395, 253, 61, 16);
		this.getContentPane().add(lblNewLabel_9);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(501, 87, 204, 26);
		this.getContentPane().add(userNameTxt);
		userNameTxt.setColumns(10);
		if ("UN".equals(AppSeting.userType)) {
			userNameTxt.setText("N/A");
		}

		cardTxt = new JTextField();
		cardTxt.setBounds(501, 141, 204, 26);
		this.getContentPane().add(cardTxt);
		cardTxt.setColumns(10);

		pwdTxt = new JTextField();
		pwdTxt.setBounds(501, 192, 204, 26);
		this.getContentPane().add(pwdTxt);
		pwdTxt.setColumns(10);

		emilTxt = new JTextField();
		emilTxt.setBounds(501, 248, 204, 26);
		this.getContentPane().add(emilTxt);
		emilTxt.setColumns(10);

		JLabel lblNewLabel_9_1 = new JLabel("Coupon Number");
		lblNewLabel_9_1.setBounds(392, 307, 109, 16);
		this.getContentPane().add(lblNewLabel_9_1);

		couponTxt = new JTextField();
		couponTxt.setColumns(10);
		couponTxt.setBounds(501, 301, 204, 26);
		this.getContentPane().add(couponTxt);

		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ("UN".equals(AppSeting.userType)) {
					new SelectUserTypeGUI();
				} else {
					new RegisteredUserLoginGUI();
				}
				setVisible(false);
			}
		});
		backBtn.setBounds(182, 390, 117, 29);
		this.getContentPane().add(backBtn);

		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String username = userNameTxt.getText().trim();
				if ("".equals(username)) {
					displayMessage("Please Fill in User Name");
					return;
				}
				String card = cardTxt.getText().trim();
				if ("".equals(card)) {
					displayMessage("Please Fill in Credit Card");
					return;
				}
				String pwd = pwdTxt.getText().trim();
				if ("".equals(pwd)) {
					displayMessage("Please Fill in Password");
					return;
				}
				String email = emilTxt.getText().trim();
				if ("".equals(email)) {
					displayMessage("Please Fill in Email");
					return;
				}
				Double cardId = 0.0;
				try {
					cardId = Double.parseDouble(card);
				} catch (NumberFormatException e) {
					displayMessage("Credit Card input Error");
					return;
				}
				if ("RU".equals(AppSeting.userType)) {
					boolean isok = AppSeting.user.checkUserInfo(username, card, pwd, email);// 验证用户信息
					if (!isok) {
						return;
					}
				}
				
				Payment payment=new Payment();
				FinancialInstitute bank = new FinancialInstitute();
				
				AppSeting.user.setCreditCard(card);
				AppSeting.user.setEmail(email);
				String coupon = couponTxt.getText().trim();
				double couponPrice =0;
				if (!"".equals(coupon)) {
					int cpNum = 0;
					try {
						cpNum = Integer.parseInt(coupon);
					} catch (NumberFormatException e) {
						displayMessage("Coupon Number input Error");
						return;
					}

					couponPrice = payment.testCoupon(cpNum);
					if(couponPrice==0) {
						displayMessage("Coupon Number the invalid");
						return;
					}
					Coupon cp = new Coupon();
					cp.setCredit(cardId);
					cp.setCouponId(cpNum);
					cp.setCredit(couponPrice);
					AppSeting.user.setCoupon(cp);
				}

				int ticketNum = AppSeting.saveDataToDB();
				
				
				if (ticketNum != 0) {
					String creditCard = "";
					double price = AppSeting.movie.getPrice();
					if ("RU".equals(AppSeting.userType)) {
						creditCard = AppSeting.user.getCreditCard();
					} else {
						creditCard = cardTxt.getText().trim();
						boolean isOk= payment.checkCard(creditCard,pwd);
						if(!isOk) {
							displayMessage("Incorrect Credit card number or password");
							return;
						}
					}

					if(couponPrice!=0) {
						price = price + couponPrice;

						payment.useCoupons(coupon);
					}
					int num=bank.updateBalance(price,creditCard);
					

					if (num == -1) {
						displayMessage("An exception occurred while making the payment......");
					} else {
						setVisible(false);
						new GenerateTicketNumberGUI(ticketNum);
					}
				} else {
					displayMessage("System Error....");
				}
			}
		});
		confirmBtn.setBounds(395, 390, 117, 29);
		this.getContentPane().add(confirmBtn);
		this.setVisible(true);
	}

private void displayAfterCheckUserInfo() {
	if (AppSeting.user.checkUserInfo(userName,card,pwd,email)==false) {
		displayMessage("Incorrect user name entered!");
		displayMessage("Incorrect user password entered!");
		displayMessage("Incorrect Credit Card entered!");
		displayMessage("Incorrect Email entered!");
	}
}
	

	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
