package com.flyonthemap.wheather;

import java.util.Date;

/**
 * Created by flyonthemap on 16/6/24.
 * 描述未来几天的天气信息，类的定义结构是根据文档返回的json数据类型进行定义的
 */
public class FutureWeatherBean {
//     星期
    private String week;
//    温度
    private String temp;
//    天气的标识符
    private String weatherId;
//    日期
    private Date date;

    public String getWeek() {
        return week;
    }

    public String getTemp() {
        return temp;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public Date getDate() {
        return date;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
