package com.zking.killprovider.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @Author 周生洪
 * @Date 2021/4/23 15:11
 * @Version 1.0
 */
@Transactional
public interface ItemKillSuccessService {

        public String goKill(Integer killId,Integer userId);



        /**
         * 根据编号找到单个的订单信息
         * @param code
         * @return
         */
        void selectById(String code);

}
