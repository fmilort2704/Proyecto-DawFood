/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public enum Subcategoria {
    //Declaracion de los diferentes tipos de subcategorias
    POKE("Poke"),
    WRAP("Wrap"),
    LOCA_MOCO("Loco Moco"),
    HELADO("Helado"),
    FRUTA("Fruta"),
    TARTA("Tarta"),
    AGUA("Agua"),
    CERVEZA("Cerveza"),
    REFRESCO("Refresco");

    private final String SUBCATEGORIA;

    private Subcategoria(String SUBCATEGORIA) {
        this.SUBCATEGORIA = SUBCATEGORIA;
    }

    public String getSUBCATEGORIA() {
        return SUBCATEGORIA;
    }

}
