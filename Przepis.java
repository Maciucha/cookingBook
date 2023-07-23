package cookingBook;

import java.io.Serializable;
import java.util.ArrayList;

public class Przepis implements Serializable {
    private String nazwa;
    private ArrayList<Skladnik> skladniki;
    private String sposobWykonania;

    public Przepis(String nazwa, ArrayList<Skladnik> skladniki, String sposobWykonania) {
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        this.sposobWykonania = sposobWykonania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Skladnik> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(ArrayList<Skladnik> skladniki) {
        this.skladniki = skladniki;
    }

    public String getSposobWykonania() {
        return sposobWykonania;
    }

    public void setSposobWykonania(String sposobWykonania) {
        this.sposobWykonania = sposobWykonania;
    }

}