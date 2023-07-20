package cookingBook;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable;

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

    public void dodajSkladnik(Skladnik skladnik) {
        skladniki.add(skladnik);
    }

    public void edytujSkladnik(int indeks, Skladnik skladnik) {
        skladniki.set(indeks, skladnik);
    }

    public void usunSkladnik(int indeks) {
        skladniki.remove(indeks);
    }

    public void wyswietlPrzepis() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nazwa przepisu: ").append(nazwa).append("\n");
        sb.append("Skladniki:\n");
        for (Skladnik skladnik : skladniki) {
            sb.append("- ").append(skladnik.getNazwa()).append(": ").append(skladnik.getIlosc()).append(" ")
                    .append(skladnik.getJednostkaMiary()).append("\n");
        }
        sb.append("Sposob wykonania: ").append(sposobWykonania).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString(), "Przepis", JOptionPane.PLAIN_MESSAGE);
    }

    public void przeliczSkladniki() {
        String message = "Podaj nowÄ… iloĹ›Ä‡ skĹ‚adnika:";
        for (int i = 0; i < skladniki.size(); i++) {
            Skladnik skladnik = skladniki.get(i);
            String newAmountStr = JOptionPane.showInputDialog(null, message, "Przeliczanie skĹ‚adnika " + skladnik.getNazwa(),
                    JOptionPane.PLAIN_MESSAGE);
            if (newAmountStr != null) {
                double newAmount = Double.parseDouble(newAmountStr);
                skladnik.setIlosc(newAmount);
                skladniki.set(i, skladnik);
            } else {
                break;
            }
        }
    }
}