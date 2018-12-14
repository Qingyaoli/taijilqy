package cn.com.taiji.redis.test.controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME cn.com.taiji.redis.test.controller
 * @USER 17862
 * @DATE 2018/12/14
 * @Description
 * 用户请求后一分钟内重复请求会显示“请求过于频繁”，请求三次后再次请求会显示“请求次数过多”
 */

@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("redis")
    public String redis(String num){

        if (!template.hasKey(num)){
           return timeController(num);
        }
        else {
          List list = template.opsForList().range(num, 0, -1);
            String b = (String) list.get(1);
            int count=Integer.parseInt(b);
            if(count==3){

                Long startTime = Long.parseLong((String) list.get(2));
                Long currytime = System.currentTimeMillis();
                if (currytime-startTime>60*1000){
                   return timeController(num);
                }else
                return "请求次数过多";

            }else {
                System.err.println(count);
                count = count+1;
                System.err.println(count);
                String starttime = (String)list.get(2);
                Long thistime = Long.parseLong((String) list.get(3));
                Long time = System.currentTimeMillis();
                String lasttime=String.valueOf(time);
                 num =String.valueOf(list.get(0));
                 String scount = String.valueOf(count);
                System.err.println(scount);
                if(System.currentTimeMillis()-thistime>10000){
                    List aList = new ArrayList();
                    aList.add(num);
                    aList.add(String.valueOf(scount));
                    aList.add(starttime);
                    aList.add(lasttime);
                    template.delete(num);
                    template.opsForList().rightPushAll(num,aList);
                    return scount;

                }else {
                    return "请求过于频繁";
                }
            }

        }
    }
    public String timeController(String num){
        int i=1;
        List arrayList = new ArrayList();
        arrayList.add(num);
        arrayList.add(String.valueOf(i));
        String startTime = String.valueOf(System.currentTimeMillis());
        String LasttTime = String.valueOf(System.currentTimeMillis());
        arrayList.add(startTime);
        arrayList.add(LasttTime);

        template.opsForList().rightPushAll(num,arrayList);

        List list = template.opsForList().range(num, 0, -1);
        System.out.println(list);
        return list.toString();
    }
}