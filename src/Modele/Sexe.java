
package Modele;


public class Sexe 
{
    private String initiale;
    private String libelle;   
    public Sexe(String nouvInitiale,String nouvLibelle)
    {
        initiale = nouvInitiale;
        libelle = nouvLibelle;
    }
    public String getLibelle()
    {
        return libelle;
    }
    public void setLibelle(String nouvLibelle)
    {
        libelle = nouvLibelle;
    }
    public String getInitiale()
    {
        return initiale;
    }
    public void setInitiale(String nouvInitiale)
    {
        initiale = nouvInitiale;
    }
    public String toString()
    {
        return libelle;
    }
}
