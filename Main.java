package cookingBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;


public class Main extends JFrame implements ActionListener
{
    KsiazkaKucharska ksiazkaKucharska = new KsiazkaKucharska();
    JButton bDodajPrzepis;
    JButton bEdytujPrzepis;
    JButton bUsunPrzepis;
    JButton bWyswietlPrzepis;
    JButton bWyswietlListePrzepisow;
    JButton bPrzeliczSkladniki;
    JButton bWczytajPrzepisy;
    JButton bZapiszPrzepisy;
    JButton bEksportujListeZakupow;
    JButton bWyjscie;
    public Main()
    {
        ksiazkaKucharska.wczytajPrzepisyZPliku("przepisy.txt");

        setSize(600,200);
        setTitle("Książka Kucharska");
        setLayout(null);

        bDodajPrzepis = new JButton("Dodaj Przepis");
        bDodajPrzepis.setBounds(10,20,180,20);
        bDodajPrzepis.setForeground(Color.gray);
        add(bDodajPrzepis);
        bDodajPrzepis.addActionListener(this);

        bEdytujPrzepis = new JButton("Edytuj Przepis");
        bEdytujPrzepis.setBounds(200,20,180,20);
        add(bEdytujPrzepis);
        bEdytujPrzepis.addActionListener(this);


        bUsunPrzepis = new JButton("Usuń Przepis");
        bUsunPrzepis.setBounds(390,20,180,20);
        bUsunPrzepis.setForeground(Color.red);
        add(bUsunPrzepis);
        bUsunPrzepis.addActionListener(this);

        bWyswietlPrzepis = new JButton("Wyswietl Przepis");
        bWyswietlPrzepis.setBounds(10,50,180,20);
        bWyswietlPrzepis.setForeground(Color.gray);
        add(bWyswietlPrzepis);
        bWyswietlPrzepis.addActionListener(this);

        bWyswietlListePrzepisow = new JButton("Wyswietl Listę Przepisów");
        bWyswietlListePrzepisow.setBounds(200,50,180,20);
        add(bWyswietlListePrzepisow);
        bWyswietlListePrzepisow.addActionListener(this);

        bPrzeliczSkladniki = new JButton("Przelicz Składniki");
        bPrzeliczSkladniki.setBounds(10,110,180,20);
        bPrzeliczSkladniki.setForeground(Color.gray);
        add(bPrzeliczSkladniki);
        bPrzeliczSkladniki.addActionListener(this);

        bWczytajPrzepisy = new JButton("Wczytaj Przepisy");
        bWczytajPrzepisy.setBounds(10,80,180,20);
        bWczytajPrzepisy.setForeground(Color.gray);
        add(bWczytajPrzepisy);
        bWczytajPrzepisy.addActionListener(this);

        bZapiszPrzepisy = new JButton("Zapisz Przepisy");
        bZapiszPrzepisy.setBounds(200,80,180,20);
        add(bZapiszPrzepisy);
        bZapiszPrzepisy.addActionListener(this);

        bEksportujListeZakupow = new JButton("Zapisz listę zakupów");
        bEksportujListeZakupow.setBounds(200,110,180,20);
        add(bEksportujListeZakupow);
        bEksportujListeZakupow.addActionListener(this);

        bWyjscie = new JButton("Spadam stąd..");
        bWyjscie.setBounds(390,110,180,20);
        bWyjscie.setForeground(Color.red);
        add(bWyjscie);
        bWyjscie.addActionListener(this);



    }

    public static void main(String[] args)
    {

        Main Glowna = new Main();
        Glowna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Glowna.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object klawisz = e.getSource();
        if (klawisz==bDodajPrzepis)
        {
            ksiazkaKucharska.dodajPrzepis();
        } else if (klawisz==bEdytujPrzepis)
        {
            {
                String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (showPrzepisResult == JOptionPane.OK_OPTION) {
                    String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                    ksiazkaKucharska.edytujPrzepis(selectedPrzepis);
                }
            }
        } else if (klawisz==bWyjscie)
        {
            dispose();
        } else if (klawisz==bUsunPrzepis)
        {
            {
                String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (showPrzepisResult == JOptionPane.OK_OPTION) {
                    String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                    ksiazkaKucharska.usunPrzepis(selectedPrzepis);
                }
            }
        } else if (klawisz==bWyswietlPrzepis)
        {
            {
                String[] przepisyArr = ksiazkaKucharska.getNazwyPrzepisow();
                JComboBox<String> przepisyComboBox = new JComboBox<>(przepisyArr);
                int showPrzepisResult = JOptionPane.showOptionDialog(null, przepisyComboBox, "Wybierz przepis",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
                if (showPrzepisResult == JOptionPane.OK_OPTION) {
                    String selectedPrzepis = (String) przepisyComboBox.getSelectedItem();
                    ksiazkaKucharska.wyswietlPrzepis(selectedPrzepis);
                }
            }
        } else if (klawisz==bWyswietlListePrzepisow)
        {
            ksiazkaKucharska.wyswietlListePrzepisow();
        } else if (klawisz==bWczytajPrzepisy)
        {
            Frame wczytaj = new Frame ("Wczytaj przepisy");
            wczytaj.setBounds(20,20,1,1);
            wczytaj.setVisible(true);

            FileDialog fd =new FileDialog(wczytaj,"Wczytaj",FileDialog.LOAD);
            fd.setVisible(true);
            String plik=fd.getDirectory() + fd.getFile();


            ksiazkaKucharska.wczytajPrzepisyZPliku(plik);
        } else if (klawisz==bZapiszPrzepisy)
        {
            ksiazkaKucharska.zapiszPrzepisyDoPliku("przepisy.txt");
        } else if (klawisz==bPrzeliczSkladniki)
        {
            ksiazkaKucharska.przeliczSkladniki();
        } else if (klawisz==bEksportujListeZakupow)
        {
            Frame zapis = new Frame ("Gdzie zapisać listę?");
            zapis.setBounds(20,20,1,1);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            zapis.setVisible(true);
            FileDialog fd =new FileDialog(zapis,"Zapisz",FileDialog.SAVE);
            fd.setVisible(true);
            String plik=fd.getFile();

            String nazwaPliku = plik + ".txt";
            ksiazkaKucharska.eksportujListeZakupow(nazwaPliku);
        }
    }
}
