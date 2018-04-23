package com.xvshu.dingding;

import com.xvshu.dingding.utils.GetDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class DingdinghomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DingdinghomeApplication.class, args);
		while(true){
			Calendar cal = Calendar.getInstance();
			int hour=cal.get(Calendar.HOUR);//小时
			int minute = cal.get(Calendar.MINUTE);//分钟
			if(hour==20||hour==7){
				if(minute==10){
					GetDate.sendDingDingMsg();
				}

			}
			sleep1m();
		}
	}


	private static void getDate(){
		GetDate.sendDingDingMsg();
	}

	public static void sleep1m(){
		try{
			Thread.sleep(60000L);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
