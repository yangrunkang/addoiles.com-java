package service;

import java.util.List;

/**
 * Description: 基础服务
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/25 14:56
 */

public interface BaseService<T> {

    /**
     * 添加
     * @param t
     * @return
     */
    int add(T t);

    /**
     * 更具id
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 更新
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 更具id获取
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 获取列表
     * @param baseQueryDto
     * @return
     */
    List<T> getList(Object baseQueryDto);

}
