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

        //Probando condición de digitos válidos para la tarjeta
        ArrayList<Tarjeta> baseDatosTarjeta = UtilidadesTarjeta.baseDatosTarjeta();
        for (int i = 0; i < baseDatosTarjeta.size(); i++) {
            System.out.println(baseDatosTarjeta.get(i).getNumTarjeta()
                    .substring(baseDatosTarjeta.get(i).getNumTarjeta().length() - 4,
                            baseDatosTarjeta.get(i).getNumTarjeta().length()));
        }
        
        //Comprobando cual es el máximo día del mes
        System.out.println(LocalDate.MAX.getDayOfMonth());

    }

}
