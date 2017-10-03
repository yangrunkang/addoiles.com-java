package service;

import com.addoiles.common.Page;
import com.addoiles.entity.Hots;

import java.util.List;

/**
 * 热门动弹
 * Created by bla on 9/24/2017.
 */
public interface HotsService {

    /**
     * 获取最新发表的动弹
     * @return
     */
    List<Hots> getLatestHots(Page page);

    /**
     * 新增热门
     * @param hots
     * @return
     */
    Integer addHots(Hots hots);

}
