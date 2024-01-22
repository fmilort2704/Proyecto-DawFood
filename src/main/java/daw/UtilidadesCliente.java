/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author francisco
 */
public class UtilidadesCliente {
//    // Array de String con las opciones a mostrar
//String[] opcionesMenu = {"1.- PIN", "2.- Sistema operativo", "3.- Contraseña personalizada"};
//
//// Método de JOptionPane para mostrar la lista desplegable. 
//// Este método devuelve un tipo Object que convertimos a String y guardamos en la variable opcionElegida
//String opcionElegida = (String) JOptionPane.showInputDialog(null,
//        "Elige una opción", "Generador de contraseñas",
//        JOptionPane.QUESTION_MESSAGE , null, opcionesMenu, "1.- PIN");
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
        JOptionPane.showInputDialog("Los productos del carrito son: ");
        for (Producto producto : listaCarrito) {
            JOptionPane.showInputDialog("- " + producto);
        }
    }
    
    
    
    
    
    
}
