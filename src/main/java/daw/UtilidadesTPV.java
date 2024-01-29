/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author FX506
 */
public class UtilidadesTPV {

    public static ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Poke de pollo", Categoria.COMIDA,
                Subcategoria.POKE, 11.99, IVA.IVA_DIEZ, 10));
        listaProductos.add(new Producto("Poke de salmón", Categoria.COMIDA,
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
        listaProductos.add(new Producto("Agua con gas", Categoria.BEBIDA,
                Subcategoria.AGUA, 1.50, IVA.IVA_DIEZ, 30));
        listaProductos.add(new Producto("Cerveza Victoria", Categoria.BEBIDA,
                Subcategoria.CERVEZA, 2.55, IVA.IVA_VETIUNO, 42));
        listaProductos.add(new Producto("Cerveza Mahou", Categoria.BEBIDA,
                Subcategoria.CERVEZA, 2.55, IVA.IVA_VETIUNO, 32));
        listaProductos.add(new Producto("Coca Cola", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_DIEZ, 45));
        listaProductos.add(new Producto("Nestea", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_DIEZ, 42));
        listaProductos.add(new Producto("Fanta limón", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_DIEZ, 42));
        listaProductos.add(new Producto("Helado de chocolate", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 40));
        listaProductos.add(new Producto("Helado de vainilla", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 37));
        listaProductos.add(new Producto("Bowl frutas del bosque", Categoria.POSTRE,
                Subcategoria.FRUTA, 3.90, IVA.IVA_DIEZ, 45));
        listaProductos.add(new Producto("Fruta mixta", Categoria.POSTRE,
                Subcategoria.FRUTA, 2.90, IVA.IVA_DIEZ, 42));
        listaProductos.add(new Producto("Tarta de chocolate", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 33));
        listaProductos.add(new Producto("Tarta de queso", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 34));
        return listaProductos;
    }

    public static int seleccionarModo() {

        //Array que contiene los nombres de los botones del joption
        String[] opciones = {"Administrador", "Usuario", "Apagar"};

        int opcionUsuario = JOptionPane.showOptionDialog(null,
                "Elige un modo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/user1.png"), opciones, opciones[0]);

        return opcionUsuario;
    }

    public static boolean seleccionarCategoría(TPV tpv) {

        Object[] options = {Categoria.COMIDA, Categoria.BEBIDA,
            Categoria.POSTRE, "Volver", "Ver cesta"};

        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una categoría", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/main/java/iconos/poke1.png"), options, options[3]);

        ImageIcon icono;
        
        switch (opcionElegida) {
            case 0 -> {
                //Categoría comida
                icono = new ImageIcon("src/main/java/iconos/bowl1.png");
                seleccionarSubcategoria(tpv, Subcategoria.POKE,
                        Subcategoria.WRAP, Subcategoria.LOCO_MOCO, icono);
                return true;
                //He hecho que devuelva un booleano en todos los case para que 
                //no haya problemas con el botón volver y repetir la pantalla como se debe.
                //Lo uso en el método encender de la clase TPV
            }
            case 1 -> {
                //Categoría bebida
                icono = new ImageIcon("src/main/java/iconos/bebida1.png");
                seleccionarSubcategoria(tpv, Subcategoria.AGUA,
                        Subcategoria.CERVEZA, Subcategoria.REFRESCO, icono);
                return true;
            }
            case 2 -> {
                //Categoría postre
                icono = new ImageIcon("src/main/java/iconos/helado1.png");
                seleccionarSubcategoria(tpv, Subcategoria.HELADO,
                        Subcategoria.FRUTA, Subcategoria.TARTA, icono);
                return true;
            }
            case 3 -> {
                //Botón volver
                return false;
            }
            case 4 -> {

                verCesta(tpv);
                return true;
            }
        }
        return true;
    }

    //Le paso por parámetros 3 subcategorías para poder diferenciar de que categoría es 
    //en el método seleccionarCategoría
    public static void seleccionarSubcategoria(TPV tpv, Subcategoria s1, Subcategoria s2, Subcategoria s3, ImageIcon icono) {

        Object[] options = {s1, s2, s3, "Volver", "Ver cesta"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                "Escoge una subcategoría", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icono, options, options[3]);

        switch (opcionElegida) {
            case 0 -> {
                
                seleccionarProducto(tpv, s1, icono);
            }
            case 1 -> {

                seleccionarProducto(tpv, s2, icono);
            }
            case 2 -> {

                seleccionarProducto(tpv, s3, icono);
            }
            case 4 -> {
                verCesta(tpv);
            }
        }
    }

    private static void seleccionarProducto(TPV tpv, Subcategoria subcat, ImageIcon icono) {

        //Obtenemos nuestra carta completa
        ArrayList<Producto> baseDatosProductos = tpv.getCartaProductos();

        //Lista para guardar qué productos se van a mostrar dendiendo 
        //de si hay stock, las categorías y subcategorías
        ArrayList<Producto> productosAMostrar = new ArrayList<>();

        //Lista para mostrar sólo los nombres de los productos en el desplegable
        ArrayList<String> nombreProductosAMostrar = new ArrayList<>();

        //Miramos que el stock de los productos no sea 0 o menor
        //y que coincidan con la subcategoría escogida, 
        //para añadirlos a las listas
        for (int i = 0; i < baseDatosProductos.size(); i++) {
            if (baseDatosProductos.get(i).getStock() > 0
                    && baseDatosProductos.get(i).getSubcategoria().equals(subcat)) {
                productosAMostrar.add(baseDatosProductos.get(i));
                nombreProductosAMostrar.add(baseDatosProductos.get(i).getDescripcion());
            }
        }

        String opcionElegidaProducto = (String) JOptionPane.showInputDialog(null,
                "Escoge un producto", "TPV - Poke Zen", JOptionPane.QUESTION_MESSAGE,
                icono, nombreProductosAMostrar.toArray(),
                nombreProductosAMostrar.get(0));

        //Este if es por el botón volver de la pantalla de productos, que devuelve un null
        if (opcionElegidaProducto == null) {
            //Botón volver
            //No hace falta que ponga nada aquí para que vaya atrás
            //Si lo quito, salta nullpointerexception, y tendría que colocar
            //unos cuantos try catch
        } else {
            //Creo este producto para poder hacer una copia
            //del que se escoja y trabajar con este
            //No es alias, ya que utilizo un constructor para este fin
            //en el for de abajo
            Producto p = new Producto();

            for (int i = 0; i < productosAMostrar.size(); i++) {
                if (opcionElegidaProducto.equals(productosAMostrar.get(i).getDescripcion())) {
                    p = new Producto(productosAMostrar.get(i));
                }
            }

            //Variable que guarda la cantidad que se quiere de un producto
            int numProductos = 0;
            //Este booleano servirá por si salta una excepción que se repita la pantalla
            boolean excepcion = true;
            do {//Este do while hará que se repita la pantalla si la cantidad que se quiere excede al stock
                do {
                    try {
                        //Mostramos el producto seleccionado con el detalle de precio con iva y sin iva
                        //y dejamos que se elija la cantidad
                        numProductos = Integer.parseInt(JOptionPane.showInputDialog("Información del producto \n"
                                + p.getDescripcion() + " Precio sin IVA: " + p.getPrecio()
                                + "€ Precio con IVA: %.2f€".formatted(p.getPrecio() * p.getIVA().getPORCENTAJE_IVA())));
                        excepcion = false;

                    } catch (NumberFormatException nfe) {//Captura que se introduzca una letra
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Debes introducir un número", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke1.png"),
                                opciones, opciones[0]);
                    }
                    //Se mostrará el mensaje si la cantidad introducida excede al stock
                    if (numProductos > p.getStock()) {
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Sólo nos queda " + p.getStock() + " " + p.getDescripcion()
                                + ", prueba de nuevo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/poke1.png"),
                                opciones, opciones[0]);
                    }
                } while (excepcion);
            } while (numProductos > p.getStock());

            //Comprobamos si ya se había guardado el producto escogido en la cesta anteriormente
            //si es así, sólo se modifica el stock del productro en la cesta
            boolean repetido = false;
            for (Producto pCarrito : tpv.getCarrito()) {
                if (p.equals(pCarrito)) {
                    repetido = true;
                    pCarrito.setStock(pCarrito.getStock() + Math.abs(numProductos));
                }
            }

            //Si no estaba el producto en la cesta, se añade a esta
            if (!repetido) {
                //Primero se modifica el stock de la copia del producto
                //para no añadir todo el stock existente
                p.setStock(numProductos);
                //Y finalmente se añade a la cesta
                tpv.getCarrito().add(p);
            }
        }
    }

    private static void verCesta(TPV tpv) {

        double totalPagar = 0;
        double totalConIva = 0;

        //En este string se irán añadiendo los nombres de los productos en la cesta,
        //su precio y la cantadidad,
        //también el precio total de la compra con iva y sin iva
        String infoProductosCesta = "PRODUCTOS EN LA CESTA \n \n";

        for (int i = 0; i < tpv.getCarrito().size(); i++) {
            //añadimos nombres de productos (descripción) y cantidad (stock del carrito)
            infoProductosCesta += tpv.getCarrito().get(i).getDescripcion()
                    + "     Cant.: " + tpv.getCarrito().get(i).getStock()
                    + "     " + tpv.getCarrito().get(i).getPrecio() + "€ \n";

            //se suman los precios
            totalPagar += tpv.getCarrito().get(i).getPrecio()
                    * tpv.getCarrito().get(i).getStock();

            //se suman los precios y se le calcula el iva
            totalConIva += tpv.getCarrito().get(i).getPrecio()
                    * tpv.getCarrito().get(i).getIVA().getPORCENTAJE_IVA()
                    * tpv.getCarrito().get(i).getStock();
        }

        //coloco los resultados de las operaciones anteriores y se suma al string
        infoProductosCesta += "\n" + "Total sin IVA: %.2f€".formatted(totalPagar)
                + "     Total con IVA: %.2f€".formatted(totalConIva) + "\n";

        String[] options = {"Finalizar compra", "Cancelar compra", "Volver"};
        int opcionElegida = JOptionPane.showOptionDialog(null,
                infoProductosCesta, "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/main/java/iconos/cesta1.png"),
                options, null);

        switch (opcionElegida) {
            case 0 -> {
                pasarelaPago(tpv, totalPagar);
            }
            case 1 -> {
                tpv.getCarrito().clear();
                seleccionarModo();
            }
            //No necesito el case 2 (volver), ya que ya está organizado en
            //el método encenderTPV, añadir algo aquí haría 
            //que se abriera la ventana de categorías dos veces
        }

    }

    private static void pasarelaPago(TPV tpv, double totalPagar) {

        String digitosTarjeta = (String) JOptionPane.showInputDialog(null,
                "Introduce los últimos 4 dígitos de tu tarjeta",
                "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION,
                new ImageIcon("src/main/java/iconos/tarjeta1.png"),
                null, null);

        //Primero comprobamos si los digitos coinciden con alguna tarjeta 
        //de la base de datos
        if (UtilidadesTarjeta.numTarjetaValido(digitosTarjeta)) {

            //Pedimos en la misma pantalla la fecha de caducidad y cvv
            JTextField mes = new JTextField();
            JTextField anyo = new JTextField();
            JTextField cvv = new JTextField();
            Object[] message = {
                "Introduce fecha de caducidad y CVV",
                "Mes:", mes,
                "Año:", anyo,
                "CVV:", cvv
            };

            int option = 0;
            boolean excepcion = true;

            do {//Este do while es por si salta una excepción
                try {

                    option = JOptionPane.showConfirmDialog(null, message,
                            "TPV - Poke Zen", JOptionPane.OK_CANCEL_OPTION);
                    excepcion = false;
                } catch (NumberFormatException nfe) {
                }

                if (option == JOptionPane.OK_OPTION) {

                    LocalDate fechaCaducidad = LocalDate.MIN;
                    excepcion = true;

                    try {

                        fechaCaducidad = (LocalDate) UtilidadesTarjeta
                                .pedirMesAnyo(Integer.parseInt(mes.getText()),
                                        Integer.parseInt(anyo.getText()));
                        excepcion = false;

                    } catch (NumberFormatException nfe) {}

                    //Se comprueba que fecha y el cvv son válidos 
                    //(son los que están guardados en la base de datos)
                    if (UtilidadesTarjeta.fechaCaducidadYCVVValidos(digitosTarjeta, fechaCaducidad, cvv.getText())) {

                        //Lo siguiente es comprobar que hay saldo para pagar la suma del carrito
                        if (UtilidadesTarjeta.saldoSuficiente(digitosTarjeta, totalPagar)) {

                            for (int i = 0; i < UtilidadesTarjeta.baseDatosTarjeta().size(); i++) {

                                //Si hay saldo, se procede a restar la suma del carrito al saldo de la tarjeta
                                if (digitosTarjeta.equals(UtilidadesTarjeta.baseDatosTarjeta().get(i)
                                        .getNumTarjeta()
                                        .substring(UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length() - 4,
                                                UtilidadesTarjeta.baseDatosTarjeta().get(i).getNumTarjeta().length()))) {

                                    UtilidadesTarjeta.baseDatosTarjeta().get(i).setSaldo(
                                            UtilidadesTarjeta.baseDatosTarjeta().get(i).getSaldo() - totalPagar);
                                }
                            }

                            //También se resta la cantidad comprada al stock de la base de datos 
                            for (Producto pCarrito : tpv.getCarrito()) {
                                for (Producto pCarta : tpv.getCartaProductos()) {
                                    if (pCarrito.equals(pCarta)) {
                                        pCarta.setStock(pCarta.getStock() - pCarrito.getStock());
                                    }
                                }
                            }

                            //Creamos el ticket con los datos anteriores
                            Ticket t = new Ticket(new ArrayList<Producto>(tpv.getCarrito()),
                                    totalPagar, tpv.getFechaSistema(),
                                    tpv.getHoraSistema());
                            //Se añade el ticket al listado del tpv
                            tpv.getBaseDatosTicket().add(t);
                            //Se vacía la cesta
                            tpv.getCarrito().clear();

                            String[] opciones = {"Aceptar"};

                            //Se muestra el ticket de compra
                            JOptionPane.showOptionDialog(null,
                                    t.toStringChulo(), "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/tarjeta1.png"),
                                    opciones, opciones[0]);

                        } else {
                            String[] opciones = {"Aceptar"};

                            JOptionPane.showOptionDialog(null,
                                    "No hay saldo suficiente, prueba de nuevo", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/tarjeta1.png"),
                                    opciones, opciones[0]);
                        }
                    } else {
                        String[] opciones = {"Aceptar"};

                        JOptionPane.showOptionDialog(null,
                                "Los datos no son correctos", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/tarjeta1.png"),
                                opciones, opciones[0]);
                    }
                }
            } while (excepcion);

        } else {
            String[] opciones = {"Aceptar"};

            JOptionPane.showOptionDialog(null,
                    "Los digitos no son correctos", "TPV - Poke Zen", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/main/java/iconos/tarjeta1.png"),
                    opciones, opciones[0]);
        }
    }
}
