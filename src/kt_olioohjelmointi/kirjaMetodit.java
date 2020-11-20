package kt_olioohjelmointi;

import java.awt.GridLayout;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class kirjaMetodit {
	public static void lisääKirja() {
		 
		// lisääKirja() luo ikkunan uuden kirjan tietojen syöttämistä varten

		kirja uusiKirja;
		
		JLabel kirjanimi = new JLabel("Kirjan nimi: ");
		JLabel tekijänimi = new JLabel("Tekijän nimi: ");
		JLabel julkaisuvuosi = new JLabel("Julkaisuvuosi: ");
		
		JTextField kirjanimikenttä = new JTextField("Syötä kirjan nimi");
		JTextField tekijänimikenttä = new JTextField("Syötä kirjailijan nimi");
		JTextField vuosikenttä = new JTextField("Syötä julkaisuvuosi");
		
		JPanel tietokentät = new JPanel();
		GridLayout tietokenttälayout = new GridLayout(0,2);
		tietokentät.setLayout(tietokenttälayout);
		
		tietokentät.add(kirjanimi);
		tietokentät.add(kirjanimikenttä);
		
		tietokentät.add(tekijänimi);
		tietokentät.add(tekijänimikenttä);
		
		tietokentät.add(julkaisuvuosi);
		tietokentät.add(vuosikenttä);
		
		int tulos = JOptionPane.showConfirmDialog(null, tietokentät, "Lisätään kirja: ", JOptionPane.OK_CANCEL_OPTION);
		
		if (tulos == JOptionPane.OK_OPTION) {
			String syötettyKirja = kirjanimikenttä.getText();
			String syötettyKirjailija = tekijänimikenttä.getText();
			int syötettyVuosi = Integer.parseInt(vuosikenttä.getText());
			
			uusiKirja = new kirja(syötettyKirja, syötettyKirjailija, syötettyVuosi); // metodi luo kirja-olion syötettyjen tietojen perusteella
			
			System.out.println("Lisätään: " + uusiKirja.toString());
						
			kirjaTietokantaan(uusiKirja); // ja kutsuu metodia, joka lisää kirjan tietokantaan
		}
	}
		
	public static void kirjaTietokantaan(kirja teos) {
		String kirjanNimi = teos.getKirjanimi();
		String kirjanTekijä = teos.getKirjailijanimi();
		int jVuosi = teos.getJulkaisuvuosi();
		
		// metodi luo yhteyden tietokantaan 
		
		try {
			System.out.println("Luodaan yhteys tietokantaan...");
			
			Connection yht_2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjatietokanta", "root", "***"); // salasana korvattu "***" -merkeillä
			Statement stat_2 = yht_2.createStatement();
			String sqlQuery = "INSERT INTO kirjatiedot (kirjanNimi, kirjailijanNimi, julkaisuVuosi) VALUES (?,?,?)"; // ja suorittaa sql lauseen, joka lisää kirjan tietokantaan
			PreparedStatement preparedStat = yht_2.prepareStatement(sqlQuery);
			
			preparedStat.setString(1, kirjanNimi);
			preparedStat.setString(2, kirjanTekijä);
			preparedStat.setInt(3, jVuosi);
			
			preparedStat.execute();
			
			System.out.println("Tallennetaan kirja tietokantaan...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void poistoPaneeli() {	
		
		// metodi luo ikkunan, johon käyttäjä syöttää poistettavan kirjan nimen
		
		kirja poistettavaKirja;
		
		JLabel nimi = new JLabel("Syötä poistettavan kirjan nimi: ");
		JTextField syötäNimi = new JTextField();
		
		JPanel poistoPaneeli = new JPanel();
		GridLayout poistopaneelilayout = new GridLayout(0,2);
		poistoPaneeli.setLayout(poistopaneelilayout);
		
		poistoPaneeli.add(nimi);
		poistoPaneeli.add(syötäNimi);
		
		int tulos_2 = JOptionPane.showConfirmDialog(null, poistoPaneeli, "Poistetaan kirja: ", JOptionPane.OK_CANCEL_OPTION);
		
		if (tulos_2 == JOptionPane.OK_OPTION) {
			String syötettyKirja = syötäNimi.getText();
			
			poistettavaKirja = new kirja(syötettyKirja, null, 0); // metodi luo olion syötettyjen tietojen perusteella
			
			System.out.println("\nPoistetaan: " + syötettyKirja);
						
			poistaKirja(poistettavaKirja); // ja kutsuu metodia, joka poistaa kirjan tietokannasta
		}
	}
	
	public static void poistaKirja(kirja teos) {
		String poistoNimi = teos.getKirjanimi();
		
		// metodi luo yhteyden tietokantaan
		
		try {
			System.out.println("Luodaan yhteys tietokantaan...");
			
			Connection yht_3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjatietokanta", "root", "***"); // salasana korvattu "***" -merkeillä
			Statement stat_3 = yht_3.createStatement();
			String sqlQuery = "DELETE FROM kirjatiedot WHERE kirjanNimi=?"; // ja suorittaa sql lauseen, joka poistaa kirjan tietokannasta syötetyn nimen perusteella
			PreparedStatement preparedStat = yht_3.prepareStatement(sqlQuery);
			
			
			preparedStat.setString(1, poistoNimi);
			
			preparedStat.execute();
			
			System.out.println("Poistetaan kirja tietokannasta...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
