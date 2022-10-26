package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static ArrayList<Szamla> szamlaLista = new ArrayList<>();

    public Bank() {

    }

    public Szamla szamlanyitas(Tulajdonos tulajdonos, int hitelKeret){
        if (hitelKeret >0){
            szamlaLista.add(new HitelSzamla(tulajdonos, hitelKeret));
            return new HitelSzamla(tulajdonos, hitelKeret);
        } else if(hitelKeret == 0){
            szamlaLista.add(new MegtakaritasiSzamla(tulajdonos));
            return new MegtakaritasiSzamla(tulajdonos);
        }else{
            throw new IllegalArgumentException("A hitelkeret nem lehet kisebb mint 0");
        }
    }

    public int getOsszegyenleg(Tulajdonos tulajdonos){
        int osszeegyenleg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos) {
                osszeegyenleg += szamla.aktualisEgyenleg;
            }
        }
        return osszeegyenleg;
    }

    public int getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        int max = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos && szamla.getAktualisEgyenleg() > max) {
                max = szamla.getAktualisEgyenleg();
            }
        }
        return max;
    }

    public long getOsszhitelkeret(){
        int osszeg = 0;
        for (Szamla szamla : szamlaLista){
            if (szamla instanceof HitelSzamla){
                osszeg+=((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszeg;
    }
}
