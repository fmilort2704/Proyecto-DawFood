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
public class UtilidadesAdmin {
    private ArrayList<Producto> carta;
    public UtilidadesAdmin() {
        this.carta = new ArrayList<>();
    }
    
    public int numeroElementos() {
        return this.carta.size();
    }

    public boolean estaVacio() {
        return carta.isEmpty();
    }

    public Producto verElemento(int posicion) {
        return this.carta.get(posicion);
    }

    public void cambiarElemento(int posicion, Producto p) {
        this.carta.set(posicion, p);
    }

    public void guardarElemento(Producto p) {
        this.carta.add(p);
    }

    public void eliminarElemento(int posicion) {
        this.carta.remove(posicion);
    }

    public void eliminarElemento(Producto p) {
        this.carta.remove(p);
    }

    public void eliminarElementos(ArrayList<Producto> listaElementos) {
        for (Producto p : listaElementos) {
            this.carta.remove(p);
        }
    }

    public void eliminarTodos() {
        this.carta.clear();
    }

    public void imprimirLista() {
        this.carta.forEach(System.out::println);
    }

    public int buscarElemento(Producto p) {
        return this.carta.indexOf(p);
    }
    

}
