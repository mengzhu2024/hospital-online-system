package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.entity.Category;
import com.wk.hc.common.mapper.CategoryMapper;
import com.wk.hc.common.service.ICategoryService;
import com.wk.hc.common.vo.IndexCategoryVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public TableVO tree() {
        List<Category> list = categoryMapper.tree();
        return TableVO.data(list);
    }

//    @CacheEvict(value = "categoryCache")    //删除缓存
    @Cacheable(value = "categoryCache",key = "'categoryKey'")
    @Override
    public List<IndexCategoryVO> indexList() {
        return baseMapper.indexList();
    }

    @Override
    public ResultVO updateStatusById(String ids, String status) {
        categoryMapper.updateStatus(status,ids.split(","));
        ResultVO vo = new ResultVO();
        if ("0".equals(status)) {
            vo.setMsg("下架成功");
        } else if ("1".equals(status)) {
            vo.setMsg("上架成功");
        }
        return vo;
    }
}
