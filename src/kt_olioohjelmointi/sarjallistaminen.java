package kt_olioohjelmointi;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class sarjallistaminen {
	public static void tallennaAutomaatti(JuomaAutomaatti JuAut) throws IOException {
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