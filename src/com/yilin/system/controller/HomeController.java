package com.yilin.system.controller;

import com.yilin.app.utils.PhotoUtil;
import com.yilin.system.common.Uploader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * Created by cc on 2018/8/10.
 */
@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(Model model){
        model.addAttribute("active","index");
        return "system";
    }

    @RequestMapping("table")
    public String table(Model model){
        model.addAttribute("active","test");
        return "table";
    }

    @RequestMapping("form")
    public String form(Model model){
        model.addAttribute("active","test2");
        return "form";
    }


}
