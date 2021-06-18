package com.ff.util.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ff.vo.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MusicService
 * @Description TODO
 * @Author ff
 * @Date 2020/4/14 13:35
 * @ModifyDate 2020/4/14 13:35
 * @Version 1.0
 */

@Component
public class MusicService {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Value("${musicSearchUrl}")
    private String musicSearchUrl;

    @Value("${randomMusicPlay}")
    private String randomMusicPlay;


    /*
     * @author: ff
     * @date: 2020/4/14 14:09
     * @param: [key]
     * @return: java.lang.String
     * @Dscribe:搜索歌曲返回歌曲id
     */
    public SongEntity searchMusicId(String key){

        SongEntity songEntity=new SongEntity();
        String musicId="";

        JSONObject jsonObject=restTemplateUtil.commonGetRestTemplateUtil(musicSearchUrl,key);

        List<String > list= JSON.parseArray(StaticUtil.getJsonObjectValueByKeyName(StaticUtil.getJsonObjectValueByKeyName(jsonObject.toString(),"data"),"songs"),String.class);

       // List<String > list= JSON.parseArray(jsonObject.get("data").toString(),String.class);

        if (jsonObject.get("code").toString().equals("200") && list.size()!=0){

            musicId=JSON.parseObject(list.get(0)).get("id").toString();

            List<String> artists=JSON.parseArray(StaticUtil.getJsonObjectValueByKeyName(list.get(0),"artists"),String.class);

            songEntity.setSinger(StaticUtil.getJsonObjectValueByKeyName(artists.get(0),"name"));
        }

        songEntity.setMusicId(musicId);


        return songEntity;
    }



/*    public String randomMusicPlayUrl(){

        restTemplateUtil.commonPostRestTemplateUtil(randomMusicPlay)

        return"";
    }*/


}
