/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class CarritoCompras {
    
    private ArrayList<Producto> listaCompras = new ArrayList<>();   
    private float totalCompra;

    public CarritoCompras() {
    }

    public ArrayList<Producto> getListaCompras() {
        return listaCompras;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    
    public void agregarProducto(){
        Producto producto = null;
        Scanner teclado = new Scanner(System.in);
        int tipo=0;
        do {
            System.out.println("Cargar producto:");
            System.out.println("1- Libro");
            System.out.println("2- Revista");
            System.out.println("");
            System.out.print("Seleccion una opción: ");
            tipo = teclado.nextInt();
            if (tipo==1){
                producto = new Libro();
                
            }else{
                if(tipo==2){
                    producto = new Revista();
                }
            }
            try{
            }catch (Exception ex){
                System.out.println("Opcion invalida");
            }
        }while((tipo!=1)&&(tipo!=2));       
        
        
        listaCompras.add(producto.crearProducto());
    }
    
    public void eliminarProducto(){
        Scanner teclado = new Scanner(System.in);
        
        int i;
        
        listarCarrito();
        System.out.print("Ingrese el numero del producto a eliminar: ");
        i = teclado.nextInt();
        try{
            this.listaCompras.remove(i-1);
        }catch (Exception ex){
            System.out.println("El valor ingresado no corresponde a un producto del carrito.");
        }
        
        
    }
    
    public void listarCarrito(){
        int i =1;
        System.out.println("");
        System.out.println("LISTA DE COMPRAS:");
        for(Producto producto:listaCompras){
            System.out.println(i+"-"+producto.toString());
            i++;
        }
        System.out.println("");
    }
    
    public float calcularCompra(){
        float total=0;
        for(Producto producto:listaCompras){
            total += producto.precioVenta();
        }
        return total;
    }

    public void finalizarCompra() {
        DecimalFormat formato1 = new DecimalFormat("#.00");
        System.out.println("");
        System.out.println("El total de su compra es: $"+formato1.format(calcularCompra()));
        System.out.println("");
        System.out.println("¡Muchas gracias por su compra!");
        System.out.println("");
    }
}
