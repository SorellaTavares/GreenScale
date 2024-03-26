

public class Product {
    public static ShoppingCart add;
    private String name;
    private double price;
    private String priceType;
    private String productGroup;
    private double offer;
    //Constructor 1:
    public Product(String name, double price, String priceType, String productGroup, double offer){
        this.name = name;
        this.productGroup = productGroup;
        this.price = price;
        this.priceType = priceType;
        this.offer = offer;
    }
    //Constructor 2:
    public Product(String name){
        this.name = name;
    }
    //Constructor 3:
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getProductGroup() {
        return productGroup;
    }
    public String getPriceType() {
        return priceType;
    }
    public double getPrice() {
        return price;
    }
    public double getOffer() {
        return offer;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
    public void setOffer(double offer) {
        this.offer = offer;
    }


    @Override
    public String toString() {
        return "Sort: " + name +
                "\nPris: " + price +
                "/" + priceType +
                "\nVarugrupp: " + productGroup + "\nErbjudande: "
                + offer + "/" + priceType;
    }
}
