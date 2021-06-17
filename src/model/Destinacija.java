package model;

public class Destinacija {
	private int destinacijaID;
	private String naziv;
	
	public Destinacija(int destinacijaID, String naziv) {
		super();
		this.destinacijaID = destinacijaID;
		this.naziv = naziv;
	}

	public int getDestinacijaID() {
		return destinacijaID;
	}

	public void setDestinacijaID(int destinacijaID) {
		this.destinacijaID = destinacijaID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Destinacija [destinacijaID=" + destinacijaID + ", naziv=" + naziv + "]";
	}
	
}
