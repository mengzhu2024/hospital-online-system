package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.DoctorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.entity.User;
import com.wk.hc.common.vo.DoctorVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface DoctorInfoMapper extends BaseMapper<DoctorInfo> {

    List<DoctorVO> list(@Param("username") String username,@Param("name") String name, @Param("status") String status);

    @Insert("insert into doctor_info(user_id,sex,title,dept_id,price) values(#{userId}, #{sex}, #{title}, #{deptId}, #{price})")
    void saveInfo(DoctorInfo di);

    @Update("update doctor_info set sex = #{sex},title = #{title},dept_id = #{deptId},price = #{price} where user_id = #{userId}")
    void updateInfo(DoctorInfo di);

    DoctorVO getIndoByid(String id);

    void doDelete(String[] split);

    List<DoctorVO> listByDept(Integer deptId);

    List<User> dept(String deptId);
}
