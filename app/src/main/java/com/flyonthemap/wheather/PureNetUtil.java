package com.flyonthemap.wheather;

/**
 * Created by flyonthemap on 16/6/24.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/**
 * 网络访问工具类
 * @author flyonthemap
 *
 */
public class PureNetUtil {
    private static final String PURENETUTIL = PureNetUtil.class.getSimpleName();

    /**
     * get方法直接调用post方法
     * @param url 网络地址
     * @return 返回网络数据
     */
    public static String get(String url){
        Log.d(PURENETUTIL,"enter the get");
        return post(url,null);
    }
    /**
     * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
     * @param url 网络地址
     * @param param 请求参数键值对
     * @return 返回读取数据
     */
    public static  String post(String  url,Map   param){
        Log.d(Config.TAG,"enter the post");
        HttpURLConnection conn=null;
        try {
            URL u=new URL(url);
            conn=(HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            StringBuffer sb=null;
            Log.d(Config.TAG,"connect");
            conn.connect();//建立连接
            Log.d(Config.TAG,"connect success");
            sb=new StringBuffer();
            //获取连接状态码
            int recode=conn.getResponseCode();
            BufferedReader reader=null;
            if(recode==200){
                Log.d(PURENETUTIL,"success");
                //Returns an input stream that reads from this open connection
                //从连接中获取输入流
                InputStream in=conn.getInputStream();
                //对输入流进行封装
                reader=new BufferedReader(new InputStreamReader(in));
                String str=null;
                sb=new StringBuffer();
                //从输入流中读取数据
                while((str=reader.readLine())!=null){
                    sb.append(str).append(System.getProperty("line.separator"));
                }
                //关闭输入流
                reader.close();
                if (sb.toString().length() == 0) {
                    return null;
                }
                Log.d(PURENETUTIL,sb.toString().substring(0,
                        sb.toString().length() - System.getProperty("line.separator").length()));
                return sb.toString().substring(0,
                        sb.toString().length() - System.getProperty("line.separator").length());
            }else{
                Log.d(Config.TAG,recode+"");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            if(conn!=null)//关闭连接
                conn.disconnect();
        }
        return null;
    }

}
