package cookingBook;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.Serializable;

public class KsiazkaKucharska implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private ArrayList<Przepis> przepisy;

    public KsiazkaKucharska() {
        przepisy = new ArrayList<>();
    }

    public void dodajPrzepis() {
        String nazwaPrzepisu = JOptionPane.showInputDialog("Podaj nazwe przepisu:");

        boolean przepisIstnieje = przepisy.stream()
                .anyMatch(przepis -> przepis.getNazwa().equalsIgnoreCase(nazwaPrzepisu));
        if (przepisIstnieje) {
            JOptionPane.showMessageDialog(null, "Przepis o podanej nazwie już istnieje.");
            return;
        }

        ArrayList<Skladnik> skladniki = new ArrayList<>();
        String nazwaSkladnika;
        boolean wprowadzanieSkladnikow = true;
        while (wprowadzanieSkladnikow) {
            nazwaSkladnika = JOptionPane.showInputDialog("Podaj nazwe skladnika:");
            String iloscSkladnikaString = JOptionPane.showInputDialog("Podaj ilosc skladnika:");
            wprowadzanieSkladnikow = isWprowadzanieSkladnikow(skladniki, nazwaSkladnika, wprowadzanieSkladnikow, iloscSkladnikaString);
        }
        String sposobWykonania = JOptionPane.showInputDialog("Podaj sposob wykonania przepisu:");
        przepisy.add(new Przepis(nazwaPrzepisu, skladniki, sposobWykonania));
        JOptionPane.showMessageDialog(null, "Przepis dodany do ksiazki kucharskiej.");
    }

    private boolean isWprowadzanieSkladnikow(ArrayList<Skladnik> skladniki, String nazwaSkladnika, boolean wprowadzanieSkladnikow, String iloscSkladnikaString) {
        double iloscSkladnika;
        iloscSkladnikaString = iloscSkladnikaString.replace(",", ".");
        String jednostkaMiarySkladnika;
        try {
            iloscSkladnika = Double.parseDouble(iloscSkladnikaString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Nieprawidlowy format ilosci skladnika");
            return wprowadzanieSkladnikow;
        }
        jednostkaMiarySkladnika = JOptionPane.showInputDialog("Podaj jednostke miary skladnika:");
        skladniki.add(new Skladnik(nazwaSkladnika, iloscSkladnika, jednostkaMiarySkladnika));
        int choice = JOptionPane.showConfirmDialog(null, "Czy chcesz dodac kolejny skladnik?", "Dodawanie skladnikow", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.NO_OPTION) {
            wprowadzanieSkladnikow = false;
        }
        return wprowadzanieSkladnikow;
    }

    public void wyswietlListePrzepisow() {
        StringBuilder listaPrzepisow = new StringBuilder();
        for (Przepis przepis : przepisy) {
            listaPrzepisow.append(przepis.getNazwa()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaPrzepisow.toString());
    }

    public void wyswietlPrzepis(String nazwaPrzepisu) {
        boolean przepisZnaleziony = false;
        for (Przepis value : przepisy) {
            if (value.getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                StringBuilder skladniki = new StringBuilder();
                for (Skladnik skladnik : value.getSkladniki()) {
                    skladniki.append(skladnik.getNazwa()).append(" - ").append(skladnik.getIlosc()).append(" ").append(skladnik.getJednostkaMiary()).append("\n");
                }
                String sposobWykonania = value.getSposobWykonania();
                String infoPrzepis = "Nazwa: " + value.getNazwa() + "\nSkladniki:\n" + skladniki + "Sposób wykonania:\n" + sposobWykonania;
                JOptionPane.showMessageDialog(null, infoPrzepis);
                przepisZnaleziony = true;
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }

    public void edytujPrzepis(String nazwaPrzepisu) {
        boolean przepisZnaleziony = false;
        for (Przepis przepis : przepisy) {
            if (przepis.getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                    ArrayList<Skladnik> skladniki = new ArrayList<>();
                    String nazwaSkladnika;
                    boolean wprowadzanieSkladnikow = true;
                    while (wprowadzanieSkladnikow) {
                        nazwaSkladnika = JOptionPane.showInputDialog("Podaj nazwe skladnika:");
                        String iloscSkladnikaString = JOptionPane.showInputDialog("Podaj ilosc skladnika:");
                        wprowadzanieSkladnikow = isWprowadzanieSkladnikow(skladniki, nazwaSkladnika, wprowadzanieSkladnikow, iloscSkladnikaString);
                    }
                    String sposobWykonania = JOptionPane.showInputDialog("Podaj sposob wykonania przepisu:");
                    przepisy.remove(przepis);
                    przepisy.add(new Przepis(nazwaPrzepisu, skladniki, sposobWykonania));
                    JOptionPane.showMessageDialog(null, "Przepis dodany do ksiazki kucharskiej.");
                przepisZnaleziony = true;
                break;
            }
        }
        if (!przepisZnaleziony) {
            JOptionPane.showMessageDialog(null, "Nie znaleziono przepisu o podanej nazwie.");
        }
    }

    public void usunPrzepis(String nazwaPrzepisu) {
        boolean przepisZnaleziony = false;
        for (Przepis value : przepisy) {
            if (value.getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                for (int i = 0; i < przepisy.size(); i++) {
                    if (przepisy.get(i).getNazwa().equalsIgnoreCase(nazwaPrzepisu)) {
                        przepisy.remove(i);
                        JOptionPane.showMessageDialog(null, "Przepis usunięty.");
                        przepisZnaleziony = true;
                        break;
                    }
                }
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

    public void zapiszPrzepisyDoPliku(String nazwaPliku) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            oos.writeObject(przepisy);
            System.out.println("Przepisy zostaly zapisane do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.err.println("Blad podczas zapisu przepisow do pliku.");
            e.printStackTrace();
        }
    }

    public void eksportujListeZakupow(String nazwaPliku) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku))) {
            for (Przepis przepis : przepisy) {
                for (Skladnik skladnik : przepis.getSkladniki()) {
                    String line = String.format("%s - %.2f %s", skladnik.getNazwa(), skladnik.getIlosc(), skladnik.getJednostkaMiary());
                    writer.write(line);
                    writer.newLine();
                }
            }
            System.out.println("Lista zakupów została zapisana do pliku: " + nazwaPliku);
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu listy zakupów do pliku.");
            e.printStackTrace();
        }
    }


    public void wczytajPrzepisyZPliku(String nazwaPliku) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            przepisy = (ArrayList<Przepis>) ois.readObject();
            System.out.println("Przepisy zostaly wczytane z pliku: " + nazwaPliku);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Blad podczas odczytu przepisow z pliku.");
            e.printStackTrace();
        }
    }
    public String[] getNazwyPrzepisow() {
        String[] nazwyPrzepisow = new String[przepisy.size()];
        for (int i = 0; i < przepisy.size(); i++) {
            nazwyPrzepisow[i] = przepisy.get(i).getNazwa();
        }
        return nazwyPrzepisow;
    }
}