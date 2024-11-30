package com.wk.hc.common.service;

import com.wk.hc.common.entity.Patient;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IPatientService extends IService<Patient> {
    boolean check(String username, String password);

    TableVO getLista(Integer page, Integer limit, String username, String status);

    ResultVO updateStatusById(String ids, String status);

    ResultVO resetPassword(String ids);

    boolean checkPassword(String oldPassword, Integer id);
}
