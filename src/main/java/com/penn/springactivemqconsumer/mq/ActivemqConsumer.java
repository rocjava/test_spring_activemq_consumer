package com.penn.springactivemqconsumer.mq;

import org.apache.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ActivemqConsumer implements MessageListener {

    final Logger logger = Logger.getLogger(ActivemqConsumer.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        try {
            logger.info("接收到queue消息：" + textMsg.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
