package com.zking.killprovider.service.Impl;

import com.zking.killcommon.dto.ItemKillDTO;
import com.zking.killcommon.dto.ItemKillSuccessDTO;
import com.zking.killprovider.mapper.ItemKillMapper;
import com.zking.killprovider.mapper.ItemKillSuccessMapper;
import com.zking.killprovider.service.ItemKillSuccessService;
import com.zking.killprovider.utils.SnowFlake;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 周生洪
 * @Date 2021/4/23 15:12
 * @Version 1.0
 */
@Service
public class ItemKillSuccessServiceImpl implements ItemKillSuccessService {

    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String goKill(Integer killId, Integer userId) {
        String msg="";
        /*
        开始秒杀:
          1.判断该活动是否支持秒杀（时间，库存）
          2.判断用户是否已经参与过有效的改秒杀活动
         */
        ItemKillDTO itemKillDTO=canKill(killId);
        if(itemKillDTO.getCankill()==1){
            if(selectCount(killId,userId)==0){
                ItemKillSuccessDTO itemKillSuccessDTO=new ItemKillSuccessDTO();
                SnowFlake snowFlake = new SnowFlake(2, 3);
                itemKillSuccessDTO.setCode(snowFlake.nextId()+"");
                itemKillSuccessDTO.setItemId(itemKillDTO.getItemId());
                itemKillSuccessDTO.setKillId(killId);
                itemKillSuccessDTO.setUserId(userId+"");
                int n = insertSelective(itemKillSuccessDTO);
                if(n<=0){
                    msg="秒杀失败";
                }else{
                    msg="秒杀成功";
                    //秒杀成功，发送到消息队列里面去
                    sendMsg(itemKillSuccessDTO);
                }
            }else{
                msg="您已经参与过该秒杀互动";
            }
        }else{
            msg="该商品活动已经过期或者库存不够";
        }

        return msg;
    }

    @Override
    public void selectById(String code) {
        ItemKillSuccessDTO itemKillSuccessDTO= itemKillSuccessMapper.selectById(code);
        if(itemKillSuccessDTO.getStatus()==0){
            itemKillSuccessMapper.updateStatus(code);
        }

    }


    private int insertSelective(ItemKillSuccessDTO itemKillSuccessDTO){
        return itemKillSuccessMapper.insertSelective(itemKillSuccessDTO);
    }



    //在新增订单之前，需要判断
    private ItemKillDTO canKill(Integer killId){
        return itemKillMapper.selectById(killId);
    }

    //判断用户是否参与过有效的活动
    private int selectCount(Integer killId,Integer userId){
        return itemKillSuccessMapper.selectCount(killId,userId);
    }


    //将订单送入到消息队列中
    public void sendMsg(ItemKillSuccessDTO itemKillSuccessDTO){
        rabbitTemplate.convertAndSend("normalmsgExchange","normalmsgRouting",itemKillSuccessDTO);
    }
}
