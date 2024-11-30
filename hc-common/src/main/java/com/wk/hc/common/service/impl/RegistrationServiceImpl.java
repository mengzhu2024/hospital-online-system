package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.Registration;
import com.wk.hc.common.entity.Schedule;
import com.wk.hc.common.entity.User;
import com.wk.hc.common.mapper.RegistrationMapper;
import com.wk.hc.common.mapper.ScheduleMapper;
import com.wk.hc.common.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.vo.DoctorVO;
import com.wk.hc.common.vo.RegistrationVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Override
    public TableVO listAll(String name,String status,Integer page,Integer limit) {
        PageHelper.startPage(page, limit);
        List<RegistrationVO> list = registrationMapper.listAll(name,status);
        return TableVO.data(list);
    }

    @Override
    public TableVO listByDoctor(String name,String status,Integer page,Integer limit) {
        User u = (User) RequestUtil.getCurrent();
        PageHelper.startPage(page, limit);
        List<RegistrationVO> list = registrationMapper.listByDoctor(u.getId(),name,status);
        return TableVO.data(list);
    }

    @Override
    public TableVO listByPatient(String patientId,Integer page,Integer limit) {
        PageHelper.startPage(page, limit);
        List<RegistrationVO> list = registrationMapper.listByPatient(patientId);
        return TableVO.data(list);
    }

    @Override
    public ResultVO cacel(String rid) {

        return null;
    }

    @Override
    public boolean isMax(String userId, String date, String time) {
        Long l = registrationMapper.selectCount(new QueryWrapper<Registration>()
                .eq("user_id", userId)
                .eq("date", date)
                .eq("time", time));
        Schedule s = scheduleMapper.selectOne(new QueryWrapper<Schedule>().eq("user_id", userId));
        if (l >= s.getMaxNum()) {
            return true;
        } else {
            return false;
        }
    }
}
