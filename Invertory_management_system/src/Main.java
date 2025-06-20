import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
ArrayList<Product> product=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        Invertory i=new Invertory();
        System.out.println("Invertory  System:");
        while(true)
        {
            System.out.println("1.Add product");
            System.out.println("2.view all product");
            System.out.println("3.search by product id");
            System.out.println("4.increase the stock quantity");
            System.out.println("5.decrease the stock quantity");
            System.out.println("6.delete by product id");
            System.out.println("7.low stock alert");
            System.out.println("8.search by name");
            System.out.println("9.total invertory value");
            System.out.println("10.most expensive and least expensive product");
            System.out.println("11.Exit");
            System.out.print("enter the choice");

            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:i.addproduct(product,sc);
                break;
                case 2:i.viewproduct(product);
                break;
                case 3:i.ViewId(product,sc);
                break;
                case 4:i.increaseStockQuantity(product,sc);
                break;
                case 5:i.decreaseStockQuantity(product,sc);
                break;
                case 6:i.deleteById(product,sc);
                break;
                case 7:i.lowStockAlert(product);
                break;
                case 8:i.searchByName(product,sc);
                break;
                case 9:i.totalInventoryValue(product);
                break;
                case 10:i.mostAndLeastExpensiveProduct(product);
                break;
                case 11:
                    System.out.println("Exiting the inventory system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}