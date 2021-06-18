package com.ff.util.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateUtil
 * @Description TODO
 * @Author ff
 * @Date 2020/4/14 13:11
 * @ModifyDate 2020/4/14 13:11
 * @Version 1.0
 */

@Component
public class RestTemplateUtil {

    @Autowired
    private RestTemplate restTemplate;


    public JSONObject commonGetRestTemplateUtil(String url, String requestMap){

        url=url+requestMap;

        return JSON.parseObject(restTemplate.getForObject(url,String.class).toString());

    }


    public JSONObject commonPostRestTemplateUtil(String url, String requestMap){


        return JSON.parseObject(restTemplate.postForObject(url,requestMap, String.class).toString());

    }


}
