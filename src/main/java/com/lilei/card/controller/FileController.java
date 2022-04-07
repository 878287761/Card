package com.lilei.card.controller;

import com.lilei.card.service.DownCountService;
import com.lilei.card.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
@RequestMapping("/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DownCountService downCountService;
    @Autowired
    private FileService fileService;

    @RequestMapping("/")
    public String toDwonload(){
        return "download";
    }

    @ResponseBody
    @GetMapping("download")
    public ResponseEntity<Resource> downloadFile(/*@PathVariable String fileName,*/
                                                 HttpServletRequest request){
        //下载的文件名
        String fileName = "navicat150_premium_cs_x64.exe";
        Resource resource = fileService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException e){
            logger.error("无法获取文件类型", e);
        }
        if (contentType==null){
            contentType="application/octet-stream";
        }
        //更新一次才在次数
        downCountService.UpDownCount();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
