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
public enum TipoPresion {
    
    Bar("Bares"), Pascal("Pascales"), Atmosfera("Atmosferas"), MMHG("Milimetros de mercurio"); 
    

    private String displayName;

    TipoPresion(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }
    @Override public String toString() { return displayName; } 
    
}
