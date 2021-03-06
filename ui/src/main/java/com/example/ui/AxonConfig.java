package com.example.ui;

import org.axonframework.axonserver.connector.AxonServerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {
    @Bean
    @Primary
    public AxonServerConfiguration axonServerConfig(AxonServerConfiguration axonServerConfiguration) {
        // Axon Server가 localhost가 아닌 경우 설정을 변경해 주어야 합니다.
        axonServerConfiguration.setServers("127.0.0.1");
        return axonServerConfiguration;
    }
}
