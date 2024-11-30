package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface PatientMapper extends BaseMapper<Patient> {
    @Select("select * from patient where username = #{username}")
    Patient selectByUsername(String username);

    List<Patient> lista(@Param("username") String username, @Param("status") String status);

    void updateStatus(@Param("status") String status, @Param("ids") String[] split);

    void resetPassword(@Param("ids") String[] split,@Param("password")String password);
}
