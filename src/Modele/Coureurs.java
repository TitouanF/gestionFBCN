package Modele;


public class Coureurs
{
    private String nomClub;
    private String nom;
    private String prenom;
    private String adresse;
    private String CP;
    private String ville;
    private String tel;
    private String email;


    
    public Coureurs(String nouvNomClub,String nouvNom,String nouvPrenom,String nouvAdresse,String nouvCp,String nouvVille, String nouvTel, String nouvEmail)
    {
        nomClub = nouvNomClub;
        nom = nouvNom;
        prenom = nouvPrenom;
        adresse = nouvAdresse;
        CP = nouvCp;
        ville = nouvVille;
        tel = nouvTel;
        email = nouvEmail;
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
    public String getAdresse()
    {
        return adresse;
    }
    public String getCP()
    {
        return CP;
    }
    public String getVille()
    {
        return ville;
    }
   public String getTel()
    {
        return tel;
    }
   public String getEmail()
    {
        return email;
    }
   public String toString()
   {
       return nom;
   }
}
