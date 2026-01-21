public class Product {
    String name;
    int qty;
    double price;

    public Product(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public double getTotal() {
        return qty * price;
    }
}