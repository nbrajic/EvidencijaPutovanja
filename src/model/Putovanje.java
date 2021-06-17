package model;

import java.util.Date;

public class Putovanje {
	private int PID, putnikID, destinacijaID, prevozID;
	private double duzinaPuta, cenaPuta;
	private Date polazak, povratak;
	
	public Putovanje(int PID, int putnikID, int destinacijaID, int prevozID, double duzinaPuta, double cenaPuta,
			Date polazak, Date povratak) {
		super();
		this.PID = PID;
		this.putnikID = putnikID;
		this.destinacijaID = destinacijaID;
		this.prevozID = prevozID;
		this.duzinaPuta = duzinaPuta;
		this.cenaPuta = cenaPuta;
		this.polazak = polazak;
		this.povratak = povratak;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public int getPutnikID() {
		return putnikID;
	}

	public void setPutnikID(int putnikID) {
		this.putnikID = putnikID;
	}

	public int getDestinacijaID() {
		return destinacijaID;
	}

	public void setDestinacijaID(int destinacijaID) {
		this.destinacijaID = destinacijaID;
	}

	public int getPrevozID() {
		return prevozID;
	}

	public void setPrevozID(int prevozID) {
		this.prevozID = prevozID;
	}

	public double getDuzinaPuta() {
		return duzinaPuta;
	}

	public void setDuzinaPuta(double duzinaPuta) {
		this.duzinaPuta = duzinaPuta;
	}

	public double getCenaPuta() {
		return cenaPuta;
	}

	public void setCenaPuta(double cenaPuta) {
		this.cenaPuta = cenaPuta;
	}

	public Date getPolazak() {
		return polazak;
	}

	public void setPolazak(Date polazak) {
		this.polazak = polazak;
	}

	public Date getPovratak() {
		return povratak;
	}

	public void setPovratak(Date povratak) {
		this.povratak = povratak;
	}

	@Override
	public String toString() {
		return "Putovanje [PID=" + PID + ", putnikID=" + putnikID + ", destinacijaID=" + destinacijaID + ", prevozID="
				+ prevozID + ", duzinaPuta=" + duzinaPuta + ", cenaPuta=" + cenaPuta + ", polazak=" + polazak
				+ ", povratak=" + povratak + "]";
	}

}
