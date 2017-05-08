package ohtu.kivipaperisakset.peli;

import static ohtu.kivipaperisakset.peli.Siirrot.KIVI;
import static ohtu.kivipaperisakset.peli.Siirrot.PAPERI;
import static ohtu.kivipaperisakset.peli.Siirrot.SAKSET;
import ohtu.kivipaperisakset.peli.pelaaja.Pelaaja;

public class KPSPeli extends AbstractKPSPeli {

    @Override
    public void pelaa(Pelaaja eka, Pelaaja toka) {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = eka.teeSiirto();
        String tokanSiirto = toka.teeSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            tulostaEra(tuomari);
            
            ekanSiirto = eka.teeSiirto();
            tokanSiirto = toka.teeSiirto();
            eka.asetaSiirto(tokanSiirto);
            toka.asetaSiirto(ekanSiirto);
        }

        tulostaLopetus(tuomari);
    }
    
    private boolean onkoOkSiirto(String siirto) {
        return KIVI.equals(siirto) || PAPERI.equals(siirto) || SAKSET.equals(siirto);
    }

    private void tulostaEra(Tuomari tuomari) {
        System.out.println(tuomari);
        System.out.println();
    }

    private void tulostaLopetus(Tuomari tuomari) {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
}
