package com.addoiles.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * author:      Yangrunkang
 * DateTime:  2017/7/28 10:15
 */
public class OilUtils {

    /**
     * 整除起始值
     */
    private static Integer index = 2;

    /**
     * 内容长度小于50不分割
     */
    private static Integer CONTENT_LENGTH = 100;

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

    }

    /**
     * 正则表达式预编译 提高匹配速度
     */
    private static Pattern pattern = Pattern.compile("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>");
    private static String handleHtmlToNormalWords(String content) {
        Matcher m = pattern.matcher(content);
        if (m.find()) {
            content = content.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
            content = handleHtmlToNormalWords(content);
        }
        return content;
    }

    /**
     * 获取部分内容
     * @param content
     * @return
     */
    private static String getPartContent(String content) {
        String partContent;
        if (content.length() < CONTENT_LENGTH) {
            partContent = content;
            index = 2;
            return partContent;
        }


        String substring = content.substring(0, content.length() / index);
        index += 1;

        //递归
        return OilUtils.getPartContent(substring).concat("....");
    }


}
