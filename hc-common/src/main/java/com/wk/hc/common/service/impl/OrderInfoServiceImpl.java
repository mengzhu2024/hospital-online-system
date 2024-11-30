package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.*;
import com.wk.hc.common.mapper.*;
import com.wk.hc.common.service.IOrderInfoService;
import com.wk.hc.common.util.IdWorker;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.vo.CartVO;
import com.wk.hc.common.vo.OrderListVO;
import com.wk.hc.common.vo.OrderVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private MedicineMapper productMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private PatientAddressMapper customerAddressMapper;
    @Autowired
    private OrderAddressMapper orderAddressMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)//rollbackFor 回滚的异常,默认runtime
    public OrderInfo saveOrder(String ids, Integer addressId) {
        Patient c = (Patient) RequestUtil.getCurrent();

        //创建一个OrderInfo对象   保存到数据库
        OrderInfo oi = new OrderInfo();
        oi.setCode(String.valueOf(IdWorker.id()));
        oi.setCreateTime(LocalDateTime.now());
        oi.setStatus("未付款");
        oi.setPatientId(c.getId());
//        oi.setPayType("alipay");
        BigDecimal sum = new BigDecimal("0");
        for (String cid : ids.split(",")) {
            Cart cart = cartMapper.selectById(Integer.parseInt(cid));
            Medicine product = productMapper.selectById(cart.getMedicineId());
            sum = sum.add(product.getPrice().multiply(new BigDecimal(cart.getAmount())));
        }
        oi.setTotalPrice(sum);
        baseMapper.insert(oi);

        //创建多个OrderDetail   保存进数据库
        for (String cid : ids.split(",")) {
            Cart cart = cartMapper.selectById(Integer.parseInt(cid));
            Medicine product = productMapper.selectById(cart.getMedicineId());
            OrderDetail od = new OrderDetail();
            od.setOrderId(oi.getId());
            od.setAmount(cart.getAmount());
            od.setOldPrice(product.getPrice());
            od.setMedicineId(cart.getMedicineId());
            orderDetailMapper.insert(od);
        }

        //创建OrderAddress对象  白村进数据库
        PatientAddress ca = customerAddressMapper.selectById(addressId);

        OrderAddress oa = new OrderAddress();
        BeanUtils.copyProperties(ca,oa);//相同属性拷贝
        oa.setOrderId(oi.getId());
        oa.setId(null);//ID置空
        orderAddressMapper.insert(oa);
        //把购物车中原来的数据删除
        for (String cid : ids.split(",")) {
            cartMapper.deleteById(Integer.parseInt(cid));
        }
        return oi;
    }

    @Override
    public TableVO getOrderList(Integer page,Integer limit) {
        Patient current = (Patient) RequestUtil.getCurrent();
        Integer id = current.getId();
        PageHelper.startPage(page, limit);
        List<OrderVO> list = baseMapper.getOrderList(id);
        return TableVO.data(list);
    }

    @Override
    public TableVO getAllOrderList(Integer page,Integer limit,String code,String status) {
        PageHelper.startPage(page, limit);
        List<OrderListVO> list = baseMapper.getAllOrderList(code,status);
        /*System.out.println("##################################################################################");;
        for (OrderVO c : list) {
            System.out.println(c);
        }
        System.out.println("##################################################################################");*/
        return TableVO.data(list);
    }

    @Override
    public OrderVO getOrderInfo(Integer oId) {
        return baseMapper.getOrderInfo(oId);
    }

    @Override
    public void pay(String code, String payType) {
        OrderInfo oi = new OrderInfo();
//        oi.setCode(code);
        oi.setPayType(payType);
        oi.setStatus("已支付");
        System.out.println("***************************************************");
        baseMapper.update(oi, new QueryWrapper<OrderInfo>().eq("code", code));
    }

    @Override
    public TableVO getOrderInfoTable(Integer id) {

        return null;
    }

    @Override
    public List<CartVO> getOrderDetail(Integer oId) {
        return baseMapper.getOrderDetail(oId);
    }
}
