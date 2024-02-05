/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapnoe;

import daw.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author francisco
 */
public class Ticket {

    private UUID ID;
    private int numPedido;
    private ArrayList<Producto> listaProductos;
    private double importeTotal;
    private LocalDate fechaOperacion;
    private LocalTime horaOperacion;
    private static int contadorNumPedido = 0;

    public Ticket(ArrayList<Producto> listaProductos, double importeTotal, LocalDate fechaOperacion, LocalTime horaOperacion) {
        this.ID = UUID.randomUUID();
        contadorNumPedido++;
        this.numPedido = contadorNumPedido;
        this.listaProductos = listaProductos;
        this.importeTotal = importeTotal;
        this.fechaOperacion = fechaOperacion;
        this.horaOperacion = horaOperacion;
    }

    public Ticket() {
        this.ID = UUID.randomUUID();
        contadorNumPedido++;
        this.numPedido = contadorNumPedido;
    }

    public UUID getID() {
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

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaHoraOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public LocalTime getHoraOperacion() {
        return horaOperacion;
    }

    public void setHoraOperacion(LocalTime horaOperacion) {
        this.horaOperacion = horaOperacion;
    }

    public String toStringChulo() {
        String ticket = """
                        ------------------------------------------------------------------
                                              Restaurante PokéZen
                        
                        ID Ticket: %s
                        Número de pedido: %d
                        Fecha: %s       Hora: %s
                        ------------------------------------------------------------------
                        Producto        Precio        Cantidad        IVA 
                        ------------------------------------------------------------------
                        """.formatted(this.ID.toString(), this.numPedido,
                this.fechaOperacion.format(DateTimeFormatter.ofPattern("d/M/uuuu")),
                this.horaOperacion.format(DateTimeFormatter.ofPattern("H:m")));

        for (Producto p : this.listaProductos) {
            ticket += """
                      %s        %.2f€        %d       %.2f%%
                      """.formatted(p.getDescripcion(), p.getPrecio(), 
                              p.getStock(),p.getIVA().getPORCENTAJE_IVA());
        }
        ticket += """
                ------------------------------------------------------------------
                  Total: %.2f€    
                  
                                  ---  Gracias por su visita  ---
                ------------------------------------------------------------------"""
                .formatted(this.importeTotal);

        return ticket;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(ID);
        sb.append(", numPedido: ").append(numPedido);
        sb.append(", importeTotal: ").append(importeTotal);
        sb.append(", fechaOperacion: ").append(fechaOperacion);
        sb.append(", horaOperacion: ").append(horaOperacion);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        return Objects.equals(this.ID, other.ID);
    }
    
    

}
