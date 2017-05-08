package ohtu.kivipaperisakset.peli.tekoaly;

public class TekoalyYksinkertainen implements Tekoaly {

    int siirto;

    public TekoalyYksinkertainen() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        paivitaSiirto();
        switch (siirto) {
            case 0:
                return "k";
            case 1:
                return "p";
            default:
                return "s";
        }
    }

    private void paivitaSiirto() {
        siirto++;
        siirto = siirto % 3;
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }
}
