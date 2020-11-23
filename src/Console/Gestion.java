package Console;

import java.util.Scanner;

public class Gestion {
    private Scanner in = new Scanner( System.in );
    String [] saisirUtilisateurs= new String[3];

    public Gestion(){
        /*
        premier menu pour demander l'utilisateur pour se connecter en tant que administrateur ou client
        */
        MenuSaisir.afficheMenu();
        gestionClient();

    }


    void gestionClient(){
        saisirUtilisateurs = MenuSaisir.recuperationSaisir();

        if (saisirUtilisateurs[0].equals("1")){ // administrateur
            Administrateur administrateur = new Administrateur();
            if (saisirUtilisateurs[1].equals( administrateur.nom ) && saisirUtilisateurs[2].equals( administrateur.motDePasse )) {
                //liste des taches pour l'administrateur
            } else {
                System.out.println("nom ou mot de passe incorrect");
            }
        }else if(saisirUtilisateurs[0].equals( "2" )){// client
            if ()
                Client client = new Client( );
            else if()
                //creeCilent();


        }else if(saisirUtilisateurs[0].equals( "3" )){
            System.exit( 0 );
        }
    }
   /*
    Client creeClient(){
        System.out.println("Saisir les informations :\n" +
                "");

    }
*/



}
