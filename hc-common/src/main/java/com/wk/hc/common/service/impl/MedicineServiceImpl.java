package com.wk.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.Category;
import com.wk.hc.common.entity.Medicine;
import com.wk.hc.common.mapper.CategoryMapper;
import com.wk.hc.common.mapper.MedicineMapper;
import com.wk.hc.common.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.vo.EditMedicineVO;
import com.wk.hc.common.vo.IndexMedicineVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {
    @Autowired
    private MedicineMapper medicineMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public TableVO getList(String name, String status, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return TableVO.data(baseMapper.list(name, status));
    }

    @Override
    public ResultVO delete(String ids) {
        medicineMapper.doDelete(ids.split(","));
        return new ResultVO();
    }

    @Override
    public EditMedicineVO doGetInfoById(Integer id) {
        return medicineMapper.doGetInfoById(id);
    }

    @Override
    public List<IndexMedicineVO> indexProduct() {
        return medicineMapper.selectAll();
    }

    @Override
    public ResultVO updateStatusById(String ids, String status) {
        medicineMapper.updateStatus(status,ids.split(","));
        ResultVO vo = new ResultVO();
        if ("0".equals(status)) {
            vo.setMsg("下架成功");
        } else if ("1".equals(status)) {
            vo.setMsg("上架成功");
        }
        return vo;
    }

    @Override
    public Medicine productInfo(Integer pId) {
        return medicineMapper.selectById(pId);
    }

    @Override
    public List<Medicine> listByName(String name) {
        return baseMapper.listByName(name);
    }
}
