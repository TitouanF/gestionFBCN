package Modele;


public class Club 
{
   private String nom;
   private String adresse;
   private String CP;
   private String ville;
   private String nomPresident;
   public Club(String nouvNom,String nouvAdresse,String nouvCP,String nouvVille,String nouvNomPresident)
   {
       nom = nouvNom;
       adresse = nouvAdresse;
       CP = nouvCP;
       ville = nouvVille;
       nomPresident = nouvNomPresident;
   }
   public String getNom()
   {
       return nom;
   }
   public void setNom(String nouvNom)
   {
       nom = nouvNom;
   }
   public String getAdresse()
   {
       return adresse;
   }
   public void setAdresse(String nouvAdresse)
   {
       adresse = nouvAdresse;
   }
   public String getCP()
   {
       return CP;
   }
   public void setCP(String nouvCP)
   {
       CP = nouvCP;
   }
   public String getVille()
   {
       return ville;
   }
   public void setVille(String nouvVille)
   {
       ville = nouvVille;
   }
   public String getNomPresident()
   {
       return nomPresident;
   }
   public void setNomPresident(String nouvNomPresident)
   {
       nomPresident = nouvNomPresident;
   }
   public String toString()
   {
       return nom;
   }
}
