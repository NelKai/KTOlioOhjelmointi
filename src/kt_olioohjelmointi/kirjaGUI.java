package kt_olioohjelmointi;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class kirjaGUI extends JFrame {
	public static void main(String args[]) {
		
	// Käyttöliittymän rakenne ja komponentit
		
	JFrame ikkuna = new JFrame("Kirja-tietokanta");
	ikkuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ikkuna.setSize(500,400);
	
	JLabel otsikko = new JLabel("Tietokannassa olevat kirjat:");
	ikkuna.add(otsikko, BorderLayout.NORTH);
	
	JPanel napit = new JPanel();
	GridLayout nappilayout = new GridLayout(0,2);
	napit.setLayout(nappilayout);
	
	JButton lisääNappi = new JButton("Lisää kirja");
	JButton poistaNappi = new JButton("Poista kirja");
	
	napit.add(lisääNappi);
	napit.add(poistaNappi);
	ikkuna.add(napit, BorderLayout.SOUTH);
	
	JTextArea kirjatiedot = new JTextArea("Ladataan kirjoja tietokannasta...");
	kirjatiedot.setEditable(false);
	ikkuna.add(kirjatiedot, BorderLayout.CENTER);
	
	JMenuBar menu = new JMenuBar();
	ikkuna.setJMenuBar(menu);
	
	JMenu toiminnot = new JMenu("Toiminnot");
	menu.add(toiminnot);
	
	ikkuna.setVisible(true);
		
	// Luodaan yhteys tietokantaan ja tuodaan kirjat käyttöliittymään näkyville
	
	try {
		System.out.println("Luodaan yhteys tietokantaan...");
		
		Connection yht = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirjatietokanta", "root", "***"); // salasana korvattu "***"-merkeillä
		Statement stat = yht.createStatement();	
		ResultSet rs = stat.executeQuery("SELECT * FROM kirjatiedot");
		
		String teksti = "";
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			teksti += "\nKirjan nimi: " + rs.getString(1) + "\nKirjailijan nimi:  " + rs.getString(2) + "\nJulkaisuvuosi: " + rs.getString(3) + "\n";
		}
		kirjatiedot.setText(teksti);
	
		} catch(SQLException sqlE) {
			System.out.println("SQL virhe: ");
			sqlE.printStackTrace();
		}
	
	// Tapahtumakuuntelijat napeille ja menulle
	
	lisääNappi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			kirjaMetodit.lisääKirja();
		}
	});
	
	poistaNappi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			kirjaMetodit.poistoPaneeli();
		}
	});
	
	JMenuItem menuLisää = new JMenuItem("Lisää kirja");
	menuLisää.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			kirjaMetodit.lisääKirja();
		}
	});
	toiminnot.add(menuLisää);
	
	JMenuItem menuPoista = new JMenuItem("Poista kirja");
	menuPoista.addActionListener(new ActionListener () {
		public void actionPerformed(ActionEvent e) {
			kirjaMetodit.poistoPaneeli();
		}
	});
	toiminnot.add(menuPoista);
	
	JMenuItem menuLopeta = new JMenuItem("Lopeta");
	menuLopeta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	toiminnot.add(menuLopeta);
	
	}
}
