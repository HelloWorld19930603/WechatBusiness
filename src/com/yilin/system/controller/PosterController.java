package com.yilin.system.controller;

import com.yilin.app.domain.Poster;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/7.
 */
@Controller
public class PosterController {

    @Autowired
    IPosterService posterService;

    @RequestMapping("poster")
    public String poster(Model model) {
        model.addAttribute("active", "poster");

        return "poster";
    }

    @RequestMapping("getPoster")
    @ResponseBody
    public Object getPoster(String page, Byte type, int start, int pageSize) {
        int totals = 0;
        SystemPage systemPage = null;
        try {
            totals = posterService.selectNum(page, type);
            List<Map<String, Object>> data = posterService.selectList(page, type, start, pageSize);
            systemPage = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return systemPage;
    }

    @RequestMapping("removePoster")
    @ResponseBody
    public Object removePoster(int id) {

        try {
            posterService.removeOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @RequestMapping("addPoster")
    public String addPoster(Model model) {
        model.addAttribute("active", "addPoster");

        return "addPoster";
    }

    @RequestMapping("/addPoster2")
    @ResponseBody
    public Object addOne(Poster poster, @RequestParam( value="file",required=false) MultipartFile file, HttpServletRequest req) {

        try {
            String path = PhotoUtil.photoUpload(file, "images/home/poster/" , StringUtil.makeFileName(), req.getSession().getServletContext().getRealPath("/"));
            poster.setContent(path);
            poster.setSize(PhotoUtil.getPhotoSize(file));
            posterService.insertPoster(poster);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
