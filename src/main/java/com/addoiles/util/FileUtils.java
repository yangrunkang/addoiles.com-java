package com.addoiles.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2018/4/23 19:20
 */
public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 判断文件是否存在
     *
     * @param file
     */
    public static void isMkdirs(File file) {

        if (file.exists()) {
            logger.info(file.getPath() + " exists");
        } else {
            logger.info(file.getPath() + " not exists, create it ...");
            try {
                file.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void isMakeFile(File file) {

        if (file.exists()) {
            logger.info(file.getName() + " exists");
        } else {
            logger.info(file.getName() + " not exists, create it ...");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void deleteFile(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("delete file error,{}", e);
        }
    }

}
