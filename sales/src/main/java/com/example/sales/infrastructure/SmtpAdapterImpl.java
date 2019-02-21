package com.example.sales.infrastructure;

import com.example.sales.app.SmtpAdapter;
import org.springframework.stereotype.Component;

@Component
public class SmtpAdapterImpl implements SmtpAdapter {
    @Override
    public void sendEmail(String message) {

    }
}
