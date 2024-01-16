/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public class Productos {
    private int ID;
    private String descripcion;
    private Categorias CATEGORIAS;
    private Subcategorias SUBCATEGORIAS;
    private int precio;
    private int IVA;
    private int stock;

    public Productos(int ID, String descripcion, Categorias CATEGORIAS, Subcategorias SUBCATEGORIAS, int precio, int IVA, int stock) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.CATEGORIAS = CATEGORIAS;
        this.SUBCATEGORIAS = SUBCATEGORIAS;
        this.precio = precio;
        this.IVA = IVA;
        this.stock = stock;
    }

    public Productos() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCATEGORIAS() {
        return CATEGORIAS;
    }

    public void setCATEGORIAS(Categorias CATEGORIAS) {
        this.CATEGORIAS = CATEGORIAS;
    }

    public Subcategorias getSUBCATEGORIAS() {
        return SUBCATEGORIAS;
    }

    public void setSUBCATEGORIAS(Subcategorias SUBCATEGORIAS) {
        this.SUBCATEGORIAS = SUBCATEGORIAS;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIVA() {
        return IVA;
    }

    public void setIVA(int IVA) {
        this.IVA = IVA;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
