package com.company;

import javax.jms.*;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

import java.util.Random;

public class SendFilter {
    public static void main(String[] args) {
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin")) {

            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            JMSProducer producer = context.createProducer();
            Destination Queue = context.createQueue("TestOrderDestinationQ");

            TextMessage message = context.createTextMessage();
            boolean isTrue = new Random().nextBoolean();
            message.setText("Filter package " + isTrue);
            message.setJMSPriority(5);
            message.setBooleanProperty("F",isTrue);
            message.setStringProperty("Filter", "Defender");

            producer.setPriority(0).send(Queue, message);

            System.out.println("OK " + isTrue);
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}