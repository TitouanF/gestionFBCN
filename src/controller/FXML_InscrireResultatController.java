package controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXML_InscrireResultatController implements Initializable 
{
    @FXML
    Label labelNom;
    @FXML
    Label labelPrenom;
    @FXML
    Label labelEcritureNom;
    @FXML
    Label labelEcriturePrenom;
    @FXML
    Label labelSelectionNom;
    @FXML
    Label labelSelectionPlace;
    @FXML
    Label labelSelectionTemps;
    @FXML
    RadioButton radioLicencie;
    @FXML
    RadioButton radioPasLicencie;
    @FXML
    ComboBox comboBoxChoix;
    @FXML
    TextField textNom;
    @FXML
    TextField textPrenom;
    @FXML
    TextField textPlace;
    @FXML
    TextField textTemps;
    @FXML
    Button boutonInserer;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        labelNom.setVisible(false);
        labelPrenom.setVisible(false);
        labelEcritureNom.setVisible(false);
        labelEcriturePrenom.setVisible(false);
        labelSelectionNom.setVisible(false);
        labelSelectionPlace.setVisible(false);
        labelSelectionTemps.setVisible(false);
        comboBoxChoix.setVisible(false);
        textNom.setVisible(false);
        textPrenom.setVisible(false);
        textPlace.setVisible(false);
        textTemps.setVisible(false);
        boutonInserer.setVisible(false);
        
    }   
    @FXML
    public void handleRadioLicencie()
    {
        radioPasLicencie.setSelected(false);
        labelSelectionNom.setVisible(true);
        comboBoxChoix.setVisible(true);
        labelPrenom.setVisible(true);
        labelPrenom.setText("prenom : ");
        labelSelectionPlace.setVisible(true);
        labelSelectionTemps.setVisible(true);
        textPlace.setVisible(true);
        textTemps.setVisible(true);
        
        
    }
    @FXML
    public void handleRadioPasLicencie()
    {
        radioLicencie.setSelected(false);
    }
    
}
