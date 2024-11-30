package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Schedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.ScheduleVO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface ScheduleMapper extends BaseMapper<Schedule> {

    List<ScheduleVO> getList(@Param("username") String username, @Param("name")String name);

    void doDelete(String[] split);

    List<LocalDate> getDates(String uid);

    List<String> getTimes(String uid);
}
