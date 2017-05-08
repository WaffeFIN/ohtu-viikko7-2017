package ohtu.kivipaperisakset.peli.pelaaja;

import ohtu.kivipaperisakset.peli.tekoaly.Tekoaly;

/**
 *
 * @author Walter Grönholm
 */
public class PelaajaTekoaly implements Pelaaja {

    private final Tekoaly tekoaly;

    public PelaajaTekoaly(Tekoaly tekoaly) {
        this.tekoaly = tekoaly;
    }

    @Override
    public String teeSiirto() {
        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        return siirto;
    }

    @Override
    public void asetaSiirto(String toisenSiirto) {
        tekoaly.asetaSiirto(toisenSiirto);
    }

}
