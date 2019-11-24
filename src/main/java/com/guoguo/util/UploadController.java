package com.guoguo.util;

import com.guoguo.config.ProjectProperties;
import com.guoguo.util.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Controller
@Slf4j
public class UploadController {
    @Autowired
    private ProjectProperties projectProperties;

    @RequestMapping("/upload/file")
    @ResponseBody
    public List<String> uploadFile(HttpServletRequest request, @RequestParam String param) {
        List<String> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        try {
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                    request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if (multipartResolver.isMultipart(request)) {
                String newPath = "/upload/" + param;
                // 创建目录
                String path = projectProperties.getFileRoot() + newPath;
                File f = new File(path);
                if (!f.exists()) {
                    f.mkdirs();
                }
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator iter = multiRequest.getFileNames();
                while (iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile file = multiRequest.getFile(iter.next().toString());
                    if (file != null) {
                        String fileName = getRandomFileNameString(file.getOriginalFilename());
                        //上传
                        file.transferTo(new File(path + "/" + fileName));
                        list.add(newPath + "/" + fileName);
                    }
                }
            }
        } catch (Exception e) {
            log.error("UploadController.uploadFile", e);
        }
        long endTime = System.currentTimeMillis();
        log.info("文件上传时间：" + String.valueOf(endTime - startTime) + "ms");
        return list;
    }

    /**
     * 获得随机的数字为文件名，有效防止文件名重读
     *
     * @param fileName 传来的文件名
     * @return String 返回新的文件名
     */
    public static String getRandomFileNameString(String fileName) {

        StringBuffer buffer = new StringBuffer();
        // 加锁为防止文件名重复
        final Lock lock = new ReentrantLock();
        lock.lock();
        try {
            buffer.append(System.currentTimeMillis());// 当前时间
            // 增加6位随机的数字
            buffer.append(getRandomString(6));
            // 添加后缀名
            buffer.append(fileName.substring(fileName.lastIndexOf(".")));
        } finally {
            lock.unlock();
        }
        return buffer.toString();
    }

    /**
     * 获取指定长度的随机数字
     *
     * @param len
     * @return
     */
    public static String getRandomString(int len) {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            buffer.append(random.nextInt(10));
            random = new Random();
        }
        return buffer.toString();
    }
}
