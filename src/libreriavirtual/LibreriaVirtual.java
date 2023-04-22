/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreriavirtual;

import ar.edu.utn.CarritoCompras;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class LibreriaVirtual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CarritoCompras carrito = new CarritoCompras();
        DecimalFormat formato1 = new DecimalFormat("#.00");
        
        System.out.println("BIENVENIDO A LA LIBRERÍA VIRTUAL");
        int opcion=-1;
        do{
            System.out.println("");
            System.out.println("---------------------------------");
            System.out.println("Menú: ");
            System.out.println("0-Salir.");
            System.out.println("1-Cargar producto al carrito de compras.");
            System.out.println("2-Listar carrito de compras.");
            System.out.println("3-Eliminar producto del carrito de compras.");
            System.out.println("4-Calcular el total de la compra.");
            System.out.println("5-Finalizar compra");
            System.out.println("6-Limpiar carrito de compras");
            System.out.println("---------------------------------");
            Scanner teclado = new Scanner(System.in);
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            
            switch (opcion){
                case 0:
                    break;
                case 1:
                    carrito.agregarProducto();
                    break;
                case 2:
                    carrito.listarCarrito();
                    break;
                case 3:
                    carrito.eliminarProducto();
                    break;
                case 4:
                    System.out.println("El total de la compra suma: $"+formato1.format(carrito.calcularCompra()));
                    carrito.calcularCompra();
                    break;
                case 5:
                    carrito.finalizarCompra();
                case 6:
                    carrito = new CarritoCompras();
                    break;
                default:
                    System.out.println("Opcion invalida, seleccione un opcion del menú"); 
                    break;
            }
        }while (opcion!=0);
        
    }
    
}
