package com.management.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CustomKafkaListener {
    private int count=1;

    @Autowired
    @Qualifier("customKafkaListenerContainerFactory")
    ConcurrentKafkaListenerContainerFactory customKafkaListenerContainerFactory;
    @Autowired
    KafkaProducerConfig kafkaProducerConfig;

//    @KafkaListener(topics = "quickstart-events-aditya")
//    void listener(@Payload String data,
//                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                  @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts ) {
//        System.out.println("event="+data);
//        System.out.println("topic->"+topic);
//    }

    @KafkaListener(id = "sp-listen1",topics = "quickstart-events-aditya",containerFactory = "customKafkaListenerContainerFactory")
    void listenertwo(ConsumerRecord<String,String> consumerRecord) {
        String key = consumerRecord.key();
        String valu = consumerRecord.value();
        consumerRecord.partition();
                System.out.println(consumerRecord.toString());

    }
}
