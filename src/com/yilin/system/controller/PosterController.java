package com.yilin.system.controller;

import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object getUsers(String page, Byte type, int start, int pageSize) {
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
}
