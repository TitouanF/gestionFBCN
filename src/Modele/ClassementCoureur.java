package Modele;

import java.sql.Time;

public class ClassementCoureur 
{
    String nomCourse,prenomCoureur,nomCoureur;
    int place;
    Time temps;
    
    public ClassementCoureur(String nouvNomCourse,String nouvPrenomCoureur,String nouvNomCoureur,int nouvPlace,Time nouvTemps)
    {
        nomCourse = nouvNomCourse;
        prenomCoureur = nouvPrenomCoureur;
        nomCoureur = nouvNomCoureur;
        place = nouvPlace;
        temps = nouvTemps;
    }
    public String getNomCourse()
    {
        return nomCourse;
    }
    public String getPrenomCoureur()
    {
        return prenomCoureur;
    }
    public String getNomCoureur()
    {
        return nomCoureur;
    }
    public int getPlace()
    {
        return place;
    }
    public Time getTemps()
    {
        return temps;
    }
}
