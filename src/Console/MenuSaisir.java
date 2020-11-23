package Console;

import java.util.Scanner;

public class MenuSaisir {

    static void afficheMenu(){
        System.out.print(" Bienvenue dans le magasin: \n"+
                " 1 Administrateur\n"+
                " 2 Client\n" +
                " 3 Quitter\n");
    }

    static String [] recuperationSaisir(){
        String [] tableau = new String[3];
        Scanner in = new Scanner( System.in );

        System.out.print("Veuillez saisir votre choix ici : ");
        tableau[0] = in.nextLine();
        System.out.println("\nVeuillez saisir votre nom et mot de passe\n" +
                "Nom: "  );
        tableau[1] = in.nextLine();
        System.out.println("Mot de passe : ");
        tableau[2]= in.nextLine();

        return tableau;
    }
}
