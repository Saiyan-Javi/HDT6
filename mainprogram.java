import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class mainprogram {
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<String> shopCart = new ArrayList<>();
        Map<String, ArrayList<String>> Nmap = makeMap(in);

        //Lee el archivo en la misma ubicacion que del programa
        try {
            Nmap = readFile("ListadoProducto.txt", Nmap);
        } catch (Exception e) {
            System.out.println("Revisar si el archivo se encuentra en el mismo lugar de este programa");
            System.exit(0);
        }
        //Imprime menu con opciones
        System.out.println("Tienda virtual Don Canche");

        while (true) {
            System.out.println("\nEliga lo que desea hacer\n \n1. Añadir un producto al carrito\n2. Ver la categoería\n3.  Mostrar el carrito\n4. Mostrar inventario\n5. Salir del programa");
            int opt = Integer.parseInt(in.nextLine());

            switch (opt) {
                //Agrega al carrito
                case 1:
                    shopCart.add(addProduct(in, Nmap));
                    break;
                //Muestra la categoria 
                case 2:
                    //en producción
                    break;
                //Muestra el carrito actual
                case 3:
                    Carrito(shopCart);
                    break;
                //Muestra el inventario 
                case 4:
                    //en producción
                    break;
                //Sale del programa
                case 5:
                    System.exit(0);
                //Programación defensiva
                default:
                    System.out.println("Ingrese un núero del 1 al 5");
                    break;
            }
        }
    }
    //Lee el archivo y lo pasa a formato UTF8, separandolos en categoria y producto identificando la | 
    private static Map<String, ArrayList<String>> readFile(String path, Map<String, ArrayList<String>> Nmap) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
            String line = null;
            ArrayList<String> productos = new ArrayList<>();
            String category = "";
            String product = "";

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                if (!(category.equals(parts[0].trim()))) {
                    productos = new ArrayList<>();
                }
                
                category = parts[0].trim();
                product = parts[1].trim();
                productos.add(product);

                Nmap.put(category, productos);
            }
            return Nmap;
        } catch (Exception e) {
            throw new Exception();
        }
    }
    //Crea el mapa en base a la seleccion del usuario
    private static Map<String, ArrayList<String>> makeMap(Scanner in) {
        Mfactory<String, ArrayList<String>> MAP = new Mfactory<>();

        System.out.println("Seleccione el mapa a utilizar\n 1. HashMap\n 2. TreeMap\n 3. LinkedHashMap");
        int map = Integer.parseInt(in.nextLine());
        Map<String, ArrayList<String>> Nmap = MAP.newMap(map);
        return Nmap;
    }
    //Métodod para agregar productos al carrito 
    public static String addProduct(Scanner in, Map<String, ArrayList<String>> Nmap) {
        System.out.println("Seleccione la categoría de productos que desea comprar.");
        String categoria = "";
        String product = "";

        while (true) {
            System.out.println(Nmap.keySet());
            categoria = in.nextLine();

            if (!(Nmap.keySet().contains(categoria))) {
                System.out.println("Seleccione una opción válida.");
            } else {
                break;
            }
        }

        System.out.println("Seleccione un producto.");

        while (true) {
            System.out.println(Nmap.get(categoria));
            product = in.nextLine();

            if (!(Nmap.get(categoria).contains(product))) {
                System.out.println("Seleccione una opción válida.");
            } else {
                break;
            }
        }
        return product;
    }
    //Método para imprimir la lista del carrito
    public static void Carrito(ArrayList<String> cart) {
        System.out.println(cart);   
    }
}
