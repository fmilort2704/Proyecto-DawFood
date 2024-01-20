/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import interfaces.InterfazTipoUsuario;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author FX506
 */
public class TPV {
    
    private final UUID ID;
    private LocalDateTime fechaHoraSistema;
    private String direccion;
    private String password;

    public TPV(String direccion) {
        this.ID = UUID.randomUUID();
        this.fechaHoraSistema = LocalDateTime.now();
        this.direccion = direccion;
        this.password = crearPassword();
    }

    public TPV() {
        this.ID = UUID.randomUUID();
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
    
    public void encenderTPV(){
        InterfazTipoUsuario interfaz = new InterfazTipoUsuario();
        interfaz.setVisible(true);
    }

    private String crearPassword(){
        //Pendiente de hacer
    }
}
