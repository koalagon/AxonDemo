package com.example.ui.app;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dashboard {
    @Id
    public String id;
    public int orderCount;
    public int userCount;
}
