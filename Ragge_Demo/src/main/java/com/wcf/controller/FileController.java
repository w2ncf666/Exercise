package com.wcf.controller;

import com.wcf.pojo.R;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class FileController {

    @Value("${file.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {

        File dir = new File(basePath);
        if (!dir.exists())
            dir.mkdirs();
        String originalFilename = file.getOriginalFilename();//获得原始文件名
        String substring = originalFilename.substring((originalFilename.lastIndexOf(".")));

        String fileName = UUID.randomUUID().toString() + substring;

        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return R.success(fileName);

    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        /*么有 设置文件格式,可能出错*/
        try {
            FileInputStream fileInputStream=new FileInputStream(new File(basePath+name));
            ServletOutputStream outputStream = response.getOutputStream();
            int len=0;
            byte[] bytes=new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1) {
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            fileInputStream.close();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
