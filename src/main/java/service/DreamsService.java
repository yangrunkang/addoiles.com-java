package service;

import com.addoiles.common.Page;
import com.addoiles.entity.Dreams;

import java.util.List;

/**
 * 梦想墙
 * Created by bla on 9/24/2017.
 */
public interface DreamsService {

    /**
     * 获取梦想
     * @param page
     * @return
     */
    List<Dreams> getDreams(Page page);

    /**
     * 添加梦想
     */
    Integer addDream(Dreams dreams);

}
