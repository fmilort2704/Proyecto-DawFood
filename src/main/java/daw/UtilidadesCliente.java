/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class UtilidadesCliente {
    private ArrayList <Producto> listaCarrito;
    public UtilidadesCliente() {
        listaCarrito = new ArrayList<>();
    }
    //Rellena el carrito con los objetos que quiera el usuario
    public void rellenarCarrito(Producto producto, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            listaCarrito.add(producto);
        }  
    }
    
    //Muestra los elementos que se encuentran en el carrito
    public void mostrarElementosCarrito(){
        System.out.println("Los productos del carrito son: ");
        for (Producto producto : listaCarrito) {
            System.out.println("- " + producto.toString());
        }
    }
    
    
    
    
    
    
}
