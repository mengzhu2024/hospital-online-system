package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.CartVO;
import com.wk.hc.common.vo.OrderListVO;
import com.wk.hc.common.vo.OrderVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    List<OrderVO> getOrderList(Integer customerId);

    OrderVO getOrderInfo(Integer orderId);

    List<OrderListVO> getAllOrderList(@Param("code") String code, @Param("status") String status);

    @Select("select order_detail.*,medicine.*\n" +
            "from order_info\n" +
            "INNER JOIN order_detail on order_detail.order_id=order_info.id\n" +
            "INNER JOIN medicine on medicine.id = order_detail.medicine_id\n" +
            "WHERE order_info.id = #{oId}")
    List<CartVO> getOrderDetail(Integer oId);
}
