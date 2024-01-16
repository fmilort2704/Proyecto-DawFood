/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author noelia
 */
public class Tarjeta {
    
    private String numTarjeta;
    private LocalDate fechaVencimiento;
    private String CVV;
    private String nombreTitular;
    private int saldo;

    public Tarjeta(String numTarjeta, LocalDate fechaVencimiento, String CVV, String nombreTitular, int saldo) {
        this.numTarjeta = numTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.CVV = CVV;
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }

    public Tarjeta() {
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCVV() {
        return CVV;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.numTarjeta);
        hash = 23 * hash + Objects.hashCode(this.fechaVencimiento);
        hash = 23 * hash + Objects.hashCode(this.CVV);
        hash = 23 * hash + Objects.hashCode(this.nombreTitular);
        hash = 23 * hash + this.saldo;
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
        final Tarjeta other = (Tarjeta) obj;
        if (this.saldo != other.saldo) {
            return false;
        }
        if (!Objects.equals(this.numTarjeta, other.numTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.CVV, other.CVV)) {
            return false;
        }
        if (!Objects.equals(this.nombreTitular, other.nombreTitular)) {
            return false;
        }
        return Objects.equals(this.fechaVencimiento, other.fechaVencimiento);
    }
    
    
    
}
