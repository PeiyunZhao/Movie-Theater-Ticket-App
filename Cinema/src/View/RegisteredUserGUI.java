package View;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegisteredUserGUI extends JFrame{

	public RegisteredUserGUI() {
		 
	}
	
	public void displayMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public void addCalcListener (ActionListener listenForCalcButton) {
		//loginBtn.addActionListener(listenForCalcButton);
	}
}
