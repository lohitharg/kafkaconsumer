package com.example.kafkaconsumer.consumerConfig;

import com.example.kafkaconsumer.model.Employee;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Configu {
        @Bean
        public ConsumerFactory<String, Employee> consumerFactory()
        {
            // Creating a Map of string-object pairs
            Map<String, Object> config = new HashMap<>();
            // Adding the Configuration
            config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                    "localhost:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG,
                    "0");
            config.put(
                    ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                    StringDeserializer.class);
            config.put(
                    ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                    JsonDeserializer.class);
            return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                    new JsonDeserializer<>(Employee.class));

        }

       @Bean
        public ConcurrentKafkaListenerContainerFactory<
    String, Employee>
        concurrentKafkaListenerContainerFactory()
        {
            ConcurrentKafkaListenerContainerFactory<String, Employee> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }


    }


