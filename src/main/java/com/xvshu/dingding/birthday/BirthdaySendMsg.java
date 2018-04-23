package com.xvshu.dingding.birthday;

import com.xvshu.dingding.dingdingmsg.DateNLToDing;

import java.util.ArrayList;

/**
 * Created by xvshu on 2018/4/23.
 */
public class BirthdaySendMsg {

    private static ArrayList<BirthDayEntity> familys = new ArrayList<BirthDayEntity>();


    static{
       familys.add(new BirthDayEntity("测试","阴历",1990,3,8));
    }

    public static ArrayList<String> getBirthMsg(){
        ArrayList<String> result = new ArrayList<>();
        for(BirthDayEntity be:familys){
            if(be.BirthType.equals("阴历")
                    &&be.month== DateNLToDing.lunarMonth
                    &&be.day== DateNLToDing.lunarDay){
                StringBuffer sb = new StringBuffer();
                sb.append("\n【特别消息!】今天是"+be.name+"的"+(DateNLToDing.lunarYear-be.year)+"岁生日，在此，送上最美好的祝福！");
                sb.append("\n【特别消息!】今天是"+be.name+"的"+(DateNLToDing.lunarYear-be.year)+"岁生日，在此，送上最美好的祝福！");
                sb.append("\n【特别消息!】今天是"+be.name+"的"+(DateNLToDing.lunarYear-be.year)+"岁生日，在此，送上最美好的祝福！");
                sb.append("\n【重要的事情说三遍】^_^");
                result.add(sb.toString());
            }
        }
        return result;
    }

}
