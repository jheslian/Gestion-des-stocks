package objects;

import java.util.Date;

public class Client {
    private String nomClient;
    private String prenomClient;
    private Date dateNaissance;
    private String email;
    private String adresse;
    private String motDePasseClient;

    public Client(String nomClient, String prenomClient, String email, String motDePasseClient) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.email = email;
        this.motDePasseClient = motDePasseClient;

    }

    public String getNomClient() {
        return nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMotDePasseClient() {
        return motDePasseClient;
    }
}
