package Modele;

import java.sql.Time;

public class ClassementCourseCoureurs 
{
   
     private String nomClub;
    private String nom;
    private String prenom;
    private int place;
    private Time temps;


    
    public ClassementCourseCoureurs(String nouvNomClub,String nouvNom,String nouvPrenom,int nouvPlace,Time nouvTemps)
    {
        nomClub = nouvNomClub;
        nom = nouvNom;
        prenom = nouvPrenom;
        place = nouvPlace;
        temps = nouvTemps;

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
    public int getPlace()
    {
        return place;
    }
    public Time getTemps()
    {
        return temps;
    }
   public String toString()
   {
       return nom;
   }
}
