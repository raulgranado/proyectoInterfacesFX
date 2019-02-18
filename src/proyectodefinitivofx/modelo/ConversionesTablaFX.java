/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodefinitivofx.modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DAM-2
 */
public class ConversionesTablaFX {
    private final StringProperty desdeMedida;
    private final StringProperty hastaMedida;
    private final DoubleProperty cantidad1;
    private final DoubleProperty cantidad2;
    
    public ConversionesTablaFX(){
        this(null,null,0,0);
    }
    
    public ConversionesTablaFX(String desdeMedida, String hastaMedida, double cantidad1, double cantidad2){
        this.desdeMedida = new SimpleStringProperty(desdeMedida);
        this.hastaMedida = new SimpleStringProperty(hastaMedida);
        this.cantidad1 = new SimpleDoubleProperty(cantidad1);
        this.cantidad2 = new SimpleDoubleProperty(cantidad2);
    }

    public StringProperty getDesdeMedida() {
        return desdeMedida;
    }

    public StringProperty getHastaMedida() {
        return hastaMedida;
    }

    public DoubleProperty getCantidad1() {
        return cantidad1;
    }
    
    public DoubleProperty getCantidad2() {
        return cantidad2;
    }
    
    public void setDesdeMedida(String str){
        this.desdeMedida.set(str);
    }
    
    public void setHastaMedida(String str){
        this.hastaMedida.set(str);
    }
    
    public void setCantidad1(double cantidad){
        this.cantidad1.set(cantidad);
    }
    
    public void setCantidad2(double cantidad){
        this.cantidad2.set(cantidad);
    }
    
}
