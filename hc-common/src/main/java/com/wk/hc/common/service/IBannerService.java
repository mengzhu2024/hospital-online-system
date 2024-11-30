package com.wk.hc.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.entity.Banner;
import com.wk.hc.common.vo.ResultVO;
import com.wk.hc.common.vo.TableVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IBannerService extends IService<Banner> {

    TableVO getList();

    void updateStatus(Integer id, String status);

    ResultVO saveBanner(Banner banner);


    List<Banner> banners();
}
