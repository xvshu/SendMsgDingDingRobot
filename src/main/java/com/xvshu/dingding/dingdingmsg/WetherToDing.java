package com.xvshu.dingding.dingdingmsg;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

/**
 * Created by xvshu on 2018/4/21.
 */
public class WetherToDing {


    public static String toDing(String input){
        Gson gson=new Gson();
        Map map = gson.fromJson(input,Map.class);
        Map mapd = (Map)map.get("data");
        List forecast =(((List) mapd.get("forecast")));
        Map today = (Map)forecast.get(0);
        String todayStr = "今天的天气：\n"+today.get("type")+" "+today.get("high")+today.get("low")+" \n特别提醒："+today.get("notice")+"\n";
        Map tomaory = (Map)forecast.get(1);
        String tomaoryStr = "明天的天气：\n"+tomaory.get("type")+" "+tomaory.get("high")+tomaory.get("low")+" \n特别提醒："+tomaory.get("notice")+"\n";
        return todayStr+tomaoryStr;
    }
}
