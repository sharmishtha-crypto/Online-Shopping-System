public class Order {
    private String order_id;
    private String order_status;
    private double total;
    private String date;
    private String details;

    public Order(String order_id, double total, String date, String details) {
        this.order_id = order_id;
        this.total = total;
        this.date = date;
        this.details = details;
        this.order_status = "Pending";
    }

    public void place_order() {
        this.order_status = "Placed";
        System.out.println("Order " + order_id + " placed successfully on " + date + " for Total: $" + total);
    }

    public void return_order() {
        this.order_status = "Returned";
        System.out.println("Order " + order_id + " has been marked for return.");
    }

    public String getOrder_id() { return order_id; }
    public String getOrder_status() { return order_status; }
}