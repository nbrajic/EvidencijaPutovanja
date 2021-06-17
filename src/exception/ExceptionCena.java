package exception;

import javax.swing.JOptionPane;

public class ExceptionCena extends NumberFormatException {
	
	public void izuzetak() {
		JOptionPane.showMessageDialog(null, "Cena je obavezno polje i mora biti pozitivan broj.\nUnos je u evrima.");
	}


}
