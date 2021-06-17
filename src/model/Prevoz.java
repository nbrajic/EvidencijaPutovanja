package model;

public class Prevoz {
	private int prevozID;
	private String vrsta;
	
	public Prevoz(int prevozID, String vrsta) {
		super();
		this.prevozID = prevozID;
		this.vrsta = vrsta;
	}
	public int getPrevozID() {
		return prevozID;
	}
	public void setPrevozID(int prevozID) {
		this.prevozID = prevozID;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	
	@Override
	public String toString() {
		return "Prevoz [prevozID=" + prevozID + ", vrsta=" + vrsta + "]";
	}
}
