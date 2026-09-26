public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   ONLINE SHOPPING SYSTEM DEMONSTRATION   ");
        System.out.println("==========================================");

        // 1. Create Products & Category
        Product laptop = new Product("P101", "Gaming Laptop", 4.8f, "Excellent performance", 1200.00, 5);
        Product mouse = new Product("P102", "Wireless Mouse", 4.2f, "Smooth and reliable", 25.50, 15);

        Categories electronics = new Categories("C01", "Electronics");
        electronics.addProduct(laptop);
        electronics.addProduct(mouse);

        electronics.search_by_cat();
        electronics.sort();

        // 2. Add Products to Cart
        System.out.println("\n--- Shopping Cart Operations ---");
        Cart cart = new Cart("CART_001");
        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.pay_now();

        // 3. Place Order
        System.out.println("\n--- Order Management ---");
        Order order = new Order("ORD_9988", cart.getTotal_amount(), "2026-03-26", "2 Items: Laptop, Mouse");
        order.place_order();

        // 4. Payment Processing
        System.out.println("\n--- Payment Processing ---");
        Payment payment = new Payment("PAY_7711", "Credit Card", cart.getTotal_amount());
        payment.completePayment();
        payment.check_status();

        // 5. Shipment Tracking
        System.out.println("\n--- Shipment Tracking ---");
        Shipment shipment = new Shipment("SHIP_3321", "TRK_99182736", "2026-03-26", "2026-03-27");
        shipment.check_status();

        System.out.println("\n==========================================");
        System.out.println("        SYSTEM PROCESS COMPLETED          ");
        System.out.println("==========================================");
    }
}