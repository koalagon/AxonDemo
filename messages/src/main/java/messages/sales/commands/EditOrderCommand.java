package messages.sales.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class EditOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;

    public EditOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
