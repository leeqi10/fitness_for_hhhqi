package hhhqi.com.controller;

import hhhqi.com.entity.Result;
import hhhqi.com.util.Md5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/image")
public class UploadDownHandler {
    /**上传地址*/
    @Value("${file.upload.path}")
    private String path;

    /**图片url前缀*/
//    @Value("${com.test.base_picture_url}")
//    private String base_picture_url;

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @PostMapping("/uploadPicture")
    public Result uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{

        //String base_picture_url = "http://localhost:8080/image/";

        //获取文件在服务器的储存位置
        File filePath = new File(path);
        System.out.println("文件的保存路径"+path);
        if(!filePath.exists() && !filePath.isDirectory()){
            System.out.println("目录不存在，创建目录" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称（包括格式）
        String originalFileName = file.getOriginalFilename();
        System.out.println("原始文件名称:" + originalFileName);

        //获取文件类型，以最后一个‘.’为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型:" + type);

        //设置文件新名称：md5文件（不包含格式）
        String date = Md5Util.getMD5String(file.getBytes());
        String fileName = date + "." +type;
        System.out.println("新文件名称:" +fileName);

        //在指定路径下创建文件
        File targetFile = new File(path,fileName);

        Result result = new Result();//定义结果
        //将文件保存到服务器指定位置
        try{
            file.transferTo(targetFile);
            System.out.println("上传成功");

        }catch (IOException e){
            System.out.println("上传失败");
            result.setCode(400);
            result.setMsg("上传失败");
            result.setCount(1);
            e.printStackTrace();
            return result;
        }

        result.setCode(0);
        result.setData(fileName);
        result.setCount(1);
        result.setMsg("上传成功");
        System.out.println(result);
        return result;

    }
}
