package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import model.Korisnik;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmSignup extends JFrame {

	private JPanel contentPane;
	private JTextField txtIme;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField txtPrezime;
	JCheckBox chckbxShowPass;
	private JPasswordField passwordField_1;
	private JLabel lblImateProfilUlogujte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSignup frame = new frmSignup();
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
	public frmSignup() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 340, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setBounds(43, 27, 80, 14);
		contentPane.add(lblIme);
		
		txtIme = new JTextField();
		txtIme.setColumns(10);
		txtIme.setBounds(133, 25, 137, 20);
		contentPane.add(txtIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setBounds(43, 63, 80, 14);
		contentPane.add(lblPrezime);
		
		JLabel lblUsername = new JLabel("Korisnicko ime: ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(43, 99, 80, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(133, 97, 137, 20);
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Lozinka:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(43, 135, 80, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(133, 133, 137, 20);
		contentPane.add(passwordField);
		
		txtPrezime = new JTextField();
		txtPrezime.setColumns(10);
		txtPrezime.setBounds(133, 61, 137, 20);
		contentPane.add(txtPrezime);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean usernameExists = false;
				boolean lengthValidation = false;
				boolean passwordsMatch = false;
				for (int i = 0; i < Controller.vratiKorisnike().size(); i++) {
					  if(Controller.vratiKorisnike().get(i).getKorisnickoIme().equalsIgnoreCase(txtUsername.getText())) {
						 usernameExists = true;
					  }
					  else {
						  if(txtIme.getText().trim().length() >= 3 
							 && txtPrezime.getText().trim().length() >= 3 
							 && txtUsername.getText().trim().length() >= 3
							 && passwordField.getText().trim().length() >= 8
							 && passwordField_1.getText().trim().length() >= 8
							 && txtPrezime.getText().matches("[a-zA-Z]+")
							 && txtIme.getText().matches("[a-zA-Z]+")
							 && txtIme.getText() != null
							 && txtPrezime.getText() != null
							 && txtUsername.getText() != null
							 && passwordField.getText() != null
							 && passwordField_1.getText() != null
						  ) {
							  lengthValidation = true;
							  if(passwordField.getText().equals(passwordField_1.getText()))
								  passwordsMatch = true;
						  }	
					  }
					}
				
				if(!usernameExists && lengthValidation && passwordsMatch) {
					dispose();
		            frmLogin login = new frmLogin();
		            login.setVisible(true);
		            
		            String ime = txtIme.getText();
					String prezime = txtPrezime.getText();
					String korisnickoIme = txtUsername.getText();
					String lozinka = passwordField.getText();
					Korisnik k = new Korisnik(0, ime, prezime, korisnickoIme, lozinka);
		            Controller.unosKorisnika(k);
				}
				else {
					if(usernameExists == true) {
						  JOptionPane.showMessageDialog(null, "Korisnicko ime vec postoji.");
						  txtUsername.setText("");
					  }
					  else {
						  if(lengthValidation == false) {
							  if(passwordField.getText().trim().length() < 8) {
							  JOptionPane.showMessageDialog(null, "Lozinka mora imati minimum 8 karaktera.");
							  passwordField.setText("");
							  passwordField_1.setText("");
							  }
							  else {
								  if(txtIme.getText().trim().length() < 3 || !txtIme.getText().matches("[a-zA-Z]+")) {
									  JOptionPane.showMessageDialog(null, "Ime mora sadrzati minimum 3 slova.");
									  txtIme.setText("");
								  }
								  else {
									  if(txtPrezime.getText().trim().length() < 3 || !txtPrezime.getText().matches("[a-zA-Z]+")) {
										  JOptionPane.showMessageDialog(null, "Prezime mora sadrzati minimum 3 slova.");
										  txtPrezime.setText("");
									  }
									  else {
										  if(txtUsername.getText().trim().length() < 3) {
											  JOptionPane.showMessageDialog(null, "Korisnicko ime mora sadrzati minimum 3 karaktera.");
											  txtUsername.setText("");
										  }
									  }
								  }
							  }
						  }
						  else if (passwordsMatch == false) {
							  JOptionPane.showMessageDialog(null, "Lozinke se ne poklapaju.");
								passwordField.setText("");
								passwordField_1.setText("");
						  }
					  }
				}
				
			}
		});
		btnSignup.setBounds(117, 220, 89, 23);
		contentPane.add(btnSignup);
		
		JLabel lblPonoviteLozinku = new JLabel("Ponovite lozinku:");
		lblPonoviteLozinku.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPonoviteLozinku.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPonoviteLozinku.setBounds(22, 171, 101, 14);
		contentPane.add(lblPonoviteLozinku);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(133, 169, 137, 20);
		contentPane.add(passwordField_1);
		
		lblImateProfilUlogujte = new JLabel("Imate profil? Ulogujte se.");
		lblImateProfilUlogujte.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            frmLogin login = new frmLogin();
	            login.setVisible(true);
			}
		});
		lblImateProfilUlogujte.setHorizontalAlignment(SwingConstants.CENTER);
		lblImateProfilUlogujte.setForeground(Color.BLUE);
		lblImateProfilUlogujte.setBounds(69, 261, 188, 14);
		contentPane.add(lblImateProfilUlogujte);
	}
	private void clearFields() {
		txtUsername.setText("");
		txtIme.setText("");
		txtPrezime.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}
}
