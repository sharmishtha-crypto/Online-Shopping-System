#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

// Product Class
class Product {
private:
    string pro_id;
    string name;
    float rating;
    string review;
    double price;
    int stock;

public:
    Product(string id, string n, float r, string rev, double p, int s)
        : pro_id(id), name(n), rating(r), review(rev), price(p), stock(s) {}

    void add_to_cart() {
        cout << "Product '" << name << "' added to cart." << endl;
    }

    void buy() {
        if (stock > 0) {
            stock--;
            cout << "Purchased " << name << ". Remaining stock: " << stock << endl;
        } else {
            cout << "Product " << name << " is out of stock!" << endl;
        }
    }

    string getName() const { return name; }
    double getPrice() const { return price; }
    int getStock() const { return stock; }
};

// Categories Class
class Categories {
private:
    string cat_id;
    string name;
    vector<Product> pro_list;

public:
    Categories(string id, string n) : cat_id(id), name(n) {}

    void addProduct(const Product& product) {
        pro_list.push_back(product);
    }

    void search_by_cat() {
        cout << "\n--- Category: " << name << " ---" << endl;
        for (const auto& p : pro_list) {
            cout << "- " << p.getName() << " | Price: $" << p.getPrice() << " | Stock: " << p.getStock() << endl;
        }
    }

    void sort_products() {
        sort(pro_list.begin(), pro_list.end(), [](const Product& a, const Product& b) {
            return a.getPrice() < b.getPrice();
        });
        cout << "Products sorted by price in " << name << " category." << endl;
    }
};

// Cart Class
class Cart {
private:
    string cart_id;
    vector<Product> item_list;
    double total_amount;

public:
    Cart(string id) : cart_id(id), total_amount(0.0) {}

    void addProduct(const Product& product) {
        item_list.push_back(product);
        total_amount += product.getPrice();
        cout << "Added to Cart: " << product.getName() << endl;
    }

    void pay_now() {
        cout << "Proceeding to payment... Total Cart Amount: $" << total_amount << endl;
    }

    double getTotalAmount() const { return total_amount; }
};

// Order Class
class Order {
private:
    string order_id;
    string order_status;
    double total;
    string date;
    string details;

public:
    Order(string id, double t, string d, string det)
        : order_id(id), total(t), date(d), details(det), order_status("Pending") {}

    void place_order() {
        order_status = "Placed";
        cout << "Order " << order_id << " placed successfully on " << date << " for Total: $" << total << endl;
    }
};

// Payment Class
class Payment {
private:
    string pay_id;
    string pay_method;
    double pay_amount;
    string pay_status;

public:
    Payment(string id, string method, double amount)
        : pay_id(id), pay_method(method), pay_amount(amount), pay_status("Initiated") {}

    void completePayment() {
        pay_status = "Completed";
        cout << "Payment of $" << pay_amount << " via " << pay_method << " successful!" << endl;
    }

    void check_status() {
        cout << "Payment ID " << pay_id << " Status: " << pay_status << endl;
    }
};

// Shipment Class
class Shipment {
private:
    string ship_id;
    string tracking_no;
    string deli_status;
    string date;
    string ship_date;

public:
    Shipment(string id, string track, string d, string ship_d)
        : ship_id(id), tracking_no(track), date(d), ship_date(ship_d), deli_status("In Transit") {}

    void check_status() {
        cout << "Shipment Tracking No: " << tracking_no << " | Status: " << deli_status << " | Shipped On: " << ship_date << endl;
    }
};

// Main Execution
int main() {
    cout << "==========================================" << endl;
    cout << "   ONLINE SHOPPING SYSTEM (C++ DEMO)     " << endl;
    cout << "==========================================" << endl;

    Product laptop("P101", "Gaming Laptop", 4.8f, "Excellent performance", 1200.00, 5);
    Product mouse("P102", "Wireless Mouse", 4.2f, "Smooth and reliable", 25.50, 15);

    Categories electronics("C01", "Electronics");
    electronics.addProduct(laptop);
    electronics.addProduct(mouse);

    electronics.search_by_cat();
    electronics.sort_products();

    cout << "\n--- Shopping Cart Operations ---" << endl;
    Cart cart("CART_001");
    cart.addProduct(laptop);
    cart.addProduct(mouse);
    cart.pay_now();

    cout << "\n--- Order Management ---" << endl;
    Order order("ORD_9988", cart.getTotalAmount(), "2026-09-27", "2 Items: Laptop, Mouse");
    order.place_order();

    cout << "\n--- Payment Processing ---" << endl;
    Payment payment("PAY_7711", "Credit Card", cart.getTotalAmount());
    payment.completePayment();
    payment.check_status();

    cout << "\n--- Shipment Tracking ---" << endl;
    Shipment shipment("SHIP_3321", "TRK_99182736", "2026-09-27", "2026-09-28");
    shipment.check_status();

    cout << "\n==========================================" << endl;
    return 0;
}