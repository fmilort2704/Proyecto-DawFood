/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.UIManager;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author FX506
 */
public class TPV {
    
    private final UUID ID;
    private LocalDateTime fechaHoraSistema;
    private String direccion;
    private String password;
    private ArrayList<Producto> cartaProductos;
    private ArrayList<Producto> carrito;
    private ArrayList<Ticket> baseDatosTicket;

    public TPV(String direccion) {
        this.ID = UUID.randomUUID();
        this.fechaHoraSistema = LocalDateTime.now();
        this.direccion = direccion;
        this.password = crearPassword();
        this.cartaProductos = CartaNoe.listaProductos();
        this.carrito = new ArrayList<>();
        this.baseDatosTicket = new ArrayList<>();
    }

    public TPV() {
        this.ID = UUID.randomUUID();
    }

    public ArrayList<Producto> getCartaProductos() {
        return cartaProductos;
    }

    public void setCartaProductos(ArrayList<Producto> cartaProductos) {
        this.cartaProductos = cartaProductos;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    public ArrayList<Ticket> getBaseDatosTicket() {
        return baseDatosTicket;
    }

    public void setBaseDatosTicket(ArrayList<Ticket> baseDatosTicket) {
        this.baseDatosTicket = baseDatosTicket;
    }

    public UUID getID() {
        return ID;
    }

    public LocalDateTime getFechaHoraSistema() {
        return fechaHoraSistema;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setFechaHoraSistema(LocalDateTime fechaHoraSistema) {
        this.fechaHoraSistema = fechaHoraSistema;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("ID=").append(ID);
        sb.append(", fechaHoraSistema=").append(fechaHoraSistema);
        sb.append(", direccion=").append(direccion);
        sb.append('}');
        return sb.toString();
    }

    private String crearPassword(){
        return RandomStringUtils.randomAlphabetic(3)
                + RandomStringUtils.randomAlphabetic(1).toUpperCase()
                + RandomStringUtils.randomNumeric(1)
                + RandomStringUtils.random(1, "#$%&()*+,-.:;<=>@");
    }
    
    public void encenderTPV(){
        
        UIManager.put("OptionPane.cancelButtonText", "Atrás");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
        
        int opcionModo = UtilidadesTPV.opcionModo();
        
        if(opcionModo == 1){
            while(true){
                CartaNoe.elegirProducto(this);
            }
            
            
            
            
        }
        
    }
    
}
