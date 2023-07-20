package cookingBook;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
        ksiazkaKucharska.wczytajPrzepisyZPliku("przepisy.txt");
        boolean programDziala = true;

        while (programDziala) {
            String[] options = {"Dodaj przepis", "Edytuj przepis", "Usun przepis", "Wyswietl przepis",
                    "Wyswietl liste przepisow", "Przelicz skladniki", "Wczytaj przepisy", "Zapisz przepisy", "Wyjscie"};

            int choice = JOptionPane.showOptionDialog(null, null, "Ksiazka kucharska",
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
                    // Wyświetl listę przepisów w JComboBox i pobierz wybrany przepis
                    String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                    JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                    int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (showPrzepisResult == JOptionPane.OK_OPTION) {
                        String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                        ksiazkaKucharska.wyswietlPrzepis(selectedPrzepis);
                    }
                    break;
                case 4:
                    ksiazkaKucharska.wyswietlListePrzepisow();
                    break;
                case 5:
                    ksiazkaKucharska.przeliczSkladniki();
                    break;
                case 6:
                    ksiazkaKucharska.wczytajPrzepisyZPliku("przepisy.txt");
                    break;
                case 7:
                    ksiazkaKucharska.zapiszPrzepisyDoPliku("przepisy.txt");
                    break;
                case 8:
                    programDziala = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Nieprawidlowa opcja");
                    break;
            }
        }
    }
}
