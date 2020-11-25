package Fenetres;

import objects.BaseClient;
import produit.BaseProduit;
import produit.Produit;

import javax.swing.*;
import java.awt.*;

public class ListeDesProduits extends JFrame {
    static BaseProduit baseProduit = new BaseProduit();


    public ListeDesProduits(){
        super("Liste des produits");

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );

        JPanel panel = (JPanel)this.getContentPane();
        panel.setLayout( new BorderLayout() );

        /******************     table des produits    ********************/
        String [] lesChamps = {"nom", "prix" , "quantite"};
        String [][] donnees = new String[baseProduit.getListeDeProduit().size()][3];
        for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
            donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
            donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
            donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());

        }


        JPanel panel3 = new JPanel();
        panel3.setLayout( new GridLayout(6,1) );
        panel.add( panel3, BorderLayout.LINE_START );

        /******************     nom du produit   ********************/
        JLabel nomProduitLabel = new JLabel("Nom du produit");
        panel3.add( nomProduitLabel );

        JTextField nomProduitTextField = new JTextField();
        nomProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( nomProduitTextField );

        /******************     prix du produit   ********************/
        JLabel prixProduitLabel = new JLabel("Nom du produit");
        panel3.add( prixProduitLabel );

        JTextField prixProduitTextField = new JTextField();
        prixProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( prixProduitTextField );

        /******************     quantité du produit   ********************/
        JLabel quantiteProduitLabel = new JLabel("Quantité");
        panel3.add( quantiteProduitLabel );

        JTextField quantiteProduitTextField = new JTextField();
        quantiteProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( quantiteProduitTextField );


        /******************     Layout pour les boutons   ********************/
        JPanel panelBouton = new JPanel();
        panelBouton.setLayout( new GridLayout (1,3));
        panel.add( panelBouton,BorderLayout.PAGE_END );

        /******************     ajouter le produit    ********************/
        JButton ajouterPoduitBtn = new JButton("Ajouter");
        panelBouton.add( ajouterPoduitBtn );

        ajouterPoduitBtn.addActionListener( e ->{
            Produit produit = new Produit( nomProduitTextField.getText(),  Float.parseFloat( prixProduitTextField.getText()), Integer.parseInt( quantiteProduitTextField.getText()));
            baseProduit.ajouteProduit(produit);
            System.out.println(baseProduit.getListeDeProduit());

        } );

        /******************     supprimer le produit    ********************/
        JButton supprimerProduitBtn = new JButton("Supprimer");
        panelBouton.add( supprimerProduitBtn);

        /******************     afficher le produit    ********************/
        JButton afficherProduitsBtn = new JButton("Afficher les produits");
        panelBouton.add( afficherProduitsBtn );

        this.setVisible( true );

        afficherProduitsBtn.addActionListener( e->{
            JTable tableDesProduits = new JTable(donnees,lesChamps);
            panel.add( tableDesProduits, BorderLayout.CENTER );

        } );


    }
}
