package com.upload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    private Logger logger = LoggerFactory.getLogger("upload");

    /*@Value("${uploadPath}")
    private String realpath;*/

    @ResponseBody
    @RequestMapping(value="/upload")
    public Object upload(@RequestParam MultipartFile file, HttpServletRequest request){
        Map<String,Object> rstMap = new HashMap<>();
        String realpath = request.getSession().getServletContext().getRealPath("/static/upload");
        logger.info("realpath="+realpath);
        String path = "";
        if(realpath.contains("\\")){
            path = realpath.substring(0,realpath.lastIndexOf("\\"))+"\\upload";
        }else{
            path = realpath.substring(0,realpath.lastIndexOf("/"))+"/upload";
        }
        logger.info("path="+path);
        String fileName = new Date().getTime()+".png";

        File targetFile = new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.getParentFile().mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
            rstMap.put("success",0);
            rstMap.put("msg","上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            rstMap.put("success",1);
            rstMap.put("msg","上传失败");
        }
        String link = "http://127.0.0.1:8080/";
	        /*if(StringUtils.isNotEmpty(link)){
	        	link = link.replace("/ycjc", "");
	        }*/
        String url = link+"upload/"+fileName;
        logger.info(url);



        return rstMap;
    }


}
