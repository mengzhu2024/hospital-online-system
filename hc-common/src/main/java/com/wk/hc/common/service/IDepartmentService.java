package com.wk.hc.common.service;

import com.wk.hc.common.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IDepartmentService  {
    TableVO list(String name, Integer page, Integer limit);

    ResultVO save(Department d);

    ResultVO delete(String ids);

    Department getInfoById(String id);

    List<Department> select();
}
