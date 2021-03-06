package com.yilin.system.controller;

import com.yilin.app.common.JuHelogistics;
import com.yilin.app.domain.*;
import com.yilin.app.service.IAddressService;
import com.yilin.app.service.IOrderService;
import com.yilin.app.service.IRoleService;
import com.yilin.app.service.ISystemLogService;
import com.yilin.app.utils.WriteExcel;
import com.yilin.system.common.SystemPage;
import com.yilin.system.service.IDataTmpService;
import com.yilin.system.service.ILogisticsService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/27.
 */
@Controller
public class OrderController {

    @Autowired
    IOrderService orderService;
    @Autowired
    IAddressService addressService;
    @Autowired
    ILogisticsService logisticsService;
    @Autowired
    IRoleService roleService;
    @Autowired
    ISystemLogService systemLogService;
    @Autowired
    IDataTmpService dataTmpService;

    //解决设置名称时的乱码
    public static String processFileName(HttpServletRequest request, String fileNames) {
        String codedfilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent
                    && -1 != agent.indexOf("Trident")) {// ie

                String name = java.net.URLEncoder.encode(fileNames, "UTF8");

                codedfilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等


                codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedfilename;
    }

    @RequestMapping("order")
    public String order(Model model) {
        model.addAttribute("active", "order");

        return "order";
    }

    @RequestMapping("getOrders")
    @ResponseBody
    public SystemPage getOrders(String orderId, String name, String phone, Byte status, Byte serise, String startDate, String endDate,
                                int start, int pageSize) {
        int totals = 0;

        SystemPage page = new SystemPage();
        try {
            totals = orderService.getCount(orderId, name, phone, status, serise, startDate, endDate);
            List data = orderService.selectList2(orderId, name, phone, status, serise, startDate, endDate, start, pageSize);
            page = new SystemPage(totals, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("getExpress")
    @ResponseBody
    public Object getExpress() {
        try {
            List list = logisticsService.findExpress();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("getLogistics")
    public Object getLogistics(String no, String com, Model model) {
        try {
            Object logistics = JuHelogistics.getRequest1(com, no);
            model.addAttribute("logistics", logistics);
            model.addAttribute("active", "order");
            return "logistics";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "单号不存在或者已经过期!");
            return "logistics";
        }
    }

    @RequestMapping("deliverGoods")
    public String deliverGoods(Model model, String orderId) {
        model.addAttribute("active", "order");
        model.addAttribute("orderId", orderId);
        return "addLogistics";
    }

    @RequestMapping("deliverGoods2")
    @ResponseBody
    public Object deliverGoods2(String orderId, String com, String no, String name,HttpServletRequest req) {
        Logistics logistics = new Logistics();
        logistics.setId(no);
        logistics.setCom(com);
        logistics.setName(name);
        logistics.setOrderId(orderId);
        logistics.setTime(new Date());
        try {
            logisticsService.removeByOrder(orderId);
            logisticsService.addOne(logistics);
            orderService.updateStatus(orderId, null, 3, 2);
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+orderId+"的订单进行了发货操作，物流单号为"+no, 4, user.getLoginName()));
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }

    }

    @RequestMapping("editOrder2")
    @ResponseBody
    public Object editOrder2(Orders order,HttpServletRequest req) {
        try {
            orderService.editOrder(order);
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+order.getId()+"的订单信息进行了修改", 5, user.getLoginName()));
            dataTmpService.addOne(new DataTmp((int)order.getSerise(),3,order.getId(),2));
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping("editAddress")
    @ResponseBody
    public Object editAddress(Orders order,HttpServletRequest req) {
        try {
            orderService.editOrder(order);
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+order.getId()+"的订单收货地址进行了修改", 6, user.getLoginName()));
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping("receivingAddress")
    public String receivingAddress(int addrId, Model model) throws Exception {
        Address address = addressService.findAddress(addrId);
        model.addAttribute("address", address);
        model.addAttribute("active", "order");

        return "address";
    }

    @RequestMapping("editOrder")
    public Object editOrder(String orderId, Model model) {
        try {
            Map map = orderService.findOrder(orderId);
            List list = orderService.selectDetails(orderId);
            UserRole userRole = roleService.selectRole((int) map.get("userId"), (int) map.get("serise"));
            model.addAttribute("list", list);
            model.addAttribute("order", map);
            model.addAttribute("userRole", userRole);
            model.addAttribute("active", "order");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "editOrder";
    }

    @RequestMapping("reviewCode")
    @ResponseBody
    public Object reviewCode(OrderComm orderComm,HttpServletRequest req) {
        try {
            orderService.editOrderComm(orderComm);
            SystemUser user = (SystemUser) req.getSession().getAttribute("user");
            systemLogService.log(new SystemLog("用户" + user.getName() + "对编号为"+orderComm.getOrderId()+"的订单追溯码进行了修改", 7, user.getLoginName()));
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    @RequestMapping("traceability")
    public String traceability(Model model) {
        model.addAttribute("active", "traceability");

        return "traceability";
    }

    @RequestMapping("traceability2")
    @ResponseBody
    public Object traceability2(String code,HttpServletRequest req) {
        try {
            Map commMap = orderService.selectByCode(code);
            JSONObject jsonObject = JSONObject.fromObject(commMap);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("writeOrders")
    public void writeOrders(HttpServletRequest req, HttpServletResponse resp, String startDate, String endDate) {
        try {

            Map<String, String> dic = new HashedMap();
            dic.put("id", "订单编号");
            dic.put("addrName", "购买人姓名");
            dic.put("phone", "购买人电话");
            dic.put("totals", "总金额");
            dic.put("serise", "系列");
            dic.put("ssq", "省市区");
            dic.put("addr", "详细地址");
            dic.put("no", "物流单号");
            dic.put("express", "物流公司");
            dic.put("description", "留言");
            dic.put("time", "下单时间");
            OutputStream out = resp.getOutputStream();
            resp.setContentType("application/vnd.ms-excel;charset=utf-8");
            resp.setHeader("Content-disposition", "attachment; filename=" + processFileName(req, "订单" + startDate + "_" + endDate + ".xls"));
            List<Map> list = orderService.selectList3(startDate, endDate, null);
            WriteExcel.writeExcel(list, dic, out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
