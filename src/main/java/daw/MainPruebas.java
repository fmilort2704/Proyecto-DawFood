/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author FX506
 */
public class MainPruebas {

    public static void main(String[] args) {

        ArrayList<Tarjeta> baseDatosTarjeta = UtilidadesTarjeta.baseDatosTarjeta();
        
        //Comprobando cual es el máximo día del mes
        System.out.println(LocalDate.MAX.getDayOfMonth());
        
        //Buscando la tarjeta del cliente
        System.out.println("----------------------------------------------------------------------");
        String digitosCliente = "4567";
        Tarjeta tarjetaCliente = new Tarjeta();
        
        for (int i = 0; i < baseDatosTarjeta.size(); i++) {
            if (digitosCliente.equals(baseDatosTarjeta.get(i)
                    .getNumTarjeta()
                    .substring(baseDatosTarjeta.get(i).getNumTarjeta().length() - 4,
                            baseDatosTarjeta.get(i).getNumTarjeta().length()))) {
                tarjetaCliente = baseDatosTarjeta.get(i);
            }
        }
        System.out.println(tarjetaCliente);
        
    }

}
