package com.example.sales.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderReports")
public class OrderReport {
    @Id
    public String id;
    public String orderId;
    public String firstName;
    public String lastName;
    public long amount;
}
