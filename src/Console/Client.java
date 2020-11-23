package Console;

import java.util.Date;

public class Client {
    private String nomClient;
    private String prenomClient;
    private Date dateNaissance;
    private String email;
    private String adresse;
    private String motDePasseClient;

    Client(String nomClient, String prenomClient, String email, String motDePasseClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.email = email;
        this.motDePasseClient = motDePasseClient;

    }

}
