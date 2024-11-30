package com.wk.hc.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wk.hc.common.entity.Attachment;
import com.wk.hc.common.vo.ResultVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IAttachmentService extends IService<Attachment> {

    ResultVO upload(MultipartFile file);

    void bind(String attIds, Integer id, String product);

    void clean();
}
