package service;

import com.addoiles.entity.NavSettings;

import java.util.List;


/**
 * 获取导航栏
 * Created by bla on 10/1/2017.
 */
public interface NavSettingsService {
    /**
     * 获取有效导航栏
     * @return
     */
    List<NavSettings> getNavs();
}
