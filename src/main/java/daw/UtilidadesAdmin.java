/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author francisco
 */
public class UtilidadesAdmin {
    
    public static boolean pedirPassword(){
        
        boolean paswordValida = false;
        
        
        
        
        return paswordValida;
    }

    public static void modoMantenimiento(TPV tpv) {

        Object[] options = {"Editar producto", "Nuevo producto",
            "Borrar producto", "Consultar ventas", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una opción", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[4]);

        switch (opcionElegida) {
            case 0 -> {
                modificarProducto(tpv);
                for (Producto p : tpv.getCartaProductos()) {
                    System.out.println(p);
                }
            }
            case 1 -> {
                tpv.getCartaProductos().add(nuevoProducto(tpv));
                //Para probar
                for (Producto p : tpv.getCartaProductos()) {
                    System.out.println(p);
                }
            }
            case 2 -> {
                Producto opcionElegidaProducto = (Producto) JOptionPane.showInputDialog(null,
                        "Escoge el producto a borrar", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                        null, tpv.getCartaProductos().toArray(),
                        tpv.getCartaProductos().get(0));
                for (Producto p : tpv.getCartaProductos()) {
                    if (opcionElegidaProducto.equals(p)) {
                        tpv.getCartaProductos().remove(p);
                    }
                }
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
                "Escoge el producto a editar", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                null, tpv.getCartaProductos().toArray(),
                tpv.getCartaProductos().get(0));

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

                try {
                    opcionElegidaProducto.setPrecio(Double.parseDouble(precio.getText()));
                    atributosCambiados += "Precio, ";
                } catch (NumberFormatException nfe) {
                    String[] opciones = {"Aceptar"};

                    JOptionPane.showOptionDialog(null,
                            "Eso no es un número", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke3.png"),
                            opciones, opciones[0]);
                }
            }

            if (!iva.getText().equals("")) {
                for (IVA iv : IVA.values()) {
                    if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {

                        try {
                            opcionElegidaProducto.setIVA(iv);
                            atributosCambiados += "IVA, ";
                        } catch (NumberFormatException nfe) {
                            String[] opciones = {"Aceptar"};

                            JOptionPane.showOptionDialog(null,
                                    "Eso no es un número", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke3.png"),
                                    opciones, opciones[0]);
                        }
                    }
                }
            }

            if (!stock.getText().equals("")) {

                try {
                    opcionElegidaProducto.setStock(Integer.parseInt(stock.getText()));
                    atributosCambiados += "Stock";
                } catch (NumberFormatException nfe) {
                    String[] opciones = {"Aceptar"};

                    JOptionPane.showOptionDialog(null,
                            "Eso no es un número", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke3.png"),
                            opciones, opciones[0]);
                }
            }

            String[] opciones = {"Aceptar"};

            JOptionPane.showOptionDialog(null,
                    "Cambios realizados con éxito en " + atributosCambiados,
                    "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
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

        Producto producto = new Producto();

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
                "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            producto.setDescripcion(descrip.getText());
//            try {
                producto.setPrecio(Double.parseDouble(precio.getText()));
                producto.setStock(Integer.parseInt(stock.getText()));

                for (Categoria c : Categoria.values()) {
                    if (categ.getText().equalsIgnoreCase(c.getCATEGORIA())) {
                        producto.setCategoria(c);
                    }
                }

                for (Subcategoria s : Subcategoria.values()) {
                    if (subcat.getText().equalsIgnoreCase(s.getSUBCATEGORIA())) {
                        producto.setSubcategoria(s);
                    }
                }

                for (IVA iv : IVA.values()) {
                    if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {
                        producto.setIVA(iv);
                    }
                }
//            } catch (NumberFormatException nfe) {
//                String[] opciones = {"Aceptar"};
//
//                JOptionPane.showOptionDialog(null,
//                        "Eso no es un número", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
//                        JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke3.png"),
//                        opciones, opciones[0]);
//            }

        } else {
            modoMantenimiento(tpv);
        }

        return producto;
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
