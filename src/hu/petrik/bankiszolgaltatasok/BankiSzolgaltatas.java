package hu.petrik.bankiszolgaltatasok;

public abstract class BankiSzolgaltatas {
    private Tulajdonos tulajdonos;

    public BankiSzolgaltatas(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }
}
