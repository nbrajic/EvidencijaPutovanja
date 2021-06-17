package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import controller.Controller;
import exception.ExceptionCena;
import exception.ExceptionDuzina;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import jtable.JTablePutovanja;
import model.Destinacija;
import model.Putovanje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPutovanja extends JFrame {

	private JPanel contentPane;
	private JTable tblPutovanja;
	private JTextField txtDuzinaPuta;
	private JTextField txtCenaKarte;
	private ButtonGroup grupa;
	private ArrayList lista;
	JComboBox cmbDestinacija;
	JComboBox cmbIme;
	JDateChooser dchPovratak;
	JDateChooser dchPolazak;
	JRadioButton rdbtnAutobus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPutovanja frame = new frmPutovanja();
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
	public frmPutovanja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o putovanju", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 267, 439);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime i prezime:");
		lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIme.setBounds(10, 35, 90, 14);
		panel.add(lblIme);
		
		cmbIme = new JComboBox();
		DefaultComboBoxModel cmbModelKorisnik = new DefaultComboBoxModel();
		cmbModelKorisnik.addElement("");
		for (int i = 0; i < Controller.vratiKorisnike().size(); i++) {
		  cmbModelKorisnik.addElement(Controller.vratiKorisnike().get(i).getIme() + " " + Controller.vratiKorisnike().get(i).getPrezime());
		}
		cmbIme.setModel(cmbModelKorisnik);
		cmbIme.setBounds(110, 31, 136, 22);
		panel.add(cmbIme);
		
		JLabel lblDestinacija = new JLabel("Destinacija:");
		lblDestinacija.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDestinacija.setBounds(10, 71, 90, 14);
		panel.add(lblDestinacija);
		
		cmbDestinacija = new JComboBox();
		DefaultComboBoxModel cmbModelDestinacija = new DefaultComboBoxModel();
		cmbModelDestinacija.addElement("");
		cmbModelDestinacija.addElement("Nova destinacija");
		for (int i = 0; i < Controller.vratiDestinacije().size(); i++) {
		  cmbModelDestinacija.addElement(Controller.vratiDestinacije().get(i).getNaziv());
		}
		
		cmbDestinacija.setModel(cmbModelDestinacija);
		cmbDestinacija.setBounds(110, 67, 136, 22);
		panel.add(cmbDestinacija);
		
		dchPolazak = new JDateChooser();
		dchPolazak.setBounds(110, 103, 136, 22);
		panel.add(dchPolazak);
		
		JLabel lblPolazak = new JLabel("Datum polaska:");
		lblPolazak.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPolazak.setBounds(10, 107, 90, 14);
		panel.add(lblPolazak);
		
		JLabel lblPovratak = new JLabel("Datum povratka:");
		lblPovratak.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPovratak.setBounds(5, 143, 95, 14);
		panel.add(lblPovratak);
		
		dchPovratak = new JDateChooser();
		dchPovratak.setBounds(110, 139, 136, 22);
		panel.add(dchPovratak);
		
		txtDuzinaPuta = new JTextField();
		txtDuzinaPuta.setBounds(110, 175, 136, 22);
		panel.add(txtDuzinaPuta);
		txtDuzinaPuta.setColumns(10);
		
		JLabel lblDuzinaPuta = new JLabel("Duzina puta:");
		lblDuzinaPuta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuzinaPuta.setBounds(10, 179, 90, 14);
		panel.add(lblDuzinaPuta);
		
		JLabel lblCenaKarte = new JLabel("Cena karte:");
		lblCenaKarte.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCenaKarte.setBounds(10, 215, 90, 14);
		panel.add(lblCenaKarte);
		
		txtCenaKarte = new JTextField();
		txtCenaKarte.setColumns(10);
		txtCenaKarte.setBounds(110, 211, 136, 22);
		panel.add(txtCenaKarte);
		
		JRadioButton rdbtnAvion = new JRadioButton("Avion");
		rdbtnAvion.setBounds(110, 247, 80, 23);
		panel.add(rdbtnAvion);
		
		rdbtnAutobus = new JRadioButton("Autobus");
		rdbtnAutobus.setSelected(true);
		rdbtnAutobus.setBounds(110, 273, 80, 23);
		panel.add(rdbtnAutobus);
		
		grupa = new ButtonGroup();
		grupa.add(rdbtnAvion);
		grupa.add(rdbtnAutobus);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date polazak = dchPolazak.getDate();
				Date povratak = dchPovratak.getDate();
				String korisnik = cmbIme.getSelectedItem().toString();
				String destinacija = null;
				Double duzinaPuta = null;
				Double cenaKarte = null;
				
				try {
					pogresnaCena();
					cenaKarte = Double.parseDouble(txtCenaKarte.getText());
				} catch (ExceptionCena e1) {
					e1.izuzetak();
					txtCenaKarte.setText("");
				}
				if(cenaKarte != null) {
					try {
						pogresnaDuzina();
						duzinaPuta = Double.parseDouble(txtDuzinaPuta.getText());
					} catch (ExceptionDuzina e1) {
						e1.izuzetak();
						txtDuzinaPuta.setText("");
					}
				}
				
				if(!cmbDestinacija.getSelectedItem().equals("")) 
					destinacija = cmbDestinacija.getSelectedItem().toString();
				
				if(cmbModelDestinacija.getSelectedItem().toString().equals("Nova destinacija")) {
					String novaDest = JOptionPane.showInputDialog(null, "Dodajte novu destinaciju: ");
					boolean postoji = false;
					if (novaDest != null) { 
						for (int i = 0; i < Controller.vratiDestinacije().size(); i++) {
							  if(novaDest.equalsIgnoreCase(Controller.vratiDestinacije().get(i).getNaziv())) {
								  postoji = true;
								  JOptionPane.showMessageDialog(null, "Destinacija vec postoji.");
							  }
						}
					if(!postoji) {	
						Destinacija nova = new Destinacija(0, novaDest);
						Controller.unosDestinacije(nova);
						cmbDestinacija.removeAllItems();
						cmbModelDestinacija.addElement("");
						cmbModelDestinacija.addElement("Nova destinacija");
						for (int i = 0; i < Controller.vratiDestinacije().size(); i++) {
							  cmbModelDestinacija.addElement(Controller.vratiDestinacije().get(i).getNaziv());	 
						}
						cmbDestinacija.setModel(cmbModelDestinacija);
						 destinacija = novaDest;
						 cmbDestinacija.setSelectedItem(novaDest);
						} else {
							 JOptionPane.showMessageDialog(null, "Destinacija nije dodata.");
						}
					}
				
			}
				if (korisnik != null
					&& destinacija != null
				    && polazak != null
				    && povratak != null
				    && duzinaPuta != null
				    && cenaKarte != null
				    && (rdbtnAutobus.isSelected() || rdbtnAvion.isSelected())
					) {
						if(cenaKarte > 0 && duzinaPuta > 0) {
							int putnikID = 0;
							if(polazak.before(povratak)) {
								if(cmbIme.getSelectedIndex() >= 1) {
									putnikID = Controller.vratiKorisnike().get(cmbIme.getSelectedIndex() - 1).getKorisnikID();
									int destinacijaID = Controller.vratiDestinacije().get(cmbDestinacija.getSelectedIndex() - 2).getDestinacijaID();
									 int prevozID = rdbtnAvion.isSelected() ? 16 : 17;
									 Putovanje p = new Putovanje(0, putnikID, destinacijaID, prevozID, duzinaPuta, cenaKarte, polazak, povratak);
									 Controller.unosPutovanja(p);
									 clearFields();
									 lista = Controller.vratiSvaPutovanja();
									 tblPutovanja.setModel((TableModel) new JTablePutovanja(lista));
								}
								else {
									cmbIme.setSelectedIndex(0);
									JOptionPane.showMessageDialog(null, "Korisnik je obavezno polje.");
								}
							}
							else
								JOptionPane.showMessageDialog(null, "Datum polaska mora biti pre datuma povratka.");
						}
						else
							JOptionPane.showMessageDialog(null, "Cena karte i duzina puta moraju biti pozitivan broj.");
				}
				else {
					if(cenaKarte != null && duzinaPuta != null)
						if(destinacija == null)
							JOptionPane.showMessageDialog(null, "Destinacija je obavezno polje.");
						else
							JOptionPane.showMessageDialog(null, "Datumi polaska i povratka su obavezna polja.");
				}
					
						
			}
		});
		btnDodaj.setBounds(157, 321, 89, 23);
		panel.add(btnDodaj);
		
		JButton btnPrikazi = new JButton("Prikazi");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista = Controller.vratiSvaPutovanja();
				tblPutovanja.setModel((TableModel) new JTablePutovanja(lista));
			}
		});
		btnPrikazi.setBounds(157, 357, 89, 23);
		panel.add(btnPrikazi);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTablePutovanja model = (JTablePutovanja) tblPutovanja.getModel();
				int selectedRow = tblPutovanja.getSelectedRow();
				if(selectedRow != -1) {
					int id = model.getLista().get(selectedRow).getPutovanje().getPID();
					Controller.obrisiSelektovano(id);
					model.obrisiSelektovano(selectedRow);
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Nije selektovano putovanje za brisanje.");
				}

			}
		});
		btnObrisi.setBounds(157, 393, 89, 23);
		panel.add(btnObrisi);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			String[] options = {"Da", "Ne"};
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showOptionDialog
					(null, 
					 "Da li ste sigurni da zelite da se izlogujete?", 
					 "Logout", 
					 JOptionPane.DEFAULT_OPTION, 
					 JOptionPane.INFORMATION_MESSAGE, 
					 null, 
					 options, 
					 options[1]);
				
				if (response == 0) {
					dispose();
		            frmLogin login = new frmLogin();
		            login.setVisible(true);
				}
				
			}
		});
		btnLogOut.setBounds(10, 393, 89, 23);
		panel.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(Color.BLACK, 0));
		scrollPane.setBounds(285, 11, 534, 439);
		contentPane.add(scrollPane);
		
		tblPutovanja = new JTable();
		tblPutovanja.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Korisnik", "Destinacija", "Polazak", "Povratak", "Duzina puta", "Cena", "Prevoz"
			}
		));
		scrollPane.setViewportView(tblPutovanja);
		
	}
	
	private void clearFields() {
		txtCenaKarte.setText("");
		txtDuzinaPuta.setText("");
		cmbIme.setSelectedIndex(0);
		cmbDestinacija.setSelectedIndex(0);
		dchPolazak.setDate(null);
		dchPovratak.setDate(null);
		rdbtnAutobus.setSelected(true);
		
	}
	
	public void pogresnaCena() throws ExceptionCena {
		if(txtCenaKarte.getText().matches("[a-zA-Z]+") || txtCenaKarte.getText().trim().length() == 0)
			throw new ExceptionCena();
	}
	
	public void pogresnaDuzina() throws ExceptionDuzina {
		if(txtDuzinaPuta.getText().matches("[a-zA-Z]+") || txtDuzinaPuta.getText().trim().length() == 0)
			throw new ExceptionDuzina();
	}
}
