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
public class CartaNoe {

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

    public static void elegirProducto(TPV tpv) {

        ArrayList<Producto> baseDatosProductos = tpv.getCartaProductos();

        Categoria[] valoresCategorias = Categoria.values();

        Categoria opcionElegida = (Categoria) JOptionPane.showInputDialog(null,
                "Selector de categorias", "TPV", JOptionPane.QUESTION_MESSAGE,
                null, valoresCategorias, valoresCategorias[0]);

        switch (opcionElegida) {
            case COMIDA -> {

                anyadirProductoACarrito(tpv, baseDatosProductos, Subcategoria.POKE, Subcategoria.WRAP, Subcategoria.LOCO_MOCO);
            }
            case BEBIDA -> {

                anyadirProductoACarrito(tpv, baseDatosProductos, Subcategoria.AGUA, Subcategoria.CERVEZA, Subcategoria.REFRESCO);
            }
            case POSTRE -> {

                anyadirProductoACarrito(tpv, baseDatosProductos, Subcategoria.HELADO, Subcategoria.FRUTA, Subcategoria.TARTA);
            }
        }
    }

    private static void anyadirProductoACarrito(TPV tpv, ArrayList<Producto> baseDatosProductos, Subcategoria s1, Subcategoria s2, Subcategoria s3) {
        Subcategoria[] opcionesSubcategorias = {s1, s2, s3};

        Subcategoria opcionElegidaSubcategoria = (Subcategoria) JOptionPane.showInputDialog(null,
                "Selector de subcategorias", "TPV", JOptionPane.QUESTION_MESSAGE,
                null, opcionesSubcategorias, Subcategoria.POKE);

        ArrayList<Producto> productosAMostrar = new ArrayList<>();
        ArrayList<String> nombreProductosAMostrar = new ArrayList<>();

        for (int i = 0; i < baseDatosProductos.size(); i++) {
            if (baseDatosProductos.get(i).getStock() > 0
                    && baseDatosProductos.get(i).getSubcategoria().equals(opcionElegidaSubcategoria)) {
                productosAMostrar.add(baseDatosProductos.get(i));
                nombreProductosAMostrar.add(baseDatosProductos.get(i).getDescripcion());
            }
        }

        String opcionElegidaProducto = (String) JOptionPane.showInputDialog(null,
                "Selector de subcategorias", "TPV", JOptionPane.QUESTION_MESSAGE,
                null, nombreProductosAMostrar.toArray(),
                nombreProductosAMostrar.get(0));

        for (int i = 0; i < productosAMostrar.size(); i++) {
            if (opcionElegidaProducto.equals(productosAMostrar.get(i).getDescripcion())) {
                tpv.getCarrito().add(productosAMostrar.get(i));
            }
        }
    }

}
