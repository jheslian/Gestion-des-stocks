package Fenetres;

import produit.BaseProduit;
import produit.Produit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListeDesProduits extends JFrame {
    JTextField quantiteProduitTextField;
    JTextField nomProduitTextField;
    JTextField prixProduitTextField;
    JPanel panel, panel3;
    JButton ajouterPoduitBtn,afficherProduitsBtn;

    static BaseProduit baseProduit = new BaseProduit();


    public ListeDesProduits(){
        super("Liste des produits");

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );

        panel = (JPanel)this.getContentPane();
        panel.setLayout( new BorderLayout() );



        /******************     table des produits    ********************/
        /*
        String [] lesChamps = {"nom", "prix" , "quantite"};
        String [][] donnees = new String[baseProduit.getListeDeProduit().size()][3];
        for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
            donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
            donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
            donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
        }
        */

        /******************     panel pour les saisies   ********************/
        panel3 = new JPanel();
        panel3.setLayout( new GridLayout(9,1) );
        panel.add( panel3, BorderLayout.LINE_START );

        /******************     nom du produit   ********************/
        JLabel nomProduitLabel = new JLabel("  Nom du produit");
        panel3.add( nomProduitLabel );

        nomProduitTextField = new JTextField();
        nomProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( nomProduitTextField );

        JLabel vide1 = new JLabel();
        panel3.add( vide1 );

        /******************     prix du produit   ********************/
        JLabel prixProduitLabel = new JLabel("  Prix ");
        panel3.add( prixProduitLabel );

        prixProduitTextField = new JTextField();
        prixProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( prixProduitTextField );

        prixProduitTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '.') {
                    prixProduitTextField.setEditable(true);
                } else {
                    //probleme sur shift
                    prixProduitTextField.setText( "" );
                    prixProduitTextField.setEditable(false);
                    prixProduitTextField.setToolTipText("le champ accepte (0-9 et '.')");
                }
            }
        });

        JLabel vide2 = new JLabel();
        panel3.add( vide2 );

        /******************     quantité du produit   ********************/
        JLabel quantiteProduitLabel = new JLabel("  Quantité");
        panel3.add( quantiteProduitLabel );

        quantiteProduitTextField = new JTextField();
        quantiteProduitTextField.setPreferredSize( new Dimension(100,30) );
        panel3.add( quantiteProduitTextField );

        quantiteProduitTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                    quantiteProduitTextField.setEditable(true);
                } else {
                    quantiteProduitTextField.setText("");
                    quantiteProduitTextField.setEditable(false);
                    quantiteProduitTextField.setToolTipText("Veuillez saisir un nombre(0-9)");
                }
            }
        });




        JLabel vide3 = new JLabel();
        panel3.add( vide3 );


        /******************     panel pour les boutons   ********************/
        JPanel panelBouton = new JPanel();
        panelBouton.setLayout( new GridLayout (1,3));
        panel.add( panelBouton,BorderLayout.PAGE_END );

        /******************     ajouter le produit    ********************/
        ajouterPoduitBtn = new JButton("Ajouter");
        panelBouton.add( ajouterPoduitBtn );

        ajouterPoduitBtn.addActionListener( e ->{
            if ( baseProduit.siProduitExiste( nomProduitTextField.getText() )){
                int answer=JOptionPane.showConfirmDialog(  null, "Le produit existe déjà, vous voulez ajouter la quantité dans le stock", "Erreur", JOptionPane.YES_NO_OPTION  );
                if (answer==0){
                    ajouteQuantite();
                }
            }else if (nomProduitTextField.getText().equals( "" ) /*|| prixProduitTextField.getText().equals( "" )*/ || quantiteProduitTextField.getText().equals( "" ) ){
                JOptionPane.showMessageDialog( null, "Un des champs est vide, veuillez completer les champs", "Erreur", JOptionPane.ERROR_MESSAGE );
            }
            else {
                Produit produit = new Produit( nomProduitTextField.getText(), Float.parseFloat( prixProduitTextField.getText() ), Integer.parseInt( quantiteProduitTextField.getText() ) );
                baseProduit.ajouteProduit( produit );
            }

            effacerLesChamps();
        } );

        /******************     supprimer le produit    ********************/
        JButton supprimerProduitBtn = new JButton("Supprimer");
        panelBouton.add( supprimerProduitBtn);

        supprimerProduitBtn.addActionListener( e -> {

                baseProduit.supprimerUnProduit( nomProduitTextField.getText() );

            effacerLesChamps();
        } );


        /******************     afficher le produit    ********************/
        afficherProduitsBtn = new JButton("Afficher les produits");
        panelBouton.add( afficherProduitsBtn );

        this.setVisible( false);

        afficherProduitsBtn.addActionListener( e->{
            /*
            JTable tableDesProduits = new JTable(donnees,lesChamps);
            //panel.add( tableDesProduits, BorderLayout.CENTER );

            tableDesProduits.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(tableDesProduits);
            panel.add( sp, BorderLayout.CENTER );

             */
            String [] lesChamps = {"nom", "prix" , "quantite"};
            String [][] donnees = new String[baseProduit.getListeDeProduit().size()][3];
            for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
                donnees[i][0] = baseProduit.getListeDeProduit().get( i ).getNomProduit();
                donnees[i][1] = Float.toString(baseProduit.getListeDeProduit().get( i ).getPrixUnitaire());
                donnees[i][2] = Integer.toString(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
            }
            JTable table =new JTable(donnees,lesChamps);
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add( scrollPane,BorderLayout.CENTER );

            /******************     JTable affiche pas si  BorderLayout.PAGE_START est vide  ********************/
            JLabel print = new JLabel("    ");
            panel.add( print, BorderLayout.PAGE_START );
            print.setText( "");


        } );
    }


    private void ajouteQuantite() {
        for (int i = 0; i < baseProduit.getListeDeProduit().size(); i++) {
            baseProduit.getListeDeProduit().get( i ).setQuantiteEnStock( (baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock()+ Integer.parseInt( quantiteProduitTextField.getText() )));
            System.out.println(baseProduit.getListeDeProduit().get( i ).getQuantiteEnStock());
            }
        }

    private  void effacerLesChamps(){
        nomProduitTextField.setText( "" );
        prixProduitTextField.setText( "" );
        quantiteProduitTextField.setText( "" );
    }

}
