package com.xvshu.dingding.utils;

import com.google.gson.Gson;
import com.xvshu.dingding.birthday.BirthdaySendMsg;
import com.xvshu.dingding.dingdingmsg.DateNLToDing;
import com.xvshu.dingding.dingdingmsg.DingDingMsg;
import com.xvshu.dingding.dingdingmsg.DingMsgEntity;
import com.xvshu.dingding.dingdingmsg.WetherToDing;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by xvshu on 2018/4/20.
 */
public class GetDate {


    private static final String dateUrl = "https://www.sojson.com/open/api/lunar/json.shtml";
    private static final String wetherUrl = "https://www.sojson.com/open/api/weather/json.shtml?city=";

    private static ArrayList<String> citys = new ArrayList<String>();

    static{
        citys.add("廊坊");
        citys.add("北京");
        citys.add("丰润");
        citys.add("定州");
    }

    public static void sendDingDingMsg(){
        String msgDate = GetDate.getDateFromWeb();
        System.out.println(msgDate);
        ArrayList<String> msgWhe = GetDate.getWeatherFromweb();
        for(String onecity: msgWhe){
            DingDingMsg.sendMsg(msgDate+onecity,null);
        }

        ArrayList<String> msgBirth = BirthdaySendMsg.getBirthMsg();
        for(String oneBi:msgBirth){
            DingDingMsg.sendMsg(oneBi,null);
        }

    }

    public static String getDateFromWeb(){
        sleep4s();
        String jsonResult = GetDate.getHttpsReturn(dateUrl);
        System.out.println(jsonResult);
        sleep4s();
        return DateNLToDing.toDing(jsonResult);
    }

    public static ArrayList<String> getWeatherFromweb(){
        ArrayList<String> sb = new ArrayList<String>();
        for(String oneCity:citys){
            sb.add(getWherByCity(oneCity));
        }
        sleep4s();
        return sb;
    }

    private static String getWherByCity(String cityName){
        sleep4s();
        String uri = wetherUrl+cityName;
        String jsonResult = GetDate.getHttpsReturn(uri);
        System.out.println(jsonResult);
        String msg= "["+cityName+"天气]：\n"+WetherToDing.toDing(jsonResult);
        sleep4s();
        return msg;
    }

    public static String getHttpsReturn (String url) {
        String result="";
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = HttpsUtil.getHttpsURLConnection(url);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            //必须设置false，否则会自动redirect到重定向后的地址
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            result= getReturn(conn);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        sleep4s();
        return result;
    }


    /*请求url获取返回的内容*/
    public static String getReturn(HttpURLConnection connection)  {
        StringBuffer buffer = new StringBuffer();
        String result="";
        //将返回的输入流转换成字符串
        try {
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            result = buffer.toString();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    public static void sleep4s(){
        try{
            Thread.sleep(10000L);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
