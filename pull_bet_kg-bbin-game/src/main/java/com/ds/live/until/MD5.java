package com.ds.live.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Zhali
 * @Description:
 * @Date: Create in 2018-10-01 16:46
 */
public class MD5 {
    public static String getMD5(String str){
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                int i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
