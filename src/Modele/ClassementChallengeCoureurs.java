package Modele;


public class ClassementChallengeCoureurs 
{
    private String nomClub;
    private String nom;
    private String prenom;
    private int point;
    public ClassementChallengeCoureurs(String nouvNomClub,String nouvNom,String nouvPrenom,int nouvPoint)
    {
        nomClub = nouvNomClub;
        nom = nouvNom;
        prenom = nouvPrenom;
        point = nouvPoint;
    }
    public String getNomClub()
    {
        return nomClub;
    }
    public String getNom()
    {
        return nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public int getPoint()
    {
        return point;
    }
}
