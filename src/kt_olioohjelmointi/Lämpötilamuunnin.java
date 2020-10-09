package kt_olioohjelmointi;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class L�mp�tilamuunnin {

		public static void GUIrakenne() {

		JFrame sovellus = new JFrame();
		GridLayout asettelu = new GridLayout(2,2);
		sovellus.setLayout(asettelu);
		
		JLabel celsius = new JLabel("Celsius");
		JTextField celsiusSy�tt� = new JTextField();
		
		JButton convertNappi = new JButton("Convert");
		JLabel fahrenheit = new JLabel("Fahrenheit: ");
		
		sovellus.add(celsius);
		sovellus.add(celsiusSy�tt�);
		sovellus.add(convertNappi);
		sovellus.add(fahrenheit);
		
		sovellus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sovellus.setVisible(true);
		
		sovellus.setTitle("Celsius Converter");
		sovellus.setSize(400,100);
		
		convertNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				double cLuku = Double.parseDouble(celsiusSy�tt�.getText());
				double fLuku = ((cLuku * 9/5) + 32);
				fahrenheit.setText("Fahrenheit: " + fLuku);
			} catch (NumberFormatException virhe) {
				System.out.println("Vastaus t�ytyy sy�tt�� numeroina.");
				}
			}	
		});
		}
		
		public static void main(String[] args) {	
			GUIrakenne();
		}
		
}

