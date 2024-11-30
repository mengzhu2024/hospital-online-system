package com.wk.hc.common.controller;

import com.wk.hc.common.service.IAttachmentService;
import com.wk.hc.common.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    IAttachmentService attachmentService;


    @PostMapping("/upload")
    @ResponseBody
    public ResultVO upload(MultipartFile file) {
        return attachmentService.upload(file);
    }
}
