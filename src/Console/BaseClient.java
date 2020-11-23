package Console;

import java.util.ArrayList;

public class BaseClient {
    private ArrayList<Client> baseClient;

    BaseClient(){
         baseClient = new ArrayList<>();

    }

    public ArrayList<Client> getBaseClient() {
        return baseClient;
    }

    public void setBaseClient(ArrayList<Client> baseClient) {
        this.baseClient = baseClient;
    }
}
