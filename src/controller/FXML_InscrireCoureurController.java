/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.Club;
import Modele.GestionRequetes;
import Modele.Sexe;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class FXML_InscrireCoureurController implements Initializable 
{
    Connection conn;
    @FXML
     private ObservableList<Club> lesClubs = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Sexe> lesSexes = FXCollections.observableArrayList();
    @FXML
    private ComboBox<Club> cmbChoixClub;
    @FXML
    private ComboBox<Sexe> cmbChoixSexe;
    @FXML
    private TextField txtBoxNom;
    @FXML
    private TextField txtBoxPrenom;
    @FXML
    private TextField txtBoxAnnee;
    @FXML
    private TextField txtBoxAdresse;
    @FXML
    private TextField txtBoxAdresseMail;
    @FXML
    private TextField txtBoxPointPrecedent;
    @FXML
    private TextField txtBoxAnneeActuelle;
    @FXML
    private TextField txtBoxCP;
    @FXML
    private TextField txtBoxVille;
    @FXML
    private TextField txtBoxNoTelephone;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Club club;
        Sexe sexeH = new Sexe("M","Homme");
        Sexe sexeF = new Sexe("F","Femme");
        lesSexes.add(sexeH);
        lesSexes.add(sexeF);
        cmbChoixSexe.setItems(lesSexes);
        lesClubs = GestionRequetes.listeClubs();
        cmbChoixClub.setItems(lesClubs);
          
    }
    public void handleInsertion()
    {
        if (cmbChoixClub.getValue() == null||((Club)cmbChoixClub.getValue()).getNom().length() == 0)
        {
            System.out.println("Veuillez selectionner un club");
        }
        else if (txtBoxNom.getText() == null || txtBoxNom.getText().length() == 0 || estUnString(txtBoxNom.getText()))
          {
            System.out.println("Nom invalide");
          }
        else if (txtBoxPrenom.getText() == null || txtBoxPrenom.getText().length() == 0 || estUnString(txtBoxPrenom.getText()))
          {
            System.out.println("Prenom invalide");
          }
        else  if (cmbChoixSexe.getValue() == null||((Sexe)cmbChoixSexe.getValue()).getInitiale().length() == 0)
         {
             System.out.println("Veuillez selectionner un sexe");
         }
        else if (txtBoxAnnee.getText() == null || txtBoxAnnee.getText().length() != 4 || estUnEntier(txtBoxAnnee.getText()))
          {
            System.out.println("Annee invalide");
          }
        else  if (txtBoxAdresse.getText() == null || txtBoxAdresse.getText().length() == 0)
           {
             System.out.println("Adresse invalide");
           }
        else  if (txtBoxCP.getText() == null ||  txtBoxCP.getText().length() != 5 || estUnEntier(txtBoxCP.getText()))
           {
             System.out.println("Code Postal invalide");
           }
        else  if (txtBoxVille.getText() == null || txtBoxVille.getText().length() == 0 || estUnString(txtBoxVille.getText()))
           {
             System.out.println("Ville invalide");
           }
        else if (txtBoxNoTelephone.getText() == null || txtBoxNoTelephone.getText().length() != 10 ||estUnEntier(txtBoxNoTelephone.getText()))
        {
            System.out.println("Numero de téléphone invalide");
        }
        else if (txtBoxAdresseMail.getText() == null || txtBoxAdresseMail.getText().length() == 0 || estUneAdresseMail(txtBoxAdresseMail.getText()))
          {
            System.out.println("Adresse mail invalide");
          }
        else  if (txtBoxPointPrecedent.getText() == null || txtBoxPointPrecedent.getText().length() == 0||txtBoxPointPrecedent.getText().length() >6 || estUnEntier(txtBoxPointPrecedent.getText()))
           {
             System.out.println("points année précédente invalide");
           }
        else  if (txtBoxAnneeActuelle.getText() == null || txtBoxAnneeActuelle.getText().length() == 0|| txtBoxAnneeActuelle.getText().length() >6 || estUnEntier(txtBoxAnneeActuelle.getText()))
           {
             System.out.println("points année actuelle invalide");
           }
        else
        {
            String clubChoisis = ((Club)cmbChoixClub.getValue()).getNom();
            String sexeChoisis = ((Sexe)cmbChoixSexe.getValue()).getInitiale();
            String nomChoisis = txtBoxNom.getText();
            String prenomChoisis = txtBoxPrenom.getText();
            String anneeChoisis = txtBoxAnnee.getText();
            String adresseChoisis = txtBoxAdresse.getText();
            String CPChoisis = txtBoxCP.getText();
            String villeChoisis = txtBoxVille.getText();
            String adresseMailChoisis = txtBoxAdresseMail.getText();
            String pointsPrecedentChoisis = txtBoxPointPrecedent.getText();
            String pointsActuelleChoisis = txtBoxAnneeActuelle.getText();    
            String noTelChoisis = txtBoxNoTelephone.getText();
            GestionRequetes.insertCourreur(clubChoisis,sexeChoisis,nomChoisis,prenomChoisis,anneeChoisis,adresseChoisis,CPChoisis,villeChoisis,adresseMailChoisis,pointsPrecedentChoisis,pointsActuelleChoisis,noTelChoisis);
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
    public boolean estUneAdresseMail(String chaine)
    {
        if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", chaine))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
