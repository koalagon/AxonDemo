package messages.sales.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class PlaceOrderCommand {
    @TargetAggregateIdentifier
    private final String orderId;
    private final String product;

    public PlaceOrderCommand(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getProduct() {
        return this.product;
    }
}
