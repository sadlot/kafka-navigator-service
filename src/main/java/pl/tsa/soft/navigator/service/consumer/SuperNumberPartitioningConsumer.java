/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import pl.tsa.soft.navigator.service.model.SuperNumber;
import pl.tsa.soft.navigator.service.redis.SuperNumberRepository;
import pl.tsa.soft.navigator.service.redis.entity.SuperNumberEntity;

/**
 *
 * @author potatolot
 */
@Component
public class SuperNumberPartitioningConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberPartitioningConsumer.class);
    private final SuperNumberRepository superNumberRepository;

    public SuperNumberPartitioningConsumer(SuperNumberRepository superNumberRepository) {
        this.superNumberRepository = superNumberRepository;
    }

    @KafkaListener(id = "consumerPartition0", topicPartitions
            = {
                @TopicPartition(topic = "superNumber", partitions = {"0"})
            })
    public void consumePartition0(SuperNumber superNumber) {

        LOGGER.info("RECEIVED SUPER EXTRA MESSAGE {}", superNumber.getNumber());
        SuperNumberEntity s = superNumberRepository.save(
                mapToEntity(superNumber));
        LOGGER.info("SuperNumber saved in Redis {}", s.toString());
    }

    @KafkaListener(id = "consumerPartition1", topicPartitions
            = {
                @TopicPartition(topic = "superNumber", partitions = {"1"})
            })
    public void consumePartition1(SuperNumber superNumber) {
        LOGGER.info("Received normal number {}", superNumber.getNumber());
        SuperNumberEntity s = superNumberRepository.save(
                mapToEntity(superNumber));
        LOGGER.info("SuperNumber saved in Redis {}", s.toString());
    }

    @KafkaListener(id = "consumerPartition2", topicPartitions
            = {
                @TopicPartition(topic = "superNumber", partitions = {"2"})
            })
    public void consumePartition2(SuperNumber superNumber) {

        LOGGER.info("Received abnormal number {}", superNumber.getNumber());
        SuperNumberEntity s = superNumberRepository.save(
                mapToEntity(superNumber));
        LOGGER.info("SuperNumber saved in Redis {}", s.toString());
    }

    private SuperNumberEntity mapToEntity(SuperNumber superNumber) {
        SuperNumberEntity superNumberEntity = new SuperNumberEntity();
        superNumberEntity.setNumber(superNumber.getNumber());
        superNumberEntity.setOwner(superNumber.getOwner());
        superNumberEntity.setTimestamp(superNumber.getTimestamp());
        superNumberEntity.setId(UUID.randomUUID().toString());
        return superNumberEntity;
    }

}
