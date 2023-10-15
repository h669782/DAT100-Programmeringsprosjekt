package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		Kort[] sortert = samling.getSamling();
		int antallKort = samling.getAntalKort();
		
		for(int i = 0; i < antallKort - 1; i++) {
			for(int j = 0; j < antallKort - i - 1; j++) {
				if(sortert[j].compareTo(sortert[j+1]) > 0) {
					Kort temp = sortert[j];
					sortert[j] = sortert[j+1];
					sortert[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		Kort[] stokket = samling.getSamling();
		int antallKort = samling.getAntalKort();
		Random random = new Random();
		
		for(int i = antallKort - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			Kort temp = stokket[i];
			stokket[i] = stokket[j];
			stokket[j] = temp;
		}
	}
	
}
