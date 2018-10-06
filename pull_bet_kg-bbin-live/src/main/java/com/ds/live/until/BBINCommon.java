package com.ds.live.until;

import java.util.Map;

/**
 * @Author: Zhali
 * @Description:
 * @Date: Create in 2018-10-02 9:49
 */
public class BBINCommon {

    //秘钥
    public final static String USERKEY = "ff6829525ef73d279117";

    /**
     　　* 按照“参数=参数值”的模式用“&”字符拼接成字符串
     　　* @param params 需要排序并参与字符拼接的参数组
     　　* @return 拼接后字符串
     　　*/
    public static String mapToString(Map<String, String> params) {
        if(null == params || params.isEmpty()){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        params.forEach((k,v)-> sb.append(k+"="+v+"&"));
        if(sb.length() > 0){
            return sb.substring(0,sb.length()-1);
        }
        return null;
    }

}
