package com.wk.hc.common.service;

import com.wk.hc.common.entity.Medicine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.EditMedicineVO;
import com.wk.hc.common.vo.IndexMedicineVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IMedicineService extends IService<Medicine> {
    TableVO getList(String name, String status, Integer page, Integer limit);

    ResultVO delete(String ids);

    EditMedicineVO doGetInfoById(Integer id);

    List<IndexMedicineVO> indexProduct();

    ResultVO updateStatusById(String ids, String status);

    Medicine productInfo(Integer pId);


    List<Medicine> listByName(String name);
}
