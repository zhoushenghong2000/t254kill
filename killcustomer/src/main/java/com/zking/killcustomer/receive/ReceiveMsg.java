package com.zking.killcustomer.receive;

import com.zking.killcommon.dto.ItemKillSuccessDTO;
import com.zking.killcustomer.feign.GoodsFeign;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "deadmsgQueue")
public class ReceiveMsg {
    @Autowired
    private GoodsFeign goodsFeign;

    //生产者将对象送到消息队列里面，然后到消息队列里面拿到对象
    @RabbitHandler
    public void handleMsg(ItemKillSuccessDTO itemKillSuccessDTO){
        goodsFeign.selectSingleKillSuccess(itemKillSuccessDTO.getCode());
    }
}
