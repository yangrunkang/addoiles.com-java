package com.addoiles.impl;

import com.addoiles.common.Page;
import com.addoiles.db.dao.ExperienceMapper;
import com.addoiles.entity.Experience;
import com.addoiles.util.OilUtils;
import com.addoiles.util.TimeUtil;
import org.springframework.stereotype.Service;
import service.ExperienceService;

import javax.annotation.Resource;
import java.util.List;

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
        experience.setRates(0);
        experience.setRateCount(0);
        experience.setCreateTime(TimeUtil.currentTime());
        return experienceMapper.insert(experience);
    }

    @Override
    public List<Experience> selectExperienceList(Page page) {
        return experienceMapper.selectExperienceList(page);
    }

    @Override
    public Integer updateRates(String experienceId, Integer rate) {
        Experience experience = experienceMapper.selectByExperienceId(experienceId);

        if (experience == null) return -1;

        Integer rates = experience.getRates();
        Integer rateCount = experience.getRateCount();
        //评分累加 + 次数+1
        rates += rate;
        rateCount++;

        experience.setRates(rates);
        experience.setRateCount(rateCount);
        return experienceMapper.updateByExperienceId(experience);
    }

    @Override
    public Integer updateExperience(Experience experience) {
        Experience tmp = new Experience();
        tmp.setTitle(experience.getTitle());
        tmp.setContent(experience.getContent());
        tmp.setExperienceId(experience.getExperienceId());
        tmp.setUpdateTime(TimeUtil.currentTime());
        return experienceMapper.updateSelectiveByExperienceId(tmp);
    }

    @Override
    public List<Experience> getExperienceByUserId(String userId) {
        return experienceMapper.selectByUserId(userId);
    }

    @Override
    public Integer deleteByExperienceId(String experienceId) {
        return experienceMapper.deleteByExperienceId(experienceId);
    }

    @Override
    public Experience getExperienceByExperienceId(String experienceId) {
        return experienceMapper.selectByExperienceId(experienceId);
    }
}
