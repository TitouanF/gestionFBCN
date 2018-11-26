package controller;
import Modele.Club;
import Modele.GestionRequetes;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class FXML_ModifierClubController implements Initializable 
    {
    ObservableList<Club> lesClubs = FXCollections.observableArrayList();
    @FXML
    ComboBox comboBoxChoix;
    @FXML
    TextField textAdresse;
    @FXML
    TextField textCP;
    @FXML
    TextField textVille;
    @FXML
    TextField textNomPresident;
    String nom,adresse,cp,ville,nomPresident;
        @Override
        public void initialize(URL url, ResourceBundle rb) 
            {
                lesClubs = GestionRequetes.listeClubs();
                comboBoxChoix.setItems(lesClubs);
                comboBoxChoix.valueProperty().addListener(new ChangeListener<Club>() 
                {
                    @Override 
                    public void changed(ObservableValue <? extends Club> observable,Club oldValue, Club newValue) 
                    {
                      textAdresse.setText(((Club)(comboBoxChoix.getValue())).getAdresse());
                      textCP.setText(((Club)(comboBoxChoix.getValue())).getCP());
                      textVille.setText(((Club)(comboBoxChoix.getValue())).getVille());
                      textNomPresident.setText(((Club)(comboBoxChoix.getValue())).getNomPresident());
                    }    
                });
            }
        @FXML
        public void handleModifier()
        {
            if (comboBoxChoix.getValue() == null)
                {
                    System.out.println("Veuillez sélectionner un club  à modifier");
                }
            else if (textAdresse.getText() == null||textAdresse.getText().length() == 0)
                {
                    System.out.println("Veuillez sélectionner une adresse valide");
                }
           else if (textCP.getText() == null||textCP.getText().length() != 5 || estUnEntier(textCP.getText()))
                {
                    System.out.println("Veuillez sélectionner un code postal valide");
                }
           else if (textVille.getText() == null||textVille.getText().length() == 0 || estUnString(textVille.getText()))
                {
                    System.out.println("Veuillez sélectionner un nom de ville valide");
                }
           else if (textNomPresident.getText() == null||textNomPresident.getText().length() == 0 || estUnString(textNomPresident.getText()))
                {
                    System.out.println("Veuillez sélectionner un nom valide");
                }
            else
                {
                    nom = ((Club)(comboBoxChoix.getValue())).getNom();
                    adresse = textAdresse.getText();
                    cp = textCP.getText();
                    ville = textVille.getText();
                    nomPresident = textNomPresident.getText();
                    GestionRequetes.modificationClub(nom, adresse, cp, ville, nomPresident);
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
