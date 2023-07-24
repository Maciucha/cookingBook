package cookingBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ramka extends JFrame implements ActionListener
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
    JButton bWyjscie;
    public Ramka()
    {
        setSize(600,200);
        setTitle("Książka Kucharska");
        setLayout(null);

        bDodajPrzepis = new JButton("Dodaj Przepis");
        bDodajPrzepis.setBounds(10,20,180,20);
        add(bDodajPrzepis);
        bDodajPrzepis.addActionListener(this);

        bEdytujPrzepis = new JButton("Edytuj Przepis");
        bEdytujPrzepis.setBounds(200,20,180,20);
        add(bEdytujPrzepis);
        bEdytujPrzepis.addActionListener(this);


        bUsunPrzepis = new JButton("Usuń Przepis");
        bUsunPrzepis.setBounds(390,20,180,20);
        add(bUsunPrzepis);
        bUsunPrzepis.addActionListener(this);

        bWyswietlPrzepis = new JButton("Wyswietl Przepis");
        bWyswietlPrzepis.setBounds(10,50,180,20);
        add(bWyswietlPrzepis);
        bWyswietlPrzepis.addActionListener(this);

        bWyswietlListePrzepisow = new JButton("Wyswietl Listę Przepisów");
        bWyswietlListePrzepisow.setBounds(200,50,180,20);
        add(bWyswietlListePrzepisow);
        bWyswietlListePrzepisow.addActionListener(this);

        bPrzeliczSkladniki = new JButton("Przelicz Składniki");
        bPrzeliczSkladniki.setBounds(10,110,180,20);
        add(bPrzeliczSkladniki);
        bPrzeliczSkladniki.addActionListener(this);

        bWczytajPrzepisy = new JButton("Wczytaj Przepisy");
        bWczytajPrzepisy.setBounds(10,80,180,20);
        add(bWczytajPrzepisy);
        bWczytajPrzepisy.addActionListener(this);

        bZapiszPrzepisy = new JButton("Zapisz Przepisy");
        bZapiszPrzepisy.setBounds(200,80,180,20);
        add(bZapiszPrzepisy);
        bZapiszPrzepisy.addActionListener(this);

        bWyjscie = new JButton("Spadam stąd..");
        bWyjscie.setBounds(390,110,180,20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);



    }

    public static void main(String[] args)
    {
        Ramka Glowna = new Ramka();
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

        } else if (klawisz==bWyjscie)
        {
            dispose();
        }
    }
}
