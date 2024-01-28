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
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author francisco
 */
public class UtilidadesAdmin {

    //Genera una contraseña con 3 letras minúsculas, 1 mayúscula, 1 número y 1 símbolo
    public static String crearPassword() {
        return RandomStringUtils.randomAlphabetic(3).toLowerCase()
                + RandomStringUtils.randomAlphabetic(1).toUpperCase()
                + RandomStringUtils.randomNumeric(1)
                + RandomStringUtils.random(1, "#$%&()*+,-.:;<=>@");
    }

    public static boolean pedirPassword(TPV tpv) {

        String password = (String) JOptionPane.showInputDialog(null,
                "Introduce la contraseña para entrar en modo administrador",
                "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION,
                new ImageIcon("src/main/java/iconos/admin1.png"),
                null, null);

        if (password == null) {
            UtilidadesTPV.seleccionarModo();
        }

        try {
            if (password.equals(tpv.getPassword())) {
                return true;
            }
        } catch (NullPointerException npe) {
            UtilidadesTPV.seleccionarModo();
        }

        return false;
    }

    public static void modoMantenimiento(TPV tpv) {

        Object[] options = {"Editar producto", "Nuevo producto",
            "Borrar producto", "Consultar ventas", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una opción", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"), options, options[4]);

        switch (opcionElegida) {
            case 0 -> {
                modificarProducto(tpv);
            }
            case 1 -> {
                tpv.getCartaProductos().add(nuevoProducto(tpv));
            }
            case 2 -> {
                Producto opcionElegidaProducto = (Producto) JOptionPane.showInputDialog(null,
                        "Escoge el producto a borrar", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon("src/main/java/iconos/admin1.png"), tpv.getCartaProductos().toArray(),
                        tpv.getCartaProductos().get(0));

                if (opcionElegidaProducto == null) {
                    modoMantenimiento(tpv);
                }

                for (Producto p : tpv.getCartaProductos()) {
                    try {
                        if (opcionElegidaProducto.equals(p)) {
                            tpv.getCartaProductos().remove(p);
                        }
                    } catch (NullPointerException npe) {}
                }
            }
            case 3 -> {
                UtilidadesAdminFran.consultarVentas(tpv);
            }
            //No necesito el case 4 (volver)
        }
    }

    private static void modificarProducto(TPV tpv) {

        Producto opcionElegidaProducto = (Producto) JOptionPane.showInputDialog(null,
                "Escoge el producto a editar", "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION,
                new ImageIcon("src/main/java/iconos/admin1.png"), tpv.getCartaProductos().toArray(),
                tpv.getCartaProductos().get(0));

        if (opcionElegidaProducto == null) {
            modoMantenimiento(tpv);
        } else {

            //Se pide todo en la misma ventana
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
                    "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    new ImageIcon("src/main/java/iconos/admin1.png"));

            if (option == JOptionPane.OK_OPTION) {

                //En este string se irá guardándo el atributo que se cambie satisfactoriamente
                //para mostrarlo en un mensaje al final
                String atributosCambiados = "";

                boolean error = false;

                //Para que se realice un cambio el campo no estará vacío ni tendrá un espacio
                if (!precio.getText().trim().equals("")) {

                    try {
                        opcionElegidaProducto.setPrecio(Double.parseDouble(precio.getText()));
                        //Esto se ñadirá a un string para saber si 
                        //se ha realizado el cambio en un mensaje al finalizar
                        atributosCambiados += "Precio, ";
                    } catch (NumberFormatException nfe) {
                        error = true;
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                opciones, opciones[0]);
                    }
                    //He anidado los ifs para que si hay algún error no muestre más mensajes de error
                    //tampoco se realizará ningún cambio al saltar un error
                    if (!iva.getText().trim().equals("") && !error) {
                        for (IVA iv : IVA.values()) {
                            if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {

                                try {
                                    opcionElegidaProducto.setIVA(iv);
                                    atributosCambiados += "IVA, ";
                                } catch (NumberFormatException nfe) {
                                    error = true;
                                    String[] opciones = {"Aceptar"};

                                    JOptionPane.showOptionDialog(null,
                                            "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                            opciones, opciones[0]);
                                }
                            }
                        }
                        if (!stock.getText().trim().equals("") && !error) {

                            try {
                                opcionElegidaProducto.setStock(Integer.parseInt(stock.getText()));
                                atributosCambiados += "Stock";
                            } catch (NumberFormatException nfe) {
                                error = true;
                                String[] opciones = {"Aceptar"};

                                JOptionPane.showOptionDialog(null,
                                        "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                        opciones, opciones[0]);
                            }
                        }
                    }
                }

                if (!descrip.getText().trim().equals("") && !error) {
                    opcionElegidaProducto.setDescripcion(descrip.getText());
                    atributosCambiados += "Descripción, ";
                }

                //Para los tipo enum debo encontrar el aquivalente en la clase
                //a partir del texto que se escriba en el campo
                if (!categ.getText().trim().equals("") && !error) {
                    for (Categoria c : Categoria.values()) {
                        if (categ.getText().equalsIgnoreCase(c.getCATEGORIA())) {
                            opcionElegidaProducto.setCategoria(c);
                            atributosCambiados += "Categoría, ";
                        }
                    }
                }

                if (!subcat.getText().trim().equals("") && !error) {
                    for (Subcategoria s : Subcategoria.values()) {
                        if (subcat.getText().equalsIgnoreCase(s.getSUBCATEGORIA())) {
                            opcionElegidaProducto.setSubcategoria(s);
                            atributosCambiados += "Subcategoría, ";
                        }
                    }
                }

                if (!error) {
                    String[] opciones = {"Aceptar"};

                    JOptionPane.showOptionDialog(null,
                            "Cambios realizados con éxito en " + atributosCambiados + " ",
                            "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                            opciones, opciones[0]);
                }
            } else {
                modoMantenimiento(tpv);
            }
        }
    }

    private static Producto nuevoProducto(TPV tpv) {

        Producto producto = new Producto();

        //Se pide todo en la misma ventana
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
                "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("src/main/java/iconos/admin1.png"));

        if (option == JOptionPane.OK_OPTION) {

            producto.setDescripcion(descrip.getText());

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

            boolean error = false;

            try {
                producto.setPrecio(Double.parseDouble(precio.getText()));
            } catch (NumberFormatException nfe) {
                error = true;
                String[] opciones = {"Aceptar"};

                JOptionPane.showOptionDialog(null,
                        "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                        opciones, opciones[0]);
            }

            if (!error) {
                for (IVA iv : IVA.values()) {
                    try {
                        if (Double.parseDouble(iva.getText()) == iv.getPORCENTAJE_IVA()) {
                            producto.setIVA(iv);
                        }
                    } catch (NumberFormatException nfe) {
                        error = true;
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                opciones, opciones[0]);
                    }
                }

                if (!error) {
                    try {
                        producto.setStock(Integer.parseInt(stock.getText()));
                    } catch (NumberFormatException nfe) {
                        error = true;
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Debes utilizar números en los campos de Precio, IVA y Stock, vuelve a intentarlo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/admin1.png"),
                                opciones, opciones[0]);
                    }
                }
            }
        } else {
            modoMantenimiento(tpv);
        }

        //El producto se creará aunque no se hayan rellenado todos los campos
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
