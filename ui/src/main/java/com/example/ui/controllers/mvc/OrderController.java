package com.example.ui.controllers.mvc;

import com.example.ui.app.Dashboard;
import com.example.ui.app.queries.DashboardQuery;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("MvcOrderController")
public class OrderController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/")
    public String homePage(Model model) {
        Dashboard dashboard = queryGateway.query(new DashboardQuery(), Dashboard.class).join();

        if (dashboard != null) {
            model.addAttribute("orderCount", dashboard.orderCount);
            model.addAttribute("userCount", dashboard.userCount);
        }
        return "/home";
    }
}
