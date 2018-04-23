package com.xvshu.dingding.dingdingmsg;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.Map;

/**
 * Created by xvshu on 2018/4/21.
 */
public class DateNLToDing {

    public static int lunarYear ;
    public static int lunarMonth ;
    public static int lunarDay ;

    public static int year ;
    public static int month ;
    public static int day ;

    public static String toDing(String input){
        Gson gson=new Gson();
        Map map = gson.fromJson(input,Map.class);
        Map mapd = (Map)map.get("data");
        String lunarYear = String.valueOf(((Double) mapd.get("lunarYear")).intValue());
        String cnmonth = (String)mapd.get("cnmonth");
        String cnday = (String)mapd.get("cnday");

        DateNLToDing.lunarYear=((Double) mapd.get("lunarYear")).intValue();
        DateNLToDing.lunarMonth=((Double) mapd.get("lunarMonth")).intValue();
        DateNLToDing.lunarDay=((Double) mapd.get("lunarDay")).intValue();

        String year = String.valueOf(((Double) mapd.get("year")).intValue());
        String month = String.valueOf(((Double) mapd.get("month")).intValue());
        String day = String.valueOf(((Double) mapd.get("day")).intValue());

        DateNLToDing.year=((Double) mapd.get("year")).intValue();
        DateNLToDing.month=((Double) mapd.get("month")).intValue();
        DateNLToDing.day=((Double) mapd.get("day")).intValue();

        String result = "";
        result="您好，今天是\n阳历"+year+"年 "+month+"月 "+day+"日 \n农历"+lunarYear+"年 "+cnmonth+"月 "+cnday+"\n";
        System.out.println(result);
        return result;
    }
}
