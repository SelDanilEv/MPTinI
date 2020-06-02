package com.company;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class MessageReceiverFilter implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer consumerT;

    MessageReceiverFilter() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                    "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            String selector = "Filter=Defender or F=true";

            Destination Queue = context.createQueue("TestOrderDestinationQ");

            consumerT = context.createConsumer(Queue, selector);

            consumerT.setMessageListener(this);
            System.out.println("Start listening");

            Thread.sleep(1200000);
        } catch (JMSException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message body: " + message.getBody(String.class));
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MessageReceiverFilter();
    }
}