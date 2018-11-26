
package controller;

import Modele.GestionRequetes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class FXML_CreerNouveauClubController implements Initializable 
{
    @FXML
    TextField textNom;
    @FXML
    TextField textAdresse;
    @FXML
    TextField textCP;
    @FXML
    TextField textVille;
    @FXML
    TextField textNomPresident;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }   
    @FXML
    public void handleAjoutClub()
    {
     String nom,adresse,ville,nomPresident,CP;
        
        if(textNom.getText() == null || textNom.getText().length() == 0 || estUnString(textNom.getText()))
            {
                System.out.println("Entrez un nom valide");
            }
        else if (textAdresse.getText() == null || textAdresse.getText().length() == 0)
            {
                System.out.println("Entrez une adresse valide");
            }
        else if (textCP.getText() == null || textCP.getText().length() != 5 || estUnEntier(textCP.getText()))
            {
                System.out.println("Entrez un code postal valide");    
            }
        else if (textVille.getText() == null || textVille.getText().length() == 0 || estUnString(textVille.getText()))
            {
                System.out.println("Entrez une ville valdie");
            }
        else if (textNomPresident.getText() == null || textNomPresident.getText().length() == 0 || estUnString(textNomPresident.getText()))
            {
                System.out.println("Entrez un nom de président valide");
            }
        else
            {
                nom = textNom.getText();
                adresse = textAdresse.getText();
                CP = textCP.getText();
                ville = textVille.getText();
                nomPresident = textNomPresident.getText();
                GestionRequetes.insertionNouvClub(nom, adresse, CP, ville, nomPresident);               
            }   
    }
          public boolean estUnEntier(String chaine)
    {
        try
        {
            Integer.parseInt(chaine);
        }
        catch(NumberFormatException e)
        {
           return true;
        }
       return false;
    }    
    public boolean estUnString(String chaine)
    {
        chaine = chaine.replaceAll(" ","");
        int nombre = chaine.length();
        int i;
        for (i=0;i<nombre;i++)
        {
            if (Character.isLetter(chaine.charAt(i)))
            {
                
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    
}
