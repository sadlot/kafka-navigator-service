/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;
import pl.tsa.soft.navigator.service.model.SuperNumber;

/**
 *
 * @author potatolot
 */
@Component
public class SuperNumberBingoStreamProcessor {

    private static final Serde<SuperNumber> SUPER_NUMBER_SERDE = new JsonSerde(SuperNumber.class);
    private static final Serde<String> STRING_SERDE = Serdes.String();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, SuperNumber> messageStream = streamsBuilder
                .stream("superNumber", Consumed.with(STRING_SERDE, new JsonSerde<>(SuperNumber.class)
                        .forKeys()
                        .noTypeInfo()));

        messageStream
                .filter((k, v) -> v.getNumber() == 10)
                .mapValues((k, v) -> buildJson(v))
                .to("bingos");

    }

    private String buildJson(SuperNumber superNumber) {
        try {
            return objectMapper.writeValueAsString(superNumber);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(SuperNumberBingoStreamProcessor.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }

}
