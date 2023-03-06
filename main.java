import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       int opc1 = 0;
       int opc2 = 0;
    
    System.out.println("Que tipo de opci+on desea ejecutar \n1. HashMap \n2.TreeMap\n3.LinkedHashMap");
    opc1 = teclado.nextInt();
    teclado.nextLine();
    switch(opc1){ 
        case 1:{
            System.out.println("¿Que desea realizar?\n1.Agregar Producto\n2.Mostrar la categoría del producto\n3.Mostrar cantidades de los productos\n4.Ordenar por tipo\n5.Mostrar productos y categorías existentes");
            opc1 = teclado.nextInt();
            teclado.nextLine();
            switch(opc2){
                case 1:{
                    break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    break;
                }

            }

            break;


        }
        case 2:{
            System.out.println("es tree");
            break;
        }
        case 3:{
            System.out.println("es link");
            break;
        }
    }
 }
}
