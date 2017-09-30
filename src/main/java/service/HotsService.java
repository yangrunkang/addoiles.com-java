package service;

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
    List<Hots> getLatestHots();


}
