package com.jesusasadey;

import Fenetres.Bienvenue;
import Fenetres.ListeDesProduits;


import java.awt.*;

public class Main {


    public static void main(String[] args) {

        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    //new Gestion();
                    //Bienvenue fenetreClient =  new Bienvenue();
                    ListeDesProduits fenetreClient =new ListeDesProduits();
                    fenetreClient.setVisible( true );

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("L'application à detecter une erreur de type " + e.getMessage());
                }
            }
        });

    }
}
