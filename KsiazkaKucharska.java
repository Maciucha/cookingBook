package cookingBook;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class KsiazkaKucharska {
    private ArrayList<Przepis> przepisy;

    public KsiazkaKucharska() {
        przepisy = new ArrayList<>();
    }

    public void dodajPrzepis() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu:");
        ArrayList<Skladnik> skladniki = new ArrayList<>();
        String nazwaSkladnika = "";
        double iloscSkladnika = 0;
        String jednostkaMiarySkladnika = "";
        boolean wprowadzanieSkladnikow = true;
        while (wprowadzanieSkladnikow) {
            nazwaSkladnika = JOptionPane.showInputDialog("Podaj nazwe skladnika:");
            String iloscSkladnikaString = JOptionPane.showInputDialog("Podaj ilosc skladnika:");
            try {
                iloscSkladnika = Double.parseDouble(iloscSkladnikaString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Nieprawidlowy format ilosci skladnika");
                continue;
            }
            jednostkaMiarySkladnika = JOptionPane.showInputDialog("Podaj jednostke miary skladnika:");
            skladniki.add(new Skladnik(nazwaSkladnika, iloscSkladnika, jednostkaMiarySkladnika));
            int choice = JOptionPane.showConfirmDialog(null, "Czy chcesz dodac kolejny skladnik?", "Dodawanie skladnikow", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.NO_OPTION) {
                wprowadzanieSkladnikow = false;
            }
        }
        String sposobWykonania = JOptionPane.showInputDialog("Podaj sposob wykonania przepisu:");
        przepisy.add(new Przepis(nazwaPrzepisu, skladniki, sposobWykonania));
        JOptionPane.showMessageDialog(null, "Przepis dodany do ksiazki kucharskiej.");
    }

    public void wyswietlListePrzepisow() {
        String listaPrzepisow = "";
        for (int i = 0; i < przepisy.size(); i++) {
            listaPrzepisow += przepisy.get(i).getNazwa() + "\n";
        }
        JOptionPane.showMessageDialog(null, listaPrzepisow);
    }

    public void wyswietlPrzepis() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu, który chcesz wyświetlić:");
        boolean przepisZnaleziony = false;
        for (int i = 0; i < przepisy.size(); i++) {
            if (przepisy.get(i).getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                przepisZnaleziony = true;
                Przepis przepis = przepisy.get(i);
                String skladniki = "";
                for (int j = 0; j < przepis.getSkladniki().size(); j++) {
                    Skladnik skladnik = przepis.getSkladniki().get(j);
                    skladniki += skladnik.getNazwa() + " - " + skladnik.getIlosc() + " " + skladnik.getJednostkaMiary() + "\n";
                }
                String sposobWykonania = przepis.getSposobWykonania();
                String infoPrzepis = "Nazwa: " + przepis.getNazwa() + "\nSkladniki:\n" + skladniki + "Sposób wykonania:\n" + sposobWykonania;
                JOptionPane.showMessageDialog(null, infoPrzepis);
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }

    public void edytujPrzepis() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu, który chcesz edytować:");
        boolean przepisZnaleziony = false;
        for (int i = 0; i < przepisy.size(); i++) {
            if (przepisy.get(i).getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                ArrayList<Skladnik> skladniki = przepisy.get(i).getSkladniki();
                String nazwaSkladnika = "";
                double iloscSkladnika = 0;
                String jednostkaMiarySkladnika = "";
                boolean wprowadzanieSkladnikow = true;
                while (wprowadzanieSkladnikow) {
                    nazwaSkladnika = JOptionPane.showInputDialog("Podaj nową nazwe skladnika:");
                    String iloscSkladnikaString = JOptionPane.showInputDialog("Podaj nową ilosc skladnika:");
                    try {
                        iloscSkladnika = Double.parseDouble(iloscSkladnikaString);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Nieprawidlowy format ilosci skladnika");
                        continue;
                    }
                    jednostkaMiarySkladnika = JOptionPane.showInputDialog("Podaj jednostke miary skladnika:");
                    skladniki.add(new Skladnik(nazwaSkladnika, iloscSkladnika, jednostkaMiarySkladnika));
                    int choice = JOptionPane.showConfirmDialog(null, "Czy chcesz dodac kolejny skladnik?", "Dodawanie skladnikow", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.NO_OPTION) {
                        wprowadzanieSkladnikow = false;
                    }
                }
                String sposobWykonania = JOptionPane.showInputDialog("Podaj zmieniony sposob wykonania przepisu:");
                przepisy.get(i).setNazwa(nazwaPrzepisu);
                przepisy.get(i).setSkladniki(skladniki);
                przepisy.get(i).setSposobWykonania(sposobWykonania);
                JOptionPane.showMessageDialog(null, "Przepis edytowany.");
                przepisZnaleziony = true;
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }

    public void usunPrzepis() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu, który chcesz usunąć:");
        boolean przepisZnaleziony = false;
        for (int i = 0; i < przepisy.size(); i++) {
            if (przepisy.get(i).getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                przepisy.remove(i);
                JOptionPane.showMessageDialog(null, "Przepis usunięty.");
                przepisZnaleziony = true;
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }

    public void przeliczSkladniki() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu, dla którego chcesz przeliczyć składniki:");
        boolean przepisZnaleziony = false;
        for (int i = 0; i < przepisy.size(); i++) {
            if (przepisy.get(i).getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                ArrayList<Skladnik> skladniki = przepisy.get(i).getSkladniki();
                String iloscPorcjiString = JOptionPane.showInputDialog("Podaj ilość porcji, dla której chcesz przeliczyć składniki:");
                try {
                    double iloscPorcji = Double.parseDouble(iloscPorcjiString);
                    for (int j = 0; j < skladniki.size(); j++) {
                        Skladnik skladnik = skladniki.get(j);
                        double ilosc = skladnik.getIlosc() * iloscPorcji;
                        skladnik.setIlosc(ilosc);
                    }
                    przepisy.get(i).setSkladniki(skladniki);
                    JOptionPane.showMessageDialog(null, "Przeliczono składniki dla przepisu: " + nazwaPrzepisu);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Nieprawidłowy format ilości porcji");
                }
                przepisZnaleziony = true;
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }
}
