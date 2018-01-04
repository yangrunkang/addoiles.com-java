package com.addoiles.util;

import java.util.UUID;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:15
 */
public class OilUtils {

    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();

    static{
        integerThreadLocal.set(2);
    }

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
//        String encrypt = OilUtils.encrypt("asfavklzxhfiashf90y389462*%^&*%&423124456HJKKLG");
//        System.out.println(encrypt.length());
        System.out.println(OilUtils.getPartContent("23142323142323"));
    }

    private static String handleHtmlToNormalWords() {

        return null;
    }

    private static String getPartContent(String content) {
        String partContent;
        if (content.length() < 50) {
            partContent = content;
            integerThreadLocal.set(2);
            return partContent;
        }

        //可以会采用递归
        String substring = content.substring(0, content.length() / integerThreadLocal.get());
        integerThreadLocal.set(integerThreadLocal.get() + 1);
        getPartContent(substring);

        return null;
    }


}
