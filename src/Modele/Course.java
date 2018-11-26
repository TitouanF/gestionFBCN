/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Titouan FLOCH
 */
public class Course 
{
    String nom;
    String lieu;
    Date date;
    Time heureDepart;
    float distance;
    int prix;
    boolean challenge;
    
    public Course(String nouvNom,String nouvLieu,Date nouvDate,Time nouvHeure, float nouvDistance,int nouvPrix,boolean nouvChallenge)
    {
        nom = nouvNom;
        lieu = nouvLieu;
        date = nouvDate;
        heureDepart = nouvHeure;
        distance = nouvDistance;
        prix = nouvPrix;
        challenge = nouvChallenge;    
    }
    public void setNom(String nouvNom)
    {
        nom = nouvNom;
    }
    public String getNom()
    {
        return nom;
    }
     public void setLieu(String nouvLieu)
    {
        nom = nouvLieu;
    }
    public String getLieu()
    {
        return lieu;
    }
     public void setDate(Date nouvDate)
    {
        date = nouvDate;
    }
    public Date getDate()
    {
        return date;
    }
    public Time getHeureDepart()
    {
        return heureDepart;
    }
    public void setHeureDepart(Time nouvHeure)
    {
        heureDepart = nouvHeure;
    }
     public void setDistance(float nouvDistance)
    {
        distance = nouvDistance;
    }
    public float getDistance()
    {
        return distance;
    }
     public void setPrix(int nouvPrix)
    {
        prix = nouvPrix;
    }
    public int getPrix()
    {
        return prix;
    }
    public void setChallenge(boolean nouvChallenge)
    {
        challenge = nouvChallenge;
    }
    public String getChallenge()
    {
        if (challenge == true)
        {
        return "oui";
        }
        else
        {
         return "non";
        }
    }
    public String toString()
    {
        String phrase;
        if (getChallenge() == "oui")
        {
            phrase = "la course " + getNom() +", le " + getDate() + " une course de " +getDistance() + " km et est part challenge" ;
        }
        else
        {        
             phrase = "la course " + getNom() +", le " + getDate() + " une course de " +getDistance() + " km et ne fait pas partie du challenge" ;
        }
        return phrase;
    }
            
}
