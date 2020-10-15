package kt_olioohjelmointi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JuomaAutomaatti implements ActionListener {

	private static int teet�;
	private static int kahvia;
	private static int kaakaota;
		
	public JuomaAutomaatti() {
		teet� = 50;
		kahvia = 50;
		kaakaota = 50;
	}
	
	public JuomaAutomaatti(int tee, int kahvi, int kaakao) {
		teet� = tee;
		kahvia = kahvi;
		kaakaota = kaakao;
	}
		
	public void valmistaKahvi() {	
		System.out.println("\nOdota hetki, kahvisi valmistuu.");
		if(kahvia >= 10) {
			kahvia = kahvia - 10;
		} else {
			kahvia = 0;
			System.out.println("\nKahvia ei ole en�� j�ljell�! T�yt� s�ili�.");
		}
	}
	
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
	
	public void kokeilu() {
		System.out.println(getTee());
	}
		
	public String toString() {
		return ("JuomaAutomaatti [tee=" + teet� + ", kahvi=" + kahvia + ", kaakao=" + kaakaota + "]");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
