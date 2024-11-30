package com.wk.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.Schedule;
import com.wk.hc.common.mapper.ScheduleMapper;
import com.wk.hc.common.service.IScheduleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements IScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;
    @Override
    public TableVO getList(String username, String name, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return TableVO.data(scheduleMapper.getList(username, name));
    }

    @Override
    public Schedule getInfoById(String id) {
        return baseMapper.selectById(id);
    }

    @Override
    public ResultVO deleteDoctor(String ids) {
        scheduleMapper.doDelete(ids.split(","));
        return new ResultVO();
    }

    @Override
    public List<LocalDate> getDates(String uid) {
        return scheduleMapper.getDates(uid);
    }

    @Override
    public List<String> getTimes(String uid) {
        return scheduleMapper.getTimes(uid);
    }
}
