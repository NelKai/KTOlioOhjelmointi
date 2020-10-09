package kt_olioohjelmointi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class JuomaAutomaattiGUI extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuomaAutomaattiGUI frame = new JuomaAutomaattiGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JuomaAutomaattiGUI() {
		setTitle("Juoma-automaatti");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//napit ja m��r�t
		
		JLabel kahviM��r� = new JLabel("Kahvia: ");
		kahviM��r�.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		kahviM��r�.setBounds(23, 198, 98, 14);
		contentPane.add(kahviM��r�);
		
		JButton kaakaoNappi = new JButton("");
		kaakaoNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_kaakao_pieni.png")));
		kaakaoNappi.setBounds(159, 32, 98, 100);
		contentPane.add(kaakaoNappi);
		
		JLabel kaakaoM��r� = new JLabel("Kaakaota: ");
		kaakaoM��r�.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		kaakaoM��r�.setBounds(159, 198, 98, 14);
		contentPane.add(kaakaoM��r�);
		
		JButton teeNappi = new JButton("");
		teeNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_teekannu_pieni.png")));
		teeNappi.setBounds(298, 32, 98, 100);
		contentPane.add(teeNappi);
		
		JLabel teeM��r� = new JLabel("Teet�: ");
		teeM��r�.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		teeM��r�.setBounds(298, 198, 98, 14);
		contentPane.add(teeM��r�);
		
		JButton kahviNappi = new JButton("");
		kahviNappi.setIcon(new ImageIcon(JuomaAutomaattiGUI.class.getResource("/kt_olioohjelmointi/GUI_kahvi_pieni.png")));
		kahviNappi.setBounds(23, 32, 98, 100);
		contentPane.add(kahviNappi);
		
		//kuvaavat otsikot
		
		JLabel kahviOtsikko = new JLabel("Kahvi");
		kahviOtsikko.setBounds(54, 134, 46, 14);
		contentPane.add(kahviOtsikko);
		
		JLabel kaakaoOtsikko = new JLabel("Kaakao");
		kaakaoOtsikko.setBounds(190, 134, 46, 14);
		contentPane.add(kaakaoOtsikko);
		
		JLabel teeOtsikko = new JLabel("Tee");
		teeOtsikko.setBounds(334, 134, 46, 14);
		contentPane.add(teeOtsikko);
		
		kahviNappi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		kaakaoNappi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}

class JuomaAutomaattiKopio {

	private int teet�;
	private int kahvia;
	private int kaakaota;
	
	//konstruktorit
	
	public JuomaAutomaattiKopio() {
		teet� = 50;
		kahvia = 50;
		kaakaota = 50;
		
	}
	
	public JuomaAutomaattiKopio(int tee, int kahvi, int kaakao) {
		teet� = tee;
		kahvia = kahvi;
		kaakaota = kaakao;
	}
	
	//metodit
	
	/*@Override
	public void actionPerformed(ActionEvent e) {
	
	// public class valmistaKahvi() {	
		System.out.println("\nOdota hetki, kahvisi valmistuu.");

		if(kahvia >= 10) {
			kahvia = kahvia - 10;
		} else {
			kahvia = 0;
			System.out.println("\nKahvia ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
		
	}*/
	
	
	public void valmistaTee() {
		System.out.println("\nOdota hetki, teesi valmistuu.");

		if(teet� >= 10) {
			teet� = teet� - 10;
		} else {
			teet� = 0;
			System.out.println("\nTeet� ei ole en�� j�ljell�! T�yt� s�ili�.");
			}
		
	}
	
	public void valmistaKaakao() {
		System.out.println("\nOdota hetki, kaakaosi valmistuu.");

		if(kaakaota >= 10) {
			kaakaota = kaakaota - 10;
		} else {
			kaakaota = 0;
			System.out.println("\nKaakaota ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
		
	}
	
	//getterit ja setterit
	
	public void setTee(int uusiTee) {
		teet� = uusiTee;
		
	}
	
	public int getTee() {
		return teet�; 
	}
	
	public void setKahvi(int uusiKahvi) {
		kahvia = uusiKahvi;
	}
	
	public int getKahvi() {
		return kahvia;
	}
	
	public void setKaakao(int uusiKaakao) {
		kaakaota = uusiKaakao;
	}
	
	public int getKaakao() {
		return kaakaota;
	}
	
	//toString
	
	public String toString() {
		return ("JuomaAutomaatti [tee=" + teet� + ", kahvi=" + kahvia + ", kaakao=" + kaakaota + "]");
	}

	
	
}
