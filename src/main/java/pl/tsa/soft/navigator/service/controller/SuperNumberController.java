/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.controller;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tsa.soft.navigator.service.model.SuperNumber;

/**
 *
 * @author potatolot
 */
@RestController
public class SuperNumberController {

    StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    public SuperNumberController(StreamsBuilderFactoryBean streamsBuilderFactoryBean) {
        this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;

    }

//    @GetMapping("/report")
//    public SuperNumberReport getReport() {
//        KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
//        ReadOnlyKeyValueStore<String, Long> counts = kafkaStreams.store(
//                StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()));
//
//        return new SuperNumberReport(counts);
//    }

}
