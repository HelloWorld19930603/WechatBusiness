package com.yilin.system.controller;

import com.yilin.app.domain.CommDetail;
import com.yilin.app.domain.Commodity;
import com.yilin.app.domain.Price;
import com.yilin.app.exception.FileException;
import com.yilin.app.service.ICommodityService;
import com.yilin.app.service.IPriceService;
import com.yilin.app.utils.PhotoUtil;
import com.yilin.app.utils.StringUtil;
import com.yilin.system.common.SystemPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * Created by cc on 2018/8/19.
 */
@Controller
public class CommodityController {


    @Autowired
    ICommodityService commodityService;
    @Autowired
    IPriceService priceService;

    @RequestMapping("commodity")
    public String commodity(Model model) {
        model.addAttribute("active", "commodity");

        return "commodity";
    }

    @RequestMapping("getCommoditys")
    @ResponseBody
    public SystemPage getCommoditys(Integer serise, int start, int pageSize) {
        if (serise == -1) {
            serise = null;
        }
        int totals = 0;
        SystemPage page = new SystemPage();
        try {
            totals = commodityService.getCount(null, serise);
            List<Commodity> data = commodityService.selectPage2(null, null, serise, start, pageSize);
            page = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("addCommodity")
    public String addCommodity(Model model) {
        model.addAttribute("active", "addCommodity");

        return "addCommodity";
    }

    @RequestMapping("editCommodity")
    public String editCommodity(Model model, int commId) {
        try {
            Commodity commodity = commodityService.selectById(commId, null);

            model.addAttribute("active", "commodity");
            model.addAttribute("commodity", commodity);
            return "editCommodity";
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }

    }

    @RequestMapping("editPrice")
    public String editCommodity(Model model,int commId, byte serise) {
        try {
            Float[] price = priceService.findAllPrice(commId);
            model.addAttribute("active", "commodity");
            model.addAttribute("price", price);
            model.addAttribute("commId", commId);
            model.addAttribute("serise", serise);
            switch (serise){
                case 1 :return  "editPrice1";
                case 2 :return  "editPrice2";
                case 3 :return  "editPrice3";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
        return "500";
    }

    @RequestMapping("updatePrice")
    @ResponseBody
    public String updatePrice(Float[] prices,int commId,HttpServletRequest req) {
        try {
            for(int i=0;i<prices.length;i++) {
                priceService.editPrice(prices[i], commId,i);
            }
            return "编辑成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "编辑失败";
        }
    }

    @RequestMapping("editCommodity2")
    @ResponseBody
    public String editCommodity2(Commodity commodity, @RequestParam(value = "file", required = false) MultipartFile file,
                                  HttpServletRequest req) {
        try {
            if (file != null) {
                String servletContext = req.getSession().getServletContext().getRealPath("/");
                String imgPath = PhotoUtil.photoUpload(file, "images/home/commodity/", StringUtil.makeFileName()
                        , servletContext);
                String context = req.getSession().getServletContext().getRealPath("/");
                PhotoUtil.removePhoto(context+commodity.getImg().substring(1));
                commodity.setImg(imgPath);
            }
            commodityService.updateOne(commodity);
            return "编辑成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "编辑失败";
        }
    }

    @RequestMapping("removeCommodity")
    @ResponseBody
    public String removeCommodity(int commId) {
        try {
            commodityService.deleteOne(commId);
            return "删除成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "删除失败";
        }
    }

    @RequestMapping("addCommodity2")
    @ResponseBody
    public String addCommodity2(Commodity commodity, Float[] prices, @RequestParam(value = "file", required = false) MultipartFile file
            , @RequestParam(value = "file2", required = false) MultipartFile file2, @RequestParam(value = "file3", required = false) MultipartFile file3
            , HttpServletRequest req) {
        try {
            String img1 = "", img2 = null, img3 = null;
            if (file != null) {
                img1 = PhotoUtil.photoUpload(file, "images/home/commodity/", StringUtil.makeFileName()
                        , req.getSession().getServletContext().getRealPath("/"));
            }
            if (file2 != null) {
                img2 = PhotoUtil.photoUpload(file2, "images/home/commodity/detail/", StringUtil.makeFileName()
                        , req.getSession().getServletContext().getRealPath("/"));
            }
            if (file3 != null) {
                img3 = PhotoUtil.photoUpload(file3, "images/home/commodity/detail/", StringUtil.makeFileName()
                        , req.getSession().getServletContext().getRealPath("/"));
            }
            commodity.setImg(img1);
            commodityService.addCommodity(commodity);
            for (int i = 0; i < prices.length; i++) {
                priceService.addPrice(new Price(commodity.getId(), i, prices[i]));
            }
            if (img2 != null) {
                commodityService.addCommDetail(new CommDetail(commodity.getId(), img2));
            }
            if (img3 != null) {
                commodityService.addCommDetail(new CommDetail(commodity.getId(), img3));
            }
            return "商品添加成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传异常";
        } catch (FileException e) {
            e.printStackTrace();
            return "图片上传异常";
        } catch (Exception e) {
            e.printStackTrace();
            return "商品添加异常";
        }
    }
}
