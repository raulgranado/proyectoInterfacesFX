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
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectodefinitivofx.modelo.ConversionesTablaFX;
import proyectodefinitivofx.vista.Controlador;
import proyectodefinitivofx.vista.UltimasConversionesController;

/**
 *
 * @author DAM-2
 */
public class Principal extends Application {
    
    private ObservableList<ConversionesTablaFX> listaConversiones = FXCollections.observableArrayList();
    BorderPane panel;
    Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Principal.class.getResource("vista/VistaPrincipal.fxml"));
        this.primaryStage=primaryStage;
        
        try {
            panel = (BorderPane) loader.load();
            Scene scene = new Scene(panel);
            
            Controlador ctr=loader.getController();
            ctr.setMain(this);
        
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
    
    public void addConversion(ConversionesTablaFX conv){
        listaConversiones.add(conv);
    }
    
    public ObservableList<ConversionesTablaFX> getConversiones(){
        return listaConversiones;
    }
    
    public void mostrarUltimasConversioens(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Principal.class.getResource("vista/UltimasConversiones.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ultimas conversiones");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            
            UltimasConversionesController controller = loader.getController();
            controller.setMain(this);
            dialogStage.showAndWait();

        } catch (IOException e) {
        }
    }
    
}
