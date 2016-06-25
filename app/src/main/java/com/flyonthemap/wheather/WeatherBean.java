package com.flyonthemap.wheather;

import java.util.List;

/**
 * Created by flyonthemap on 16/6/24.
 * 此类主要用于主界面的消息显示
 */
public class WeatherBean {
//    城市
    private String city;
//    发布时间
    private String release;
//    当前的天气信息
    private String weatherId;
    private String weatherStr;
//  当前的温度信息
    private String temp;
    private String tempCurrent;
//    PM2.5 相关信息
    private String AQI;
    private String quality;
//    详细的天气信息
//    湿度
    private String infoHumidity;
//    风力和风向
    private String infoWind;
//    紫外线强度
    private String infoUvIndex;
//    穿衣指数
    private String infoDressingIndex;
//    未来几天的天气信息
    List<FutureWeatherBean> futureList;

    public String getCity() {
        return city;
    }

    public String getRelease() {
        return release;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public String getWeatherStr() {
        return weatherStr;
    }

    public String getTemp() {
        return temp;
    }

    public String getTempNow() {
        return tempCurrent;
    }

    public String getAQI() {
        return AQI;
    }

    public String getQuality() {
        return quality;
    }

    public String getInfoHumidity() {
        return infoHumidity;
    }

    public String getInfoWind() {
        return infoWind;
    }

    public String getInfoUxIndex() {
        return infoUvIndex;
    }

    public String getInfoDressingIndex() {
        return infoDressingIndex;
    }

    public List<FutureWeatherBean> getFutureList() {
        return futureList;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setWeatherStr(String weatherStr) {
        this.weatherStr = weatherStr;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setTempCurrent(String tempNow) {
        this.tempCurrent = tempNow;
    }

    public void setAQI(String AQI) {
        this.AQI = AQI;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    public void setInfoHumidity(String infoHumidity) {
        this.infoHumidity = infoHumidity;
    }

    public void setInfoWind(String infoWind) {
        this.infoWind = infoWind;
    }

    public void setInfoUvIndex(String infoUvIndex) {
        this.infoUvIndex = infoUvIndex;
    }

    public void setInfoDressingIndex(String infoDressingIndex) {
        this.infoDressingIndex = infoDressingIndex;
    }

    public void setFutureList(List<FutureWeatherBean> futureList) {
        this.futureList = futureList;
    }
}
