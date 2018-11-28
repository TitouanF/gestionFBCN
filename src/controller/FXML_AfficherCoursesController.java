/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.Course;
import Modele.GestionRequetes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Titouan FLOCH
 */
public class FXML_AfficherCoursesController implements Initializable 
{
    ObservableList<Course> lesCourses = FXCollections.observableArrayList();
    @FXML
    private TableView<Course> tableCourse = new TableView();
    @FXML
     private TableColumn<Course, String> colNom;
    @FXML
    private TableColumn<Course, String> colLieu;
    @FXML
    private TableColumn<Course, String> colDate;
    @FXML
    private TableColumn<Course, String> colHeureD;
    @FXML
     private TableColumn<Course, String> colDistance;
    @FXML
    private TableColumn<Course, String> colPrix;
    @FXML
    private TableColumn<Course, String> colChallenge;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      vraiInitialize();
    }  
      public void vraiInitialize()
  {
        colNom.setCellValueFactory(new PropertyValueFactory<Course,String>("nom"));
        colLieu.setCellValueFactory(new PropertyValueFactory<Course,String>("lieu"));
        colDate.setCellValueFactory(new PropertyValueFactory<Course,String>("date"));
        colHeureD.setCellValueFactory(new PropertyValueFactory<Course,String>("heureDepart"));
        colDistance.setCellValueFactory(new PropertyValueFactory<Course,String>("distance"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Course,String>("prix"));
        colChallenge.setCellValueFactory(new PropertyValueFactory<Course,String>("challenge"));    
        lesCourses = GestionRequetes.listeCourse();
        tableCourse.setItems(lesCourses);
  }
  @FXML
  private void handleAjoutCourse()
  {
       try
        {
          FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_NouvelleCourse.fxml"));  
          AnchorPane page=(AnchorPane) loader.load();
          Stage dialogStage = new Stage();
          Scene scene = new Scene(page);
          dialogStage.setScene(scene);
          dialogStage.showAndWait();
        }
         catch(IOException ioe)
        {      
          System.out.println("ERREUR chargement boite dialogue:" + ioe.getMessage());
        }
  }
  public void handleRefresh()
  {
      vraiInitialize();
  }
}
