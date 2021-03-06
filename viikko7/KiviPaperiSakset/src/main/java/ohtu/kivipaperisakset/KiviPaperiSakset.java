package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class KiviPaperiSakset {

    protected Peliparametrit parametrit;
    private static final Scanner scanner = new Scanner(System.in);

    public KiviPaperiSakset(Peliparametrit parametrit) {
        this.parametrit = parametrit;
    }

    // t�m� on ns template metodi
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        System.out.println("Ensimm�isen pelaajan siirto: ");
        String ekanSiirto = ensimmaisenSiirto();
        System.out.println("Toisen pelaajan siirto: ");
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println("");

            System.out.println("Ensimm�isen pelaajan siirto: ");
            ekanSiirto = ensimmaisenSiirto();
            System.out.println("Toisen pelaajan siirto: ");
            tokanSiirto = toisenSiirto();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    protected String ensimmaisenSiirto() {
        return scanner.nextLine();
    }

    // t�m� on abstrakti metodi sill� sen toteutus vaihtelee eri pelityypeiss�
    abstract protected String toisenSiirto();

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}