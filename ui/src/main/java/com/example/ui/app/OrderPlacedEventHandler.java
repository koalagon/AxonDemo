package com.example.ui.app;

import messages.sales.events.OrderPlacedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class OrderPlacedEventHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @EventHandler
    public void handle(OrderPlacedEvent event) {
        Optional<Dashboard> dashboard = dashboardRepository.findAll().stream().findFirst();

        if (!dashboard.isPresent()) {
            Dashboard newDashboard = new Dashboard();
            newDashboard.id = UUID.randomUUID().toString();
            newDashboard.orderCount = 1;
            dashboardRepository.save(newDashboard);
        } else {
            dashboard.get().orderCount++;
        }
    }
}
