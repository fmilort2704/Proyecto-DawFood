/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author francisco
 */
public class UtilidadesAdminFran {

    public void cambiarDescripcion(Producto producto, String descripcion) {
        producto.setDescripcion(descripcion);
    }

    public void cambiarCategoria(Producto producto, Categoria categoria) {
        producto.setCategoria(categoria);
    }

    public void cambiarSubcategoria(Producto producto, Subcategoria subcategoria) {
        producto.setSubcategoria(subcategoria);
    }

    public void cambiarPrecio(Producto producto, double precio) {
        producto.setPrecio(precio);
    }

    public void cambiarIVA(Producto producto, IVA iva) {
        producto.setIVA(iva);
    }

    public void cambiarStock(Producto producto, int stock) {
        producto.setStock(stock);
    }

    //Hay que controlar que no se pueda meter una categoria en la lista equivocada
//    public void añadirComida(Producto comida, ArrayList<Producto> listaComida){
//        listaComida.add(comida);
//    }
//    
//    public void añadirBebida(Producto bebida, ArrayList<Producto> listaBebida){
//        listaBebida.add(bebida);
//    }
//    
//    public void añadirPostre(Producto postre, ArrayList<Producto> listaPostre){
//        listaPostre.add(postre);
//    }
    public static void modoMantenimiento(TPV tpv) {

        Object[] options = {"Editar producto", "Nuevo producto",
            "Borrar producto", "Consultar ventas", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una categoría", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[4]);

        switch (opcionElegida) {
            case 0 -> {

            }
            case 1 -> {

            }
            case 2 -> {
            }
            case 3 -> {
                consultarVentas(tpv);
            }
            case 4 -> {

            }
        }

    }

    //Ver los pedidos de la lista entera de ticket durente el dia de hoy
    public static void verPedidosDia(LocalDate dia, ArrayList<Ticket> listaTicket, TPV tpv) {
        ArrayList<Ticket> listaTicketHoy = new ArrayList<>();
        for (int i = 0; i < listaTicket.size(); i++) {
            if (listaTicket.get(i).getFechaOperacion().isEqual(dia)) {
                listaTicketHoy.add(listaTicket.get(i));
            }
        }
        if (!(tpv.getBaseDatosTicket().isEmpty())) {
            Ticket opcionTicket = (Ticket) JOptionPane.showInputDialog(null,
                    "Lista de ventas", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                    null, listaTicketHoy.toArray(),
                    listaTicketHoy.get(0));
        } else {
            JOptionPane.showMessageDialog(null, "No hay ventas en el dia de hoy todavia");
        }
    }

    //Ver los pedidos de la lista entera de ticket hasta una fecha concreta
    public static void verPedidosHastaFecha(LocalDate diaLimite, ArrayList<Ticket> listaTicket, TPV tpv) {
        ArrayList<Ticket> listaTicketFechaConcreta = new ArrayList<>();
        for (int i = 0; i < listaTicket.size(); i++) {
            if (listaTicket.get(i).getFechaOperacion().isBefore(diaLimite)
                    || listaTicket.get(i).getFechaOperacion().isEqual(diaLimite)) {
                listaTicketFechaConcreta.add(listaTicket.get(i));
            }
        }
        if (!(tpv.getBaseDatosTicket().isEmpty())) {
            Ticket opcionTicket = (Ticket) JOptionPane.showInputDialog(null,
                    "Lista de ventas", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                    null, listaTicketFechaConcreta.toArray(),
                    listaTicketFechaConcreta.get(0));
        } else {
            JOptionPane.showMessageDialog(null, "Hasta esa fecha no hay ventas registradas");
        }

    }

    public static void consultarVentas(TPV tpv) {
        Object[] opciones = {"Ventas del dia", "Venta hasta un dia concreto",
            "Todas la ventas registada"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Consultar las ventas", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[2]);
        tpv.getBaseDatosTicket();
        switch (opcionElegida) {
            case 0 -> {
                JTextField mes = new JTextField();
                JTextField anyo = new JTextField();
                JTextField dia = new JTextField();
                Object[] message = {
                    "Introduce la fecha concreta",
                    "Dia:", dia,
                    "Mes:", mes,
                    "Año:", anyo,};

                int option = 0;

                option = JOptionPane.showConfirmDialog(null, message,
                        "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    LocalDate fechaDia = LocalDate.MIN;

                    verPedidosDia(fechaDia, tpv.getBaseDatosTicket(), tpv);
                }
            }
            case 1 -> {
                JTextField mes = new JTextField();
                JTextField anyo = new JTextField();
                JTextField dia = new JTextField();
                Object[] message = {
                    "Introduce la fecha concreta",
                    "Dia:", dia,
                    "Mes:", mes,
                    "Año:", anyo,};

                int option = 0;

                option = JOptionPane.showConfirmDialog(null, message,
                        "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    LocalDate fechaDia = LocalDate.MIN;
                    verPedidosHastaFecha(fechaDia, tpv.getBaseDatosTicket(), tpv);
                }
            }
            case 2 -> {
                tpv.getBaseDatosTicket();
                if (!(tpv.getBaseDatosTicket().isEmpty())) {
                    Ticket TodasLasVentas = (Ticket) JOptionPane.showInputDialog(null,
                            "Consultar las ventas", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                            null, tpv.getBaseDatosTicket().toArray(),
                            tpv.getBaseDatosTicket().get(0));
                }else {
                    JOptionPane.showMessageDialog(null, "No hay ventas registradas en la base de datos");
                }

            }
        }
    }

    public static LocalDate pedirDia(int dia, int mes, int anyo) {
        LocalDate fecha = LocalDate.MIN;

        if (((mes >= LocalDate.MIN.getMonthValue() && mes <= LocalDate.MAX.getMonthValue())
                && (anyo >= LocalDate.MIN.getYear() && anyo <= LocalDate.MAX.getYear())
                && (dia >= LocalDate.MIN.getDayOfYear() && dia <= LocalDate.MAX.getDayOfYear()))) {
            fecha = LocalDate.of(anyo, mes, dia);
        }

        return fecha;
    }
}
