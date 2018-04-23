package com.xvshu.dingding.dingdingmsg;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xvshu on 2018/4/11.
 */
public class DingDingMsg {

    private static final String dingdingUrlhuanle ="https://oapi.dingtalk.com/robot/send?access_token=****";

    private static final Logger logger = LoggerFactory.getLogger(DingDingMsg.class);

    public static void sendMsg(String msg, List<String> mobailNos){

        try {
            DingMsgEntity dingMsgEntity = new DingMsgEntity();
            dingMsgEntity.getText().setContent(msg);
            if(mobailNos!=null && mobailNos.size()>0){
                dingMsgEntity.getAt().setAtMobiles(mobailNos);
            }else{
                dingMsgEntity.getAt().setAtAll(true);
            }

            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(dingdingUrlhuanle);
            httppost.addHeader("Content-Type", "application/json; charset=utf-8");
            Gson gson = new Gson();
            String dingMsg = gson.toJson(dingMsgEntity);
            logger.info("gson result is :{}",dingMsg);
            StringEntity se = new StringEntity(dingMsg, "utf-8");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                logger.info("=DingDingMsg.sendMsg=>钉钉机器人发送成功，结果为：{}",result);
            }else{
                logger.info("=DingDingMsg.sendMsg=>钉钉机器人发送失败，结果为：{}",response.getStatusLine().getStatusCode());
            }
        }catch (Exception ex){
            logger.error("=DingDingMsg.sendMsg=>钉钉机器人发送失败，原因是：",ex);
        }

    }
}
