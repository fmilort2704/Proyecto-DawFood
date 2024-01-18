/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author francisco
 */
public class UtilidadesTarjeta {

    public ArrayList<Tarjeta> baseDatosTarjeta() {
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

        listaTarjetas.add(new Tarjeta("1234567891234567",
                LocalDate.of(2026, 10, 1),
                "123", "Noelia", 432));

        //Poco saldo
        listaTarjetas.add(new Tarjeta("1234567898912345",
                LocalDate.of(2024, 3, 10),
                "456", "Fran", 10));

        //Caducada
        listaTarjetas.add(new Tarjeta("1234567894567891",
                LocalDate.of(2023, 12, 28),
                "789", "Vica", 100000));

        return listaTarjetas;
    }

    public boolean numTarjetaValido(String digitosCliente) {
        ArrayList<Tarjeta> baseDatosTarjeta = baseDatosTarjeta();
        
        if(digitosCliente){
            
        }
        for (int i = 0; i < baseDatosTarjeta.size(); i++) {

            if (digitosCliente.equals(baseDatosTarjeta.get(i)
                    .getNumTarjeta()
                    .substring(baseDatosTarjeta.get(i).getNumTarjeta().length() - 4,
                            baseDatosTarjeta.get(i).getNumTarjeta().length()))) {
                return true;
            }
        }

        return false;
    }
    
    

}
