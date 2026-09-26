public class Shipment {
    private String ship_id;
    private String tracking_no;
    private String deli_status;
    private String date;
    private String ship_date;

    public Shipment(String ship_id, String tracking_no, String date, String ship_date) {
        this.ship_id = ship_id;
        this.tracking_no = tracking_no;
        this.date = date;
        this.ship_date = ship_date;
        this.deli_status = "In Transit";
    }

    public void check_status() {
        System.out.println("Shipment Tracking No: " + tracking_no + " | Status: " + deli_status + " | Shipped On: " + ship_date);
    }
}