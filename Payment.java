public class Payment {
    private String pay_id;
    private String pay_method;
    private double pay_amount;
    private String pay_status;

    public Payment(String pay_id, String pay_method, double pay_amount) {
        this.pay_id = pay_id;
        this.pay_method = pay_method;
        this.pay_amount = pay_amount;
        this.pay_status = "Initiated";
    }

    public void check_status() {
        System.out.println("Payment ID " + pay_id + " Status: " + pay_status);
    }

    public void cancel() {
        this.pay_status = "Cancelled";
        System.out.println("Payment " + pay_id + " was cancelled.");
    }

    public void refund() {
        this.pay_status = "Refunded";
        System.out.println("Amount $" + pay_amount + " refunded for Payment ID: " + pay_id);
    }

    public void completePayment() {
        this.pay_status = "Completed";
        System.out.println("Payment of $" + pay_amount + " via " + pay_method + " successful!");
    }
}