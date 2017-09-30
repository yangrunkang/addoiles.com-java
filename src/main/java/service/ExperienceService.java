package service;

import com.addoiles.common.Page;
import com.addoiles.entity.Experience;

import java.util.List;

/**
 * Created by bla on 9/24/2017.
 */
public interface ExperienceService {

    /**
     * 添加经历
     * @param experience
     * @return
     */
    Integer addExperience(Experience experience);

    /**
     * 获取经历列表
     * @param page
     * @return
     */
    List<Experience> selectExperienceList(Page page);

}
