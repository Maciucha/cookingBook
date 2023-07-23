package cookingBook;

import java.io.Serializable;

public class Skladnik implements Serializable {
    private final String nazwa;
    private double ilosc;
    private final String jednostkaMiary;

    public Skladnik(String nazwa, double ilosc, String jednostkaMiary) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.jednostkaMiary = jednostkaMiary;
    }

    public String getNazwa() {
        return nazwa;
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

}

