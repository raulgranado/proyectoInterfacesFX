/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodefinitivofx.vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import proyectodefinitivofx.Principal;
import proyectodefinitivofx.modelo.ConversionesTablaFX;

/**
 * FXML Controller class
 *
 * @author DAM-2
 */
public class UltimasConversionesController implements Initializable {

    private Principal main;
    @FXML
    private TableView<ConversionesTablaFX> tabla;
    
    @FXML
    private TableColumn<ConversionesTablaFX, String> desde;
    @FXML
    private TableColumn<ConversionesTablaFX, String> hasta;
    @FXML
    private TableColumn<ConversionesTablaFX, Number> cantidad1;
    @FXML
    private TableColumn<ConversionesTablaFX, Number> cantidad2;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        desde.setCellValueFactory(cellData -> cellData.getValue().getDesdeMedida());
        hasta.setCellValueFactory(cellData -> cellData.getValue().getHastaMedida());
        cantidad1.setCellValueFactory(cellData -> cellData.getValue().getCantidad1());
        cantidad2.setCellValueFactory(cellData -> cellData.getValue().getCantidad2());
        
        
    }

    public void setMain(Principal main){
        this.main=main;
        this.tabla.setItems(main.getConversiones());
    }
    
}
