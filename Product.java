public class Product {
    private String pro_id;
    private String name;
    private float rating;
    private String review;
    private double price;
    private int stock;

    public Product(String pro_id, String name, float rating, String review, double price, int stock) {
        this.pro_id = pro_id;
        this.name = name;
        this.rating = rating;
        this.review = review;
        this.price = price;
        this.stock = stock;
    }

    public void add_to_cart() {
        System.out.println("Product '" + name + "' added to cart.");
    }

    public void buy() {
        if (stock > 0) {
            stock--;
            System.out.println("Purchased " + name + ". Remaining stock: " + stock);
        } else {
            System.out.println("Product " + name + " is out of stock!");
        }
    }

    public String getPro_id() { return pro_id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}