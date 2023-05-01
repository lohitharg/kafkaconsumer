package com.example.kafkaconsumer.service;


import com.example.kafkaconsumer.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component

public class Consumer {
    @KafkaListener(topics="firsttopic",groupId = "0")
    public void consumefirstmessage(String st) throws JsonProcessingException {

        ObjectMapper ob=new ObjectMapper();
        Employee em=ob.readValue(st,Employee.class);
System.out.println("message"+em);
    }


}
