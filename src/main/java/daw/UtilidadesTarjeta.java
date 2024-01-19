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

    public static ArrayList<Tarjeta> baseDatosTarjeta() {
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

        listaTarjetas.add(new Tarjeta("1234567891234567",
                LocalDate.of(2026, 10, LocalDate.MIN.getDayOfMonth()),
                "123", "Noelia", 432));

        //Poco saldo
        listaTarjetas.add(new Tarjeta("1234567898912345",
                LocalDate.of(2024, 3, LocalDate.MIN.getDayOfMonth()),
                "456", "Fran", 10));

        //Caducada
        listaTarjetas.add(new Tarjeta("1234567894567891",
                LocalDate.of(2023, 12, LocalDate.MIN.getDayOfMonth()),
                "789", "Vica", 100000));

        return listaTarjetas;
    }

    public static boolean numTarjetaValido(String digitosCliente) {
        ArrayList<Tarjeta> baseDatosTarjeta = baseDatosTarjeta();

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

    public LocalDate fechaCaducidad(int mes, int año) {
        LocalDate fecha = LocalDate.MIN;
        if (((mes >= LocalDate.MIN.getMonthValue() && mes <= LocalDate.MAX.getMonthValue())
                && (año >= LocalDate.now().getYear() && año <= LocalDate.MAX.getYear()))) {
            fecha = LocalDate.of(año, mes, LocalDate.MIN.getDayOfMonth());
        }
        return fecha;
    }

    public boolean fechaCaducidadYCVVValidos(String digitosCliente, LocalDate fechaCaducidad, String CVV) {
        ArrayList<Tarjeta> baseDatosTarjeta = baseDatosTarjeta();
        Tarjeta tarjetaCliente = new Tarjeta();

        //Primero obtengo la tarjeta del cliente para poder mirar sus atributos
        for (int i = 0; i < baseDatosTarjeta.size(); i++) {
            if (digitosCliente.equals(baseDatosTarjeta.get(i)
                    .getNumTarjeta()
                    .substring(baseDatosTarjeta.get(i).getNumTarjeta().length() - 4,
                            baseDatosTarjeta.get(i).getNumTarjeta().length()))) {
                tarjetaCliente = baseDatosTarjeta.get(i);
            }
        }
        
        //comprobamos que la fecha introducida
        //no esté pasada (caducada)
        //y que la fecha introducida es la misma que está guardada
        //en la info de la tarjeta de nustra base de datos
        if (fechaCaducidad.isAfter(LocalDate.now())
                && fechaCaducidad.equals(tarjetaCliente.getFechaVencimiento())) {
            //En este otro if al que sólo se llega si la fecha está bien
            //compruebo que el cvv sea el correcto
            if (CVV.equals(tarjetaCliente.getCVV())) {
                return true;
            }
        }
        return false;
    }

}
