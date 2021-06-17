package model;

public class Korisnik {
	private int korisnikID;
	String ime, prezime, korisnickoIme, lozinka;
	
	public Korisnik(int korisnikID, String ime, String prezime, String korisnickoIme, String lozinka) {
		super();
		this.korisnikID = korisnikID;
		this.ime = ime;
		this.prezime = prezime;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public int getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(int korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	@Override
	public String toString() {
		return "Korisnik [korisnikID=" + korisnikID + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme="
				+ korisnickoIme + ", lozinka=" + lozinka + "]";
	}
}
