package com.wk.hc.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.entity.Category;
import com.wk.hc.common.vo.IndexCategoryVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 */
public interface ICategoryService extends IService<Category> {
    TableVO tree();

    List<IndexCategoryVO> indexList();

    ResultVO updateStatusById(String ids, String status);
}
