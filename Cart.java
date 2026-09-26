import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String cart_id;
    private List<Product> item_list;
    private double total_amount;

    public Cart(String cart_id) {
        this.cart_id = cart_id;
        this.item_list = new ArrayList<>();
        this.total_amount = 0.0;
    }

    public void addProduct(Product product) {
        item_list.add(product);
        total_amount += product.getPrice();
        System.out.println("Added to Cart: " + product.getName());
    }

    public void pay_now() {
        System.out.println("Proceeding to payment... Total Cart Amount: $" + total_amount);
    }

    public void buy_now() {
        System.out.println("Processing immediate checkout for " + item_list.size() + " items.");
    }

    public double getTotal_amount() { return total_amount; }
    public List<Product> getItem_list() { return item_list; }
}