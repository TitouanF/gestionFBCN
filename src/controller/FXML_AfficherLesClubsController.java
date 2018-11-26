/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Modele.ClubEtCoureurs;
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

public class FXML_AfficherLesClubsController implements Initializable 
    {
        ObservableList<ClubEtCoureurs> lesClubsEtCoureurs = FXCollections.observableArrayList();
        @FXML
        TableView<ClubEtCoureurs> TableClub;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colNom;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colAdresse;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colCP;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colVille;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colPresident;
        @FXML
         private TableColumn<ClubEtCoureurs, String> colCoureurs;

        @Override
        public void initialize(URL url, ResourceBundle rb)
        {
            vraiInitialize();
        }  
        public void vraiInitialize()
            {
                colNom.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("nom"));
                colAdresse.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("adresse"));
                colCP.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("CP"));
                colVille.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("ville"));
                colPresident.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("nomPresident"));
                colCoureurs.setCellValueFactory(new PropertyValueFactory<ClubEtCoureurs,String>("nombreCoureurs"));
                lesClubsEtCoureurs = GestionRequetes.requeteClubEtCoureurs();
                TableClub.setItems(lesClubsEtCoureurs);
            }

        @FXML
        public void handleAjoutClub()
            {  
                try
                     {
                       FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_CreerNouveauClub.fxml"));  
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
        public void handleModifierClub()
            {  
                try
                     {
                       FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_ModifierClub.fxml"));  
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
                TableClub.getItems().clear();
                vraiInitialize();
            }


    }
