/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.tsa.soft.navigator.service.model.NavigationSnapshot;

/**
 *
 * @author potatolot
 */
@Service
class NavigationSnapshotConsumer implements MessageConsumer<String> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationSnapshotConsumer.class);
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    @KafkaListener(topics = "navigationSnapshot", concurrency = "2")
    @Override
    public void consume(String message) {
        try {
            NavigationSnapshot navigationSnapshot = objectMapper.readValue(message, NavigationSnapshot.class);
            LOGGER.info("Consumed Navigation Snapshot. Longitude/Latitide {}-{}, date {}, userName {}, serviceName {}",
                    navigationSnapshot.getLongitude(), navigationSnapshot.getLatitude(), new Date(navigationSnapshot.getSnapshotTimestamp()).toString(),
                    navigationSnapshot.getUserName(), navigationSnapshot.getServiceName());
        } catch (JsonProcessingException ex) {
            LOGGER.error("JSON deserialization has failed for message: {}", message, ex);
        }
    }
    
}
