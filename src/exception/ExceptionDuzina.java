package exception;

import javax.swing.JOptionPane;

public class ExceptionDuzina extends NumberFormatException {
	
	public void izuzetak() {
		JOptionPane.showMessageDialog(null, "Duzina puta je obavezno polje i mora biti pozitivan broj.\nUnos je u kilometrima.");
	}


}
