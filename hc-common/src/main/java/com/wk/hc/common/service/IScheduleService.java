package com.wk.hc.common.service;

import com.wk.hc.common.entity.Schedule;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IScheduleService extends IService<Schedule> {

    TableVO getList(String username, String name, Integer page, Integer limit);

    Schedule getInfoById(String id);

    ResultVO deleteDoctor(String ids);

    List<LocalDate> getDates(String uid);

    List<String> getTimes(String uid);
}
