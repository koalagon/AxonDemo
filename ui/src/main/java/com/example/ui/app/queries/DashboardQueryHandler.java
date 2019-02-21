package com.example.ui.app.queries;

import com.example.ui.app.Dashboard;
import com.example.ui.app.DashboardRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardQueryHandler {
    @Autowired
    DashboardRepository dashboardRepository;

    @QueryHandler
    public Dashboard handle(DashboardQuery query) {
        return dashboardRepository.findAll().stream().findFirst().get();
    }
}
