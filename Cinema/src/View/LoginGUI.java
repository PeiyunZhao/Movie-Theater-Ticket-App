package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginGUI extends JFrame implements ActionListener{

	private JTextField userNameTxt =null;
	private JPasswordField userPwdTxt =null;
	private String userType="NU";
	private JRadioButton nuAdo =null;
	private JRadioButton ruAdo =null;
	private JButton loginBtn =null;
	
	public LoginGUI() {
		this.setTitle("User Login");
		this.setSize(435, 339);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(359, 230);
		this.setResizable(false);
		this.setLayout(null); 
		JLabel title = new JLabel ("User Login");
		title.setBounds(125, 50, 200, 26);
		title.setFont(new Font("Courier New", Font.BOLD, 30));
		this.add(title); 
		JLabel userTip = new JLabel ("User Name:");
		userTip.setBounds(40, 100, 150, 26);
		userTip.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(userTip); 
		userNameTxt = new JTextField();
		userNameTxt.setBounds(140, 100, 200, 26);
		this.add(userNameTxt); 
		JLabel pwdTip = new JLabel ("User Password:");
		pwdTip.setBounds(40, 155, 150, 26);
		pwdTip.setFont(new Font("Courier New", Font.BOLD, 12));
		this.add(pwdTip); 
		userPwdTxt = new JPasswordField();
		userPwdTxt.setBounds(140, 155, 200, 26);
		this.add(userPwdTxt);
		nuAdo = new JRadioButton("Normal User");
		nuAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		nuAdo.setBounds(30, 200, 140, 30);
		nuAdo.setSelected(true);
		this.add(nuAdo);
		ruAdo = new JRadioButton("Registered User");
		ruAdo.setFont(new Font("Courier New", Font.BOLD, 16));
		ruAdo.setBounds(188, 200, 180, 30);
		this.add(ruAdo);
		nuAdo.addActionListener(this);
		ruAdo.addActionListener(this);
		ButtonGroup radioGrupu = new ButtonGroup();
		radioGrupu.add(ruAdo);
		radioGrupu.add(nuAdo);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(98, 235, 237, 33);
		this.add(loginBtn);
		this.setVisible(true); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nuAdo) {
			this.userType="NU";
		}else if(e.getSource()==ruAdo) {
			this.userType="RU";
		} 
	}
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public void addCalcListener (ActionListener listenForCalcButton) {
		loginBtn.addActionListener(listenForCalcButton);
	}
	
	public JTextField getUserNameTxt() {
		return userNameTxt;
	}

	public void setUserNameTxt(JTextField userNameTxt) {
		this.userNameTxt = userNameTxt;
	}

	public JPasswordField getUserPwdTxt() {
		return userPwdTxt;
	}

	public void setUserPwdTxt(JPasswordField userPwdTxt) {
		this.userPwdTxt = userPwdTxt;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public static void main(String[] args) {
		new LoginGUI();
	}

	
}
