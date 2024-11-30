package com.wk.hc.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.entity.Banner;
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
public interface BannerMapper extends BaseMapper<Banner> {

    @Select("select * from banner order by sequence")
    List<Banner> getList();

    @Update("update banner set status = #{status} where id = #{id}")
    void updateStatus(@Param("id") Integer id,@Param("status") String status);

    @Insert("insert into banner(img_path, href, sequence) values (#{imgPath},#{href},#{sequence})")
    void saveBanner(Banner banner);

    @Update("update banner set img_path = #{imgPath},href = #{href},sequence = #{sequence} where id = #{id}")
    void updateBanner(Banner banner);

    @Select("select * from banner where status = '0' order by sequence")
    List<Banner> banners();
}
