/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer.stream;

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
public class SuperNumberAlertConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberAlertConsumer.class);

    //@KafkaListener(topics = "bingos", groupId = "alerts")
    public void consumePartition0(SuperNumber superNumber) {

        LOGGER.info("BINGO ALERT {}", superNumber.getNumber());

    }
}
