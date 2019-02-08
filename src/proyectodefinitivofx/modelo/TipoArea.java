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
public enum TipoArea {
    
    Km2("Kilometros cuadrado"), M2("Metros cuadrado"), Hectarea("Hectareas"), Acre("Acres"); 
    

    private String displayName;

    TipoArea(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }
    @Override public String toString() { return displayName; }
}
