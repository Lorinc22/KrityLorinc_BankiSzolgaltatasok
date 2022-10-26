package hu.petrik.bankiszolgaltatasok;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Tulajdonos t = new Tulajdonos("Korcsek Suto Slenk A Hűséges");
        MegtakaritasiSzamla msz1 = new MegtakaritasiSzamla (t);
        Szamla szamla = new MegtakaritasiSzamla(t);
        System.out.println(t.getNev());
        szamla.befizet(20000);
        System.out.println("Számla értékek: "+ szamla.aktualisEgyenleg);
        szamla.kivesz(5000);
        System.out.println("Számla értéke kivétel után: "+ szamla.aktualisEgyenleg);

        HitelSzamla hitelSzamla = new HitelSzamla(t,20);
        System.out.printf("Hitelkeret: %d\n", hitelSzamla.getHitelKeret());
        hitelSzamla.kivesz(10);
        System.out.printf("Hitelkeret kivétel után: %d\n", hitelSzamla.getHitelKeret());

        Kartya kartya = new Kartya(t,szamla,"75634578");
        System.out.printf("Kártyaszám: %s\n",kartya.getKartyaSzam());
        kartya.vasarlas(140);
        System.out.printf("Összeg vásárlás után: %d\n",szamla.aktualisEgyenleg);

        HitelSzamla szh1 = new HitelSzamla(new Tulajdonos("Korcsek"),324);
        HitelSzamla szh2 = new HitelSzamla(new Tulajdonos("Shrek"),179);
        MegtakaritasiSzamla msz2 = new MegtakaritasiSzamla(new Tulajdonos("Bazsi"));
        msz2.befizet(1842);


        Bank bank = new Bank();
        System.out.println(bank.getLegnagyobbEgyenleguSzamla(new Tulajdonos("Korcsek Suto Slenk A Hűséges")));
    }
}