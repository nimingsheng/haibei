package com.nms.mydemo.seashell.httputils;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by my on 2016/3/4.
 */
public class HttpUtils {
    private static ExecutorService mExecutorService;
    private static RequestCallBack mRequestCallBack;

    static {
        mExecutorService = Executors.newFixedThreadPool(4);
    }
    static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mRequestCallBack != null&&msg.obj != null){
                    mRequestCallBack.onSuccess(msg.obj.toString(), msg.what);
            }
        }
    };
    public static void requestPost(final String path,final RequestCallBack callBack,final Map<String,String> map,final int requestCode) {
        mRequestCallBack = callBack;

        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.d("demo", "run: --------------+11111111111111111111111111111");
                String result = httpPost(path, map);
                Message msg = handler.obtainMessage();
                msg.obj = result;
                msg.what = requestCode;
                handler.sendMessage(msg);
        }
        });
    }

    public static void requestGet(final String path,final RequestCallBack callBack,final int requestCode) {
        mRequestCallBack = callBack;
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                String result = httpGet(path);
                Message msg = handler.obtainMessage();
                msg.obj = result;
                msg.what = requestCode;
                handler.sendMessage(msg);
                Log.d("demo", "run: --------------1111111111111111111111");
            }
        });
    }
    public static String httpPost(String path,Map<String,String> map){
        InputStream is = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            String paramStr = getPostParams(map);
            connection.getOutputStream().write(paramStr.getBytes());
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                is = connection.getInputStream();
                StringBuffer sb = new StringBuffer();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer))!= -1){
                    sb.append(new String(buffer,0,len));
                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    private static String getPostParams(Map<String,String> map) {
        //kay=value&kay2=value2
        Set set = map.entrySet();
        StringBuffer sb = new StringBuffer();
        for (Object obj : set){
            sb.append(sb).append("&");
        }
        return sb.substring(0,sb.length()-1);
    }

    public static String httpGet(String path){
        InputStream is = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                is = connection.getInputStream();
                StringBuffer sb = new StringBuffer();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer))!= -1){
                    sb.append(new String(buffer,0,len));
                }
                return sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

}
