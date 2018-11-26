/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.Club;
import Modele.Course;
import Modele.GestionRequetes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXML_AccueilController implements Initializable 
{
     @FXML
     Label labelProchaineCourse;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Course course = GestionRequetes.RequeteCoursePlusProche();
        labelProchaineCourse.setText(course.accueil());      
    }    
     @FXML
  private void handleInscrireCoureur()
  {
       try
    {
      FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_InscrireCoureur.fxml"));  
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
     @FXML
  private void handleAfficherCourses()
  {
       try
    {
      FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_AfficherCourses.fxml"));  
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
    @FXML
  private void handleAfficherClub()
  {
       try
    {
      FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_AfficherLesClubs.fxml"));  
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
  @FXML
  private void handleModifierCoureur()
  {
       try
    {
      FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_ModifierCoureur.fxml"));  
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
}
