package com.company;

import javax.jms.*;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

public class SendSimpleQueue {
    public static void main(String[] args) {
        ConnectionFactory factory;
        factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.CLIENT_ACKNOWLEDGE)) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination Queue = context.createQueue("TestOrderDestinationQ");
            JMSProducer producer = context.createProducer();

            producer.send(Queue, "This is queue simple package");
            System.out.println("OK");
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

