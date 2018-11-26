/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.Challenge;
import Modele.GestionRequetes;
import Modele.Heure;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Titouan FLOCH
 */
public class FXML_NouvelleCourseController implements Initializable 
{
    @FXML
    private TextField txtBoxNom;
    @FXML
    private TextField txtBoxLieu;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField txtBoxDistance;;
    @FXML
    private TextField txtBoxPrix;
    @FXML
    private ComboBox comboBoxChallenge;
    @FXML
    private ComboBox comboBoxHeure;
    
    ObservableList<Challenge> lesChallenges = FXCollections.observableArrayList();
    ObservableList<Heure> lesHeures = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
        Challenge ChallengeA = new Challenge(1,"OUI");
        Challenge ChallengeB = new Challenge(0,"NON");
        Heure horraire = new Heure ("09:15");
        Heure horraire1 = new Heure ("09:30");
        Heure horraire2 = new Heure ("09:45");
        Heure horraire3 = new Heure ("10:00");
        Heure horraire4 = new Heure ("10:15");
        Heure horraire5 = new Heure ("10:30");
        Heure horraire6 = new Heure ("10:45");
        Heure horraire7 = new Heure ("17:00");
        
        lesChallenges.add(ChallengeA);
        lesChallenges.add(ChallengeB);
        lesHeures.add(horraire);
        lesHeures.add(horraire1);
        lesHeures.add(horraire2);
        lesHeures.add(horraire3);
        lesHeures.add(horraire4);
        lesHeures.add(horraire5);
        lesHeures.add(horraire6);
        lesHeures.add(horraire7);
        comboBoxHeure.setItems(lesHeures);
        comboBoxChallenge.setItems(lesChallenges);
        
    }    
    @FXML
    public void HandleAjout()
    {
        LocalDate dateaujourdhui = LocalDate.now();
        String messageErreur = "";
        if (txtBoxNom.getText() == null || txtBoxNom.getText().length() == 0 || estUnString(txtBoxNom.getText()))
        {
            messageErreur = "Nom invalide";
        }
       else if (txtBoxLieu.getText() == null || txtBoxLieu.getText().length() == 0 || estUnString(txtBoxLieu.getText()))
        {
            messageErreur = "Lieu invalide";
        }
       else if (datePicker.getValue() == null || datePicker.getValue().isBefore(dateaujourdhui))
        {
            messageErreur = "Entrez une date valide";
        }
        else if (comboBoxHeure.getValue() == null)
        {
            messageErreur = "Heure invalide";
        }
        else if (txtBoxDistance.getText() == null || txtBoxDistance.getText().length() == 0 || estUnEntier(txtBoxDistance.getText()))
        {
            messageErreur = "distance invalide";
        }
        else if (txtBoxPrix.getText() == null || txtBoxPrix.getText().length() == 0 || estUnEntier(txtBoxPrix.getText()))
        {
            messageErreur = "prix invalide";
        }
        else if (comboBoxChallenge.getValue() == null )
        {
            messageErreur = "Selectionnez une valeur pour le challenge";
        }
        else
        {
            String nom = txtBoxNom.getText();
            String lieu = txtBoxLieu.getText();
            LocalDate date = datePicker.getValue();
            String heureDepart = ((Heure)comboBoxHeure.getValue()).toString();
            String distance = txtBoxDistance.getText();
            String prix = txtBoxPrix.getText();
            int challenge = ((Challenge)comboBoxChallenge.getValue()).getValeur();
            GestionRequetes.insertionDansBDD(nom, lieu, date, heureDepart,distance, prix, challenge);
        }
        System.out.println(messageErreur);
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
