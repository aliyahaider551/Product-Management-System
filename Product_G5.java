package Group5;

// Aliya Haider 1082079
// Kommal Tariq 1088392
// Lynn Abbidi 1083873

public class Product_G5 {
    //name, Id,price,quantity, rating, boolean imported, description,discounted price
    private String name;
    private int ID;
    private int quantity;
    private boolean imported;
    private double rating;
    private String Company;
    private double price;

    Product_G5(String name,int ID,int quantity,String imported, double rating,String company,double price ){
        setName(name);
        setID(ID);
        this.quantity=quantity;
        setImported(imported);
        setRating(rating);
        setCompany(company);
        this.price=price;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }

    public boolean isImported() {
        return imported;
    }
    public void setImported(String imported){
        if (imported=="Yes"||imported=="YES"||imported=="True"||imported=="true"||imported=="y"||imported=="Y"){
            this.imported=true;
        }
        else
            this.imported=false;
    }
    public double getRating(){
        return rating;
    }
    public void setRating(double rating){
        if (rating<0||rating>5){
            System.out.println("Invalid Rating!");
        }
        else{
            this.rating=rating;
        }
    }

    public String getCompany(){
        return Company;
    }
    public void setCompany(String Company){
        this.Company=Company;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double totalPrice(){
        return quantity*price;
    }


    @Override
    public String toString() {
        return getName()+" "+getID()+" "+getPrice()+"AED"+ " "+getRating()+" /5";
    }
}

