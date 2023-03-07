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
            printMenu();
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
