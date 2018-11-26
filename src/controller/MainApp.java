package controller;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application 
{
 private Stage primaryStage;
    private AnchorPane rootLayout;
    
    @Override
    public void start(Stage primaryStage) 
    {
      this.primaryStage = primaryStage;
       this.primaryStage.setTitle("Accueil");
       try
        {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FXML_Accueil.fxml"));
            rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            FXML_AccueilController controleur2 = loader.getController();
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
