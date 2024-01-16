/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public enum Categorias {
    COMIDA("Comida"),
    POSTRES("Postre"),
    BEBIDAS("Bebida");
    
    private final String CATEGORIAS;
    
    Categorias(String CATEGORIAS){
    this.CATEGORIAS = CATEGORIAS;
}

    public String getCATEGORIAS() {
        return CATEGORIAS;
    }
    
    
}
