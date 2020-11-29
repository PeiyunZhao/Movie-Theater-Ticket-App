package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

import java.util.List;

import javax.swing.JButton;

public class SelectUserTypeGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectUserTypeGUI window = new SelectUserTypeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectUserTypeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		JLabel lblNewLabel = new JLabel("Select User Type");
		lblNewLabel.setBounds(218, 22, 227, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JButton ouBtn = new JButton("Ordinary User");
		ouBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ouBtn.setBounds(119, 80, 173, 84);
		frame.getContentPane().add(ouBtn);
		ouBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton ruBtn = new JButton("Registered User");
		ruBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ruBtn.setBounds(371, 80, 178, 84);
		frame.getContentPane().add(ruBtn);
		ruBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton backBtn = new JButton("Back to Seat Selection");
		backBtn.setBounds(31, 214, 167, 29);
		frame.getContentPane().add(backBtn);
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		frame.setVisible(true);
	}
}

