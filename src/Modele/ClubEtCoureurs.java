/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Titouan FLOCH
 */
public class ClubEtCoureurs
{
    private String nom;
    private String adresse;
    private String CP;
    private String ville;
    private String nomPresident;
    private int nombreCoureurs;
    
    public ClubEtCoureurs(String nouvNom,String nouvAdresse,String nouvCP,String nouvVille,String nouvNomPresident,int nouvNombreCoureurs)
    {
        nom = nouvNom;
        adresse = nouvAdresse;
        CP = nouvCP;
        ville = nouvVille;
        nomPresident = nouvNomPresident;
        nombreCoureurs = nouvNombreCoureurs;       
    }
        public String getNom()
        {
            return nom;
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
        public String getNomPresident()
        {
            return nomPresident;
        }
        public int getNombreCoureurs()
        {
            return nombreCoureurs;
        }
                
}
