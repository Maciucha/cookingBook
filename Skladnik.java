package cookingBook;

import java.io.Serializable;

public class Skladnik implements Serializable {
    private String nazwa;
    private double ilosc;
    private String jednostkaMiary;

    public Skladnik(String nazwa, double ilosc, String jednostkaMiary) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.jednostkaMiary = jednostkaMiary;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public String getJednostkaMiary() {
        return jednostkaMiary;
    }

    public void setJednostkaMiary(String jednostkaMiary) {
        this.jednostkaMiary = jednostkaMiary;
    }
}
