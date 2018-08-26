package com.yilin.system.controller;

import com.yilin.app.domain.Commodity;
import com.yilin.app.service.ICollegeService;
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
import java.util.List;

/**
 * Created by cc on 2018/8/25.
 */
@Controller
public class ColleageController {

    @Autowired
    ICollegeService collegeService;

    @RequestMapping("colleage")
    public String colleage(Model model){
        model.addAttribute("active","colleage");
        return "colleage";
    }

    @RequestMapping("getColleages")
    @ResponseBody
    public SystemPage getColleages(Byte type,int start,int pageSize){
        int totals = 0;
        SystemPage page = new SystemPage();
        try {
            totals = collegeService.getCount(type);
            List<Commodity> data = collegeService.findList(type,start,pageSize);
            page = new SystemPage(totals,data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("addColleage")
    public String addColleage(Model model){
        model.addAttribute("active","addColleage");
        return "addColleage";
    }


    @RequestMapping("imageUp")
    public void imageUp(HttpServletRequest req, HttpServletResponse response, @RequestParam MultipartFile upfile) throws Exception {
        Uploader up = new Uploader(req);
        up.setSavePath("upload");
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile,req.getSession().getServletContext().getRealPath("/")+"images/home/colleage");

        String callback = req.getParameter("callback");

        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getFileName() +"\"}";

        result = result.replaceAll( "\\\\", "\\\\" );

        if( callback == null ){
            response.getWriter().print( result );
        }else{
            response.getWriter().print("<script>"+ callback +"(" + result + ")</script>");
        }
    }
}
