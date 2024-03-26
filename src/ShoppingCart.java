public class ShoppingCart {

    private String name;
    private double price;
    private String priceType;
    private String productGroup;
    private double offer;
    public ShoppingCart(String name, double price, String priceType, String productGroup, double offer){
        this.name = name;
        this.productGroup = productGroup;
        this.price = price;
        this.priceType = priceType;
        this.offer = offer;
    }
}
