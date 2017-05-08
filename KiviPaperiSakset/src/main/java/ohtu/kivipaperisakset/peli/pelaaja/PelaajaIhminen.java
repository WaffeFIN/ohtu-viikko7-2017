package ohtu.kivipaperisakset.peli.pelaaja;

import java.util.Scanner;

/**
 *
 * @author Walter Grönholm
 */
public class PelaajaIhminen implements Pelaaja {

    private final String nimi;
    private final Scanner scanner;

    public PelaajaIhminen(String nimi, Scanner scanner) {
        this.nimi = nimi;
        this.scanner = scanner;
    }

    @Override
    public String teeSiirto() {
        System.out.print(nimi + " siirto: ");
        System.out.println("");
        String siirto = scanner.nextLine();
        return siirto;
    }

    @Override
    public void asetaSiirto(String toisenSiirto) {
        //ei tee mitään
    }

}
