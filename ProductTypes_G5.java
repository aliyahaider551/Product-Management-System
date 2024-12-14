package Group5;

import java.util.ArrayList;
import java.util.Scanner;

// Aliya Haider 1082079
// Kommal Tariq 1088392
// Lynn Abbidi 1083873

public abstract class ProductTypes_G5 {
    private String Categoryname;
    private int ID;
    private ArrayList<Product_G5> product= new ArrayList<>();

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String categoryname) {
        Categoryname = categoryname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void AddProduct(){
        //we need to add the products from the Product class
        System.out.println("Please enter the name of the product: ");
        Scanner input= new Scanner(System.in);
        String name= input.nextLine();
        System.out.println("Please enter the ID of the product: ");
        int ID= input.nextInt();
        System.out.println("Please enter the quantity of the product: ");
        int quantity=input.nextInt();
        System.out.println("Please enter if the product was imported: ");
        String imported= input.next();
        System.out.println("Please enter the rating of the product: ");
        double rating= input.nextDouble();
        System.out.println("Please enter the name of company of the product: ");
        String company=input.next();
        System.out.println("Please enter the price of the product: ");
        double price=input.nextDouble();

        Product_G5 p1=new Product_G5(name,ID,quantity,imported,rating,company,price);
        product.add(p1);
    }
    public Product_G5 searchByID(int ID){
        //when given id
        for(Product_G5 p:product){
           if(p.getID()==ID){
               return p;
           }

        }
        return null;
    }
    public Product_G5 searchByName(String name){
        for (Product_G5 product1:product){
            if (product1.getName().equals(name)){
                return product1;
            }
        }
        return null;
    }
    public void updatePrice(){
        // get id if the product,
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter ID:");
        int ID= sc.nextInt();
        if(searchByIDBool(ID)){
            System.out.println("Enter price:");
            double price= sc.nextDouble();
            Product_G5 p2= searchByID(ID);
            // update the price for p2
            p2.setPrice(price);
            System.out.println("Price Updated");
        }
        else
            System.out.println("The product doesn't exists");

    }
    //updatePriceByName
 public void updatePriceByName(){
        Scanner sc= new Scanner(System.in);
     System.out.println("Enter name:");
        String name= sc.nextLine();
        if (searchByNameBool(name)){
            System.out.println("Enter price:");
            double price= sc.nextDouble();
            Product_G5 p3=searchByName(name);
            p3.setPrice(price);
            System.out.println("Price Updated");
        }
        else
            System.out.println("The product doesn't exists");
 }
 //updateQuantityByName
    public void updateQuantityByName(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        if (searchByNameBool(name)){
            System.out.println("Enter Quantity:");
            int quantity= sc.nextInt();
            Product_G5 p4=searchByName(name);
            p4.setQuantity(quantity);
            System.out.println("Quantity Updated");
        }
        else
            System.out.println("Unable to Updated the Quantity");
        }
        //updateQuantityByID
    public void updateQuantityByID(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter ID");
        int ID= sc.nextInt();
        if (searchByIDBool(ID)){
            System.out.println("Enter Quantity:");
            int quantity=sc.nextInt();
            Product_G5 p5=searchByID(ID);
            p5.setQuantity(quantity);
            System.out.println("Quantity Updated");
        }
        else
            System.out.println("Unable to Update the Quantity");

    }

    public boolean searchByNameBool(String name){
        for (Product_G5 product1:product){
            if (product1.getName().equals(name)){
                return true;
            }
        }
        return false;

    }
    public boolean searchByIDBool(int ID){
        for(Product_G5 p:product){
            if(p.getID()==ID){
                return true;
            }

        }
        return false;

    }
    public void printArrayList() {
        for (int i = 0; i < product.size(); i++) {
            System.out.println(product.get(i));
        }
    }
    public double stockPrice(){
        double sum=0;
        for(Product_G5 p:product){
            sum+=p.totalPrice();
        }
        return sum;
    }
    public void add(Product_G5 product){
        this.product.add(product);
    }
    public Product_G5 FindHighestRating(){
        Product_G5 highest= product.get(0);
        for(Product_G5 product:product){
            if(highest.getRating()<product.getRating()){
                highest=product;
            }
        }
        return highest;
    }


}
