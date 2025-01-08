/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import pl.tsa.soft.navigator.service.consumer.SuperNumberPartitioningConsumer;
import pl.tsa.soft.navigator.service.model.SuperNumber;

/**
 *
 * @author potatolot
 */
@Component
public class SuperNumberBingoConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberBingoConsumer.class);

    //@KafkaListener(topics = "bingos")
    public void consumePartition0(SuperNumber superNumber) {

        LOGGER.info("WE HAVE A BINGO {}", superNumber.getNumber());

    }
}
