package com.wk.hc.common.service;

import com.wk.hc.common.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.RegistrationVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IRegistrationService extends IService<Registration> {

    TableVO listAll(String name,String status,Integer page,Integer limit);

    TableVO listByDoctor(String name,String status,Integer page,Integer limit);

    TableVO listByPatient(String patientId,Integer page,Integer limit);

    ResultVO cacel(String rid);

    boolean isMax(String userId, String date, String time);
}
