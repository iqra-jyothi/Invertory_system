import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Invertory {
    public void addproduct(ArrayList<Product> product, Scanner sc) {
        Product p = new Product(1, "Laptop", "Electronics", 40000.0, 10);
        product.add(p);
        product.add(new Product(2, "smartphone", "Electronics", 20000.0, 10));
        product.add(new Product(3, "Washing Machine", "Electronics", 500000.0, 10));
        product.add(new Product(4, "Refrigerator", "Electronics", 30000.0, 10));
        product.add(new Product(5, "Television", "Electronics", 50000.0, 10));
        System.out.print("eneter the product id");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("eneter the product name");
        String name = sc.next();
        sc.nextLine();
        System.out.print("eneter the product category");
        String category = sc.next();
        sc.nextLine();
        System.out.print("eneter the product price");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("eneter the product stock quantity");
        int stockQuantity = sc.nextInt();
        sc.nextLine();
        Product newproduct=new Product(id,name,category,price,stockQuantity);
        product.add(newproduct);
        System.out.println("Product added successfully!");
    }

    public void viewproduct(ArrayList<Product> product) {
        if(product.isEmpty()){
            System.out.print("Product list is empty.");
        }
        else {
            System.out.println("Product List:");
            for (Product p : product) {
                System.out.println(p);
            }
        }
    }


    public void ViewId(ArrayList<Product> product, Scanner sc) {
        System.out.print("enter the product id to be searched");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        Iterator<Product>iterator=product.iterator();
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getId()==id)
            {
                System.out.println("Product found: " + p);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void increaseStockQuantity(ArrayList<Product> product, Scanner sc) {
        System.out.print("enter the product id to be searched");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter the quantity to be added");
        int quantityToAdd = sc.nextInt();
        Iterator<Product>iterator=product.iterator();
        boolean found = false;
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getId()==id)
            {
                p.setStockQuantity(p.getStockQuantity()+quantityToAdd);
                System.out.println("Product found: " + p);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Product with ID " + id + " not found.");
        }

    }

    public void decreaseStockQuantity(ArrayList<Product> product, Scanner sc) {
        System.out.print("enter the product id to be searched");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("enter the quantity to be removed");
        int quantityToRemove = sc.nextInt();
        Iterator<Product>iterator=product.iterator();
        boolean found = false;
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getId()==id)
            {
                if(p.getStockQuantity() >= quantityToRemove) {
                    p.setStockQuantity(p.getStockQuantity() - quantityToRemove);
                    System.out.println("Product found: " + p);
                    found = true;
                    break;
                } else {
                    System.out.println("Insufficient stock to remove " + quantityToRemove + " items.");
                }

            }
        }
        if(!found) {
            System.out.println("Product with ID " + id + " not found.");
        }

    }

    public void deleteById(ArrayList<Product> product, Scanner sc) {
        System.out.print("enter the product id to be searched");
        int id = sc.nextInt();
        sc.nextLine();

        Iterator<Product>iterator=product.iterator();
        boolean found = false;
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getId()==id)
            {

              iterator.remove();
                found = true;
                System.out.println("Product with ID " + id + " has been deleted.");
                break;
            }
        }
        if(!found) {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void lowStockAlert(ArrayList<Product> product) {

        Iterator<Product>iterator=product.iterator();

        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getStockQuantity()<5)
            {
               System.out.println("Low stock alert for product: " + p.getName() + " (ID: " + p.getId() + ") - Current stock: " + p.getStockQuantity());
            }
        }
        if(!iterator.hasNext()) {
            System.out.println("No products with low stock.");
        }

    }

    public void searchByName(ArrayList<Product> product, Scanner sc) {
        System.out.print("enter the product name to be searched");
        String name = sc.next();
        sc.nextLine();

        Iterator<Product>iterator=product.iterator();
        boolean found = false;
        while(iterator.hasNext())
        {
            Product p=iterator.next();
            if(p.getName().equalsIgnoreCase(name))
            {

                System.out.println("Product found: " + p);
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Product with ID " + name + " not found.");
        }
    }

    public void totalInventoryValue(ArrayList<Product> product) {
        double totalvalue=0.0;
        if(product.isEmpty()){
            System.out.print("Product list is empty.");
        }
        else {
            System.out.println("Product List:");
            for (Product p : product) {
                double per=p.getStockQuantity()*p.getPrice();
                totalvalue+=per;
            }
        }
        System.out.println("Total inventory value: " + totalvalue);
    }

    public void mostAndLeastExpensiveProduct(ArrayList<Product> product) {
        double mostExpensive = Double.MIN_VALUE;
        double leastExpensive = Double.MAX_VALUE;
        Product mostExpensiveProduct = null;
        Product leastExpensiveProduct = null;
        Iterator<Product>iterator=product.iterator();

        while(iterator.hasNext()) {
            Product p = iterator.next();
           if(p.getPrice()>mostExpensive)
           {
               mostExpensive= p.getPrice();
                mostExpensiveProduct = p;
           }
              if(p.getPrice()<leastExpensive)
              {
                leastExpensive= p.getPrice();
                leastExpensiveProduct = p;
              }
        }
        System.out.println("Most Expensive Product: " + mostExpensiveProduct);
        System.out.println("Least Expensive Product: " + leastExpensiveProduct);

        }
}
