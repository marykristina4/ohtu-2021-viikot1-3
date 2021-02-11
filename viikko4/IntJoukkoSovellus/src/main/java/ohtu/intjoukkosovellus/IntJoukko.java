package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int kapasiteetti = 5,
            oletuskasvatus = 5;

    private int kasvatuskoko;
    private int[] lukujono;
    private int alkioidenMaara;

    public IntJoukko() {
        this(kapasiteetti, oletuskasvatus);

    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, oletuskasvatus);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Parametreissa vikaa");
        }
        //if (kasvatuskoko < 0) {
        //    throw new IndexOutOfBoundsException("kasvatuskoko negatiivinen");
        //}
        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }
        alkioidenMaara = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {

        if (alkioidenMaara == 0) {
            lukujono[0] = luku;
            alkioidenMaara++;
            return true;
        } else {
        }
        if (!kuuluu(luku)) {
            lukujono[alkioidenMaara] = luku;
            alkioidenMaara++;
            if (alkioidenMaara % lukujono.length == 0) {
                int[] aputaulukko = lukujono;
                kopioiTaulukko(lukujono, aputaulukko);
                lukujono = new int[alkioidenMaara + kasvatuskoko];
                kopioiTaulukko(aputaulukko, lukujono);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {

        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        int apu;
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == lukujono[i]) {
                kohta = i;
                lukujono[kohta] = 0;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenMaara - 1; j++) {
                apu = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = apu;
            }
            alkioidenMaara--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        System.arraycopy(vanha, 0, uusi, 0, vanha.length);

    }

    public int mahtavuus() {
        return alkioidenMaara;
    }

    @Override
    public String toString() {
        if (alkioidenMaara == 0) {
            return "{}";
        } else if (alkioidenMaara == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenMaara - 1; i++) {
                tuotos += lukujono[i];
                tuotos += ", ";
            }
            tuotos += lukujono[alkioidenMaara - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            x.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.toIntArray().length; i++) {
            x.lisaa(b.toIntArray()[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            for (int j = 0; j < b.toIntArray().length; j++) {
                if (a.toIntArray()[i] == b.toIntArray()[j]) {
                    y.lisaa(b.toIntArray()[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        for (int i = 0; i < a.toIntArray().length; i++) {
            z.lisaa(a.toIntArray()[i]);
        }
        for (int i = 0; i < b.toIntArray().length; i++) {
            z.poista(b.toIntArray()[i]);
        }

        return z;
    }

}
