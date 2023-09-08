package com.polyglot.appdeposit.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polyglot.appdeposit.model.TransactionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TransactionMessagePublish {


    @Value("${spring.kafka.template.default-topic}")
    String topicName;
    private Logger log = LoggerFactory.getLogger(TransactionMessagePublish.class);
    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    ObjectMapper objectMapper;

    public void sendDepositEvent(TransactionModel transactionModel) throws JsonProcessingException {

        String value = objectMapper.writeValueAsString(transactionModel);
        kafkaTemplate.send(topicName,value);
    }

}