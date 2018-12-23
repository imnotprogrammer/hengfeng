package com.hengfeng.web.controller;

import com.hengfeng.web.utils.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    /**
     * 公共上传文件接口
     * @param request
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, @RequestParam("file")MultipartFile file) throws Exception
    {
        ApiResponse apiResponse = new ApiResponse();
        try {
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = request.getServletContext().getRealPath("/") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6.把文件名放在model里，以便后续显示用
            Map<String, Object> fileData = new HashMap<>();
            Map<String, String> data = new HashMap<>();
            data.put("src", request.getRemoteHost() + File.separator + fileName);
            data.put("title", fileName);
            fileData.put("code", 0);
            fileData.put("msg", "");
            fileData.put("data", data);
            return fileData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ApiResponse.createResponse(e);
        } catch (IOException e) {
            return ApiResponse.createResponse(e);
        }
    }
}
