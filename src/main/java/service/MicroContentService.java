package service;

import com.addoiles.entity.MicroContent;

/**
 * Description: 微内容接口
 * All rights Reserved, Designed By HQYG
 *
 * @author Yangrunkang
 * @Copyright: Copyright(C) 2016
 * @Company: HQYG
 * @CreateDate: 2017/12/22 16:39
 */

public interface MicroContentService {

    /**
     * 添加微内容
     * @param microContent
     * @return
     */
    int addMicroContent(MicroContent microContent);

}
