package ohtu.kivipaperisakset;

import ohtu.kivipaperisakset.peli.KPSPeli;
import java.util.Scanner;
import ohtu.kivipaperisakset.peli.pelaaja.Pelaaja;
import ohtu.kivipaperisakset.peli.pelaaja.PelaajaIhminen;
import ohtu.kivipaperisakset.peli.pelaaja.PelaajaTekoaly;
import ohtu.kivipaperisakset.peli.tekoaly.TekoalyParannettu;
import ohtu.kivipaperisakset.peli.tekoaly.TekoalyYksinkertainen;

public class Paaohjelma {

    private static final int TEKOALY_MUISTI = 20;

    private static final String IHMISTA_VASTAAN = "a";
    private static final String TEKOALYA_VASTAAN = "b";
    private static final String PAREMPAA_VASTAAN = "c";

    private static final String EKA_PELAAJA = "Ensimmäisen pelaajan";
    private static final String TOKA_PELAAJA = "Toisen pelaajan";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            Pelaaja ekaPelaaja = new PelaajaIhminen(EKA_PELAAJA, scanner);

            tulostaKayttoohjeet();

            String vastaus = scanner.nextLine();
            Pelaaja tokaPelaaja = luoToinenPelaaja(vastaus, scanner);
            if (tokaPelaaja == null)
                break;

            tulostaMilloinPeliLoppuu();
            new KPSPeli().pelaa(ekaPelaaja, tokaPelaaja);
        }

    }

    private static Pelaaja luoToinenPelaaja(String vastaus, Scanner scanner) {
        if (vastaus.endsWith(IHMISTA_VASTAAN))
            return new PelaajaIhminen(TOKA_PELAAJA, scanner);
        else if (vastaus.endsWith(TEKOALYA_VASTAAN))
            return new PelaajaTekoaly(new TekoalyYksinkertainen());
        else if (vastaus.endsWith(PAREMPAA_VASTAAN))
            return new PelaajaTekoaly(new TekoalyParannettu(TEKOALY_MUISTI));

        return null;
    }

    private static void tulostaMilloinPeliLoppuu() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
    }

    private static void tulostaKayttoohjeet() {
        System.out.println("\nValitse pelataanko"
            + "\n (" + IHMISTA_VASTAAN + ") ihmistä vastaan "
            + "\n (" + TEKOALYA_VASTAAN + ") tekoälyä vastaan"
            + "\n (" + PAREMPAA_VASTAAN + ") parannettua tekoälyä vastaan"
            + "\nmuilla valinnoilla lopetataan");
    }
}
