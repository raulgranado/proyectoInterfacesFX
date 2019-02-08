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
public enum TipoEnergia {
    KJ("Kilojulios"), Julio("Julios"), Cal("Calorias"), Vatio_hora("Vatios/hora"); 
    

    private String displayName;

    TipoEnergia(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() { return displayName; }
    @Override public String toString() { return displayName; }
}
