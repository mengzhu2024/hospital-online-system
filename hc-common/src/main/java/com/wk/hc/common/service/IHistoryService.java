package com.wk.hc.common.service;

import com.wk.hc.common.entity.History;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.TableVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IHistoryService extends IService<History> {

    TableVO getList(String pName, String deptId, Integer page, Integer limit);

    TableVO getListBypatient(String patientId, Integer page, Integer limit);
}
