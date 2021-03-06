package com.huayun.article.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/file")
public class FileController {

    //读取配置文件中的文件存储路径；
    @Value("${img.location}")
    private String location;

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file){
        //首先进行文件上传
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        try {
            uploadFile(file.getBytes(), location, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            return "1";
        }

        return "/api/image/"+fileName;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadEditorFile", method = RequestMethod.POST)
    public Object uploadEditorFile(@RequestParam("file") MultipartFile file){
        //首先进行文件上传
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        try {
            uploadFile(file.getBytes(), location, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            return "1";
        }
        Map map = new HashMap();
        map.put("errno",0);
        List _list = new ArrayList();
        _list.add("/api/image/" + fileName);
        map.put("data",_list);

        return map;
    }

    /**
     * 上传文件
     * @param file  文件对应的byte数组流   使用file.getBytes()方法可以获取
     * @param filePath  上传文件路径，不包含文件名
     * @param fileName 上传文件名
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+"/"+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
