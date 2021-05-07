package com.zking.killprovider.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    private static final SimpleDateFormat dateFormateOne=new SimpleDateFormat("yyyyMMddHHmmssSS");
    private static final ThreadLocalRandom random=ThreadLocalRandom.current();
    /**
     * 生成订单编号-方式一
     * @return
     */
    public static String generateOrderCode(){
        //时间戳+N为随机数流水号
        return dateFormateOne.format(DateTime.now().toDate())+generateNumber(4);
    }

    public static String generateNumber(final int num){
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=num;i++){
              sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for(int i=1;i<=100000;i++){
            System.out.println(generateOrderCode());
        }
    }



}
