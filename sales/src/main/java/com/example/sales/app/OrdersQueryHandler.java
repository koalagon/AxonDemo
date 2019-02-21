package com.example.sales.app;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import messages.sales.queries.OrdersProjection;
import messages.sales.queries.OrdersQuery;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersQueryHandler {
    @Autowired
    private OrderReportRepository orderReportRepository;

    @QueryHandler
    public List<OrdersProjection> handle(OrdersQuery query) {
        List<OrdersProjection> orderProjection = orderReportRepository.findAll().stream().map(order ->
                new OrdersProjection(order.id, order.amount, order.firstName, order.lastName)).collect(Collectors.toList());

        return orderProjection;
    }
}
