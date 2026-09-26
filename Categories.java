import java.util.ArrayList;
import java.util.List;

public class Categories {
    private String cat_id;
    private String name;
    private List<Product> pro_list;

    public Categories(String cat_id, String name) {
        this.cat_id = cat_id;
        this.name = name;
        this.pro_list = new ArrayList<>();
    }

    public void addProduct(Product product) {
        pro_list.add(product);
    }

    public void search_by_cat() {
        System.out.println("\n--- Category: " + name + " ---");
        for (Product p : pro_list) {
            System.out.println("- " + p.getName() + " | Price: $" + p.getPrice() + " | Stock: " + p.getStock());
        }
    }

    public void sort() {
        pro_list.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Products sorted by price in " + name + " category.");
    }
}