package Fenetres;

import javax.swing.*;
import java.awt.*;

import static Fenetres.ListeDesProduits.baseProduit;

public class TestListes extends JFrame{

    public  TestListes(){
        super("titre");

        this.setSize( 1200, 1000 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );

        JPanel panelTable =(JPanel)this.getContentPane();
        panelTable.setLayout( new FlowLayout());

        String [] lesChamps = {"nom", "prix" , "quantite"};

        String [][] donnees = new String[baseProduit.getListeDeProduit().size()][3];
        for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
            donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
            donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
            donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
        }


        JTable table =new JTable(donnees,lesChamps);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add( scrollPane );




        this.setVisible( true );

    }
}
