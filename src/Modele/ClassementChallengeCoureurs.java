package Modele;


public class ClassementChallengeCoureurs 
{
    private String nom;
    private String prenom;
    private int point;
    public ClassementChallengeCoureurs(String nouvNom,String nouvPrenom, int nouvPoints)
    {
        nom = nouvNom;
        prenom = nouvPrenom;
        point = nouvPoints;
    }
    public String getNom()
    {
        return nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public void setPoint(int nouvPoint)
    {
        point = point +  nouvPoint;
    }
    public int getPoint()
    {
        return point;
    }
}
