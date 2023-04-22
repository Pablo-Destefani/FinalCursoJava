/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Libro extends Producto {

    private String titulo, autorPrincipal, editorial;

    public Libro() {
    }

    public Libro(String titulo, String autorPrincipal, String editorial, String codigo, int tipoDeVenta, Date fechaPublicacion, float precioCompra) {
        super(codigo, tipoDeVenta, fechaPublicacion, precioCompra);
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.editorial = editorial;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutorPrincipal() {
        return autorPrincipal;
    }

    public void setAutorPrincipal(String autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
     
    @Override
    public Producto crearProducto() {
        Libro libro = new Libro();
        Scanner teclado = new Scanner(System.in);
        String titulo, autorPrincipal, editorial, codigo;
        int tipoDeVenta;
        Date fechaPublicacion;
        float precioCompra;        
        teclado.nextLine();
        System.out.print("Ingrese el código del libro: ");
        codigo = teclado.nextLine();
        System.out.print("Ingrese el título del libro: ");
        titulo = teclado.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        autorPrincipal = teclado.nextLine();
        System.out.print("Ingrese la editorial del libro: ");
        editorial = teclado.nextLine();
        System.out.print("Ingrese la fecha de publicación del libro: ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            fechaPublicacion = formato.parse(teclado.next());
        } catch (ParseException ex) {
            fechaPublicacion = null;
        }
        System.out.print("Ingrese el tipo de venta: ");
        System.out.println("1- Copia fisica");
        System.out.println("2- Copia virtual");
        tipoDeVenta = teclado.nextInt();
        System.out.print("Ingrese el precio de compra: ");
        precioCompra = teclado.nextFloat();
        
        libro.setTitulo(titulo);
        libro.setAutorPrincipal(autorPrincipal);
        libro.setEditorial(editorial);
        libro.setCodigo(codigo);
        libro.setTipoDeVenta(tipoDeVenta);
        libro.setFechaPublicacion(fechaPublicacion);
        libro.setPrecioCompra(precioCompra);        
        
        return libro;
    }
     
    @Override
    public float ventaFisica() {
        return super.getPrecioCompra()*1.18f;
    }

    @Override
    public float ventaDigital() {
        return super.getPrecioCompra()*1.08f;
    }
    

    @Override
    public String toString() {
        
        DecimalFormat formato1 = new DecimalFormat("#.00");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        
        String descripcion = ("Libro: "+this.titulo+". Autor: "+this.autorPrincipal+". Editorial: "+this.editorial+". Fecha de publicación: "
                +formato.format(this.getFechaPublicacion())+". Precio: $"+formato1.format(precioVenta())+".");
        return descripcion;
    }





    
}
