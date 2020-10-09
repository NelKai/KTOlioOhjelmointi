package kt_olioohjelmointi;

public class JuomaAutomaatti {

	private int teetä;
	private int kahvia;
	private int kaakaota;
	
	//konstruktorit
	
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
	
	//metodit
	
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
	
	//getterit ja setterit
	
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
	
	//toString()
	
	public String toString() {
		return ("JuomaAutomaatti [tee=" + teetä + ", kahvi=" + kahvia + ", kaakao=" + kaakaota + "]");
	}
	
}
