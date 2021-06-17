package jtable;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

//import controller.Controller;
import model.Putovanje;
import model.dto.PutovanjeDTO;

public class JTablePutovanja extends AbstractTableModel {

	private ArrayList<PutovanjeDTO> lista;

	public JTablePutovanja(ArrayList<PutovanjeDTO> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int r, int c) {
		PutovanjeDTO pom = lista.get(r);
		switch (c) {
		case 0:
			return pom.getKorisnik().getIme() + " " + pom.getKorisnik().getPrezime();
		case 1:
			return pom.getDestinacija().getNaziv();
		case 2:
			return pom.getPutovanje().getPolazak();
		case 3:
			return pom.getPutovanje().getPovratak();
		case 4:
			return pom.getPutovanje().getDuzinaPuta();
		case 5:
			return pom.getPutovanje().getCenaPuta();
		case 6:
			return pom.getPrevoz().getVrsta();
		default:
			return "Greska";
		}
	}

	@Override
	public String getColumnName(int c) {
		switch (c) {
		case 0:
			return "Korisnik";
		case 1:
			return "Destinacija";
		case 2:
			return "Polazak";
		case 3:
			return "Povratak";
		case 4:
			return "Duzina puta";
		case 5:
			return "Cena puta";
		case 6:
			return "Prevoz";
		default:
			return "Greska";
		}
	}

	public void obrisiSelektovano(int r) {
		lista.remove(r);
		fireTableDataChanged();
	}

	public ArrayList<PutovanjeDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PutovanjeDTO> lista) {
		this.lista = lista;
	}

}
