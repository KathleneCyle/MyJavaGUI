import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup {
	public Signup() {
		JFrame frame = new JFrame("Signup");
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.setBackground(Color.WHITE);
		JLabel label = new JLabel("Create Account");
		label.setFont(new Font("Monospaced", Font.BOLD, 40));
		panel.add(label);

		JLabel subheading = new JLabel("<html>Create account to continue.</html>");
		subheading.setFont(new Font("Monospaced", Font.PLAIN, 16));
		subheading.setPreferredSize(new Dimension(300, 50));
		panel.add(subheading);

		Components components = new Components();
		components.setBackground(Color.WHITE);
		components.setLayout(new GridLayout(8, 1));

		JTextField username = components.InputTextField("Username");
		JPasswordField userpassword = components.PasswordTextField("Password");

		JButton signup = components.Button("Create Account", Color.WHITE, Color.RED);
		JButton login = components.Link("I have account, Login.", Color.RED, Color.WHITE);

		// add action listeners when login button is clicked
		signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (username.getText().isEmpty() && userpassword.getText().isEmpty()
						|| username.getText().equals("Username") || userpassword.getText().equals("Password")) {
					JOptionPane.showMessageDialog(frame, "Username and password field is required.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (username.getText().length() < 3) {
					JOptionPane.showMessageDialog(frame, "Username must be at least 4 characters.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (userpassword.getText().length() < 8) {
					JOptionPane.showMessageDialog(frame, "Password must be at least 8 characters.",
							"Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "Registered successfully.", "Error",
							JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					new Login();
				}
			}
		});

		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
			}
		});

		panel.add(components);
		frame.add(panel);
		frame.setVisible(true);
	}

}