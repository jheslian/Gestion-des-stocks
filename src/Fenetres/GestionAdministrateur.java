package Fenetres;

import javax.swing.*;
import java.awt.*;

public class GestionAdministrateur extends JFrame {

    public GestionAdministrateur(){
        super("Gestion Adminstrateur");

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );
        JPanel panelOption = (JPanel)this.getContentPane();
        panelOption.setLayout( new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();


        /******************     Acces sur listes des produits   ********************/
        JButton listesDesProduitsBtn = new JButton("Listes des produits");
        listesDesProduitsBtn.setPreferredSize( new Dimension(200,50) );
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx= 0;
        constraints.gridy= 1;

        listesDesProduitsBtn.addActionListener( e ->{
                (new ListeDesProduits()).setVisible( true );
        } );


        panelOption.add( listesDesProduitsBtn, constraints);

        /******************     Listes des commandes   ********************/
        JButton listesDesCommandesBtn = new JButton("Listes des paniers");
        listesDesCommandesBtn.setPreferredSize( new Dimension(200,50) );

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx= 0;
        constraints.gridy= 4;

        panelOption.add( listesDesCommandesBtn);

        this.setVisible( true );//////???? verify if components works when this window opens
    }
}
