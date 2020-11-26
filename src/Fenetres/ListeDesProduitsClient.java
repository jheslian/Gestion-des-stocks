package Fenetres;

import javax.swing.*;
import java.awt.*;

import static Fenetres.ListeDesProduits.baseProduit;

public class ListeDesProduitsClient extends JFrame{
    JButton afficherProduitsBtn;
    static String []  lesChamps = {"nom", "prix" , "quantite"};
    static String [][] donnees;
    JPanel pane;


    public ListeDesProduitsClient(){
        super("Liste des produits dans le magasin");

        this.setSize( 800, 600 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocation( 900,50 );



        JPanel panelTable = (JPanel)this.getContentPane();

        pane= new JPanel();
        getContentPane().add( pane, BorderLayout.CENTER );
        afficherProduitsBtn = new JButton("Afficher les produits");
        getContentPane().add( afficherProduitsBtn, BorderLayout.PAGE_END );


        //pane.setLayout( new GridLayout(1,1));

        afficherProduitsBtn.addActionListener( e->{
            this.remove( pane );
            //this.repaint();


            donnees = new String[baseProduit.getListeDeProduit().size()][3];
            for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
                donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
                donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
                donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
            }
            pane =new JPanel();

            JTable table =new JTable(donnees,lesChamps);
            JScrollPane scrollPane = new JScrollPane(table);

            pane.add( scrollPane, BorderLayout.CENTER );
            getContentPane().add( pane,BorderLayout.CENTER );

       });


        this.setVisible( false );
    }
}