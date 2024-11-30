package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wk.hc.common.entity.Cart;
import com.wk.hc.common.entity.Patient;
import com.wk.hc.common.exception.MyException;
import com.wk.hc.common.mapper.CartMapper;
import com.wk.hc.common.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void saveCart(Cart cart) {

        System.out.println(RequestUtil.getCurrent());
        Object o = RequestUtil.getCurrent();
        Patient c = (Patient) o;
        cart.setPatientId(c.getId());

        QueryWrapper<Cart> qw = new QueryWrapper<>();
        qw.eq("medicine_id", cart.getMedicineId());
        qw.eq("patient_id", cart.getPatientId());
        Cart oldCart = cartMapper.selectOne(qw, false);
        if (oldCart == null) {
            cart.setCreateTime(LocalDateTime.now());
            cartMapper.insert(cart);
        } else {
            int amount = cart.getAmount() + oldCart.getAmount();
            cart.setAmount(amount);
            cart.setId(oldCart.getId());
            cartMapper.updateById(cart);
        }
    }

    @Override
    public List<CartVO> getCart(Integer patientId) {
        return cartMapper.selectCart(patientId);
    }

    @Override
    public void amount(Integer id, Integer amount) {
        Cart cart = cartMapper.selectById(id);
        cart.setAmount(cart.getAmount() + amount);
        cartMapper.updateById(cart);
    }

    @Override
    public List<CartVO> getOrderCart(String[] ids) {
        System.out.println(Arrays.toString(ids));
        return cartMapper.selectOrderCart(ids);
    }
}
