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

        Map<String, ArrayList<String>> myMap = makeMap(in);


        try {
            myMap = readFile("ListadoProducto.txt", myMap);
        } catch (Exception e) {
            System.out.println("Revisar si el archivo se encuentra en el mismo lugar de este programa");
            System.exit(0);
        }

        System.out.println("Tienda virtual Don Canche");

        while (true) {
            System.out.println("\nEliga lo que desea hacer\n \n1. Añadir un producto al carrito\n2. Ver la categoería\n3.  Mostrar el carrito\n4. Mostrar inventario\n5. Salir del programa");
            int option = Integer.parseInt(in.nextLine());

            switch (option) {
                case 1:
                    shopCart.add(addProduct(in, myMap));
                    break;
                case 2:
                    productCat(in, myMap);
                    break;
                case 3:
                    listProds(shopCart);
                    break;
                case 4:
                    listInventory(myMap);
                    break;
                case 5:
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
    public static String addProduct(Scanner in, Map<String, ArrayList<String>> myMap) {
        System.out.println("Seleccione la categoría de productos que desea comprar.");
        String cat = "";
        String prod = "";

        while (true) {
            System.out.println(myMap.keySet());
            cat = in.nextLine();

            if (!(myMap.keySet().contains(cat))) {
                System.out.println("Seleccione una opción válida.");
            } else {
                break;
            }
        }

        System.out.println("Seleccione un producto.");

        while (true) {
            System.out.println(myMap.get(cat));
            prod = in.nextLine();

            if (!(myMap.get(cat).contains(prod))) {
                System.out.println("Seleccione una opción válida.");
            } else {
                break;
            }
        }
        System.out.println("Producto añadido!");
        return prod;
    }
    private static Map<String, ArrayList<String>> makeMap(Scanner in) {
        Mfactory<String, ArrayList<String>> mapMaker = new Mfactory<>();

        System.out.println("Seleccione una opción para generar el mapa a utilizar en el programa.");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int map = Integer.parseInt(in.nextLine());
        Map<String, ArrayList<String>> myMap = mapMaker.newMap(map);
        return myMap;
    }
    private static Map<String, ArrayList<String>> readFile(String path, Map<String, ArrayList<String>> myMap) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
            String line = null;
            ArrayList<String> products = new ArrayList<>();
            String category = "";
            String product = "";

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                
                if (!(category.equals(parts[0].trim()))) {
                    products = new ArrayList<>();
                }
                
                category = parts[0].trim();
                product = parts[1].trim();
                products.add(product);

                myMap.put(category, products);
            }
            reader.close();
            return myMap;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
