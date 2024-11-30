package com.wk.hc.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.entity.Attachment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

    void bind(@Param("ids") String[] split, @Param("id") Integer id, @Param("source") String source);
}
