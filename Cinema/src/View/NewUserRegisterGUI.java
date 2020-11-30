package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Model.RegisteredUser;

public class NewUserRegisterGUI extends JFrame{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserRegisterGUI window = new NewUserRegisterGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField userNameTxt;
	private JTextField cardTxt;
	private JTextField pwdTxt;
	private JTextField emilTxt;
	private JTextField addressTxt;

	/**
	 * Create the application.
	 */
	public NewUserRegisterGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("New User Register");
		this.setLayout(null);
		this.setBounds(400, 200, 590, 450);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("New User Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 25));
		lblNewLabel.setBounds(131, 20,341, 16);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("User Name");
		lblNewLabel_6.setBounds(115, 60, 76, 16);
		this.getContentPane().add(lblNewLabel_6);
		userNameTxt = new JTextField();
		userNameTxt.setBounds(265, 60, 204, 26);
		this.getContentPane().add(userNameTxt);
		userNameTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Credit Card");
		lblNewLabel_7.setBounds(115, 100, 80, 16);
		this.getContentPane().add(lblNewLabel_7);
		cardTxt = new JTextField();
		cardTxt.setBounds(265, 100, 204, 26);
		this.getContentPane().add(cardTxt);
		cardTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setBounds(115, 150, 67, 16);
		this.getContentPane().add(lblNewLabel_8);
		pwdTxt = new JTextField();
		pwdTxt.setBounds(265, 150, 204, 26);
		this.getContentPane().add(pwdTxt);
		pwdTxt.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Email");
		lblNewLabel_9.setBounds(115, 200, 61, 16);
		this.getContentPane().add(lblNewLabel_9);
		emilTxt = new JTextField();
		emilTxt.setBounds(265, 200, 204, 26);
		this.getContentPane().add(emilTxt);
		emilTxt.setColumns(10);
		
		JLabel lblNewLabel_9_1 = new JLabel("Address");
		lblNewLabel_9_1.setBounds(115, 250, 109, 16);
		this.getContentPane().add(lblNewLabel_9_1);
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		addressTxt.setBounds(265, 250, 204, 26);
		this.getContentPane().add(addressTxt);
		
		JLabel TipLabel = new JLabel("$20 dollar annual menbership fee is charged");
		TipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TipLabel.setFont(new Font("Courier New", Font.BOLD, 15));
		TipLabel.setBounds(81,300,431, 16);
		this.getContentPane().add(TipLabel);
		
		JButton backBtn = new JButton("Back To Main Page");
		backBtn.setBounds(119, 350, 160, 28);
		this.getContentPane().add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new WelcomeGUI();
			}
		});
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.setBounds(395, 350, 117, 29);
		this.getContentPane().add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkTheInput()) {
					
					
					RegisteredUser user=new RegisteredUser();
			
					user.setName(userNameTxt.getText().trim());
					user.setPwd(pwdTxt.getText().trim());
					user.setCreditCard(cardTxt.getText().trim());
					user.setEmail(emilTxt.getText().trim());
					user.setAddress(addressTxt.getText().trim());
					if(user.registerUser(user)>=1) {
						displayMessage("New User Register Success.");
						setVisible(false);
						new WelcomeGUI();
					}else {
						displayMessage("New User Register Failure.");
					}
				}
			}
		});
		setVisible(true);
	}

	protected boolean checkTheInput() {
		String username = userNameTxt.getText().trim();
		if ("".equals(username)) {
			displayMessage("Please Fill in User Name");
			return false;
		}
		String card = cardTxt.getText().trim();
		if ("".equals(card)) {
			displayMessage("Please Fill in Credit Card");
			return false;
		}else if(card.length()!=15){
			displayMessage("Credit card length must be 15 digits");
			return false;
		}
		String pwd = pwdTxt.getText().trim();
		if ("".equals(pwd)) {
			displayMessage("Please Fill in Password");
			return false;
		}
		String email = emilTxt.getText().trim();
		if ("".equals(email)) {
			displayMessage("Please Fill in Email");
			return false;
		}
		String address = addressTxt.getText().trim();
		if ("".equals(address)) {
			displayMessage("Please Fill in Address");
			return false;
		}
		return true;
	}
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
