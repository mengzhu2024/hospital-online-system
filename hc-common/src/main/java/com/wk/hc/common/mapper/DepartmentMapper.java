package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    List<Department> list(@Param("name") String name);

    @Insert("insert into department(name,tel) values(#{name}, #{tel})")
    void save(Department d);

    @Update("update department set name = #{name},tel = #{tel} where id = #{id}")
    void update(Department d);

    @Select("select * from department where id = #{id}")
    Department selectById(String id);

    @Select("select * from department where name = #{name}")
    Department selectByName(String name);
    void doDelete(String... ids);


    @Select("Select * from department")
    List<Department> select();
}
