package com.example.sales.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import messages.sales.commands.EditOrderCommand;
import messages.sales.commands.PlaceOrderCommand;
import messages.sales.events.OrderPlacedEvent;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.*;

@Entity
@Aggregate
public class OrderAggregate {
    @Id
    @AggregateIdentifier
    private String orderId;
    private String product;
    private long amount;

    @CommandHandler
    public OrderAggregate(PlaceOrderCommand command) {
        this.amount = 10000;
        this.orderId = command.getOrderId();
        this.product = command.getProduct();

        AggregateLifecycle.apply(new OrderPlacedEvent(command.getOrderId(), command.getProduct(), amount));
    }

    @CommandHandler
    public void handle(EditOrderCommand command) {

    }

    protected OrderAggregate() { }
}
