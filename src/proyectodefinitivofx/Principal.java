/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodefinitivofx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import proyectodefinitivofx.modelo.TipoArea;
import proyectodefinitivofx.modelo.TipoMedida;

/**
 *
 * @author DAM-2
 */
public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Principal.class.getResource("vista/VistaPrincipal.fxml"));
        
        AnchorPane panel;
        try {
            panel = (AnchorPane) loader.load();
            Scene scene = new Scene(panel);
            
            
        
            primaryStage.setTitle("Conversor");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
