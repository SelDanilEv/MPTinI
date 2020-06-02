package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;

public class SendSimpleTopic {
    public static void main(String[] args) {
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.CLIENT_ACKNOWLEDGE)) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination Topic = context.createTopic("TestOrderDestinationT");
            JMSProducer producer = context.createProducer();

            producer.send(Topic, "This is topic simple package");
            System.out.println("OK");
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
