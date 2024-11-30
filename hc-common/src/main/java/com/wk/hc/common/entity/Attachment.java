package com.wk.hc.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("attachment")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件访问路径
     */
    private String filePath;

    /**
     * 文件名(老)
     */
    private String fileName;

    /**
     * 上传事件
     */
    private LocalDateTime createTime;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 源(表名)
     */
    private String source;

    /**
     * 源的ID
     */
    private Integer sourceId;

    /**
     * 类型
     */
    private String type;


}
