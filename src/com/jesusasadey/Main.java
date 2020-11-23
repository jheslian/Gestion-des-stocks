package com.jesusasadey;

import Console.Gestion;

import java.awt.*;

public class Main {


    public static void main(String[] args) {
        EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    new Gestion();
                    //userInterface.setVisible( true );
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("L'application à detecter une erreur de type " + e.getMessage());
                }
            }
        });

    }
}
