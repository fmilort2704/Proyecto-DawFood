/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public enum Subcategorias {
    POKE("Poke"),
    WRAP("Wrap"),
    LOCA_MOCO("Loco Moco"),
    HELADO("Helado"),
    FRUTA("Fruta"),
    TARTA("Tarta"),
    AGUA("Agua"),
    CERVEZA("Cerveza"),
    VINO("Vino"),
    ZUMO("Zumo");
    
    private final String SUBCATEGORIAS;
    
    Subcategorias(String SUBCATEGORIAS){
    this.SUBCATEGORIAS = SUBCATEGORIAS;
}

    public String getSUBCATEGORIAS() {
        return SUBCATEGORIAS;
    }
    
    
}
