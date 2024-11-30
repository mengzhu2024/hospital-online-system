package com.wk.hc.common.service;

import com.wk.hc.common.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.vo.CartVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface ICartService extends IService<Cart> {
    void saveCart(Cart cart);

    List<CartVO> getCart(Integer customerId);

    void amount(Integer id,Integer amount);

    List<CartVO> getOrderCart(String[] split);
}
