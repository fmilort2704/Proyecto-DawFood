/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class Ticket {
    private int ID;
    private int numPedido;
    private ArrayList<Productos> listaProductos;
    private int importeTotal;
    private LocalDateTime fechaHoraOperacion;

    public Ticket(int ID, int numPedido, ArrayList<Productos> listaProductos, int importeTotal, LocalDateTime fechaHoraOperacion) {
        this.ID = ID;
        this.numPedido = numPedido;
        this.listaProductos = listaProductos;
        this.importeTotal = importeTotal;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public Ticket() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(int importeTotal) {
        this.importeTotal = importeTotal;
    }

    public LocalDateTime getFechaHoraOperacion() {
        return fechaHoraOperacion;
    }

    public void setFechaHoraOperacion(LocalDateTime fechaHoraOperacion) {
        this.fechaHoraOperacion = fechaHoraOperacion;
    }
    
    
}
