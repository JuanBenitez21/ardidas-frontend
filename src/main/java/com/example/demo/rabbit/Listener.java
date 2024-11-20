package com.example.demo.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    @RabbitListener
    public void escucharOrden(){
        log.info("EscucharOrden");
    }
}
