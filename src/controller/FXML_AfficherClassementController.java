package controller;
import Modele.ClassementChallengeCoureurs;
import Modele.ClassementCourseCoureurs;
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
    ObservableList<Course> lesCourses = FXCollections.observableArrayList();
    @FXML
    TableView<ClassementCourseCoureurs>tableCourse;
    @FXML
    TableView<ClassementChallengeCoureurs> tableChallenge;
    @FXML
    ComboBox<Course> comboBoxChoixCourse;
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
    static ObservableList<ClassementChallengeCoureurs> leClassementCoureurs = FXCollections.observableArrayList();
            
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
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
    } 
    @FXML
    public void handleCourse()
        {      
            radioChallenge.setSelected(false);
            tableChallenge.setVisible(false);
            comboBoxChoixCourse.setVisible(true);
            tableCourse.setVisible(true);
            lesCourses = GestionRequetes.listeCourse();
            comboBoxChoixCourse.setItems(lesCourses);
            comboBoxChoixCourse.valueProperty().addListener(new ChangeListener<Course>() 
                {
                    @Override 
                    public void changed(ObservableValue <? extends Course> observable,Course oldValue,Course newValue) 
                    {
                        String nomCourse = ((Course)(comboBoxChoixCourse.getValue())).getNom();
                        lesCoureursCourse = GestionRequetes.RecuperationCoureur(nomCourse);
                        tableCourse.setItems(lesCoureursCourse);
                    }    
                });
        }
    @FXML
    public void handleChallenge()
        {
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
