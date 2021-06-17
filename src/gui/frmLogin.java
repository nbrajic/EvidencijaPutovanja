package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	JCheckBox chckbxShowPass;
	private JLabel lblSignup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 297, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Korisnicko ime: ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(28, 49, 80, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(118, 47, 137, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(118, 88, 137, 20);
		contentPane.add(passwordField);
		
		lblPassword = new JLabel("Lozinka:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(28, 90, 80, 14);
		contentPane.add(lblPassword);
		
		JCheckBox chckbxShowPass = new JCheckBox("Prikazi lozinku");
		chckbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			            if (chckbxShowPass.isSelected()) {
			                passwordField.setEchoChar((char) 0);
			            } else {
			                passwordField.setEchoChar('*');
			            }
			}
		});
		chckbxShowPass.setBounds(118, 114, 137, 23);
		contentPane.add(chckbxShowPass);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean loggedIn = false;
				for (int i = 0; i < Controller.vratiKorisnike().size(); i++) {
					  if(Controller.vratiKorisnike().get(i).getKorisnickoIme().equals(txtUsername.getText()) 
						 && 
						 Controller.vratiKorisnike().get(i).getLozinka().equals(passwordField.getText())) {
						  	loggedIn = true;
					  }
				}
				
				if(loggedIn) {
					dispose();
					frmPutovanja home = new frmPutovanja();
					home.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Pogresno korisnicko ime ili lozinka.");
					clearFields();
				}
			}
		});
		btnLogin.setBounds(96, 162, 89, 23);
		contentPane.add(btnLogin);
		
		lblSignup = new JLabel("Nemate profil? Registrujte se.");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            frmSignup signup = new frmSignup();
	            signup.setVisible(true);
			}
		});
		lblSignup.setForeground(Color.BLUE);
		lblSignup.setBounds(46, 212, 188, 14);
		contentPane.add(lblSignup);
	}
	
	private void clearFields() {
		txtUsername.setText("");
		passwordField.setText("");
	}
}
