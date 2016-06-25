package com.flyonthemap.wheather;

/**
 * Created by flyonthemap on 16/6/24.
 */

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * 根据城市名/id查询天气
 * @author silk
 *
 */
public class WeatherReportByCity {

    private static WeatherBean weatherBean;



    /**
     * 根据城市名获取
     * @param cityName
     * @return
     */


    public static String execute(String cityName) {
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
               Config.CITY_NAME_URL+cityName+"&key="+Config.WEATHER_KEY;
//        String url = "https://www.baidu.com";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @param city
     * @return
     */
    public static WeatherBean getWeatherByCity(String city) {
        weatherBean = new WeatherBean();
        Log.d(Config.TAG,city);
        String result=Config.TEST;
//        String result = execute(city);
        if(result!=null){
            JSONObject obj= null;
            try {
                obj = new JSONObject(result);
                /*获取返回状态码*/
                String resultcode = obj.getString(Config.RESULTCODE);

                /*如果状态码是200说明返回数据成功*/
                if(resultcode != null && resultcode.equals(Config.SUCCESS_RESULT_CODE)) {
                    Log.d(Config.TAG+resultcode,resultcode);
                    JSONObject resultJSON = new JSONObject(obj.getString(Config.RESULT));
//                    获取今天的天气信息
                    Log.d(Config.TAG+"result",resultJSON.toString());
                    getTodayWeather(resultJSON,Config.TODAY);

//                    获取当前时刻的天气信息
//                    getCurrentWeather(resultJSON,Config.CURRENT_WEATHER);
//                    获取未来几天的天气信息
                    getFutureWeather(resultJSON,Config.FUTURE_WEATHER);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
//        Log.d(Config.TAG,city+"end");
        return weatherBean;
    }

    private static void getFutureWeather(JSONObject resultJSON, String futureWeather) throws JSONException {
//        暂时简单获取填充天气信息，后面打算将天气信息制作成图表的形式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        JSONObject futureJSON = resultJSON.getJSONObject(futureWeather);
        Iterator<String> iterator = futureJSON.keys();
        Date date = new Date(System.currentTimeMillis());
        Date dateF = null;
        List<FutureWeatherBean> futureList = new ArrayList<>();
        while (iterator.hasNext()){

            FutureWeatherBean futureWeatherBean = new FutureWeatherBean();
            JSONObject temp = futureJSON.getJSONObject(iterator.next());
            futureWeatherBean.setTemp(temp.getString(Config.TEMPERATURE));

            futureWeatherBean.setWeatherId(temp.getJSONObject(Config.WEATHER_ID).getString(Config.FA));
            try {
                dateF = simpleDateFormat.parse(temp.getString(Config.DATE));

            } catch (ParseException e) {
                e.printStackTrace();
            }
            futureWeatherBean.setDate(dateF);
            futureWeatherBean.setWeek(temp.getString(Config.WEEK));
            futureList.add(futureWeatherBean);
        }
        Iterator<FutureWeatherBean> iter = futureList.iterator();
        while (iter.hasNext()){
            Log.d(Config.TAG,iter.next().getDate().toString());
        }
//        Log.d(Config.TAG,futureList.toString());
        weatherBean.setFutureList(futureList);
//        Log.d(Config.TAG,dateF.toString());
    }

    private static void getCurrentWeather(JSONObject resultJSON, String strCurrent) throws JSONException {
        JSONObject currentJSON = new JSONObject(resultJSON.getString(strCurrent));
        weatherBean.setTempCurrent(currentJSON.getString(Config.TEMPERATURE_CURRENT));
        weatherBean.setInfoWind(currentJSON.getString(Config.WIND_DIRECTION)+currentJSON.getString(Config.WIND_STRENGTH));
        weatherBean.setInfoHumidity(currentJSON.getString(Config.HUMIDITY));
        weatherBean.setRelease(currentJSON.getString(Config.RELEASE));
    }

    private static void getTodayWeather(JSONObject resultJSON, String strToday) throws JSONException {
        JSONObject todayJSON = new JSONObject(resultJSON.getString(strToday));
        Log.d(Config.TAG,todayJSON.getString(Config.UV_INDEX)+"get");
        weatherBean.setCity(todayJSON.getString(Config.CITY));
        weatherBean.setInfoUvIndex(todayJSON.getString(Config.UV_INDEX));
        weatherBean.setInfoDressingIndex(todayJSON.getString(Config.DRESSING_INDEX));
        weatherBean.setWeatherId(todayJSON.getJSONObject(Config.WEATHER_ID).getString(Config.FA));
        weatherBean.setWeatherStr(todayJSON.getString(Config.WEATHER));
        weatherBean.setTemp(todayJSON.getString(Config.TEMPERATURE));
    }


}
