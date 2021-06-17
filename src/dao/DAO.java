package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Destinacija;
import model.Korisnik;
import model.Prevoz;
import model.Putovanje;
import model.dto.PutovanjeDTO;

public class DAO {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static DAO dao;
	
	private DAO() {};
	
	public static DAO getInstance() {
		if(dao == null) dao = new DAO();
		return dao;
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/evidencija_putovanja", "root", "");
	}

	public ArrayList<PutovanjeDTO> vratiSvaPutovanja() throws ClassNotFoundException, SQLException {
		ArrayList<PutovanjeDTO> lista = new ArrayList<PutovanjeDTO>();
		connect();
		String query = "select p.PID, p.PutnikID, p.DestinacijaID, p.PrevozID, p.DuzinaPuta, p.CenaPuta, p.VremePolaska, p.VremeDolaska, k.Ime, k.Prezime, k.KorisnickoIme, k.Lozinka, pr.Vrsta, d.Naziv from putovanje p join korisnik k on k.KorisnikID = p.PutnikID join destinacija d on d.DestinacijaID = p.DestinacijaID join prevoz pr on pr.PrevozID=p.PrevozID ORDER BY ime";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();

		while (resultSet.next()) {
			int pid = resultSet.getInt("pid");
			int putnikID = resultSet.getInt("PutnikID");
			int destinacijaID = resultSet.getInt("DestinacijaID");
			int prevozID = resultSet.getInt("PrevozID");
			double duzinaPuta = resultSet.getDouble("DuzinaPuta");
			double cenaPuta = resultSet.getDouble("CenaPuta");
			Date polazak = resultSet.getDate("VremePolaska");
			Date povratak = resultSet.getDate("VremeDolaska");
			
			Putovanje putovanje = new Putovanje(pid, putnikID, destinacijaID, prevozID, duzinaPuta, cenaPuta, polazak, povratak);
			
			String ime = resultSet.getString("Ime");
			String prezime = resultSet.getString("Prezime");
			String korisnickoIme = resultSet.getString("KorisnickoIme");
			String lozinka = resultSet.getString("Lozinka");
			
			Korisnik korisnik = new Korisnik(putnikID, ime, prezime, korisnickoIme, lozinka);
			
			String vrsta = resultSet.getString("Vrsta");
			
			Prevoz prevoz = new Prevoz(prevozID, vrsta);
			
			String naziv = resultSet.getString("Naziv");
			
			Destinacija destinacija = new Destinacija(destinacijaID, naziv); 
			
			PutovanjeDTO putovanjeDTO = new PutovanjeDTO(putovanje, korisnik, prevoz, destinacija);
			lista.add(putovanjeDTO);
		}
		close();
		return lista;
	}

	public void obrisiSelektovano(int id) throws ClassNotFoundException, SQLException {
		connect();
		String query = "DELETE FROM putovanje WHERE pid = ?";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		close();
	}

	public ArrayList<Korisnik> vratiKorisnike() throws ClassNotFoundException, SQLException {
		connect();
		String query = "SELECT * FROM `korisnik` ORDER BY ime";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		while (resultSet.next()) {
			String ime = resultSet.getString("Ime");
			String prezime = resultSet.getString("Prezime");
			String korisnickoIme = resultSet.getString("KorisnickoIme");
			String lozinka = resultSet.getString("Lozinka");
			int korisnikID = resultSet.getInt("KorisnikID");

			Korisnik k = new Korisnik(korisnikID, ime, prezime, korisnickoIme, lozinka);
			
			korisnici.add(k);
		}
		close();
		return korisnici;
	}
	
	public ArrayList<Destinacija> vratiDestinacije() throws ClassNotFoundException, SQLException {
		connect();
		String query = "SELECT * FROM `destinacija` ORDER BY naziv";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		ArrayList<Destinacija> destinacije = new ArrayList<Destinacija>();
		while (resultSet.next()) {
			String naziv = resultSet.getString("Naziv");
			int id = resultSet.getInt("DestinacijaID");
			Destinacija d = new Destinacija(id, naziv);
			destinacije.add(d);
		}
		close();
		return destinacije;
	}
	
	public void unosKorisnika(Korisnik k) throws ClassNotFoundException, SQLException {
		connect();
		String query = "INSERT INTO Korisnik(`Ime`, `Prezime`, `KorisnickoIme`, `Lozinka`) VALUES (?, ?, ?, ?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setString(1, k.getIme().substring(0, 1).toUpperCase() + k.getIme().substring(1));
		preparedStatement.setString(2, k.getPrezime().substring(0, 1).toUpperCase() + k.getPrezime().substring(1));
		preparedStatement.setString(3, k.getKorisnickoIme());
		preparedStatement.setString(4, k.getLozinka());
		preparedStatement.execute();
		close();
	}
	
	public void unosDestinacije(Destinacija d) throws ClassNotFoundException, SQLException {
		connect();
		String query = "INSERT INTO Destinacija(`Naziv`) VALUES (?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setString(1, d.getNaziv().substring(0, 1).toUpperCase() + d.getNaziv().substring(1));
		preparedStatement.execute();
		close();
	}
	
	public void unosPutovanja(Putovanje p) throws ClassNotFoundException, SQLException {
		connect();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String query = "INSERT INTO `putovanje`(`PutnikID`, `DestinacijaID`, `VremePolaska`, `VremeDolaska`, `DuzinaPuta`, `CenaPuta`, `PrevozID`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.setInt(1, p.getPutnikID());
		preparedStatement.setInt(2, p.getDestinacijaID());
		preparedStatement.setString(3, sdf.format(p.getPolazak()));
		preparedStatement.setString(4, sdf.format(p.getPovratak()));
		preparedStatement.setDouble(5, p.getDuzinaPuta());
		preparedStatement.setDouble(6, p.getCenaPuta());
		preparedStatement.setInt(7, p.getPrevozID());
		preparedStatement.execute();
		close();
	}
	

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
