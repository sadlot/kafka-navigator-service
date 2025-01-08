/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pl.tsa.soft.navigator.service.model.SuperNumber;

/**
 *
 * @author potatolot
 */
@Component
public class SuperNumberConsumer implements MessageConsumer<SuperNumber> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberConsumer.class);

    //@KafkaListener(topics = "superNumber", concurrency = "2")
    @Override
    public void consume(SuperNumber message) {
//        try {
            LOGGER.info("Consumed super number {}", message.getNumber());
//        } catch (JsonProcessingException ex) {
//            LOGGER.error("JSON deserialization has failed for message: {}", message, ex);
//        }
    }

}
