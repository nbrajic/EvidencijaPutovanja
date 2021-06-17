package model.dto;

import model.Destinacija;
import model.Korisnik;
import model.Prevoz;
import model.Putovanje;

public class PutovanjeDTO {
	private Putovanje putovanje;
	private Korisnik korisnik;
	private Prevoz prevoz;
	private Destinacija destinacija;
	
	public PutovanjeDTO(Putovanje putovanje, Korisnik korisnik, Prevoz prevoz, Destinacija destinacija) {
		super();
		this.putovanje = putovanje;
		this.korisnik = korisnik;
		this.prevoz = prevoz;
		this.destinacija = destinacija;
	}

	public Putovanje getPutovanje() {
		return putovanje;
	}

	public void setPutovanje(Putovanje putovanje) {
		this.putovanje = putovanje;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Prevoz getPrevoz() {
		return prevoz;
	}

	public void setPrevoz(Prevoz prevoz) {
		this.prevoz = prevoz;
	}

	public Destinacija getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	@Override
	public String toString() {
		return "PutovanjeDTO [putovanje=" + putovanje + ", korisnik=" + korisnik + ", prevoz=" + prevoz
				+ ", destinacija=" + destinacija + "]";
	}
}
