package com.ds.sgs.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.ds.msg.TelegramMessage;
import com.ds.sgs.common.BaseCommon;

public class HttpClientUtils {
	
	 private static final CloseableHttpClient httpclient = HttpClients.createDefault();
	 private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000).setConnectTimeout(15000)
			   .setConnectionRequestTimeout(15000).build();
	 
	 /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendSgsGet(String url, String signature, String sgsDate, String clientId) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json");
	    httpGet.setHeader("Authorization","SGS "+clientId+":" +signature);
	    httpGet.setHeader("X-Sgs-Date", sgsDate);
	    httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e1) {
        	TelegramMessage telegramMessage = TelegramMessage.getInstance();
        	telegramMessage.sendMessage(BaseCommon.BOT_A, BaseCommon.GROUP_JAVA, SgsConfig.TELEGRAM_HTTP_ERROR, 
        			"SGS注单拉取发送请求失败，异常："+ErrorUtil.LogExceptionStack(e1));
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String, String> map) {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e1) {
            e1.printStackTrace();
            TelegramMessage telegramMessage = TelegramMessage.getInstance();
        	telegramMessage.sendMessage(BaseCommon.BOT_A, BaseCommon.GROUP_JAVA, SgsConfig.TELEGRAM_HTTP_ERROR, 
        			"SGS注单拉取发送请求失败，异常："+ErrorUtil.LogExceptionStack(e1));
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
	
}