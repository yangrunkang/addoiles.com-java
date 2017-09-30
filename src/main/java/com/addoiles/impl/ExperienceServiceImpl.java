package com.addoiles.impl;

import com.addoiles.dao.ExperienceMapper;
import com.addoiles.entity.Experience;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.ExperienceService;

import javax.annotation.Resource;

/**
 * Created by bla on 9/24/2017.
 */
@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Resource
    private ExperienceMapper experienceMapper;

    @Override
    public Integer addExperience(Experience experience) {
        experience.setExperienceId(OilUtils.generateID());
        experience.setUserId(OilUtils.generateID());
        experience.setRates(0);
        experience.setCreateTime(TimeUtil.currentTime());
        return experienceMapper.insert(experience);
    }
}
