package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.DoctorInfo;
import com.wk.hc.common.entity.User;
import com.wk.hc.common.exception.MyException;
import com.wk.hc.common.mapper.DoctorInfoMapper;
import com.wk.hc.common.mapper.UserMapper;
import com.wk.hc.common.service.IDoctorInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.util.StringUtil;
import com.wk.hc.common.vo.DoctorVO;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 */
@Service
public class DoctorInfoServiceImpl implements IDoctorInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DoctorInfoMapper doctorInfoMapper;


    @Override
    public TableVO list(String username, String name, String status, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        return TableVO.data(doctorInfoMapper.list(username, name, status));
    }

    @Override
    public ResultVO save(DoctorVO d) {
        ResultVO vo = new ResultVO();
        User u = new User();
        u.setId(d.getId());
        u.setUsername(d.getUsername());
        u.setPassword(d.getPassword());
        u.setName(d.getName());
        u.setTel(d.getTel());
        u.setAvatar(d.getAvatar());

        DoctorInfo di = new DoctorInfo();
        di.setDeptId(d.getDeptId());
        di.setPrice(d.getPrice());
        di.setSex(d.getSex());
        di.setTitle(d.getTitle());
        di.setUserId(d.getId());

        if (u.getId() == null) {

            User user = userMapper.selectByUsername(u.getUsername());
            if (user != null) {
                throw new MyException("工号已存在");
            }

            if (!StringUtil.isTruePassword(u.getPassword())) {
                vo.setCode(2);
                vo.setMsg("密码格式错误");
                return vo;
            }
            u.setPassword(StringUtil.md5(u.getPassword()));
            u.setCreateTime(LocalDateTime.now());
            u.setRole("医生");
            if (u.getAvatar() == null || u.getAvatar().equals("")) {
                u.setAvatar("/u/1710079771639.jpg");
            }
            userMapper.save(u);
            int userId = u.getId();
            di.setUserId(userId);

            doctorInfoMapper.saveInfo(di);
        } else {
            userMapper.update(u);
            doctorInfoMapper.updateInfo(di);
        }
        return vo;
    }

    @Override
    public DoctorVO getInfoById(String id) {
        return doctorInfoMapper.getIndoByid(id);
    }

    @Override
    public ResultVO deleteDoctor(String ids) {
        doctorInfoMapper.doDelete(ids.split(","));
        return new ResultVO();
    }

    @Override
    public TableVO listByDept(Integer deptId, Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<DoctorVO> list = doctorInfoMapper.listByDept(deptId);
        return TableVO.data(list);
    }

    @Override
    public DoctorInfo getInfoByUserId(String userId) {
        return doctorInfoMapper.selectOne(new QueryWrapper<DoctorInfo>().eq("user_id",userId));
    }

    @Override
    public List<User> dept(String deptId) {
        return doctorInfoMapper.dept(deptId);
    }
}
