package com.wk.hc.common.service;

import com.wk.hc.common.entity.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.CartVO;
import com.wk.hc.common.vo.OrderVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IOrderInfoService extends IService<OrderInfo> {
    OrderInfo saveOrder(String ids, Integer addressId);

    TableVO getOrderList(Integer page,Integer limit);

    TableVO getAllOrderList(Integer page, Integer limit, String code, String status);

    OrderVO getOrderInfo(Integer oId);

    void pay(String code, String payType);

    TableVO getOrderInfoTable(Integer id);

    List<CartVO> getOrderDetail(Integer oId);
}
