/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author FX506
 */
public class Carta {
    //Crea 3 listas con los diferentes tipos de productos
//    public ArrayList<Subcategoria> subcategoriaComidas() {
//        ArrayList<Subcategoria> subcategoriaComidas = new ArrayList<>();
//        subcategoriaComidas.add(Subcategoria.POKE);
//        subcategoriaComidas.add(Subcategoria.WRAP);
//        subcategoriaComidas.add(Subcategoria.LOCA_MOCO);
//        return subcategoriaComidas;
//    }
//    
//    public ArrayList<Subcategoria> subcategoriaBebidas() {
//        ArrayList<Subcategoria> subcategoriaBebidas = new ArrayList<>();
//        subcategoriaBebidas.add(Subcategoria.AGUA);
//        subcategoriaBebidas.add(Subcategoria.CERVEZA);
//        subcategoriaBebidas.add(Subcategoria.REFRESCO);
//        return subcategoriaBebidas;
//    }
//    
//    public ArrayList<Subcategoria> subcategoriaPostres() {
//        ArrayList<Subcategoria> subcategoriaPostres = new ArrayList<>();
//        subcategoriaPostres.add(Subcategoria.FRUTA);
//        subcategoriaPostres.add(Subcategoria.HELADO);
//        subcategoriaPostres.add(Subcategoria.TARTA);
//        return subcategoriaPostres;
//    }

