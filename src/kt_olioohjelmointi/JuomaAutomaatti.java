package kt_olioohjelmointi;

public class JuomaAutomaatti {

	private int teet�;
	private int kahvia;
	private int kaakaota;
	
	//konstruktorit
	
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
	
	//metodit
	
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
	
	//toString()
	
	public String toString() {
		return ("JuomaAutomaatti [tee=" + teet� + ", kahvi=" + kahvia + ", kaakao=" + kaakaota + "]");
	}
	
}
