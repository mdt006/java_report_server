package com.ds.live.until;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @Author: Zhali
 * @Description:
 * @Date: Create in 2018-10-02 9:53
 */
public class EncryptUtils {

    /**
     * 返回数组加密后的md5值
     * @param strArr
     * @return
     */
    private static String encrypt(String[] strArr,String userkey){
        if(strArr.length == 0 || userkey == null){
            return null;
        }
        Arrays.sort(strArr);
        StringBuffer sb = new StringBuffer();
        for (String str : strArr) {
            sb.append(StringUtils.substringAfter(str, "="));
        }
        sb.append(userkey);
        return MD5.getMD5(sb.toString());
    }

    /**
     * 加密
     * @param param
     * @return
     */
    public static String encrypt(String param,String userkey) {
        String [] strArr = param.split("\\&");
        if(strArr.length == 0 || userkey == null){
            return null;
        }

        return encrypt(strArr,userkey);
    }

}
