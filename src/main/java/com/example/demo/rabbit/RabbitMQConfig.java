package com.example.demo.rabbit;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String STOCK_LOW_EXCHANGE = "product.stock.low";
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(STOCK_LOW_EXCHANGE);
    }
}
