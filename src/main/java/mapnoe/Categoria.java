/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package mapnoe;


/**
 *
 * @author francisco
 */
public enum Categoria {
    //Declaración de las diferentes categoria de comida
    COMIDA("Comida"),
    POSTRE("Postre"),
    BEBIDA("Bebida");
    
    private final String CATEGORIA;
    
    Categoria(String CATEGORIA){
    this.CATEGORIA = CATEGORIA;
}

    public String getCATEGORIA() {
        return CATEGORIA;
    }
    
    
}
