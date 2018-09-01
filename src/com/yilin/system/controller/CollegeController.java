package com.yilin.system.controller;

import com.yilin.app.domain.College;
import com.yilin.app.domain.Commodity;
import com.yilin.app.exception.FileException;
import com.yilin.app.service.ICollegeService;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import com.yilin.system.common.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by cc on 2018/8/25.
 */
@Controller
public class CollegeController {

    @Autowired
    ICollegeService collegeService;

    @RequestMapping("college")
    public String College(Model model) {
        model.addAttribute("active", "college");
        return "college";
    }

    @RequestMapping("getColleges")
    @ResponseBody
    public SystemPage getColleges(Byte type, String titile, int start, int pageSize, String title) {
        int totals = 0;
        SystemPage page = new SystemPage();
        try {
            totals = collegeService.getCount(type);
            List<Commodity> data = collegeService.findList(type,title, start, pageSize);
            page = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("addCollege")
    public String addCollege(Model model) {
        model.addAttribute("active", "addCollege");
        return "addCollege";
    }

    @RequestMapping("removeCollege")
    @ResponseBody
    public String removeCollege(int id, HttpServletRequest req) {
        try {
            College college = collegeService.selectOne(id);
            String servletContext =  req.getSession().getServletContext().getRealPath("/");
            if(StringUtil.isNotEmpty(college.getImg())) {
                PhotoUtil.removePhoto(servletContext+college.getImg().substring(1));
            }
            if(StringUtil.isNotEmpty(college.getVideo())) {
                PhotoUtil.removePhoto(servletContext+college.getVideo().substring(1));
            }
            collegeService.removeOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "addCollege";
    }


    @RequestMapping("editCollege")
    public String editCollege(Model model,int id) throws Exception {
        College college = collegeService.selectOne(id);
        model.addAttribute("college",college);
        model.addAttribute("active","college");
        return "editCollege";
    }

    @RequestMapping("editCollege2")
    @ResponseBody
    public String editCollege2(College college,String oldImg,String oldVideo,@RequestParam(value = "file1", required = false) MultipartFile file1,
                               @RequestParam(value = "file2", required = false) MultipartFile file2, HttpServletRequest req) {
        try {

            String img = null, video = null;
            String servletContext =  req.getSession().getServletContext().getRealPath("/");
            if (file1 != null) {
                img = PhotoUtil.photoUpload(file1, "images/home/college/",
                        file1.getOriginalFilename().substring(0,file1.getOriginalFilename().lastIndexOf(".")),
                        req.getSession().getServletContext().getRealPath("/"));
                if(StringUtil.isNotEmpty(oldImg)) {
                    PhotoUtil.removePhoto(servletContext+oldImg.substring(1));
                }
                college.setImg(img);
            }
            if (file2 != null) {
                video = PhotoUtil.photoUpload(file2, "images/home/college/video/",
                        file2.getOriginalFilename().substring(0,file2.getOriginalFilename().lastIndexOf(".")),
                        req.getSession().getServletContext().getRealPath("/"));
                if(StringUtil.isNotEmpty(oldVideo)) {
                    PhotoUtil.removePhoto(servletContext+oldVideo.substring(1));
                }
                college.setVideo(video);
            }
            college.setTime(new Date());
            collegeService.editOne(college);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "editCollege2";
    }

    @RequestMapping("addCollege2")
    @ResponseBody
    public Object addCollege2(String title, String content, byte type, @RequestParam(value = "file1", required = false) MultipartFile file1,
                               @RequestParam(value = "file2", required = false) MultipartFile file2, HttpServletRequest req) {

        try {
            String img = null, video = null;
            if (file1 != null) {
                img = PhotoUtil.photoUpload(file1, "images/home/college/",
                        file1.getOriginalFilename().substring(0,file1.getOriginalFilename().lastIndexOf(".")),
                        req.getSession().getServletContext().getRealPath("/"));
            }
            if (file2 != null) {
                video = PhotoUtil.photoUpload(file2, "images/home/college/video/",
                        file2.getOriginalFilename().substring(0,file2.getOriginalFilename().lastIndexOf(".")),
                        req.getSession().getServletContext().getRealPath("/"));
            }
            collegeService.addOne(title, content, img, video, type);

        } catch (IOException e) {
            e.printStackTrace();
            return "文件上传异常";
        } catch (FileException e) {
            e.printStackTrace();
            return "文件上传异常";
        } catch (Exception e) {
            e.printStackTrace();
            return "素材添加失败";
        }
        return "素材添加成功";
    }

    @RequestMapping("imageUp")
    public void imageUp(HttpServletRequest req, HttpServletResponse response,
                        @RequestParam(value = "upfile", required = false) MultipartFile upfile) throws Exception {
        Uploader up = new Uploader(req);
        up.setSavePath("upload");
        String[] fileType = {".gif", ".png", ".jpg", ".jpeg", ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile, req.getSession().getServletContext().getRealPath("/") ,"images/home/college");

        String callback = req.getParameter("callback");

        String result = "{\"name\":\"" + up.getFileName() + "\", \"originalName\": \"" + up.getOriginalName()+ "\", \"size\": " + up.getSize() + ", \"state\": \"" + up.getState() + "\", \"type\": \"" + up.getType() + "\", \"url\": \"" +up.getUrl() + "\"}";

        result = result.replaceAll("\\\\", "\\\\");

        if (callback == null) {
            response.getWriter().print(result);
        } else {
            response.getWriter().print("<script>" + callback + "(" + result + ")</script>");
        }
    }
}
