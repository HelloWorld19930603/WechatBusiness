package com.yilin.app.utils;

import com.yilin.app.exception.FileException;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by cc on 2018/7/27.
 */
public class PhotoUtil {

    /**
     * 图片文件上传
     */
    public static void photoUpload(MultipartFile file,String dic, HttpServletRequest request) throws IllegalStateException, IOException ,FileException{

        if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath=request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName=fileName;
                    // 设置存放图片文件的路径
                    path=realPath+dic+"/"+trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    throw new FileException("不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                System.out.println("文件类型为空");
                throw new FileException("文件类型为空");
            }
        }else {
            System.out.println("没有找到相对应的文件");
            throw new FileException("没有找到相对应的文件");
        }
    }
}
