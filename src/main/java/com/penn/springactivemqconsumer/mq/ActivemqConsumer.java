package com.penn.springactivemqconsumer.mq;

import com.penn.spring.activemq.comm.po.PersonVo;
import org.apache.log4j.Logger;

import javax.jms.*;

public class ActivemqConsumer implements MessageListener {

    final Logger logger = Logger.getLogger(ActivemqConsumer.class);

    @Override
    public void onMessage(Message message) {
        ObjectMessage objMsg = (ObjectMessage) message;
        PersonVo po = null;
        try {
            po = (PersonVo) objMsg.getObject();
            if(po == null){
                logger.info("接收到queue消息：null");
                return;
            }
            if(po != null){
                logger.info("接收到queue消息：" + po.toString());
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
