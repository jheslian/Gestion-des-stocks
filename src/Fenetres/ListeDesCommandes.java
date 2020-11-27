package Fenetres;

import javax.swing.*;
import java.awt.*;

import static Fenetres.ListeDesProduits.baseProduit;

public class ListeDesCommandes extends JFrame {
    JButton afficherProduitsBtn;

    public ListeDesCommandes(){

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );
        JPanel panel = (JPanel)this.getContentPane();


        /******************     afficher le produit  (Table des produits)  ********************/
        JPanel panelBtn = new JPanel();
        panelBtn.setLayout( new FlowLayout() );
        panel.add( panelBtn, BorderLayout.PAGE_END );

        afficherProduitsBtn = new JButton("Afficher les paniers");
        afficherProduitsBtn.setPreferredSize( new Dimension(100,30) );
        panelBtn.add( afficherProduitsBtn );

        afficherProduitsBtn.addActionListener( e->{

            JPanel panelTable = new JPanel();
            panelTable.setLayout( new GridLayout(1,1));

            String [] lesChamps = {"nom", "prix" , "quantite"};
            String [][] donnees = new String[baseProduit.getListeDeProduit().size()][3];
            for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
                donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
                donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
                donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
            }
            JTable table =new JTable(donnees,lesChamps);
            JScrollPane scrollPane = new JScrollPane(table);
            panelTable.add( scrollPane );
            panel.add( panelTable, BorderLayout.CENTER );


            /******************     JTable affiche pas si  BorderLayout.PAGE_START est vide  ********************/
            JLabel print = new JLabel("    ");
            panel.add( print, BorderLayout.PAGE_START );
            print.setText( "");



        } );


        /******************     fermer fenetre    ********************/
        JButton fermerFenetre = new JButton("Fermer");
        panelBtn.add( fermerFenetre );

        fermerFenetre.addActionListener( e ->{
            System.exit( 0 );
        } );

        /******************     Menu gestion    ********************/
        JButton menuGestion = new JButton("Menu Gestion");
        panelBtn.add( menuGestion );

        menuGestion.addActionListener( e ->{
            (new GestionAdministrateur()).setVisible( true );
            this.setVisible( false );
        } );


    }
}
