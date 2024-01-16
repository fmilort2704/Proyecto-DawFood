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
    private ArrayList<Producto> listaProductos;
    private int importeTotal;
    private LocalDateTime fechaHoraOperacion;
    private static int contadorId = 0;
    private static int contadorNumPedido = 0;

    public Ticket(ArrayList<Producto> listaProductos, int importeTotal, LocalDateTime fechaHoraOperacion) {
        this.ID = contadorId;
        contadorId++;
        this.numPedido = contadorNumPedido;
        contadorNumPedido++;
        this.listaProductos = listaProductos;
        this.importeTotal = importeTotal;
        this.fechaHoraOperacion = fechaHoraOperacion;
    }

    public Ticket() {
    }

    public int getID() {
        return ID;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
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
