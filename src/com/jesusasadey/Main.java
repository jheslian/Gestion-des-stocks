package com.jesusasadey;

import Fenetres.*;


import java.awt.*;

public class Main {


    public static void main(String[] args) {

        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    //new Gestion();

                   // Bienvenue fenetreClient =  new Bienvenue();
                   // TestListes fenetreClient = new TestListes();
                    ListeDesProduits fenetre =new ListeDesProduits();
                    fenetre.setVisible( true );

                    ListeDesProduitsClient fen = new ListeDesProduitsClient();

                    fen.setVisible( true );
                    //GestionAdministrateur fenetreClient =new GestionAdministrateur();
                    //AchatDuClient fenetreClient = new AchatDuClient();
                    //fenetreClient.setVisible( true );

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("L'application à detecter une erreur de type " + e.getMessage());
                }
            }
        });

    }
}
