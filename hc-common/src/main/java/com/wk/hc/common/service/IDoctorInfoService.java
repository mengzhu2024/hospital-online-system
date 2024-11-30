package com.wk.hc.common.service;

import com.wk.hc.common.entity.DoctorInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.entity.User;
import com.wk.hc.common.vo.DoctorVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IDoctorInfoService {

    TableVO list(String username, String name, String status, Integer page, Integer limit);

    ResultVO save(DoctorVO d);

    DoctorVO getInfoById(String id);

    ResultVO deleteDoctor(String ids);

    TableVO listByDept(Integer deptId, Integer page, Integer limit);

    DoctorInfo getInfoByUserId(String userId);

    List<User> dept(String deptId);
}
