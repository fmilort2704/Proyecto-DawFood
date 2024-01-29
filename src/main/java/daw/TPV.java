/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author FX506
 */
public class TPV {

    private final UUID ID;
    private LocalDateTime fechaHoraSistema;
    private LocalDate fechaSistema;
    private LocalTime horaSistema;
    private String direccion;
    private String password;
    private ArrayList<Producto> cartaProductos;
    private ArrayList<Producto> carrito;
    private ArrayList<Ticket> baseDatosTicket;

    public TPV(String direccion) {
        this.ID = UUID.randomUUID();
        this.fechaHoraSistema = LocalDateTime.now();
        this.direccion = direccion;
        this.password = UtilidadesAdmin.crearPassword();
        this.cartaProductos = UtilidadesTPV.listaProductos();
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

    public String getPassword() {
        return password;
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

    public void encenderTPV() {

        //Se crea la contraseña y se muestra para el modo admin
        System.out.println("Contraseña Admin: " + this.password);

        UIManager.put("OptionPane.okButtonText", "Aceptar");
        UIManager.put("OptionPane.cancelButtonText", "Volver");
        UIManager.put("OptionPane.background", new Color(147, 217, 196));
        UIManager.put("Panel.background", new Color(147, 217, 196));

        boolean encendido = true;
        boolean usuario = false;
        
        do {//Do while que controla el apagado del tpv
            int opcionModo;

            //Se encarga de volver al seleccionarModo
            if (usuario) {
                opcionModo = 1;
            } else {
                opcionModo = UtilidadesTPV.seleccionarModo();
            }

            switch (opcionModo) {
                case 0 -> {
                    boolean passValida;
                    usuario = false;
                    do {
                        passValida = UtilidadesAdmin.pedirPassword(this);

                        if (passValida) {
                            UtilidadesAdmin.modoMantenimiento(this);

                        } else {
                            String[] opciones = {"Aceptar"};

                            JOptionPane.showOptionDialog(null,
                                    "La contraseña no es correcta, vuelve a intentar", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                    opciones, opciones[0]);
                        }
                    } while (!passValida);
                }
                case 1 -> {

                    usuario = UtilidadesTPV.seleccionarCategoría(this);
                }
                case 2 -> {
                    usuario = false;
                    //Opción apagar
                    encendido = false;
                }
            }
        } while (encendido);
    }

}
