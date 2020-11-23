package Console;

import java.util.Scanner;

public class Gestion {
    private Scanner in = new Scanner( System.in );
    String saisirNom;
    String saisirMotDePasse;

    Gestion(){

        /*
        premier menu pour demander l'utilisateur pour se connecter en tant que administrateur ou client
         */
        System.out.print(" Veuillez saisir votre choix : \n"+
                " 1 Administrateur\n"+
                " 2 Client\n" +
                " 3 Quitter\n");

        int input =in.nextInt();
        System.out.print("Veuillez saisir votre nom et mot de passe\n" +
                "Nom: \n"  );
        saisirNom = in.nextLine();
        System.out.println("Mot de passe : ");
        saisirMotDePasse = in.nextLine();
        if (input==1){ // administrateur
            Administrateur administrateur = new Administrateur();
            if (saisirNom.equals( administrateur.nom ) && saisirMotDePasse.equals( administrateur.motDePasse )) {
                //liste des taches pour l'administrateur
            } else {
                System.out.println("nom ou mot de passe incorrect");
            }
        }else if(input==2){// client
            System.out.println("Client");
            
        }else if(input==3){
            System.exit( 0 );
        }




    }







}
