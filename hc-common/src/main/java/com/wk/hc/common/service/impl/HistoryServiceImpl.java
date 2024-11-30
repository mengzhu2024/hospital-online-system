package com.wk.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.History;
import com.wk.hc.common.mapper.HistoryMapper;
import com.wk.hc.common.service.IHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.vo.HistoryVo;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History> implements IHistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public TableVO getList(String pName, String deptId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HistoryVo> list = historyMapper.getList(pName, deptId);
        return TableVO.data(list);
    }

    @Override
    public TableVO getListBypatient(String patientId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<HistoryVo> list = historyMapper.getListByPatient(patientId);
        return TableVO.data(list);
    }
}
