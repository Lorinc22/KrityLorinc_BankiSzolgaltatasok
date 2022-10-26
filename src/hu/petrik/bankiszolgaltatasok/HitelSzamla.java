package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{
    private int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return this.hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        if(osszeg <= this.hitelKeret + this.aktualisEgyenleg){
            this.hitelKeret -= osszeg;
            return true;
        }else {
            return false;
        }
    }
}
