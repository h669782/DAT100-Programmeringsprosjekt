package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.kontroll.spill.Spillere;
import no.hvl.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for å representere en vriåtter syd-spiller. Strategien er å lete
 * gjennom kortene man har på hand og spille det første som er lovlig.
 *
 */
public class SydSpiller extends Spiller {

	/**
	 * Konstruktør.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public SydSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for å implementere strategi. Strategien er å spille det første
	 * kortet som er lovlig (også en åtter selv om man har andre kort som også
	 * kan spilles). Dersom man ikke har lovlige kort å spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I så fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg øverst på til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {
	    
	    if (topp == null) {
	        return new Handling(HandlingsType.TREKK, null);
	    }
	    
	    Kort[] hand = getHand().getAllekort();
	    
	    if (hand.length == 0) {
	        return new Handling(HandlingsType.TREKK, null);
	    }
	    
	    for (Kort k : hand) {
	        if (k != null && Regler.kanLeggeNed(k, topp)) {
	            return new Handling(HandlingsType.LEGGNED, k);
	        }
	    }
	    
	    if (getAntallTrekk() < Regler.maksTrekk()) {
	        return new Handling(HandlingsType.TREKK, null);
	    } else {
	        return new Handling(HandlingsType.FORBI, null);
	    }
	}

}
