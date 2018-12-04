package controller;
import Modele.ClassementChallengeCoureurs;
import Modele.ClassementCoureur;
import Modele.ClassementCourseCoureurs;
import Modele.CoureurIndividuel;
import Modele.Coureurs;
import Modele.Course;
import Modele.GestionRequetes;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class FXML_AfficherClassementController implements Initializable 
{
    ObservableList<ClassementCourseCoureurs> lesCoureursCourse = FXCollections.observableArrayList();
    ObservableList<ClassementChallengeCoureurs> lesCoureursChallenge = FXCollections.observableArrayList();
    ObservableList<ClassementChallengeCoureurs> leClassementCoureurs = FXCollections.observableArrayList();
    ObservableList<ClassementCoureur> lesCoursesCoureur = FXCollections.observableArrayList();
    ObservableList<Course> lesCourses = FXCollections.observableArrayList();
    ObservableList<CoureurIndividuel> lesCoureursIndividuel = FXCollections.observableArrayList();
    
    @FXML
    TableView<ClassementCoureur> tableCoureur;
    @FXML
    TableView<ClassementCourseCoureurs>tableCourse;
    @FXML
    TableView<ClassementChallengeCoureurs> tableChallenge;
      
    @FXML
    ComboBox<Course> comboBoxChoixCourse;
    @FXML
    ComboBox<CoureurIndividuel> comboBoxChoixCoureur;
     
    @FXML
    TableColumn<ClassementCoureur,String> colCoureurCourse;
    @FXML
    TableColumn<ClassementCoureur,String> colCoureurPrenom;
    @FXML
    TableColumn<ClassementCoureur,String> colCoureurNom;
    @FXML
    TableColumn<ClassementCoureur,String> colCoureurPlace;
    @FXML
    TableColumn<ClassementCoureur,String> colCoureurTemps;
     
    @FXML
    TableColumn<ClassementCourseCoureurs,String> colCourseNom;
    @FXML
    TableColumn<ClassementCourseCoureurs,String> colCoursePrenom;
    @FXML
    TableColumn<ClassementCourseCoureurs,String> colCoursePlace;
    @FXML
    TableColumn<ClassementCourseCoureurs,String> colCourseTemps;
      
    @FXML
    TableColumn<ClassementChallengeCoureurs,String> colChallengeNomCoureur;
    @FXML
    TableColumn<ClassementChallengeCoureurs,String> colChallengePrenomCoureur;
    @FXML
    TableColumn<ClassementChallengeCoureurs,String> colChallengePoints;
       
    @FXML
    RadioButton radioCourse;
    @FXML
    RadioButton radioChallenge;
    @FXML
    RadioButton radioCoureur;
     
    ChangeListener<Course> changeListener1 = new ChangeListener<Course>() 
    {
        @Override 
        public void changed(ObservableValue <? extends Course> observable,Course oldValue,Course newValue) 
        {
            tableCourse.getItems().clear();
            String nomCourse = ((Course)(comboBoxChoixCourse.getValue())).getNom();
            lesCoureursCourse = GestionRequetes.RecuperationCoureur(nomCourse);
            tableCourse.setItems(lesCoureursCourse);                     
        }    
    };
     ChangeListener<CoureurIndividuel> changeListener2 = new ChangeListener<CoureurIndividuel>() 
    {
        @Override 
        public void changed(ObservableValue <? extends CoureurIndividuel> observable,CoureurIndividuel oldValue,CoureurIndividuel newValue) 
        {
            tableCoureur.getItems().clear();
            String nomCoureur = ((CoureurIndividuel)(comboBoxChoixCoureur.getValue())).getNom();
            lesCoursesCoureur = GestionRequetes.getCourseCoureur(nomCoureur);
            tableCoureur.setItems(lesCoursesCoureur);                     
        }    
    };
            
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        comboBoxChoixCoureur.setVisible(false);
        tableCoureur.getItems().clear();
        tableCoureur.setVisible(false);
        tableChallenge.getItems().clear();
        tableCourse.getItems().clear();
        tableCourse.setVisible(false);
        tableChallenge.setVisible(false);
        comboBoxChoixCourse.setVisible(false);
        colCourseNom.setCellValueFactory(new PropertyValueFactory<ClassementCourseCoureurs,String>("nom"));
        colCoursePrenom.setCellValueFactory(new PropertyValueFactory<ClassementCourseCoureurs,String>("prenom"));
        colCoursePlace.setCellValueFactory(new PropertyValueFactory<ClassementCourseCoureurs,String>("place"));
        colCourseTemps.setCellValueFactory(new PropertyValueFactory<ClassementCourseCoureurs,String>("temps"));
        colChallengeNomCoureur.setCellValueFactory(new PropertyValueFactory<ClassementChallengeCoureurs,String>("nom"));
        colChallengePrenomCoureur.setCellValueFactory(new PropertyValueFactory<ClassementChallengeCoureurs,String>("prenom"));
        colChallengePoints.setCellValueFactory(new PropertyValueFactory<ClassementChallengeCoureurs,String>("point"));       
        colCoureurCourse.setCellValueFactory(new PropertyValueFactory<ClassementCoureur,String>("nomCourse"));
        colCoureurPrenom.setCellValueFactory(new PropertyValueFactory<ClassementCoureur,String>("prenomCoureur"));
        colCoureurNom.setCellValueFactory(new PropertyValueFactory<ClassementCoureur,String>("nomCoureur"));
        colCoureurPlace.setCellValueFactory(new PropertyValueFactory<ClassementCoureur,String>("place"));
        colCoureurTemps.setCellValueFactory(new PropertyValueFactory<ClassementCoureur,String>("temps"));
    } 
    
    @FXML
    public void handleCourse()
        {   
            comboBoxChoixCoureur.valueProperty().removeListener(changeListener2);
            lesCoureursIndividuel.clear();
            radioCoureur.setSelected(false);
            radioChallenge.setSelected(false);
            tableChallenge.setVisible(false);
            comboBoxChoixCourse.setVisible(true);
            tableCourse.setVisible(true);
            lesCourses = GestionRequetes.listeCourse();
            comboBoxChoixCourse.setItems(lesCourses);
            comboBoxChoixCourse.valueProperty().addListener(changeListener1);
            comboBoxChoixCoureur.setVisible(false);
            tableCoureur.setVisible(false);
        }
    
    @FXML
    public void handleCoureur()
    {
        lesCoureursIndividuel = GestionRequetes.getCoureur();
        comboBoxChoixCoureur.setItems(lesCoureursIndividuel);
        comboBoxChoixCourse.valueProperty().removeListener(changeListener1);
        radioChallenge.setSelected(false);
        radioCourse.setSelected(false);
        tableChallenge.setVisible(false);
        tableCourse.setVisible(false);
        comboBoxChoixCourse.setVisible(false);
        comboBoxChoixCoureur.setVisible(true);
        tableCoureur.setVisible(true);
        comboBoxChoixCoureur.valueProperty().addListener(changeListener2);
    }
    
    @FXML
    public void handleChallenge()
    {
        
        tableCoureur.setVisible(false);
        comboBoxChoixCoureur.setVisible(false);
        radioCoureur.setSelected(false);
        comboBoxChoixCourse.valueProperty().removeListener(changeListener1);
        comboBoxChoixCoureur.valueProperty().removeListener(changeListener2);
        lesCoureursIndividuel.clear();
        leClassementCoureurs.clear();
        tableChallenge.getItems().clear();
        radioCourse.setSelected(false);
        tableCourse.setVisible(false);
        tableChallenge.setVisible(true);
        comboBoxChoixCourse.setVisible(false);
        leClassementCoureurs = GestionRequetes.RecuperationClassementCoureurs();
        Comparator<ClassementChallengeCoureurs> comparator; 
        comparator = Comparator.comparingInt(ClassementChallengeCoureurs::getPoint);
        FXCollections.sort(leClassementCoureurs, comparator); 
        tableChallenge.setItems(leClassementCoureurs);
    }   
}
