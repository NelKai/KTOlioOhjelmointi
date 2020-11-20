package kt_olioohjelmointi;

// Konstruktorit, getterit ja setterit kirja-olioille

	public class kirja {
		String kirjanimi;
		String kirjailijanimi;
		int julkaisuvuosi;
		
		public kirja() {
			this.kirjanimi = "Ei määritelty";
			this.kirjailijanimi = "Ei määritelty";
			this.julkaisuvuosi = 0;
		}
		
		public kirja(String kirjanimi, String kirjailijanimi, int julkaisuvuosi) {
			super();
			this.kirjanimi = kirjanimi;
			this.kirjailijanimi = kirjailijanimi;
			this.julkaisuvuosi = julkaisuvuosi;
		}
		
		public String getKirjanimi() {
			return kirjanimi;
		}
		
		public String getKirjailijanimi() {
			return kirjailijanimi;
		}
		
		public int getJulkaisuvuosi() {
			return julkaisuvuosi;
		}
		
		public void setKirjanimi(String nimi) {
			this.kirjanimi = nimi;
		}
		
		public void setKirjailijanimi(String tekijä) {
			this.kirjailijanimi = tekijä;
		}
		
		public void setJulkaisuvuosi(int vuosi) {
			this.julkaisuvuosi = vuosi;
		}
		
		public String toString() {
			String kirjatostring = "\nKirjan nimi: " + this.getKirjanimi() + "\nKirjailijan nimi: " + this.getKirjailijanimi() + "\nJulkaisuvuosi: " + this.getJulkaisuvuosi();
			return kirjatostring;
		}
	}

