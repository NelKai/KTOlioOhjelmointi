package kt_olioohjelmointi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuomaAutomaatti implements ActionListener {

	private static int teetä;
	private static int kahvia;
	private static int kaakaota;
		
	public JuomaAutomaatti() {
		teetä = 50;
		kahvia = 50;
		kaakaota = 50;
	}
	
	public JuomaAutomaatti(int tee, int kahvi, int kaakao) {
		teetä = tee;
		kahvia = kahvi;
		kaakaota = kaakao;
	}
		
	public void valmistaKahvi() {	
		System.out.println("\nOdota hetki, kahvisi valmistuu.");
		if(kahvia >= 10) {
			kahvia = kahvia - 10;
		} else {
			kahvia = 0;
			System.out.println("\nKahvia ei ole enää jäljellä! Täytä säiliö.");
		}
	}
	
	public void valmistaTee() {
		System.out.println("\nOdota hetki, teesi valmistuu.");
		if(teetä >= 10) {
			teetä = teetä - 10;
		} else {
			teetä = 0;
			System.out.println("\nTeetä ei ole enää jäljellä! Täytä säiliö.");
			}
	}
	
	public void valmistaKaakao() {
		System.out.println("\nOdota hetki, kaakaosi valmistuu.");

		if(kaakaota >= 10) {
			kaakaota = kaakaota - 10;
		} else {
			kaakaota = 0;
			System.out.println("\nKaakaota ei ole enää jäljellä! Täytä säiliö.");
		}
		
	}
		
	public void setTee(int uusiTee) {
		teetä = uusiTee;
	}
	
	public int getTee() {
		return teetä; 
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
	
	public void kokeilu() {
		System.out.println(getTee());
	}
		
	public String toString() {
		return ("JuomaAutomaatti [tee=" + teetä + ", kahvi=" + kahvia + ", kaakao=" + kaakaota + "]");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
