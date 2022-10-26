package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    public static double alapKamat = 1.1;

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    public double getKamat() {
        return kamat;
    }

    public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        kamat = alapKamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if (getAktualisEgyenleg() - osszeg < 0) {
            return false;
        } else {
            this.aktualisEgyenleg -= osszeg;
            return true;
        }
    }

    public void kamatJovairas() {
        befizet((int)kamat*this.getAktualisEgyenleg());
    }
}
