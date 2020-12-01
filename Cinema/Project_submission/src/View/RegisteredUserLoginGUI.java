package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Model.AppSeting;
import Model.RegisteredUser;

import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisteredUserLoginGUI extends JFrame{

	private JTextField userNameTxt;
	private JPasswordField pwdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredUserLoginGUI window = new RegisteredUserLoginGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisteredUserLoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(300, 300, 574, 342);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Registered User Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(175, 27, 230, 38);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 104, 90, 26);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(71, 173, 90, 26);
		this.getContentPane().add(lblNewLabel_1_1);
		
		userNameTxt = new JTextField();
		userNameTxt.setBounds(188, 105, 253, 26);
		this.getContentPane().add(userNameTxt);
		userNameTxt.setColumns(10);
		
		pwdTxt = new JPasswordField();
		pwdTxt.setColumns(10);
		pwdTxt.setBounds(188, 174, 253, 26);
		this.getContentPane().add(pwdTxt);
		
		JButton userTypeBtn = new JButton("Back to Select User Type");
		userTypeBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		userTypeBtn.setBounds(34, 270, 209, 29);
		this.getContentPane().add(userTypeBtn);
		userTypeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SelectUserTypeGUI();
			}
		});
		
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		confirmBtn.setBounds(420, 270, 117, 29);
		this.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisteredUser user = new RegisteredUser();
				String name = userNameTxt.getText().trim();
				if("".equals(name)) {
					displayMessage("Please enter the user name");
					return;
				}
				String pwd = pwdTxt.getText().trim();
				if("".equals(pwd)) {
					displayMessage("Please enter the user name");
					return;
				}
				AppSeting.user = user.login(name, pwd);
				if(AppSeting.user!=null) {
					setVisible(false);
					new PaymentGUI();
				}else {
					displayMessage("Login failed, please try again...");
					return;
				} 
			}
		});
		this.setVisible(true);
	}
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
