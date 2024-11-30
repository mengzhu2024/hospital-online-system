package com.wk.hc.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wk.hc.common.entity.Attachment;
import com.wk.hc.common.mapper.AttachmentMapper;
import com.wk.hc.common.service.IAttachmentService;
import com.wk.hc.common.vo.ResultVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {


    /*@Value("${file.path}")
    private String filePath;
    @Value("${file.location}")
    private String fileLocation;*/

    @Override
    public ResultVO upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));


        ResultVO vo = new ResultVO();
        try {
            File f = new File(System.getProperty("user.dir") + "\\images\\" + newFileName);
            //把文件保存到服务器上的对应目录中
            file.transferTo(f);

            //保存到attachment表一条数据
            Attachment att = new Attachment();
            att.setCreateTime(LocalDateTime.now());
            att.setFilePath("/u/" + newFileName);
            att.setFileName(file.getOriginalFilename());
            att.setFileSize(file.getSize());
            baseMapper.insert(att);

            vo.setData(att);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("上传文件失败");
        }

        return vo;
    }

    @Override
    public void bind(String attIds, Integer id, String source) {
        baseMapper.bind(attIds.split(","), id, source);
    }

    @Override
    public void clean() {
        System.out.println("service去清理了");
    }
}
