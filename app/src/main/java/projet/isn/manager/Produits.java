package projet.isn.manager;

public class Produits
{

    public String nom_prod;
    public int nb_prod = 0;

    public Produits(String nom,int nb)
    {
        this.nom_prod = nom;
        this.nb_prod = nb;
    }

    public String getNomProd()
    {
        return nom_prod;
    }
    public void setNomProd(String nom_prod)
    {
        this.nom_prod =  nom_prod;
    }

    public int getNb_prod()
    {
        return nb_prod;
    }

    public void setNb_prod(int nb)
    {
        this.nb_prod = nb;
    }
}
