package com.hotel.controller;

import ch.qos.logback.core.util.FileUtil;
import com.hotel.povo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @PostMapping
    public ResponseEntity<BaseResult> photoUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
        // 判断用户是否登录
    /*User user=(User) session.getAttribute("user");
     if (user==null) {
     resultData.setCode(40029);
     resultData.setMsg("用户未登录");
     return resultData;
     }*/
    String url = "";
        if (file != null) {// 判断上传的文件是否为空
            String path = null;// 文件路径
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName); // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) { // 项目在容器中实际发布运行的根路径
                    String realPath =  "D://img/";
                    File tmpFile = new File(realPath);
                    if (!tmpFile.exists()) {
                        // 创建临时目录
                        tmpFile.mkdir();
                    }
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName; // 设置存放图片文件的路径
                    path = realPath +/*System.getProperty("file.separator")+*/trueFileName;
                    System.out.println("存放图片文件的路径:" + path); // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    url = "http://localhost:8081/img/"+trueFileName;
                    System.out.println("文件成功上传到指定目录下");
                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            } else {
                System.out.println("文件类型为空");
                return null;
            }
        } else {
            System.out.println("没有找到相对应的文件");
            return null;
        }
        return ResponseEntity.ok(new BaseResult(1,"上传成功",url));
    }
}
