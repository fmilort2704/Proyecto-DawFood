/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author francisco
 */
public class UtilidadesAdmin {

    public static void modoMantenimiento(TPV tpv) {

        Object[] options = {"Editar producto", "Nuevo producto",
            "Borrar producto", "Consultar ventas", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una opción", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[4]);

        switch (opcionElegida) {
            case 0 -> {
                modificarProducto(tpv);
            }
            case 1 -> {
                tpv.getCartaProductos().add(new Producto());
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {
                UtilidadesTPV.seleccionarModo();
            }
        }
    }

    private static void modificarProducto(TPV tpv) {

        Producto opcionElegidaProducto = (Producto) JOptionPane.showInputDialog(null,
                "Escoge el producto a editar", "TPV", JOptionPane.QUESTION_MESSAGE,
                null, tpv.getCartaProductos().toArray(), tpv.getCartaProductos().get(0));

        JTextField descrip = new JTextField();
        JTextField categ = new JTextField();
        JTextField subcat = new JTextField();
        JTextField precio = new JTextField();
        JTextField iva = new JTextField();
        JTextField stock = new JTextField();
        Object[] message = {
            "Cambiar atributos del producto",
            "Descripcion:", descrip,
            "Categoría:", categ,
            "Subcategoría:", subcat,
            "Precio:", precio,
            "IVA:", iva,
            "Stock:", stock
        };

        int option = JOptionPane.showConfirmDialog(null, message,
                "TPV", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            String atributosCambiados = "";

            if (!descrip.getText().equals("")) {
                opcionElegidaProducto.setDescripcion(descrip.getText());
                atributosCambiados += "Descripción, ";
            }

            if (!categ.getText().equals("")) {
                for (Categoria c : Categoria.values()) {
                    if (categ.getText().equalsIgnoreCase(c.getCATEGORIA())) {
                        opcionElegidaProducto.setCategoria(c);
                        atributosCambiados += "Categoría, ";
                    }
                }
            }

            if (!subcat.getText().equals("")) {
                for (Subcategoria s : Subcategoria.values()) {
                    if (subcat.getText().equalsIgnoreCase(s.getSUBCATEGORIA())) {
                        opcionElegidaProducto.setSubcategoria(s);
                        atributosCambiados += "Subcategoría, ";
                    }
                }
            }

            if (!precio.getText().equals("")) {
                opcionElegidaProducto.setPrecio(Double.parseDouble(precio.getText()));
                atributosCambiados += "Precio, ";
            }

            if (!iva.getText().equals("")) {
                for (IVA iv : IVA.values()) {
                    if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {
                        opcionElegidaProducto.setIVA(iv);
                        atributosCambiados += "IVA, ";
                    }
                }
            }

            if (!stock.getText().equals("")) {
                opcionElegidaProducto.setPrecio(Integer.parseInt(stock.getText()));
                atributosCambiados += "Stock";
            }

            String[] opciones = {"Aceptar"};

            JOptionPane.showOptionDialog(null,
                    "Cambios realizados con éxito en " + atributosCambiados,
                    "TPV", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]);
        } else {
            modoMantenimiento(tpv);
        }

        if (opcionElegidaProducto == null) {
            modoMantenimiento(tpv);
        }
    }

    private static Producto nuevoProducto(TPV tpv) {

        JTextField descrip = new JTextField();
        JTextField categ = new JTextField();
        JTextField subcat = new JTextField();
        JTextField precio = new JTextField();
        JTextField iva = new JTextField();
        JTextField stock = new JTextField();
        Object[] message = {
            "Completa los datos del producto",
            "Descripcion:", descrip,
            "Categoría:", categ,
            "Subcategoría:", subcat,
            "Precio:", precio,
            "IVA:", iva,
            "Stock:", stock
        };

        int option = JOptionPane.showConfirmDialog(null, message,
                "TPV", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            for (Categoria c : Categoria.values()) {
                if (categ.getText().equalsIgnoreCase(c.getCATEGORIA())) {

                }
            }

            for (Subcategoria s : Subcategoria.values()) {
                if (subcat.getText().equalsIgnoreCase(s.getSUBCATEGORIA())) {

                }
            }

            for (IVA iv : IVA.values()) {
                if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {

                }
            }

        } else {
            modoMantenimiento(tpv);
        }

        for (Producto p : tpv.getCartaProductos()) {
            System.out.println(p);
        }
        
        return new Producto(descripcion, Categoria.COMIDA, 
                Subcategoria.TARTA, option, IVA.IVA_DIEZ, option);

    }

    public static void consultarTickets(ArrayList<Ticket> listaTicket) {
        JOptionPane.showInputDialog("La lista de ventas hasta el dia de hoy es:");
        for (Ticket ticket : listaTicket) {
            JOptionPane.showInputDialog("- " + ticket);
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

}
