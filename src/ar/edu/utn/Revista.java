/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Revista extends Producto{
    
    private String nombre, editor;

    public Revista() {
    }

    
    public Revista(String nombre, String editor, String codigo, int tipoDeVenta, Date fechaPublicacion, float precioCompra) {
        super(codigo, tipoDeVenta, fechaPublicacion, precioCompra);
        this.nombre = nombre;
        this.editor = editor;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
    
    @Override
    public Producto crearProducto() {
        Revista revista = new Revista();
        Scanner teclado = new Scanner(System.in);
        String nombre, editor, codigo;
        int tipoDeVenta;
        Date fechaPublicacion;
        float precioCompra;
        
        teclado.nextLine();
        System.out.print("Ingrese el código del revista: ");
        codigo = teclado.nextLine();
        System.out.print("Ingrese el nombre del revista: ");
        nombre = teclado.nextLine();
        System.out.print("Ingrese el editor del revista: ");
        editor = teclado.nextLine();
        System.out.print("Ingrese la fecha de publicación del revista: ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            fechaPublicacion = formato.parse(teclado.next());
        } catch (ParseException ex) {
            fechaPublicacion = Date.from(Instant.MIN);
        }
        System.out.print("Ingrese el tipo de venta: ");
        tipoDeVenta = teclado.nextInt();
        System.out.print("Ingrese el precio de compra: ");
        precioCompra = teclado.nextFloat();
        
        revista.setNombre(nombre);
        revista.setEditor(editor);
        revista.setCodigo(codigo);
        revista.setTipoDeVenta(tipoDeVenta);
        revista.setFechaPublicacion(fechaPublicacion);
        revista.setPrecioCompra(precioCompra);
        
        return new Revista(nombre,editor,codigo,tipoDeVenta,fechaPublicacion,precioCompra);
    }      
    
    @Override
    public float ventaFisica() {
        return super.getPrecioCompra()*1.22f;
    }

    @Override
    public float ventaDigital() {
        return super.getPrecioCompra()*1.12f;
    }


    @Override
    public String toString() {
        DecimalFormat formato1 = new DecimalFormat("#.00");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        String descripcion = ("Revista: "+this.editor+". Autor: "+this.editor+". Fecha de publicación: "
                +formato.format(this.getFechaPublicacion())+". Precio: $"+formato1.format(precioVenta())+".");
        return descripcion;
    }


    
    
}
