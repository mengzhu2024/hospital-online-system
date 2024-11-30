package com.wk.hc.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.entity.Category;
import com.wk.hc.common.vo.IndexCategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> tree();

    List<IndexCategoryVO> indexList();

    void updateStatus(@Param("status") String status, @Param("ids") String[] split);
}
