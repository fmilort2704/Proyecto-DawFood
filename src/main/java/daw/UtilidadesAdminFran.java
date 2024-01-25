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
                
            }
            case 4 -> {

            }
        }

    }

    //Ver los pedidos de la lista entera de ticket durente el dia de hoy
    public static void verPedidosDia(LocalDate dia, ArrayList<Ticket> listaTicket) {
        JOptionPane.showInputDialog("Los ticket de hoy son:");
        ArrayList<Ticket> listaTicketHoy = new ArrayList<>();
        for (int i = 0; i < listaTicket.size(); i++) {
            if (listaTicket.get(i).getFechaOperacion().isEqual(dia)) {
                listaTicketHoy.add(listaTicket.get(i));
            }
        }
        for (Ticket ticket : listaTicketHoy) {
            JOptionPane.showInputDialog("- " + ticket);
        }

    }

    //Ver los pedidos de la lista entera de ticket hasta una fecha concreta
    public static void verPedidosHastaFecha(LocalDate diaLimite, ArrayList<Ticket> listaTicket) {
        ArrayList<Ticket> listaTicketFechaConcreta = new ArrayList<>();
        JOptionPane.showInputDialog("Los tickets hasta este dia son:");
        for (int i = 0; i < listaTicket.size(); i++) {
            if (listaTicket.get(i).getFechaOperacion().isBefore(diaLimite)) {
                listaTicketFechaConcreta.add(listaTicket.get(i));
            }

        }
        for (Ticket ticket : listaTicketFechaConcreta) {
            JOptionPane.showInputDialog("- " + ticket);
        }
    }

    public static void consultarVentas(TPV tpv) {
        Object[] opciones = {"Ventas del dia", "Venta hasta un dia concreto",
            "Todas la ventas registada"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Consultar las ventas", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[3]);
        tpv.getBaseDatosTicket();
        switch (opcionElegida) {
            case 0 -> {
                verPedidosDia(tpv.getBaseDatosTicket().get(0).getFechaOperacion(), tpv.getBaseDatosTicket());
            }
            case 1 -> {
                verPedidosHastaFecha(LocalDate.now(),tpv.
            }
            case 2 -> {

            }

        }
    }

}