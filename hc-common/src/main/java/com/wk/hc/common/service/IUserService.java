package com.wk.hc.common.service;


import com.wk.hc.common.entity.User;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IUserService {
    TableVO list(String username, String name, String status, Integer page, Integer limit);

    ResultVO save(User u);

    ResultVO delete(String ids);

    User getInfoById(String id);

    boolean check(String username, String password);

    boolean checkPassword(String password,Integer id);

    void setPassword(String password, Integer id);
}
