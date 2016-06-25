package com.flyonthemap.wheather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

/**
 * Created by flyonthemap on 16/6/21.
 */
public class WeatherActivity extends Activity {
    private static final int REQUEST = 1;
    private PullToRefreshScrollView pullToRefreshScrollView;
    private ScrollView mScrollView;
    private TextView tvCity;
    private TextView tvPublish;
    private TextView tvNowWeather;
    private ImageView ivNowWeather;
    private TextView tvNowTemp;
    private TextView tvTodayTemp;
//    描述PM2.5
    private TextView tvAQI;
    private TextView tvQuality;
//    描述未来五小时天气
    private TextView tvNextThree;
    private TextView tvNextSix;
    private TextView tvNextNine;
    private TextView tvNextTwelve;
    private TextView tvNextFifteen;
    private ImageView ivNextThree;
    private ImageView ivNextSix;
    private ImageView ivNextNine;
    private ImageView ivNextTwelve;
    private ImageView ivNextFifteen;
//    描述未来三天的天气情况
    private TextView tvToday;
    private TextView tvTodayTempA;
    private TextView tvTodayTempB;
    private TextView tvTomorrow;
    private TextView tvTomorrowTempA;
    private TextView tvTomorrowTempB;
    private TextView tvThird;
    private TextView tvThirdTempA;
    private TextView tvThirdTempB;
    private TextView tvForth;
    private TextView tvForthTempA;
    private TextView tvForthTempB;
    private ImageView ivTodayWeather;
    private ImageView ivTomorrowWeather;
    private ImageView ivThirdWeather;
    private ImageView ivForthWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_wheather);
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = REQUEST;
                WeatherBean weatherBean = WeatherReportByCity.getWeatherByCity("上海");
                message.obj = weatherBean;
                handler.sendMessage(message);
            }
        }).start();

    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case REQUEST:
                    Log.d(Config.TAG,"hahah");
                    WeatherBean weatherBean = (WeatherBean) msg.obj;
///                    Log.d(Config.TAG,weatherBean.getInfoHumidity());
                    break;
            }
        }

    };
    private void initView(){
        pullToRefreshScrollView = (PullToRefreshScrollView) findViewById(R.id.pull_to_refresh);
        pullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {

            }
        });
        mScrollView = pullToRefreshScrollView.getRefreshableView();
//        加载顶端的控件
        tvCity = (TextView) findViewById(R.id.tv_city);
        tvPublish = (TextView) findViewById(R.id.tv_publish);
//        加载当前天气和温度的控件
        tvNowWeather = (TextView) findViewById(R.id.tv_now_weather);
        ivNowWeather = (ImageView) findViewById(R.id.iv_now_weather);
        tvNowTemp = (TextView) findViewById(R.id.tv_now_temp);
        tvTodayTemp = (TextView) findViewById(R.id.tv_today_temp);
//        加载PM2.5的控件信息
        tvAQI = (TextView) findViewById(R.id.tv_aqi);
        tvQuality = (TextView) findViewById(R.id.tv_quality);
//        加载未来十五小时的天气控件
        tvNextThree = (TextView) findViewById(R.id.tv_next_three);
        tvNextSix = (TextView) findViewById(R.id.tv_next_six);
        tvNextNine = (TextView) findViewById(R.id.tv_next_nine);
        tvNextTwelve = (TextView) findViewById(R.id.tv_next_twelve);
        tvNextFifteen = (TextView) findViewById(R.id.tv_next_fifteen);
        ivNextThree = (ImageView) findViewById(R.id.iv_next_three);
        ivNextSix = (ImageView) findViewById(R.id.iv_next_six);
        ivNextNine = (ImageView) findViewById(R.id.iv_next_nine);
        ivNextTwelve = (ImageView) findViewById(R.id.iv_next_twelve);
        ivNextFifteen = (ImageView) findViewById(R.id.iv_next_fifteen);

//        未来三天的天气和温度情况
        tvToday = (TextView) findViewById(R.id.tv_today);
        ivTodayWeather = (ImageView) findViewById(R.id.iv_today_weather);
        tvTodayTempA = (TextView) findViewById(R.id.tv_today_temp_a);
        tvTodayTempB = (TextView) findViewById(R.id.tv_today_temp_b);
        
        tvToday = (TextView) findViewById(R.id.tv_today);
        ivTomorrowWeather = (ImageView) findViewById(R.id.iv_tomorrow_weather);
        tvTomorrow = (TextView) findViewById(R.id.tv_tomorrow_temp_a);
        tvTomorrow = (TextView) findViewById(R.id.tv_tomorrow_temp_b);
        
        tvThird = (TextView) findViewById(R.id.tv_third);
        ivThirdWeather = (ImageView) findViewById(R.id.iv_third_weather);
        tvThirdTempA = (TextView) findViewById(R.id.tv_third_temp_a);
        tvThirdTempB = (TextView) findViewById(R.id.tv_third_temp_b);
        
        tvForth = (TextView) findViewById(R.id.tv_forth);
        ivForthWeather = (ImageView) findViewById(R.id.iv_forth_weather);
        tvForthTempA = (TextView) findViewById(R.id.tv_forth_temp_a);
        tvForthTempB = (TextView) findViewById(R.id.tv_forth_temp_b);
        


    }
}
