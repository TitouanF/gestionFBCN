package controller;
import Modele.Club;
import Modele.Coureurs;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class FXML_ModifierCoureurController implements Initializable 
{
    ObservableList<Club> lesClubs = FXCollections.observableArrayList();
    ObservableList<Coureurs> lesCoureurs = FXCollections.observableArrayList();
    @FXML
    ComboBox<Coureurs> comboBoxChoix;
    @FXML
    ComboBox<Club> comboBoxNomClub;
    @FXML
    TextField textPrenom;
    @FXML
    TextField textNom;
    @FXML
    TextField textAdresse;
    @FXML
    TextField textCP;
    @FXML
    TextField textVille;
    @FXML
    TextField textNoTel;
    @FXML
    TextField textEmail;
    @FXML
    Label labelClubActuel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     lesClubs = GestionRequetes.listeClubs();
     lesCoureurs = GestionRequetes.ListeCoureurs();
     comboBoxChoix.setItems(lesCoureurs);
     comboBoxNomClub.setItems(lesClubs);
     comboBoxChoix.valueProperty().addListener(new ChangeListener<Coureurs>() 
                {
                    @Override 
                    public void changed(ObservableValue <? extends Coureurs> observable,Coureurs oldValue,Coureurs newValue) 
                    {
                        String nomClub = ((Coureurs)(comboBoxChoix.getValue())).getNomClub();
                        labelClubActuel.setText(nomClub);
                        textPrenom.setText(((Coureurs)(comboBoxChoix.getValue())).getPrenom());
                        textNom.setText(((Coureurs)(comboBoxChoix.getValue())).getNom());
                        textAdresse.setText(((Coureurs)(comboBoxChoix.getValue())).getAdresse());
                        textCP.setText(((Coureurs)(comboBoxChoix.getValue())).getCP());
                        textVille.setText(((Coureurs)(comboBoxChoix.getValue())).getVille());
                        textNoTel.setText(((Coureurs)(comboBoxChoix.getValue())).getTel());
                        textEmail.setText(((Coureurs)(comboBoxChoix.getValue())).getEmail());
                    }    
                });
    }    
     @FXML
     public void handleModification()
     {
         if (comboBoxChoix.getValue() == null||((Coureurs)comboBoxChoix.getValue()).getNom().length() == 0)
            {
                System.out.println("Veuillez selectionner un coureur");
            }
        else if (textPrenom.getText() == null||textPrenom.getText().length() == 0 || estUnString(textPrenom.getText()))
            {
                System.out.println("Veuillez mettre un prenom valide");
            }
         else if (textNom.getText() == null||textNom.getText().length() == 0 || estUnString(textNom.getText()))
            {
                System.out.println("Veuillez mettre un nom valide");
            }
        else if (textAdresse.getText() == null||textAdresse.getText().length() == 0 )
            {
                System.out.println("Veuillez mettre une adresse valide");
            }
        else if (textCP.getText() == null||textCP.getText().length() != 5 || estUnEntier(textCP.getText()))
            {
                System.out.println("Veuillez mettre un code postal valide");
            }
        else if (textVille.getText() == null||textVille.getText().length() == 0 || estUnString(textVille.getText()))
            {
                System.out.println("Veuillez entre une ville valide");
            }
        else
            {
                String nomAChanger,nomClub,prenom,nom,adresse,cp,ville,noTel,email;
                noTel =textNoTel.getText();
                nomAChanger = ((Coureurs)(comboBoxChoix.getValue())).getNom();
                prenom = textPrenom.getText();
                nom = textNom.getText();
                adresse = textAdresse.getText();
                cp = textCP.getText();
                nomClub = labelClubActuel.getText();
                ville = textVille.getText();
                email = textEmail.getText();
                if(comboBoxNomClub.getValue() == null||((Club)comboBoxNomClub.getValue()).getNom().length() == 0)
                {
                    nomClub = labelClubActuel.getText();
                }
                else
                {
                    nomClub = ((Club)comboBoxNomClub.getValue()).getNom();
                }
                
                if (textNoTel.getText() == null || textNoTel.getText().length() == 0)
                    {
                        noTel = "";
                    }
                else if(estUnEntier(textNoTel.getText()))
                    {
                        System.out.println("Entrez un numero de télephone valide ou laissez vide s'il n'y en a pas");
                    }
                else if( textNoTel.getText().length() != 10)
                    {
                        System.out.println("Entrez un numero de télephone valide ou laissez vide s'il n'y en a pas");
                    }
                else
                    {
                        noTel = textNoTel.getText();
                    }
                 
                if(textEmail.getText() == null || textNoTel.getText().length() == 0)
                    {
                        System.out.println("ici");
                        email = "";
                    }
                else
                    {
                        email = textEmail.getText();
                    }
                GestionRequetes.modificationCoureur(nomClub,nom, prenom, adresse,cp, noTel, ville, email, nomAChanger);               
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
