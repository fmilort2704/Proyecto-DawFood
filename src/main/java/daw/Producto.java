/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author francisco
 */
public class Producto {

    private int ID;
    private String descripcion;
    private Categoria categoria;
    private Subcategoria subcategoria;
    private double precio;
    private IVA IVA;
    private int stock;
    private static int contadorId = 0;

    public Producto(String descripcion, Categoria categoria, Subcategoria subcategoria, double precio, IVA IVA, int stock) {

        this.ID = contadorId;
        contadorId++;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.precio = precio;
        this.IVA = IVA;
        this.stock = stock;
    }

    public Producto() {
        this.ID = contadorId;
        contadorId++;
    }

    public int getID() {
        return ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public IVA getIVA() {
        return IVA;
    }

    public void setIVA(IVA IVA) {
        this.IVA = IVA;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID=").append(ID);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategoria=").append(subcategoria);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", IVA=").append(IVA);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    public String datosTicket(){
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID=").append(ID);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", IVA=").append(IVA);
        sb.append('}');
        return sb.toString();
    }

    
}