    public ArrayList<Producto> listaProductos() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("Poke de pollo", Categoria.COMIDA,
                Subcategoria.POKE, 11.99, IVA.IVA_DIEZ, 10));
        listaProductos.add(new Producto("Poke de verdura", Categoria.COMIDA,
                Subcategoria.POKE, 12.59, IVA.IVA_DIEZ, 14));
        listaProductos.add(new Producto("Wrap de pollo", Categoria.COMIDA,
                Subcategoria.WRAP, 13.35, IVA.IVA_DIEZ, 23));
        listaProductos.add(new Producto("Wrap de ternera", Categoria.COMIDA,
                Subcategoria.WRAP, 12.99, IVA.IVA_DIEZ, 25));
        listaProductos.add(new Producto("Loco Moko", Categoria.COMIDA,
                Subcategoria.LOCA_MOCO, 10.99, IVA.IVA_DIEZ, 32));
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

    public ArrayList<Producto> baseDatosComidas() {
        ArrayList<Producto> listaComida = new ArrayList<>();
        listaComida.add(new Producto("Poke de pollo", Categoria.COMIDA,
                Subcategoria.POKE, 11.99, IVA.IVA_DIEZ, 10));
        listaComida.add(new Producto("Poke de verdura", Categoria.COMIDA,
                Subcategoria.POKE, 12.59, IVA.IVA_DIEZ, 14));
        listaComida.add(new Producto("Wrap de pollo", Categoria.COMIDA,
                Subcategoria.WRAP, 13.35, IVA.IVA_DIEZ, 23));
        listaComida.add(new Producto("Wrap de ternera", Categoria.COMIDA,
                Subcategoria.WRAP, 12.99, IVA.IVA_DIEZ, 25));
        listaComida.add(new Producto("Loco Moko", Categoria.COMIDA,
                Subcategoria.LOCA_MOCO, 10.99, IVA.IVA_DIEZ, 32));
        return listaComida;
    }

    public ArrayList<Producto> baseDatosBebidas() {
        ArrayList<Producto> listaBebidas = new ArrayList<>();
        listaBebidas.add(new Producto("Agua", Categoria.BEBIDA,
                Subcategoria.AGUA, 1.20, IVA.IVA_DIEZ, 54));
        listaBebidas.add(new Producto("Cerveza", Categoria.BEBIDA,
                Subcategoria.CERVEZA, 2.55, IVA.IVA_VETIUNO, 42));
        listaBebidas.add(new Producto("Coca Cola", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_VETIUNO, 45));
        listaBebidas.add(new Producto("Nestea", Categoria.BEBIDA,
                Subcategoria.REFRESCO, 2.55, IVA.IVA_VETIUNO, 42));
        return listaBebidas;
    }

    public ArrayList<Producto> baseDatosPostres() {
        ArrayList<Producto> listaPostres = new ArrayList<>();
        listaPostres.add(new Producto("Helado de chocolate", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 40));
        listaPostres.add(new Producto("Helado de vainilla", Categoria.POSTRE,
                Subcategoria.HELADO, 2.45, IVA.IVA_DIEZ, 37));
        listaPostres.add(new Producto("Platano", Categoria.POSTRE,
                Subcategoria.FRUTA, 1.99, IVA.IVA_DIEZ, 45));
        listaPostres.add(new Producto("Manzana", Categoria.POSTRE,
                Subcategoria.FRUTA, 1.99, IVA.IVA_DIEZ, 42));
        listaPostres.add(new Producto("Tarta de chocolate", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 33));
        listaPostres.add(new Producto("Tarta de fresa", Categoria.POSTRE,
                Subcategoria.TARTA, 4.59, IVA.IVA_DIEZ, 34));
        return listaPostres;
    }

    //Muestra las diferenrentea categorias y subcategorias y el precio de
    public static void elegirCategoria() {
        String[] opcionesMenu = {"1.- " + Categoria.COMIDA, "2.- " + Categoria.BEBIDA + "3.- " + Categoria.POSTRE};
        Categoria opcionElegida = (Categoria) JOptionPane.showInputDialog(null,
                "Selector de categorias", "Selector de categorias", JOptionPane.QUESTION_MESSAGE,
                null, opcionesMenu, "1.- " + Categoria.COMIDA);

        switch (opcionElegida) {
            case COMIDA -> {
                String[] opcionesMenuComida = {"1.- " + Subcategoria.POKE, "2.- " + Subcategoria.WRAP + "3.- " + Subcategoria.LOCA_MOCO};
                Subcategoria opcionElegidaComida = (Subcategoria) JOptionPane.showInputDialog(null,
                        "Selector de subcategorias", "Selector de subcategorias", JOptionPane.QUESTION_MESSAGE,
                        null, opcionesMenuComida, "1.- " + Subcategoria.POKE);
                switch (opcionElegidaComida) {
                    case POKE -> {
                        JOptionPane.showInputDialog("Poke de pollo: ");
                        JOptionPane.showInputDialog("Poke de verdura: ");
                    }
                    case WRAP -> {
                        JOptionPane.showInputDialog("Wrap de pollo: ");
                        JOptionPane.showInputDialog("Poke de ternera: ");
                    }
                    case LOCA_MOCO -> {
                        JOptionPane.showInputDialog("Loca moco : ");
                    }
                }
            }
            case BEBIDA -> {
                String[] opcionesMenuBebida = {"1.- " + Subcategoria.AGUA, "2.- " + Subcategoria.CERVEZA + "3.- " + Subcategoria.REFRESCO};
                Subcategoria opcionElegidaBebida = (Subcategoria) JOptionPane.showInputDialog(null,
                        "Selector de subcategorias", "Selector de subcategorias", JOptionPane.QUESTION_MESSAGE,
                        null, opcionesMenuBebida, "1.- " + Subcategoria.AGUA);
            }
            case POSTRE -> {
                String[] opcionesMenuPostre = {"1.- " + Subcategoria.FRUTA, "2.- " + Subcategoria.HELADO + "3.- " + Subcategoria.TARTA};
                Subcategoria opcionElegidaPotre = (Subcategoria) JOptionPane.showInputDialog(null,
                        "Selector de subcategorias", "Selector de subcategorias", JOptionPane.QUESTION_MESSAGE,
                        null, opcionesMenuPostre, "1.- " + Subcategoria.FRUTA);
            }
        }
    }

    //Muestra los produtos de la lista indicada
    public static void mostrarProductos(ArrayList<Producto> listaMostrar) {
        JOptionPane.showInputDialog("La lista de productos es la siguiente");
        for (Producto producto : listaMostrar) {
            JOptionPane.showInputDialog("- " + producto);
        }
    }

    //Muestra el precio de los productos con el iva aplicado y sin aplicar
    public void mostrarPrecio(Producto producto) {
        double precioConIva = producto.getPrecio() * producto.getIVA().getPORCENTAJE_IVA();
        System.out.println("El precio sin iva es: " + producto.getPrecio() + "y el"
                + "precio con el IVA es: " + precioConIva);
    }

}
