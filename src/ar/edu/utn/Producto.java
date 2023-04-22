/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn;

import java.util.Date;

/**
 *
 * @author pablo
 */
public abstract class Producto {
    
    private String codigo;
    private int tipoDeVenta;
    private Date fechaPublicacion;
    private float precioCompra;


    public Producto() {
    }

    public Producto(String codigo, int tipoDeVenta, Date fechaPublicacion, float precioCompra) {
        this.codigo = codigo;
        this.tipoDeVenta = tipoDeVenta;
        this.fechaPublicacion = fechaPublicacion;
        this.precioCompra = precioCompra;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipoDeVenta() {
        return tipoDeVenta;
    }

    public void setTipoDeVenta(int tipoDeVenta) {
        this.tipoDeVenta = tipoDeVenta;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }
    
    public abstract Producto crearProducto();
    public abstract float ventaFisica();
    public abstract float ventaDigital();
    
    public float precioVenta(){
        if (this.tipoDeVenta==1){
            return ventaFisica();
        }else{
            return ventaDigital();
        }
    }
    
    
    
    @Override
    public abstract String toString();
    
    
}
