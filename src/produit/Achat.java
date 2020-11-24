package produit;

import objects.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Achat {

    private static void menuAchat(){
        System.out.println("Veuillez saisir votre choix: \n" +
                           "1 Ajouter un produit\n" +
                            "2 Supprimer un produit\n" +
                            "3 Afficher la liste des produits\n" +
                            "4 Abandonner\n");

    }

    public static PanierDuClient acheterDesProduit(BaseProduit baseProduit, PanierDuClient panierClient){
        boolean continueAchat = true;
        Scanner scanner = new Scanner( System.in );
        String choix = scanner.nextLine();

        while (continueAchat){
            menuAchat();

            switch (choix){
                case "1": // ajouter un produit
                    panierClient = creationDuPanier( baseProduit, panierClient );
                    break;
                case "2": // supprimer
                    panierClient = supprimerProduitPanier(baseProduit, panierClient);
                    break;
                case "3": // afficher la liste des produits
                    panierClient.afficherUnPanier();
                    break;

                case "4": // abandoner
                    continueAchat = false;
                    break;

            }

        }
        return panierClient;
    }

    private static PanierDuClient supprimerProduitPanier(BaseProduit baseProduit, PanierDuClient panierClient) {
        Scanner scanner = new Scanner( System.in );
        baseProduit.affichLesListeProduit();
        System.out.println("Donner le nom du produit que vous voulez supprimer: ");
        String nomDeProduit = scanner.nextLine();
        for (Produit produit : panierClient.getPanier()) {
            if (nomDeProduit.equals( produit.getNomProduit() )){
                panierClient.supprimerUnProduit( produit );
            }
        }

        return panierClient;
    }

    private static PanierDuClient creationDuPanier(BaseProduit baseProduit, PanierDuClient panierClient){
        Scanner scanner = new Scanner( System.in );
        float prix=0;
        baseProduit.affichLesListeProduit();
        System.out.println("Donner le nom du produit que vous voulez ajouter: ");
        String nomDeProduit = scanner.nextLine();
        for (Produit produit : baseProduit.getListeDeProduit()) {
            if (nomDeProduit.equals( produit.getNomProduit() )){
                prix = produit.getPrixUnitaire();

            }
        }
        panierClient.ajouteProduit( new Produit( nomDeProduit,prix,1 ) );

        return panierClient;

    }

}
