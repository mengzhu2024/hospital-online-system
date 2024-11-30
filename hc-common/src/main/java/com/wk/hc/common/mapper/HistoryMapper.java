package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.History;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.HistoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface HistoryMapper extends BaseMapper<History> {

    List<HistoryVo> getList(@Param("pName") String pName,@Param("deptId") String deptId);

    List<HistoryVo> getListByPatient(String patientId);
}
