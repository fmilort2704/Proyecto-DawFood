/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;

/**
 *
 * @author FX506
 */
public class Carta {
    
    public ArrayList<Producto> baseDatosComidas(){
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
    
    public ArrayList<Producto> baseDatosBebidas(){
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
    
    public ArrayList<Producto> baseDatosPostres(){
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
    
    public double precioConIva(Producto producto){
        double precioConIva = producto.getPrecio() * producto.getIVA().getPORCENTAJE_IVA();
        return precioConIva;
    }
    
    
    
    
    
    

}
