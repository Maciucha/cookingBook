package cookingBook;

import javax.swing.*;

public class Main_old {
    public static void main(String[] args) {
        KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
        ksiazkaKucharska.wczytajPrzepisyZPliku("przepisy.txt");
        boolean programDziala = true;

        while (programDziala) {
            String[] options = {
                    "Dodaj przepis", "Edytuj przepis", "Usun przepis", "Wyswietl przepis",
                    "Wyswietl liste przepisow", "Przelicz skladniki", "Wczytaj przepisy", "Zapisz przepisy", "Wyjscie"
            };

            int choice = JOptionPane.showOptionDialog(null, null, "Ksiazka kucharska",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0 -> ksiazkaKucharska.dodajPrzepis();
                case 1 -> {
                    String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                    JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                    int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (showPrzepisResult == JOptionPane.OK_OPTION) {
                        String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                        ksiazkaKucharska.edytujPrzepis(selectedPrzepis);
                    }
                }
                case 2 -> {
                    String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                    JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                    int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (showPrzepisResult == JOptionPane.OK_OPTION) {
                        String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                        ksiazkaKucharska.usunPrzepis(selectedPrzepis);
                    }
                }
                case 3 -> {
                    String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                    JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                    int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (showPrzepisResult == JOptionPane.OK_OPTION) {
                        String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                        ksiazkaKucharska.wyswietlPrzepis(selectedPrzepis);
                    }
                }
                case 4 -> ksiazkaKucharska.wyswietlListePrzepisow();
                case 5 -> ksiazkaKucharska.przeliczSkladniki();
                case 6 -> ksiazkaKucharska.wczytajPrzepisyZPliku("przepisy.txt");
                case 7 -> ksiazkaKucharska.zapiszPrzepisyDoPliku("przepisy.txt");
                case 8 -> programDziala = false;
                default -> JOptionPane.showMessageDialog(null, "Nieprawidlowa opcja");
            }
        }
    }
}
