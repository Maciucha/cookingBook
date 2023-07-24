package cookingBook;

import javax.swing.*;

public class Ramka extends JFrame
{
    JButton bDodajPrzepis;
    JButton bEdytujPrzepis;
    JButton bUsunPrzepis;
    JButton bWyswietlPrzepis;
    JButton bWyswietlListePrzepisow;
    JButton bPrzeliczSkladniki;
    JButton bWczytajPrzepisy;
    JButton bZapiszPrzepisy;
    JButton bWyjscie;
    public Ramka()
    {
        setSize(600,200);
        setTitle("Książka Kucharska");
        setLayout(null);

        bDodajPrzepis = new JButton("Dodaj Przepis");
        bDodajPrzepis.setBounds(10,20,180,20);
        add(bDodajPrzepis);

        bEdytujPrzepis = new JButton("Edytuj Przepis");
        bEdytujPrzepis.setBounds(200,20,180,20);
        add(bEdytujPrzepis);

        bUsunPrzepis = new JButton("Usuń Przepis");
        bUsunPrzepis.setBounds(390,20,180,20);
        add(bUsunPrzepis);

        bWyswietlPrzepis = new JButton("Wyswietl Przepis");
        bWyswietlPrzepis.setBounds(10,50,180,20);
        add(bWyswietlPrzepis);

        bWyswietlListePrzepisow = new JButton("Wyswietl Listę Przepisów");
        bWyswietlListePrzepisow.setBounds(200,50,180,20);
        add(bWyswietlListePrzepisow);

        bPrzeliczSkladniki = new JButton("Przelicz Składniki");
        bPrzeliczSkladniki.setBounds(10,110,180,20);
        add(bPrzeliczSkladniki);

        bWczytajPrzepisy = new JButton("Wczytaj Przepisy");
        bWczytajPrzepisy.setBounds(10,80,180,20);
        add(bWczytajPrzepisy);

        bZapiszPrzepisy = new JButton("Zapisz Przepisy");
        bZapiszPrzepisy.setBounds(200,80,180,20);
        add(bZapiszPrzepisy);

        bWyjscie = new JButton("Spadam stąd..");
        bWyjscie.setBounds(390,110,180,20);
        add(bWyjscie);



    }

    public static void main(String[] args)
    {
        Ramka Glowna = new Ramka();
        Glowna.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Glowna.setVisible(true);


    }

}
