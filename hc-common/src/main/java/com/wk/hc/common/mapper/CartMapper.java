package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.CartVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface CartMapper extends BaseMapper<Cart> {
    @Select("SELECT * FROM cart INNER JOIN medicine on medicine.id = cart.medicine_id order by create_time desc ")
    List<CartVO> selectCart(Integer customerId);

    List<CartVO> selectOrderCart(@Param("ids") String[] ids);
}
