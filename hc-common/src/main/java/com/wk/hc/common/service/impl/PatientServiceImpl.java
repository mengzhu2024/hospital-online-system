package com.wk.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.Patient;
import com.wk.hc.common.mapper.PatientMapper;
import com.wk.hc.common.service.IPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.util.StringUtil;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public boolean check(String username, String password) {
        Patient c = baseMapper.selectByUsername(username);
        boolean b = c != null && c.getPassword().equals(StringUtil.md5(password)) && c.getStatus().equals("0");
        if (b) {
            RequestUtil.setCurrent(c);
        }
        return b;
    }

    @Override
    public TableVO getLista(Integer page, Integer limit, String username, String status) {
        PageHelper.startPage(page, limit);
        List<Patient> list = patientMapper.lista(username, status);
        System.out.println(list);
        /*TableVO vo = new TableVO();
        vo.setData(list);
        vo.setCount(20L);*/
        return TableVO.data(list);
    }

    @Override
    public ResultVO updateStatusById(String ids, String status) {
        patientMapper.updateStatus(status, ids.split(","));
        ResultVO vo = new ResultVO();
        if ("0".equals(status)) {
            vo.setMsg("已启用");
        } else if ("1".equals(status)) {
            vo.setMsg("已停用");
        }
        return vo;
    }

    @Override
    public ResultVO resetPassword(String ids) {
        String password = StringUtil.md5("123456");
        patientMapper.resetPassword(ids.split(","), password);
        ResultVO vo = new ResultVO();
        vo.setMsg("重置成功:123456");
        return vo;
    }

    @Override
    public boolean checkPassword(String oldPassword, Integer id) {
        String s = StringUtil.md5(oldPassword);
        return s.equals(baseMapper.selectById(id).getPassword());
    }
}
