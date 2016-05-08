package projet.isn.manager;


import android.media.Image;

public class Commande {

    private Image img;
    private String table;
    private String table_nb;
    private String client;
    private String client_nom;
    private String status;

    public Commande(String table, String table_nb, String client, String client_nom, String status)
    {

        this.client = client;
        this.table = table;
        this.table_nb = table_nb;
        this.client_nom = client_nom;
        this.status = status;

    }

    public String getTable()
    {
        return table;
    }

    public String getTable_nb()
    {
        return table_nb;
    }

    public String getClient()
    {
        return client;
    }

    public String getClient_nom()
    {
        return client_nom;
    }

    public void setTable()
    {
        this.table = table;
    }

    public void setTable_nb()
    {
        this.table_nb = table_nb;
    }

    public void setClient()
    {
        this.client = client;
    }

    public void setClient_nom()
    {
        this.client_nom = client_nom;
    }


}