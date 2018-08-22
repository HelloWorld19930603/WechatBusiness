package com.yilin.app.utils;

import com.yilin.app.exception.FileException;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by cc on 2018/7/27.
 */
public class PhotoUtil {

    /**
     * 图片文件上传
     */
    public static String photoUpload(MultipartFile file,String dic,String trueFileName,
                                     String realPath) throws IllegalStateException, IOException ,FileException{

        if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf("."), fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if (".GIF".equals(type.toUpperCase())||".PNG".equals(type.toUpperCase())||".JPG".equals(type.toUpperCase())) {
                    // 设置存放图片文件的路径
                    path=realPath+dic;
                    File f = new File(path);
                    //创建文件夹
                    if(!f.exists()){
                        f.mkdir();
                    }
                    path+=trueFileName+type;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                    return "/"+dic+trueFileName+type;
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

    public static String getPhotoSize(MultipartFile multipartFile) throws IOException {
        BufferedImage image = ImageIO.read(multipartFile.getInputStream());
        if (image != null) {//如果image=null 表示上传的不是图片格式
            System.out.println(image.getWidth());//获取图片宽度，单位px
            System.out.println(image.getHeight());//获取图片高度，单位px
        }
        return image.getWidth()+"*"+image.getHeight();
    }

    public static void main(String[] args) throws IOException, FileException {
        File file = new File("D:\\weishang\\格丽缇\\代理价\\ut\\286513421706691989.jpg");
        MultipartFile multipartFile = new MockMultipartFile(file.getName(),file.getName(),null, new FileInputStream(file));

        System.out.println(getPhotoSize(multipartFile));
       // System.out.println( photoUpload(multipartFile,"e:/photo/","hello",""));

    }
}
