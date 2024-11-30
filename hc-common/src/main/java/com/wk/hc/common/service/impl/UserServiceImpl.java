package com.wk.hc.common.service.impl;


import com.github.pagehelper.PageHelper;
import com.wk.hc.common.entity.User;
import com.wk.hc.common.exception.MyException;
import com.wk.hc.common.mapper.UserMapper;
import com.wk.hc.common.service.IUserService;
import com.wk.hc.common.util.RequestUtil;
import com.wk.hc.common.util.StringUtil;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class UserServiceImpl  implements IUserService {
    /*@Value("${file.path}")
    private String filePath;*/

    @Autowired
    UserMapper mapper;


    @Override
    public TableVO list(String username, String name, String status, Integer page, Integer limit) {
//        TableVO vo = new TableVO();

        //PageHelper 分页小工具
        //这行代码后跟的第一次查数据库是分页查询,只生效一次
        PageHelper.startPage(page, limit);
        List<User> list = mapper.list(username, name, status);

        return TableVO.data(list);
    }

    @Override
    public ResultVO save(User u) {
        ResultVO vo = new ResultVO();
        if (u.getId() == null) {

            User user = mapper.selectByUsername(u.getUsername());
            if (user != null) {
                throw new MyException("用户已存在");
            }

            if (!StringUtil.isTruePassword(u.getPassword())) {
                vo.setCode(2);
                vo.setMsg("密码格式错误");
                return vo;
            }
            u.setPassword(StringUtil.md5(u.getPassword()));
            u.setCreateTime(LocalDateTime.now());
            u.setRole("管理员");
            if (u.getAvatar() == null || u.getAvatar().equals("")) {
                u.setAvatar("/u/1710079771639.jpg");
            }
            mapper.save(u);
        } else {
            mapper.update(u);
        }
        return vo;
    }

/*    @Override
    public ResultVO delete(String id) {
        User u = mapper.selectById(id);
        ResultVO vo = new ResultVO();
        if (u.getUsername().equals("admin")) {
            vo.setCode(2);
            vo.setMsg("此账号是管理员账号,不能删除");
        } else {
            mapper.delete(id);
        }
        return vo;
    }*/

    @Override
    public User getInfoById(String id) {
        User user = mapper.selectById(id);
//        user.setAvatar(filePath+user.getAvatar());
        return user;
    }

    @Override
    public boolean check(String username, String password) {
        User u = mapper.selectByUsername(username);
        boolean b = u != null && u.getPassword().equals(StringUtil.md5(password));
        if (b) {
            RequestUtil.setCurrent(u);
        }
        return b;
    }

    @Override
    public boolean checkPassword(String password, Integer id) {
        String s = StringUtil.md5(password);
        return s.equals(mapper.getPasswordById(id).getPassword());
    }

    @Override
    public void setPassword(String password, Integer id) {
        mapper.setPasswordById(password,id);
    }

    @Override
    public ResultVO delete(String ids) {
        mapper.doDelete(ids.split(","));
        return new ResultVO();
    }
}
