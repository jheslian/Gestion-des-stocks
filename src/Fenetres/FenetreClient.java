package Fenetres;

import javax.swing.*;

public class FenetreClient extends JFrame {

    public FenetreClient(){
        super("Première Fenêtre");

        this.setSize( 700, 500 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo( null );


        JLabel nomLabel = new JLabel("Nom"); //  nom
        JTextField nomTextField = new JTextField();

        JLabel prenomLabel = new JLabel("Prenom"); //prenom
        JTextField prenomTextField = new JTextField();

        JLabel emailLabel = new JLabel("Email"); // email
        JTextField emailTextField = new JTextField();

        JLabel motDePasseLabel = new JLabel("Mot De Passe"); // mot de passe
        JTextField motDePasseTextField = new JTextField();


    }

}
