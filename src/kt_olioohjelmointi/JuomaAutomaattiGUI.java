package kt_olioohjelmointi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JuomaAutomaattiGUI extends JFrame implements Serializable {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuomaAutomaatti JuAut = new JuomaAutomaatti();
					JuomaAutomaattiGUI frame = new JuomaAutomaattiGUI(JuAut);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public JuomaAutomaattiGUI(JuomaAutomaatti JuAut){
		setTitle("Juoma-automaatti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Yll‰pito-menu

		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		menuBar.add(mnNewMenu);
		
		// Aseta kahvin m‰‰r‰
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmNewMenuItem.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent arg0) {
				int kahviArvo = 0;
				try {
					do {
						String stringKahvi = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
						kahviArvo = Integer.parseInt(stringKahvi);
						setKahvi(kahviArvo);
					} while (kahviArvo < 0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(mntmNewMenuItem, "Syˆt‰ vastaus numerona");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		// Aseta teen m‰‰r‰
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmNewMenuItem_1.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent e) {
				int teeArvo = 0;
				try {
					do {
						String stringTee = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
						teeArvo = Integer.parseInt(stringTee);
						setTee(teeArvo);
					} while (teeArvo < 0);
				} catch (NumberFormatException z) {
					JOptionPane.showMessageDialog(mntmNewMenuItem_1, "Syˆt‰ vastaus numerona");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		// Aseta kaakaon m‰‰r‰
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		mntmNewMenuItem_2.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent e) {
				int kaakaoArvo = 0;
				try {
					do {
						String stringKaakao = JOptionPane.showInputDialog("Anna uusi arvo: ");
						kaakaoArvo = Integer.parseInt(stringKaakao);
						setKaakao(kaakaoArvo);
					} while (kaakaoArvo < 0);
				} catch (NumberFormatException x) {
					JOptionPane.showMessageDialog(mntmNewMenuItem_2, "Syˆt‰ vastaus numerona");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		// Serialisointi ja lataaminen
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tallenna automaatin tila");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sarjallistaminen(JuAut);
				} catch (Exception e1) {
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(mntmNewMenuItem_3, "Tallennus ep‰onnistui");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Lataa automaatti");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti ladattuJuAut = lataaAutomaatti();
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(mntmNewMenuItem_4, "Tiedostoa ei lˆydy");
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		// Ohjelman lopetus
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Lopeta");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		// Tietoja-menu
		
		JMenu mnNewMenu_1 = new JMenu("Tietoja");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Versiotiedot");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot tietoIkkuna = new Versiotiedot();
				tietoIkkuna.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		
		// Nappi & label -komponenttien luonti
		
		JLabel kahviM‰‰r‰ = new JLabel("Kahvia: ");
		kahviM‰‰r‰.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		kahviM‰‰r‰.setBounds(23, 169, 98, 14);
		contentPane.add(kahviM‰‰r‰);
		
		JButton kaakaoNappi = new JButton("");
		kaakaoNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_kaakao_pieni.png")));
		kaakaoNappi.setBounds(159, 32, 98, 100);
		contentPane.add(kaakaoNappi);
		
		JLabel kaakaoM‰‰r‰ = new JLabel("Kaakaota: ");
		kaakaoM‰‰r‰.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		kaakaoM‰‰r‰.setBounds(159, 169, 98, 14);
		contentPane.add(kaakaoM‰‰r‰);
		
		JButton teeNappi = new JButton("");
		teeNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_teekannu_pieni.png")));
		teeNappi.setBounds(298, 32, 98, 100);
		contentPane.add(teeNappi);
		
		JLabel teeM‰‰r‰ = new JLabel("Teet‰: ");
		teeM‰‰r‰.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		teeM‰‰r‰.setBounds(298, 169, 98, 14);
		contentPane.add(teeM‰‰r‰);
		
		JButton kahviNappi = new JButton("");
		kahviNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_kahvi_pieni.png")));
		kahviNappi.setBounds(23, 32, 98, 100);
		contentPane.add(kahviNappi);
		
		// Juomien nimet & tapahtumia kuvaava teksti
		
		JLabel kahviOtsikko = new JLabel("Kahvi");
		kahviOtsikko.setBounds(54, 134, 46, 14);
		contentPane.add(kahviOtsikko);
		
		JLabel kaakaoOtsikko = new JLabel("Kaakao");
		kaakaoOtsikko.setBounds(190, 134, 46, 14);
		contentPane.add(kaakaoOtsikko);
		
		JLabel teeOtsikko = new JLabel("Tee");
		teeOtsikko.setBounds(334, 134, 46, 14);
		contentPane.add(teeOtsikko);
		
		JLabel tapahtumaTeksti = new JLabel();
		tapahtumaTeksti.setFont(new Font("Tahoma", Font.ITALIC, 11));
		tapahtumaTeksti.setHorizontalAlignment(SwingConstants.CENTER);
		tapahtumaTeksti.setBounds(101, 207, 231, 22);
		contentPane.add(tapahtumaTeksti);
		
		// Nappien toiminnallisuudet
		
		kahviNappi.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent e) {
				valmistaKahvi();
				kahviM‰‰r‰.setForeground(Color.BLACK);
				if (getKahvi() >= 20) {
					kahviM‰‰r‰.setText("Kahvia: " + getKahvi());
					tapahtumaTeksti.setText("Odota hetki, kahvisi valmistuu...");
				} else if (getKahvi() < 20) {
					kahviM‰‰r‰.setText("Kahvia: " + getKahvi());
					kahviM‰‰r‰.setForeground(Color.RED);
					tapahtumaTeksti.setText("Kahvi on loppumassa! T‰yt‰ s‰iliˆ.");
				} 
			}
		});
		
		kaakaoNappi.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent e) {
				valmistaKaakao();
				kaakaoM‰‰r‰.setForeground(Color.BLACK);
				if (getKaakao() >= 20) {
					kaakaoM‰‰r‰.setText("Kaakaota: " + getKaakao());
					tapahtumaTeksti.setText("Odota hetki, kaakaosi valmistuu...");
				} else if (getKaakao() < 20) {
					kaakaoM‰‰r‰.setText("Kaakaota: " + getKaakao());
					kaakaoM‰‰r‰.setForeground(Color.RED);
					tapahtumaTeksti.setText("Kaakao on loppumassa! T‰yt‰ s‰iliˆ.");
				}
			}
		});
		
		teeNappi.addActionListener(new JuomaAutomaatti() {
			public void actionPerformed(ActionEvent e) {
				valmistaTee();
				teeM‰‰r‰.setForeground(Color.BLACK);
				if (getTee() >= 20) {
					teeM‰‰r‰.setText("Teet‰: " + getTee());
					tapahtumaTeksti.setText("Odota hetki, teesi valmistuu...");
				} else if (getTee() < 20) {
					teeM‰‰r‰.setText("Teet‰: " + getTee());
					teeM‰‰r‰.setForeground(Color.RED);
					tapahtumaTeksti.setText("Tee on loppumassa! T‰yt‰ s‰iliˆ.");
				} 
			}
		});
	}

	// Sarjallistaminen ja lataaminen
	
	public void sarjallistaminen(JuomaAutomaatti JuAut) throws IOException {
		FileOutputStream tallennus = new FileOutputStream("GUItallennus.xml");
		XMLEncoder tallentaja = new XMLEncoder(new BufferedOutputStream(tallennus));
	
		tallentaja.writeObject(JuAut);
	
		tallentaja.close();
		tallennus.close();
	}
	
	public static JuomaAutomaatti lataaAutomaatti() throws FileNotFoundException {
		XMLDecoder lataaja = null;
		FileInputStream tallennus = new FileInputStream("GUItallennus.xml");
		
		lataaja = new XMLDecoder(new BufferedInputStream(tallennus));
		JuomaAutomaatti lataus = (JuomaAutomaatti) lataaja.readObject();
		
		lataaja.close();
		return lataus;
	}
}
