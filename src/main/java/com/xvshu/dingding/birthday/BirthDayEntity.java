package com.xvshu.dingding.birthday;

/**
 * Created by xvshu on 2018/4/23.
 */
public class BirthDayEntity {

    //姓名
    public String name;

    //生日类型（阳历  阴历）
    public String BirthType;

    //生日年
    public int year ;

    //生日月
    public int month ;

    //生日
    public int day ;

    public BirthDayEntity(String name, String birthType, int year, int month, int day) {
        this.name = name;
        BirthType = birthType;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
