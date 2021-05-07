package com.zking.killprovider.controller;


import com.zking.killprovider.model.t_swiper;
import com.zking.killprovider.service.SwiperService;
import com.zking.killprovider.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yf
 * @since 2020-10-12
 */
@RestController
@RequestMapping("/home")
public class SwiperController{

    @Autowired
    private SwiperService swiperService;

    /**
     * 获取轮播图数据
     * @param resp
     * @return
     */
    @RequestMapping(value = "/swiperdata")
    @ResponseBody
    public String swiperdata(HttpServletResponse resp){
        List<t_swiper> list = swiperService.list();
        CommonUtils.writeJsonData(resp,list,"获取成功","200");
        return  null;
    }

}
