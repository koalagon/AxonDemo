package messages.sales.queries;

public class OrdersProjection {
    private String orderId;
    private long amount;
    private String firstName;
    private String lastName;

    public OrdersProjection(String orderId, long amount, String firstName, String lastName) {
        this.orderId = orderId;
        this.amount = amount;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getOrderId() {
        return orderId;
    }

    public long getAmount() {
        return amount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
