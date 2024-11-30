package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.DoctorVO;
import com.wk.hc.common.vo.RegistrationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface RegistrationMapper extends BaseMapper<Registration> {

    List<RegistrationVO> listAll(@Param("name") String name,@Param("status") String status);

    List<RegistrationVO> listByDoctor(@Param("id") Integer id,@Param("name") String name,@Param("status") String status);

    List<RegistrationVO> listByPatient(String patientId);
}
