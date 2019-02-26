/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodefinitivofx.modelo;

/**
 *
 * @author DAM-2
 */
public class ConversionesReporte {
    
    private String desdeMedida, hastaMedida, tipo;
    private double cantidad1, cantidad2;

    public ConversionesReporte(String desdeMedida, String hastaMedida, double cantidad1, double cantidad2, String tipo) {
        this.desdeMedida = desdeMedida;
        this.hastaMedida = hastaMedida;
        this.cantidad1 = cantidad1;
        this.cantidad2 = cantidad2;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getDesdeMedida() {
        return desdeMedida;
    }

    public void setDesdeMedida(String desdeMedida) {
        this.desdeMedida = desdeMedida;
    }

    public String getHastaMedida() {
        return hastaMedida;
    }

    public void setHastaMedida(String hastaMedida) {
        this.hastaMedida = hastaMedida;
    }

    public double getCantidad1() {
        return cantidad1;
    }

    public void setCantidad1(double cantidad1) {
        this.cantidad1 = cantidad1;
    }

    public double getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(double cantidad2) {
        this.cantidad2 = cantidad2;
    }
    
    
    
}
