package com.example.ui.controllers.rest.v1;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import messages.sales.commands.EditOrderCommand;
import messages.sales.commands.PlaceOrderCommand;
import messages.sales.queries.OrdersProjection;
import messages.sales.queries.OrdersQuery;

import java.util.List;
import java.util.UUID;

@RestController("RestV1Controller")
public class OrderController {
    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public OrderController(CommandGateway commandGateway, QueryGateway queryGateway)
    {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/ship-order")
    public void shipOrder() {
        String orderId = UUID.randomUUID().toString();
        commandGateway.sendAndWait(new PlaceOrderCommand(orderId, "Deluxe Chair"));
    }

    @GetMapping("/all-orders")
    public List<OrdersProjection> findAllOrders() {
        return queryGateway.query(new OrdersQuery(),
                ResponseTypes.multipleInstancesOf(OrdersProjection.class)).join();
    }

    @PostMapping("/edit-order")
    public void editOrder() {
        String orderId = "0e4eae38-80cb-4bb4-8d9a-259f016b7541";
        commandGateway.send(new EditOrderCommand(orderId));
    }
}
