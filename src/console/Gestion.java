package console;

import objects.Administrateur;
import objects.BaseClient;

import java.util.Scanner;

public class Gestion {
    Scanner in = new Scanner( System.in );
    BaseClient baseClient = new BaseClient();

    public Gestion() {
        /*
        premier menu pour demander l'utilisateur pour se connecter en tant que administrateur ou client
        */
        boolean isRunning = true;
        while (isRunning) {
            menuPrincipal();

            switch (choix()){
                case "1":
                    logInAdministrateur();
                    break;
                case "2":
                    choixClient();
                    break;
                case "3":
                    isRunning = false;
                    break;

                default:
                    optionInvalid();
            }
        }
    }

    private void choixClient() {
        Scanner in = new Scanner( System.in );
        System.out.println("\t 1 Acceder mon compte\n" +
                "\t 2 Créer un compte");
        String choix = in.nextLine();
        if (choix.equals( "1" )){
            logInClient();
        }else if (choix.equals( "2" )) {
           //new line need to remove
            creerUnCompte();
        } else {
            optionInvalid();
        }
    }

    private void creerUnCompte() {
        System.out.print("Nom: ");
        String nom = in.nextLine();
        System.out.print("Prenom: ");
        String prenom = in.nextLine();
        System.out.print("Email: ");
        String email = in.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = in.nextLine();
        baseClient.creeClient( nom,prenom,email,motDePasse );
        // probleme : un saisir qui se balade
    }

    private void menuPrincipal() {
        System.out.print( "Bienvenue dans le magasin: \n" +
                "\t 1 Administrateur\n" +
                "\t 2 Client\n" +
                "\t 3 Quitter\n" );
        System.out.print( "Veuillez saisir votre choix ici : " );

    }

    void logInAdministrateur () {
        System.out.println("Nom: ");
        String nom = choix();
        System.out.println("Mot De Passe: ");
        String motDePasse = choix();
        Administrateur administrateur = new Administrateur();
        if ((administrateur.nom).equals( nom ) && (administrateur.motDePasse).equals( motDePasse )) {
            System.out.println( "Acces l'adminisrateur succes" );
        } else {
            System.out.println("Vous n'êtes pas administrateur");
        }
    }

    void logInClient () {
        System.out.print("Email: ");
        String email = choix();
        System.out.print("Mot de passe: ");
        String motDePasse = choix();
        if (baseClient.isClientExist( email, motDePasse )) {
            System.out.println( "Bienvenue!" );
        } else {
            System.out.println("le client existe pas");
        }

    }

    String choix(){
        String input = in.nextLine();
    return input;
    }

    void optionInvalid(){
        System.out.println("Option Invalid");
    }

}


