package cookingBook;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
        boolean programDziala = true;
        while (programDziala) {
            String[] options = {"Dodaj przepis", "Edytuj przepis", "Usun przepis", "Wyswietl przepis",
                    "Wyswietl liste przepisow", "Przelicz skladniki", "Wyjscie"};
            int choice = JOptionPane.showOptionDialog(null, "Wybierz opcje", "Ksiazka kucharska",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    ksiazkaKucharska.dodajPrzepis();
                    break;
                case 1:
                    ksiazkaKucharska.edytujPrzepis();
                    break;
                case 2:
                    ksiazkaKucharska.usunPrzepis();
                    break;
                case 3:
                    ksiazkaKucharska.wyswietlPrzepis();
                    break;
                case 4:
                    ksiazkaKucharska.wyswietlListePrzepisow();
                    break;
                case 5:
                    ksiazkaKucharska.przeliczSkladniki();
                    break;
                case 6:
                    programDziala = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Nieprawidlowa opcja");
                    break;
            }
        }
    }
}

