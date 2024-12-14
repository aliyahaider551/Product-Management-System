package Group5;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Aliya Haider 1082079
// Kommal Tariq 1088392
// Lynn Abbidi 1083873

public class ProductManager_G5{
    static Electronics_G5 electronics=new Electronics_G5();
    static Clothing_G5 clothing= new Clothing_G5();
    static Furniture_G5 furniture=  new Furniture_G5();

    public static void main(String[] args) throws Exception {
        try {
            displayMenu();
            System.out.println("Please Enter a Number to Proceed: ");
            Scanner sc= new Scanner(System.in);
            int input= sc.nextInt();
            while(input!=0&&input!=7) {
                switch (input) {
                    case 1:
                        addProduct();
                        System.out.println("Product Added");
                        break;
                    case 2:
                        updatePriceOrStock();
                        System.out.println("Product Updated");
                        break;
                    case 3:
                        ReadFromFile();
                        System.out.println("Bulk addition of products done");
                        break;
                    case 4:
                        ListAll();
                        System.out.println("All Products are listed below");
                        break;
                    case 5:
                        StockValue();
                        System.out.println("Stock value for every category printed below");
                        break;
                    case 6:
                        FindHighestRatingProduct();
                        System.out.println("The product with the highest rating is listed below");
                        break;

                    default:
                        throw new Exception("Invalid Input");
                }

                displayMenu();
                input= sc.nextInt();

                System.out.println("Thank for using the E-commerce Product Manger System!");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }

    }

    public static void displayMenu(){
        System.out.println("**MENU**");
        System.out.println("1.Add a Product");
        System.out.println("2.Update a product");
        System.out.println("3.Bulk additions of product from a file");
        System.out.println("4.List all products in a category:");
        System.out.println("5.Calculate stock value of each category");
        System.out.println("6. Print highest rated product ");

        System.out.println("0 or 7 to exit the program:");
                System.out.println("**");
    }

    public static int miniMenu(){
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Furniture");
        System.out.println("Enter your choice: ");
        Scanner input=new Scanner(System.in);
        int category=input.nextInt();
        return category;
    }
    public static void ListAll(){
        try{
            switch (miniMenu()){
                case 1:
                    electronics.printArrayList();
                    break;
                case 2:
                    clothing.printArrayList();
                    break;
                case 3:
                    furniture.printArrayList();
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input!");
        }
    }
    public static void StockValue(){
        try{
            switch (miniMenu()){
                case 1:
                    System.out.println("The stock price for electronics is: "+electronics.stockPrice()+" AED");
                    break;
                case 2:
                    System.out.println("The stock price for clothing is: "+clothing.stockPrice()+" AED");
                    break;
                case 3:
                    furniture.printArrayList();
                    System.out.println("The stock price for furniture is: "+furniture.stockPrice()+" AED");
                    break;
            }

        }
        catch (Exception e){
            System.out.println("Invalid Input!");
        }
    }
    public static void addProduct(){
        try {
            switch (miniMenu()){
                case 1:
                    electronics.AddProduct();
                    break;
                case 2:
                    clothing.AddProduct();
                    break;
                case 3:
                    furniture.AddProduct();
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input!");
        }
    }
    public static void ReadFromFile() throws FileNotFoundException {
        java.io.File file= new java.io.File("src/Group5/Example.txt");
        Scanner sc= new Scanner(file);
        try {
            while (sc.hasNext()){
                String line=sc.nextLine();
                String[] details= line.split(" ");
                int category= Integer.parseInt(details[0]);
                String name= details[1];
                int price= Integer.parseInt(details[2]);
                int quantity=Integer.parseInt(details[3]);
                int ID= Integer.parseInt(details[4]);
                String imported= details[5];
                double rating =Double.parseDouble(details[6]);
                String company= details[7];
                Product_G5 p1=new Product_G5(name,ID,quantity,imported,rating,company,price);
                switch (category){
                    case 1:
                        electronics.add(p1);
                        break;
                    case 2:
                        clothing.add(p1);
                        break;
                    case 3:
                        furniture.add(p1);
                        break;
                }

            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
        sc.close();
    }
    public static void updatePriceOrStock(){
        System.out.println("1. Price: ");
        System.out.println("2.Stock: ");
        System.out.println("What would you like to update: ");
        Scanner sc= new Scanner(System.in);
        int input= sc.nextInt();
        try {
            switch (input){
                case 1:
                    updatePrice();
                    break;
                case 2:
                    updateQuantity();
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
    public static void updatePrice(){
        try {
            switch (miniMenu()){
                case 1:
                    if(updateMenu()==1){
                        electronics.updatePriceByName();

                    }
                    else {
                        electronics.updatePrice();
                    }
                    break;
                case 2:
                    if(updateMenu()==1){
                        clothing.updatePriceByName();

                    }
                    else {
                        clothing.updatePrice();
                    }
                    break;
                case 3:
                    if(updateMenu()==1){
                        furniture.updatePriceByName();

                    }
                    else {
                        furniture.updatePrice();
                    }
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
    public static void updateQuantity(){
        try {
            switch (miniMenu()){
                case 1:
                    if(updateMenu()==1){
                        electronics.updateQuantityByName();
                    }
                    else {
                        electronics.updateQuantityByID();
                    }
                    break;
                case 2:
                    if(updateMenu()==1){
                        clothing.updateQuantityByName();

                    }
                    else {
                        clothing.updateQuantityByID();
                    }
                    break;
                case 3:
                    if(updateMenu()==1){
                        furniture.updateQuantityByName();

                    }
                    else {
                        furniture.updateQuantityByID();
                    }
                    break;
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
        }

    }
    public  static int updateMenu(){
        System.out.println("Would you like to update the product by name or ID");
        System.out.println("1.name:" );
        System.out.println("2.ID: ");
        Scanner input= new Scanner(System.in);
        int sc= input.nextInt();
        return sc;
    }
    public static void FindHighestRatingProduct(){
        System.out.println("For Electronics the product with the highest rating: "+ electronics.FindHighestRating());
        System.out.println("For Clothing the product with the highest rating: "+ clothing.FindHighestRating());
        System.out.println("For Furniture the product with the highest rating: "+ furniture.FindHighestRating());
    }

}