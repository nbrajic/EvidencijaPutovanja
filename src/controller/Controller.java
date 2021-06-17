package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.Destinacija;
import model.Korisnik;
import model.Putovanje;
import model.dto.PutovanjeDTO;

public class Controller {
	
	private static Controller kontroler;
	private static ArrayList<PutovanjeDTO> lista;
	private static ArrayList<Korisnik> korisnici;
	private static ArrayList<Destinacija> destinacije;
	
	private Controller() {}
	
	public static Controller getInstance() {
		if(kontroler == null) kontroler = new Controller();
		return kontroler;
	}

	public static void unosKorisnika(Korisnik k) {
		try {
			DAO.getInstance().unosKorisnika(k);
		} catch (ClassNotFoundException | SQLException e) {
		}
	}
	
	public static void unosDestinacije(Destinacija d) {
		try {
			DAO.getInstance().unosDestinacije(d);
		} catch (ClassNotFoundException | SQLException e) {
		}
	}
	
	public static void unosPutovanja(Putovanje p) {
		try {
			DAO.getInstance().unosPutovanja(p);
		} catch (ClassNotFoundException | SQLException e) {
		}
	}
	
	public static ArrayList<Korisnik> vratiKorisnike() {
		try {
			korisnici = DAO.getInstance().vratiKorisnike();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return korisnici;
	}
	
	public static ArrayList<Destinacija> vratiDestinacije() {
		try {
			destinacije = DAO.getInstance().vratiDestinacije();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinacije;
	}

	public static ArrayList<PutovanjeDTO> vratiSvaPutovanja() {
		try {
			lista = DAO.getInstance().vratiSvaPutovanja();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public static void obrisiSelektovano(int id) {
		try {
			DAO.getInstance().obrisiSelektovano(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
