/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodefinitivofx.vista;

import convert.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;
import proyectodefinitivofx.Principal;
import proyectodefinitivofx.modelo.AbrirReportes;
import proyectodefinitivofx.modelo.ConversionesTablaFX;
import proyectodefinitivofx.modelo.TipoAngulo;
import proyectodefinitivofx.modelo.TipoArea;
import proyectodefinitivofx.modelo.TipoEnergia;
import proyectodefinitivofx.modelo.TipoLongitud;
import proyectodefinitivofx.modelo.TipoMasa;
import proyectodefinitivofx.modelo.TipoMedida;
import proyectodefinitivofx.modelo.TipoPresion;
import proyectodefinitivofx.modelo.TipoTemperatura;
import proyectodefinitivofx.modelo.TipoVelocidad;


/**
 *
 * @author DAM-2
 */
public class Controlador implements Initializable {
    
    private Principal main;
    
    @FXML
    private MenuItem ultimas;
    @FXML
    private MenuItem informe;
    @FXML
    private MenuItem salir;
    @FXML
    private MenuItem conv;
    @FXML
    private MenuItem camb;
    
    @FXML
    private ComboBox<TipoMedida> cbx;
    @FXML
    private ComboBox<Object> cbxIz;
    @FXML
    private ComboBox<Object> cbxDer;
    
    @FXML
    private TextField textIz;
    
    @FXML
    private TextField textDer;
    
    @FXML
    private Button convert;
    @FXML
    private Button change;

    
    @FXML
    private void convertir(ActionEvent event) {
        if(cbx.getSelectionModel().getSelectedItem()==null || cbxIz.getSelectionModel().getSelectedItem()==null
                || cbxDer.getSelectionModel().getSelectedItem()==null || textIz.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Debes rellenar todos los campos");
            alert.showAndWait();
        }else{
            conversion();
        }
        
        
    }
    
    private void conversion(){
            int tipo = cbx.getSelectionModel().getSelectedIndex();
            int unidad1=cbxIz.getSelectionModel().getSelectedIndex();
            int unidad2=cbxDer.getSelectionModel().getSelectedIndex();
            double numero=Double.parseDouble(textIz.getText());
            double result=convert(tipo, unidad1, unidad2, numero);
            textDer.setText(String.valueOf(result));
            
            
    }
    
    private double convert(int tipo, int unidad1, int unidad2, double numero) {
        double result=0;
        switch(tipo){
            case 0:
                result=Angulo.convertirAngulo(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoAngulo.values()[unidad1].toString(),
                        TipoAngulo.values()[unidad2].toString(), numero, result, "Angulo"));
                break;
            case 1:
                result=Area.convertirArea(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoArea.values()[unidad1].toString(),
                        TipoArea.values()[unidad2].toString(), numero, result, "Area"));
                break;
            case 2:
                result=Energia.convertirEnergia(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoEnergia.values()[unidad1].toString(),
                        TipoEnergia.values()[unidad2].toString(), numero, result, "Energia"));
                break;
            case 3:
                result=Longitud.convertirLongitud(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoLongitud.values()[unidad1].toString(),
                        TipoLongitud.values()[unidad2].toString(), numero, result, "Longitud"));
                break;
            case 4:
                result=Masa.convertirMasa(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoMasa.values()[unidad1].toString(),
                        TipoMasa.values()[unidad2].toString(), numero, result, "Masa"));
                break;
            case 5:
                result=Presion.convertirPresion(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoPresion.values()[unidad1].toString(),
                        TipoPresion.values()[unidad2].toString(), numero, result, "Presion"));
                break;
            case 6:
                result=Temperatura.convertirTemperatura(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoTemperatura.values()[unidad1].toString(),
                        TipoTemperatura.values()[unidad2].toString(), numero, result, "Temperatura"));
                break;
            case 7:
                result=Velocidad.convertirVelocidad(numero, unidad1, unidad2);
                main.addConversion(new ConversionesTablaFX(TipoVelocidad.values()[unidad1].toString(),
                        TipoVelocidad.values()[unidad2].toString(), numero, result, "Velocidad"));
                break;
        }
        return result;
    }
    
    @FXML
    private void mostrarUltimasConversiones(){
        main.mostrarUltimasConversioens();
    }
    
    @FXML
    private void generarInforme() {
        AbrirReportes abrir = new AbrirReportes(main.getConversiones());
        try {
            abrir.abrirReporte();
        } catch (JRException ex) {
            
        }
    }
    
    
    @FXML
    private void salir(){
        System.exit(0);
    }
    
    @FXML
    private void cambiar(ActionEvent event) {
        Object selectIz=cbxIz.getSelectionModel().getSelectedItem();
        Object selectDer=cbxDer.getSelectionModel().getSelectedItem();
        String strIz=textIz.getText();
        String strDer=textDer.getText();
        
        if(selectIz!=null){
            cbxDer.getSelectionModel().select(selectIz);
            cbxIz.getSelectionModel().clearSelection();
        }
        if(selectDer!=null){
            cbxIz.getSelectionModel().select(selectDer);
            if(selectIz==null){
                cbxDer.getSelectionModel().clearSelection();
            } 
        }
        
        if(strDer.equals("")){
            strIz="";
        }
        textIz.setText(strDer);
        textDer.setText(strIz);
        if(!textIz.getText().equals("")){
            conversion();
        }
        
        
    }
    
    public void setMain(Principal main){
        this.main=main;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarCombobox();
        configurarTextField();
        textIz.isFocused();

    }    

    private void configurarCombobox() {
        cbx.getItems().addAll(TipoMedida.values());
        cbx.valueProperty().addListener(new ChangeListener<TipoMedida>(){
            @Override
            public void changed(ObservableValue<? extends TipoMedida> observable, TipoMedida oldValue, TipoMedida newValue) {
                textIz.setText("");
                textDer.setText("");
                switch(newValue.toString()){
                    case "Angulo":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoAngulo.values());
                        cbxDer.getItems().addAll(TipoAngulo.values());
                        break;
                    case "Area":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoArea.values());
                        cbxDer.getItems().addAll(TipoArea.values());
                        break;
                    case "Energia":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoEnergia.values());
                        cbxDer.getItems().addAll(TipoEnergia.values());
                        break;
                    case "Longitud":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoLongitud.values());
                        cbxDer.getItems().addAll(TipoLongitud.values());
                        break;
                    case "Masa":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoMasa.values());
                        cbxDer.getItems().addAll(TipoMasa.values());
                        break;
                    case "Presion":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoPresion.values());
                        cbxDer.getItems().addAll(TipoPresion.values());
                        break;
                    case "Temperatura":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoTemperatura.values());
                        cbxDer.getItems().addAll(TipoTemperatura.values());
                        break;
                    case "Velocidad":
                        cbxIz.getItems().clear();
                        cbxDer.getItems().clear();
                        cbxIz.getItems().addAll(TipoVelocidad.values());
                        cbxDer.getItems().addAll(TipoVelocidad.values());
                        break;
                }
            }
            
        });
        
        cbxIz.valueProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                textDer.setText("");
            }
        });
        
        cbxDer.valueProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                textDer.setText("");
            }
        });
    }

    private void configurarTextField() {
        textIz.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("\\d*([\\.]\\d*)?([E]\\d*)?")){
                    textIz.setText(oldValue);
                }
            }
           
       });
       
    }

    
    
}
