package com.example.kafkaconsumer.service;


import com.example.kafkaconsumer.model.Employee;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component

public class Consumer {
    @KafkaListener(topics="firsttopic",groupId = "0")
    public void consumefirstmessage(Employee em){
System.out.println("message"+em);
    }


}
