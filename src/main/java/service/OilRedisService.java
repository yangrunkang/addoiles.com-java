package service;

import com.addoiles.entity.NavSettings;
import com.addoiles.entity.User;

import java.util.List;

/**
 * Description:
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/30 16:53
 */

public interface OilRedisService {

    /**
     * 获取所有用户Id-Name集合
     * @param reload 是否重载
     * @return
     */
    List<User> getUsersIdsNames(Boolean reload);


    /**
     * 缓存用户验证码
     * @param email
     * @param code
     * @return
     */
    void cacheUserVerifyCode(String email,String code);

    /**
     * 根据邮箱获取验证码
     * @param email
     * @return
     */
    String getVerifyCodeByEmail(String email);


    List<NavSettings> getNavList();

}
