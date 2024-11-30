package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.entity.Banner;
import com.wk.hc.common.mapper.BannerMapper;
import com.wk.hc.common.service.IBannerService;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Override
    public TableVO getList() {
        List<Banner> list = baseMapper.getList();
        TableVO vo = new TableVO();
        vo.setData(list);
        return vo;
    }

    @Override
    public void updateStatus(Integer id, String status) {
        baseMapper.updateStatus(id,status);
    }

    @Override
    public ResultVO saveBanner(Banner banner) {
        ResultVO vo = new ResultVO();
        if (banner.getId() == null) {
            baseMapper.saveBanner(banner);
        } else {
            baseMapper.updateBanner(banner);
        }
        return vo;
    }

    @Override
    public List<Banner> banners() {
        return baseMapper.banners();
    }


}
