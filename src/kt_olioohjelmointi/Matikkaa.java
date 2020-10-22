package kt_olioohjelmointi;

public class Matikkaa {

	// JUnit-harjoituksia
	
	public static int summa(int eka, int toka) {
		return eka + toka;
	}
	public static double potenssi(int eka, int toka) {
		return Math.pow(eka, toka);
	}
	
	public static boolean ekaSuurempiKuin(int eka, int toka) {
		if (eka > toka) {
			return true;
		}
		return false;
	}
	
	public static int pintaAla(int pituus, int leveys) {
		if (pituus < 0 || leveys < 0) {
			return 0;
		} else {
			return pituus * leveys;
		}
	}
	
	public static void main(String[] args) {

		System.out.println( Matikkaa.summa(2, 3) );
		System.out.println( Matikkaa.potenssi(4, 2) );
		
		System.out.println( Matikkaa.ekaSuurempiKuin(8, 3) );
		System.out.println( Matikkaa.ekaSuurempiKuin(2, 2) );
		System.out.println( Matikkaa.ekaSuurempiKuin(3, 8) );

		System.out.println( Matikkaa.pintaAla(10, 20) );
		System.out.println( Matikkaa.pintaAla(-9, 2) );
	}
}
