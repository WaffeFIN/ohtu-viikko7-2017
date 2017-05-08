package ohtu.kivipaperisakset.peli;

import static ohtu.kivipaperisakset.peli.Siirrot.KIVI;
import static ohtu.kivipaperisakset.peli.Siirrot.PAPERI;
import static ohtu.kivipaperisakset.peli.Siirrot.SAKSET;

/**
 * Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.
 */
public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;

    public Tuomari() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (tasapeli(ekanSiirto, tokanSiirto))
            tasapelit++;
        else if (ekaVoitti(ekanSiirto, tokanSiirto))
            ekanPisteet++;
        else
            tokanPisteet++;
    }

    private static boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    private static boolean ekaVoitti(String eka, String toka) {
        if (KIVI.equals(eka) && SAKSET.equals(toka))
            return true;
        else if (SAKSET.equals(eka) && PAPERI.equals(toka))
            return true;
        else if (PAPERI.equals(eka) && KIVI.equals(toka))
            return true;

        return false;
    }

    @Override
    public String toString() {
        String s = "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet + "\n"
            + "Tasapelit: " + tasapelit;
        return s;
    }
}
