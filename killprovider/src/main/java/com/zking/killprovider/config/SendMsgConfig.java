package com.zking.killprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 周生洪
 * @Date 2021/4/23 20:01
 * @Version 1.0
 */
@Configuration
public class SendMsgConfig {

    //定义队列
    private  static final String NORMALMSG_QUEUE="nomalmsgQueue";
    private static final String DEADMSG_QUEUE="deadmsgQueue";


    //定义交换机
    private static final String NORMALMSG_EXCHANGE="normalmsgExchange";
    private static final String DEADMSG_EXCHANGE="deadmsgExchange";

    //定义路由键
    private static final String NORMALMSG_ROUTING="normalmsgRouting";
    private static final String DEADMSG_ROUTING="deadmsgRouting";



    //定义普通队列
    @Bean
    public Queue deadMsgQueue(){
        return new Queue(DEADMSG_QUEUE,true);
    }

    //定义交换机
    @Bean
    public DirectExchange deadMsgExchange(){
        return new DirectExchange(DEADMSG_EXCHANGE);
    }


    @Bean
    public Binding deadMsgBinding(){
        return BindingBuilder.bind(deadMsgQueue()).to(deadMsgExchange()).with(DEADMSG_ROUTING);
    }


    //死信交换机
    @Bean
    public Queue normalMsgQueue(){
        Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("x-message-ttl", 10000);//message在该队列queue的存活时间最大为10秒
        arguments.put("x-dead-letter-exchange", DEADMSG_EXCHANGE); //x-dead-letter-exchange参数是设置该队列的死信交换器（DLX）
        arguments.put("x-dead-letter-routing-key", DEADMSG_ROUTING);//x-dead-letter-routing-key参数是给这个DLX指定路由键
        return new Queue(NORMALMSG_QUEUE, true, false, true, arguments);
    }

    @Bean
    public DirectExchange normalMsgExchange(){
        return new DirectExchange(NORMALMSG_EXCHANGE);
    }

    @Bean
    public Binding normalMsgBinding(){
        return BindingBuilder.bind(normalMsgQueue()).to(normalMsgExchange()).with(NORMALMSG_ROUTING);
    }


}
