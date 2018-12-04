
package controller;

import Modele.GestionRequetes;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    @FXML
    Label labelErreurNom;
    @FXML
    Label labelErreurAdresse;
    @FXML
    Label labelErreurCodePostal;
    @FXML
    Label labelErreurVille;
    @FXML
    Label labelErreurPresident;
    @FXML
    Label labelAjoutFini;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelErreurNom.setVisible(false);
        labelErreurAdresse.setVisible(false);
        labelErreurCodePostal.setVisible(false);
        labelErreurVille.setVisible(false);
        labelErreurPresident.setVisible(false);
        labelAjoutFini.setVisible(false);
    }   
    @FXML
    public void handleAjoutClub()
    {
     String nom,adresse,ville,nomPresident,CP;
        
        if(textNom.getText() == null || textNom.getText().length() == 0 || estUnString(textNom.getText()))
            {
                labelAjoutFini.setVisible(false);
                System.out.println("Entrez un nom valide");
                labelErreurNom.setVisible(true);
            }
        else if (textAdresse.getText() == null || textAdresse.getText().length() == 0)
            {
                labelAjoutFini.setVisible(false);
                labelErreurNom.setVisible(false);
                System.out.println("Entrez une adresse valide");
                labelErreurAdresse.setVisible(true);
            }
        else if (textCP.getText() == null || textCP.getText().length() != 5 || estUnEntier(textCP.getText()))
            {
                labelAjoutFini.setVisible(false);
                labelErreurAdresse.setVisible(false);
                labelErreurNom.setVisible(false);
                System.out.println("Entrez un code postal valide");
                labelErreurCodePostal.setVisible(true);
            }
        else if (textVille.getText() == null || textVille.getText().length() == 0 || estUnString(textVille.getText()))
            {
                labelAjoutFini.setVisible(false);
                labelErreurAdresse.setVisible(false);
                labelErreurNom.setVisible(false);
                labelErreurCodePostal.setVisible(false);
                System.out.println("Entrez une ville valdie");
                labelErreurVille.setVisible(true);
            }
        else if (textNomPresident.getText() == null || textNomPresident.getText().length() == 0 || estUnString(textNomPresident.getText()))
            {
                labelAjoutFini.setVisible(false);
                labelErreurAdresse.setVisible(false);
                labelErreurNom.setVisible(false);
                labelErreurCodePostal.setVisible(false);
                labelErreurVille.setVisible(false);
                System.out.println("Entrez un nom de président valide");
                labelErreurPresident.setVisible(true);
            }
        else
            {
                labelAjoutFini.setVisible(true);
                labelErreurAdresse.setVisible(false);
                labelErreurNom.setVisible(false);
                labelErreurCodePostal.setVisible(false);
                labelErreurVille.setVisible(false);
                labelErreurPresident.setVisible(false);
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
            if (Pattern.matches("^[a-zA-Zéèàùûêâôë]{1}[a-zA-Zéèàùûêâôë \\'-]*[a-zA-Zéèàùûêâôë]$", chaine))
            {
                return false;
            }
            else
            {
                return true;
            }
    }
    
}
