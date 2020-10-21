package kt_olioohjelmointi;

import java.util.Scanner;
import java.io.*;

public class Lukemista {

	// Viope kehittämisharjoituksia OSA 2 teht. 3
	
	public static void main(String[] args) {
		
		File tiedosto = new File("teksti.txt");
		Scanner lukija = new Scanner(System.in);
		
		try {	
			System.out.print("Anna haettava sana: ");
			String haettavaSana = lukija.nextLine();
			int rivinro = 0;
			lukija = new Scanner(tiedosto);

				while (lukija.hasNextLine()) {
					String rivi = lukija.nextLine();
					rivinro++;	
					
					if (rivi.indexOf(haettavaSana) > -1) {
						System.out.println(rivinro + ": " + rivi);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Tiedostoa ei löydy.");
		}
	}
	
}
