package com.example.sales.app;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import messages.sales.events.OrderPlacedEvent;

import java.util.UUID;

@Component
public class OrderPlacedEventHandler {
    @Autowired
    private OrderReportRepository orderReportRepository;
    @Autowired
    private SmtpAdapter smtpAdapter;

    @EventHandler
    public void handle(OrderPlacedEvent event) {
        smtpAdapter.sendEmail("New order is placed");

        // JOIN으로 인한 성능 저하를 없애기 위해 Denormalized dimension table로 저장합니다.
        OrderReport orderReport = new OrderReport();
        orderReport.id = UUID.randomUUID().toString();
        orderReport.orderId = event.getOrderId();
        orderReport.firstName = "Hello";
        orderReport.lastName = "World";
        orderReport.amount = event.getAmount();

        orderReportRepository.save(orderReport);
    }
}
