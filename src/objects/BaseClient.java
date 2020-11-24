package objects;

import java.util.ArrayList;

public class BaseClient {
    private ArrayList<Client> listeDeClient = null;
    //private HashMap<Integer, Client> listDeLivresHashMap = null;

    public BaseClient(){
        listeDeClient = new ArrayList<>();

    }

    public ArrayList<Client> getListDeClient() {
        return listeDeClient;
    }

    public void creeClient(String nomClient, String prenomClient, String email, String motDePasseClient){
        Client client = new Client( nomClient, prenomClient, email, motDePasseClient );
        getListDeClient().add(client);
        System.out.println("Vous avez bien créer votre compte");

    }
    public void affichLesListeClient(Client client, String liste) {
        for (int i=0; i<getListDeClient().size(); i++){
            System.out.println(getListDeClient().get(i).getEmail() + " / " + getListDeClient().get(i).getMotDePasseClient());
        }
    }

    public boolean isClientExist(String email, String motDePasse){
        boolean clientExist = false;
        for (int i=0; i<this.listeDeClient.size(); i++) {
            if ((this.listeDeClient.get(i).getEmail().equals(email)) && (this.listeDeClient.get(i).getMotDePasseClient()).equals( motDePasse )) {
                //System.out.println( "Bienvenue, " + this.listeDeClient.get(i).getPrenomClient() );
                clientExist = true;
                return  clientExist;
            }
        }
        return clientExist;
    }






}
