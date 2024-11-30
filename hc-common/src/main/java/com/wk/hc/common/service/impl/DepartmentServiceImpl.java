package com.wk.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.Department;
import com.wk.hc.common.exception.MyException;
import com.wk.hc.common.mapper.DepartmentMapper;
import com.wk.hc.common.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.util.StringUtil;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    DepartmentMapper mapper;


    @Override
    public TableVO list(String name, Integer page, Integer limit) {
//        TableVO vo = new TableVO();

        //PageHelper 分页小工具
        //这行代码后跟的第一次查数据库是分页查询,只生效一次
        PageHelper.startPage(page, limit);
        List<Department> list = mapper.list(name);

        return TableVO.data(list);
    }

    @Override
    public ResultVO save(Department d) {
        ResultVO vo = new ResultVO();
        if (d.getId() == null) {

            Department dept = mapper.selectByName(d.getName());
            if (dept != null) {
                throw new MyException("科室已存在");
            }
            mapper.save(d);
        } else {
            mapper.update(d);
        }
        return vo;
    }



    @Override
    public Department getInfoById(String id) {
        Department d = mapper.selectById(id);
        return d;
    }

    @Override
    public List<Department> select() {
        return mapper.select();
    }


    @Override
    public ResultVO delete(String ids) {
        mapper.doDelete(ids.split(","));
        return new ResultVO();
    }
}
