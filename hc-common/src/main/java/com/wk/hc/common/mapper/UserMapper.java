package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> list(@Param("username") String username, @Param("name") String name, @Param("status") String status);

    @SelectKey(statement = "SELECT LAST_INSERT_ID() AS id", keyProperty = "id", before = false, resultType = Integer.class)
    @Insert("insert into user(username,password,name,tel,create_time,avatar,role) values(#{username}, #{password}, #{name}, #{tel}, #{createTime},#{avatar},#{role})")
    void save(User u);

    @Update("update user set username = #{username},name = #{name},tel = #{tel},avatar = #{avatar} where id = #{id}")
    void update(User u);

    @Select("select * from user where id = #{id}")
    User selectById(String id);

/*    @Update("update user set status = '-1' where id = #{id}")
    void delete(String id);*/

    @Select("select * from user where username = #{username}")
    User selectByUsername(String username);

    void doDelete(String... ids);

    @Select("select * from user where id = #{id}")
    User getPasswordById(Integer id);

    @Update("update user set password = #{password} where id = #{id}")
    void setPasswordById(String password, Integer id);
}
