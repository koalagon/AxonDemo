package messages.sales.events;

public class OrderPlacedEvent {
    private final String orderId;
    private final String product;
    private final long amount;

    public OrderPlacedEvent(String orderId, String product, long amount) {
        this.orderId = orderId;
        this.product = product;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public long getAmount() {
        return amount;
    }
}
