package com.addoiles.util;

import java.util.UUID;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:15
 */
public class OilUtils {

    /**
     * 生成ID
     *
     * @return
     */
    public static String generateID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成随机数
     *
     * @param length 生成的随机数长度
     * @return
     */
    public static String generateRandom(int length) {
        return String.valueOf(Math.random()).substring(2, length + 2);
    }

    /**
     * 加密
     *
     * @param var
     * @return
     */
    public static String encrypt(String var) {
        String result = "error_";
        try {
            CryptoUtil des1 = new CryptoUtil();
            result = des1.encrypt(var);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 解密
     *
     * @param var
     * @return
     */
    public static String decrypt(String var) {
        String result = "error_";
        try {
            CryptoUtil des1 = new CryptoUtil();
            result = des1.decrypt(des1.encrypt(var));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {//允许明文密码长度47
        String encrypt = OilUtils.encrypt("asfavklzxhfiashf90y389462*%^&*%&423124456HJKKLG");
        System.out.println(encrypt.length());
    }

}
