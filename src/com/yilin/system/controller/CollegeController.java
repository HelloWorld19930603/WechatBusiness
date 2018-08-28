package com.yilin.system.controller;

import com.yilin.app.domain.College;
import com.yilin.app.domain.Commodity;
import com.yilin.app.exception.FileException;
import com.yilin.app.service.ICollegeService;
import com.yilin.app.utils.PhotoUtil;
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
import java.util.List;

/**
 * Created by cc on 2018/8/25.
 */
@Controller
public class CollegeController {

    @Autowired
    ICollegeService collegeService;

    @RequestMapping("College")
    public String College(Model model) {
        model.addAttribute("active", "College");
        return "College";
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
    public String removeCollege(int id) {
        try {
            collegeService.removeOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "addCollege";
    }

    @RequestMapping("editCollege")
    @ResponseBody
    public String editCollege(College college) {
        try {
            collegeService.editOne(college);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "addCollege";
    }

    @RequestMapping("addCollege2")
    @ResponseBody
    public Object addCollege2(String title, String content, byte type, @RequestParam(value = "file1", required = false) MultipartFile file1,
                               @RequestParam(value = "file2", required = false) MultipartFile file2, HttpServletRequest req) {

        try {
            String img = null, video = null;
            if (file1 != null) {
                img = PhotoUtil.photoUpload(file1, "images/home/College/",
                        file1.getOriginalFilename().substring(0,file1.getOriginalFilename().lastIndexOf(".")),
                        req.getSession().getServletContext().getRealPath("/"));
            }
            if (file2 != null) {
                video = PhotoUtil.photoUpload(file2, "images/home/College/video/",
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
        up.upload(upfile, req.getSession().getServletContext().getRealPath("/") ,"images/home/College");

        String callback = req.getParameter("callback");

        String result = "{\"name\":\"" + up.getFileName() + "\", \"originalName\": \"" + up.getOriginalName()+ "\", \"size\": " + up.getSize() + ", \"state\": \"" + up.getState() + "\", \"type\": \"" + up.getType() + "\", \"url\": \"" +up.getOriginalName() + "\"}";

        result = result.replaceAll("\\\\", "\\\\");

        if (callback == null) {
            response.getWriter().print(result);
        } else {
            response.getWriter().print("<script>" + callback + "(" + result + ")</script>");
        }
    }
}