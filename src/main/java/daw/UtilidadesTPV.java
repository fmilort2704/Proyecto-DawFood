/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author FX506
 */
public class UtilidadesTPV {

    public static ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Poke de pollo", Categoria.COMIDA,
                Subcategoria.POKE, 11.99, IVA.IVA_DIEZ, 10));
        listaProductos.add(new Producto("Poke de verdura", Categoria.COMIDA,
                Subcategoria.POKE, 12.59, IVA.IVA_DIEZ, 14));
        listaProductos.add(new Producto("Wrap de pollo", Categoria.COMIDA,
                Subcategoria.WRAP, 13.35, IVA.IVA_DIEZ, 23));
        listaProductos.add(new Producto("Wrap de ternera", Categoria.COMIDA,
                Subcategoria.WRAP, 12.99, IVA.IVA_DIEZ, 25));
        listaProductos.add(new Producto("Loco Moko pollo teriyaki", Categoria.COMIDA,
                Subcategoria.LOCO_MOCO, 10.99, IVA.IVA_DIEZ, 32));
        listaProductos.add(new Producto("Loco Moko gambas", Categoria.COMIDA,
                Subcategoria.LOCO_MOCO, 10.99, IVA.IVA_DIEZ, 2));
        listaProductos.add(new Producto("Agua", Categoria.BEBIDA,
                Subcategoria.AGUA, 1.20, IVA.IVA_DIEZ, 54));
        listaProductos.add(new Producto("Cerveza", Categoria.BEBIDA,
                Subcategoria.CERVEZA, 2.55, IVA.IVA_VETIUNO, 42));
        listaProductos.add(new Producto("Coca Cola", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_VETIUNO, 45));
        listaProductos.add(new Producto("Nestea", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_VETIUNO, 42));
        listaProductos.add(new Producto("Helado de chocolate", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 40));
        listaProductos.add(new Producto("Helado de vainilla", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 37));
        listaProductos.add(new Producto("Platano", Categoria.POSTRE,
                Subcategoria.FRUTA, 1.99, IVA.IVA_DIEZ, 45));
        listaProductos.add(new Producto("Manzana", Categoria.POSTRE,
                Subcategoria.FRUTA, 1.99, IVA.IVA_DIEZ, 42));
        listaProductos.add(new Producto("Tarta de chocolate", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 33));
        listaProductos.add(new Producto("Tarta de fresa", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 34));
        return listaProductos;
    }

    public static int seleccionarModo() {

        String[] opciones = {"Administrador", "Usuario"};

        int opcionUsuario = JOptionPane.showOptionDialog(null,
                "Elige un modo", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        return opcionUsuario;
    }

    public static void seleccionarCategoría(TPV tpv) {

        Object[] options = {Categoria.COMIDA, Categoria.BEBIDA,
            Categoria.POSTRE, "Volver", "Ver cesta"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una categoría", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[3]);

        switch (opcionElegida) {
            case 0 -> {

                seleccionarSubcategoria(tpv, Subcategoria.POKE,
                        Subcategoria.WRAP, Subcategoria.LOCO_MOCO);
            }
            case 1 -> {

                seleccionarSubcategoria(tpv, Subcategoria.AGUA,
                        Subcategoria.CERVEZA, Subcategoria.REFRESCO);
            }
            case 2 -> {

                seleccionarSubcategoria(tpv, Subcategoria.HELADO,
                        Subcategoria.FRUTA, Subcategoria.TARTA);
            }
            case 3 -> {
                UtilidadesTPV.seleccionarModo();
            }
            case 4 -> {
                verCesta(tpv);
            }
        }
    }

    public static void seleccionarSubcategoria(TPV tpv, Subcategoria s1, Subcategoria s2, Subcategoria s3) {

        Object[] options = {s1, s2, s3, "Volver", "Ver cesta"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una subcategoría", "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[3]);

        switch (opcionElegida) {
            case 0 -> {

                seleccionarProducto(tpv, s1, s1, s2, s3);
            }
            case 1 -> {

                seleccionarProducto(tpv, s2, s1, s2, s3);
            }
            case 2 -> {

                seleccionarProducto(tpv, s3, s1, s2, s3);
            }
            case 3 -> {
                seleccionarCategoría(tpv);
            }
            case 4 -> {
                verCesta(tpv);
            }
        }
    }

    private static void seleccionarProducto(TPV tpv, Subcategoria subcat, Subcategoria s1, Subcategoria s2, Subcategoria s3) {
        ArrayList<Producto> baseDatosProductos = tpv.getCartaProductos();
        ArrayList<Producto> productosAMostrar = new ArrayList<>();
        ArrayList<String> nombreProductosAMostrar = new ArrayList<>();

        for (int i = 0; i < baseDatosProductos.size(); i++) {
            if (baseDatosProductos.get(i).getStock() > 0
                    && baseDatosProductos.get(i).getSubcategoria().equals(subcat)) {
                productosAMostrar.add(baseDatosProductos.get(i));
                nombreProductosAMostrar.add(baseDatosProductos.get(i).getDescripcion());
            }
        }

        String opcionElegidaProducto = (String) JOptionPane.showInputDialog(null,
                "Escoge un producto", "TPV", JOptionPane.QUESTION_MESSAGE,
                null, nombreProductosAMostrar.toArray(),
                nombreProductosAMostrar.get(0));

        if (opcionElegidaProducto == null) {
            seleccionarSubcategoria(tpv, s1, s2, s3);
        }

        Producto p = new Producto();

        for (int i = 0; i < productosAMostrar.size(); i++) {
            if (opcionElegidaProducto.equals(productosAMostrar.get(i).getDescripcion())) {
                p = productosAMostrar.get(i);
            }
        }

        int numProductos = 0;
        boolean excepcion = true;
        do {
            try {

                numProductos = Integer.parseInt(JOptionPane.showInputDialog("Información del producto \n"
                        + p.getDescripcion() + " Precio sin IVA: " + p.getPrecio()
                        + " Precio con IVA: %.2f".formatted(p.getPrecio() * p.getIVA().getPORCENTAJE_IVA())));
                excepcion = false;

            } catch (NumberFormatException nfe) {
                String[] opciones = {"Aceptar"};

                JOptionPane.showOptionDialog(null,
                        "Eso no es un número", "TPV", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            }
        } while (excepcion);
        
        p.setStock(Math.abs(numProductos));
        tpv.getCarrito().add(p);
    }

    private static void verCesta(TPV tpv) {

        double totalPagar = 0;
        double totalConIva = 0;
        String infoProductosCesta = "PRODUCTOS EN LA CESTA \n \n";

        for (int i = 0; i < tpv.getCarrito().size(); i++) {
            infoProductosCesta += tpv.getCarrito().get(i).getDescripcion()
                    + "     Cant.:" + tpv.getCarrito().get(i).getStock()
                    + "     " + tpv.getCarrito().get(i).getPrecio() + "\n";

            totalPagar += tpv.getCarrito().get(i).getPrecio()
                    * tpv.getCarrito().get(i).getStock();

            totalConIva += tpv.getCarrito().get(i).getPrecio()
                    * tpv.getCarrito().get(i).getIVA().getPORCENTAJE_IVA()
                    * tpv.getCarrito().get(i).getStock();
        }

        infoProductosCesta += "\n" + "Total sin IVA: %.2f".formatted(totalPagar)
                + "     Total con IVA: %.2f".formatted(totalConIva) + "\n";

        String[] options = {"Finalizar compra", "Cancelar compra", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                infoProductosCesta, "TPV", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[2]);

        switch (opcionElegida) {
            case 0 -> {
                pasarelaPago(tpv, totalPagar);
            }
            case 1 -> {
                tpv.getCarrito().clear();
                seleccionarModo();
            }
            case 2 -> {
                seleccionarCategoría(tpv);
            }
        }

    }

    private static void pasarelaPago(TPV tpv, double totalPagar) {

        String digitosTarjeta = JOptionPane.showInputDialog(
                "Introduce los últimos 4 dígitos de tu tarjeta");

        if (UtilidadesTarjeta.numTarjetaValido(digitosTarjeta)) {

            JTextField mes = new JTextField();
            JTextField anyo = new JTextField();
            JTextField cvv = new JTextField();
            Object[] message = {
                "Mes:", mes,
                "Año:", anyo,
                "CVV:", cvv
            };

            int option = 0;
            boolean excepcion = true;

            do {
                try {

                    option = JOptionPane.showConfirmDialog(null, message,
                            "Introduce la fecha de caducidad y el CVV de tu tarjeta",
                            JOptionPane.OK_CANCEL_OPTION);
                    excepcion = false;
                } catch (NumberFormatException nfe) {
//                    String[] opciones = {"Aceptar"};
//
//                    JOptionPane.showOptionDialog(null,
//                            "La fecha no es correcta", "TPV", JOptionPane.DEFAULT_OPTION,
//                            JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                }

                if (option == JOptionPane.OK_OPTION) {

                    LocalDate fechaCaducidad = LocalDate.MIN;
                    excepcion = true;

                    try {

                        fechaCaducidad = (LocalDate) UtilidadesTarjeta
                                .pedirMesAnyo(Integer.parseInt(mes.getText()),
                                        Integer.parseInt(anyo.getText()));
                        excepcion = false;

                    } catch (NumberFormatException nfe) {
//                        String[] opciones = {"Aceptar"};
//
//                        JOptionPane.showOptionDialog(null,
//                                "La fecha no es correcta", "TPV", JOptionPane.DEFAULT_OPTION,
//                                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                    }

                    if (UtilidadesTarjeta.fechaCaducidadYCVVValidos(digitosTarjeta, fechaCaducidad, cvv.getText())) {

                        if (UtilidadesTarjeta.saldoSuficiente(digitosTarjeta, totalPagar)) {
                            for (int i = 0; i < UtilidadesTarjeta.baseDatosTarjeta().size(); i++) {
                                if (digitosTarjeta.equals(UtilidadesTarjeta.baseDatosTarjeta().get(i)
                                        .getNumTarjeta()
                                        .substring(UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length() - 4,
                                                UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length()))) {

                                    UtilidadesTarjeta.baseDatosTarjeta().get(i).setSaldo(
                                            UtilidadesTarjeta.baseDatosTarjeta().get(i).getSaldo() - totalPagar);
                                }
                            }
                            for (int i = 0; i < tpv.getCarrito().size(); i++) {
                                for (int j = 0; j < tpv.getCartaProductos().size(); j++) {
                                    if (tpv.getCarrito().get(i).equals(tpv.getCartaProductos().get(j))) {
                                        tpv.getCartaProductos().get(j).setStock(
                                                tpv.getCartaProductos().get(j).getStock()
                                                - tpv.getCarrito().get(i).getStock());
                                    }
                                }
                            }
                            tpv.getCarrito().clear();
                        } else {
                            String[] opciones = {"Aceptar"};

                            JOptionPane.showOptionDialog(null,
                                    "No hay saldo suficiente, prueba de nuevo", "TPV", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                            verCesta(tpv);
                        }
                    } else {
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Los datos no son correctos", "TPV", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                        verCesta(tpv);
                    }

                } else {
                    System.out.println("Login canceled");
                }
            } while (excepcion);

        } else {
            String[] opciones = {"Volver a intentar", "Cancelar pago"};

            int opcionUsuario = JOptionPane.showOptionDialog(null,
                    "Los digitos no son correctos", "TPV", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (opcionUsuario == 0) {
                pasarelaPago(tpv, totalPagar);
            } else {
                verCesta(tpv);
            }

        }

    }

}
