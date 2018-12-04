package Modele;

public class CoureurIndividuel 
{
    String prenom,nom;
    public CoureurIndividuel(String nouvPrenom,String nouvNom)
    {
        prenom = nouvPrenom;
        nom = nouvNom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public String getNom()
    {
        return nom;
    }
    public String toString()
    {
        return nom;
    }
}