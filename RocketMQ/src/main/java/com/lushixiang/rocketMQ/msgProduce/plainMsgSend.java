package com.lushixiang.rocketMQ.msgProduce;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.nio.ByteBuffer;

public class plainMsgSend {
    public static void main(String[] args) throws Exception {
        // 初始化一个producer并设置Producer group name
        DefaultMQProducer producer = new DefaultMQProducer("MqGroup-lushixiang"); //（1）
        // 设置NameServer地址
        producer.setNamesrvAddr("43.143.106.57:9876");  //（2）
        // 启动producer
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建一条消息，并指定topic、tag、body等信息，tag可以理解成标签，对消息进行再归类，RocketMQ可以在消费端对tag进行过滤
            Message msg = new Message("Topic-lushixiang-broker-b" /* Topic */,
                    "Tag-lushixiang" /* Tag */,
                    ("WTF RocketMQ  " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );   //（3）
            // 利用producer进行发送，并同步等待发送结果
            SendResult sendResult = producer.send(msg);   //（4）
            System.out.printf("%s%n", sendResult);
        }
        // 一旦producer不再使用，关闭producer
        producer.shutdown();
    }
    private void testByteBuffer(){
//        ByteBuffer
        plainMsgSend plainMsgSend = new plainMsgSend();
        Class<? extends com.lushixiang.rocketMQ.msgProduce.plainMsgSend> aClass = plainMsgSend.getClass();
    }
}
