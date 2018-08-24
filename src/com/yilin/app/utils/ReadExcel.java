package com.yilin.app.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */
public class ReadExcel {


    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 去读Excel的方法，该方法的入口参数为一个File对象
     *
     * @param file
     * @return
     */
    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            List<List<List>> result = new ArrayList<>();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList = new ArrayList<>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0, m = 0; i < sheet.getRows(); i++, m++) {
                    List<String> innerList = new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if (cellinfo.isEmpty()) {
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    for (String s : innerList) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    outerList.add(m, innerList);
                }
                result.add(outerList);
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    static void commodity(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 1 ; i < 13; i++) {
            StringBuilder sql = new StringBuilder(" insert into commodity (name,e_name, serise,scale, stock,img ) values(  ");
            List l = excelList.get(i);
            sql.append("'").append(l.get(0)).append("'").append(",");
            sql.append("'").append(l.get(1)).append("'").append(",");
            sql.append("'").append(1).append("'").append(",");
            sql.append("'").append(l.get(12)).append("'").append(",");
            sql.append("'").append(999).append("',");
            sql.append("'").append("/images/home/commodity/"+i+"/"+i+".jpg").append("'");
            sql.append(")");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

    static void commoDetail() {
        for (int i = 1 ; i < 13; i++) {
            StringBuilder sql = new StringBuilder(" insert into comm_detail (comm_id,url ) values(  ");
            sql.append("'").append(i).append("'").append(",");

            sql.append("'").append("/images/home/commodity/"+i+"/"+i+"-1.jpg").append("'");
            sql.append(")");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

    static void price(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 17; i < 18; i++) {
            for (int j = 1; j < 8; j++) {
                StringBuilder sql = new StringBuilder(" insert into price (comm_id,role_id, price) values(  ");
                List l = excelList.get(i);
                sql.append("").append(i - 3).append("").append(",");
                sql.append("").append(j).append("").append(",");
                sql.append("").append(l.get(j + 2)).append("");

                sql.append(")");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
            }
        }
    }


        public static void main(String[] args) {

        String fileName = "D:\\weishang\\格丽缇\\工作簿1.xls";
       // domain(fileName);
        commoDetail();
       // inserExpress();
    }


    public static void domain(String fileName) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File(fileName);
        List<List<List>> excelAllList = obj.readExcel(file);
        for (int n = 0; n < excelAllList.size(); n++) {
            //commodity(excelAllList.get(n), n);
            // price(excelAllList.get(n), n);
        }


    }

    public static void inserExpress(){
        String express = "[{\"com\":\"顺丰\",\"no\":\"sf\"},{\"com\":\"申通\",\"no\":\"sto\"},{\"com\":\"圆通\",\"no\":\"yt\"},{\"com\":\"韵达\",\"no\":\"yd\"},{\"com\":\"天天\",\"no\":\"tt\"},{\"com\":\"EMS\",\"no\":\"ems\"},{\"com\":\"中通\",\"no\":\"zto\"},{\"com\":\"汇通\",\"no\":\"ht\"},{\"com\":\"全峰\",\"no\":\"qf\"},{\"com\":\"德邦\",\"no\":\"db\"},{\"com\":\"国通\",\"no\":\"gt\"},{\"com\":\"如风达\",\"no\":\"rfd\"},{\"com\":\"京东快递\",\"no\":\"jd\"},{\"com\":\"宅急送\",\"no\":\"zjs\"},{\"com\":\"EMS国际\",\"no\":\"emsg\"},{\"com\":\"Fedex国际\",\"no\":\"fedex\"},{\"com\":\"邮政国内（挂号信）\",\"no\":\"yzgn\"},{\"com\":\"UPS国际快递\",\"no\":\"ups\"},{\"com\":\"中铁快运\",\"no\":\"ztky\"},{\"com\":\"佳吉快运\",\"no\":\"jiaji\"},{\"com\":\"速尔快递\",\"no\":\"suer\"},{\"com\":\"信丰物流\",\"no\":\"xfwl\"},{\"com\":\"优速快递\",\"no\":\"yousu\"},{\"com\":\"中邮物流\",\"no\":\"zhongyou\"},{\"com\":\"天地华宇\",\"no\":\"tdhy\"},{\"com\":\"安信达快递\",\"no\":\"axd\"},{\"com\":\"快捷速递\",\"no\":\"kuaijie\"},{\"com\":\"AAE全球专递\",\"no\":\"aae\"},{\"com\":\"DHL\",\"no\":\"dhl\"},{\"com\":\"DPEX国际快递\",\"no\":\"dpex\"},{\"com\":\"D速物流\",\"no\":\"ds\"},{\"com\":\"FEDEX国内快递\",\"no\":\"fedexcn\"},{\"com\":\"OCS\",\"no\":\"ocs\"},{\"com\":\"TNT\",\"no\":\"tnt\"},{\"com\":\"东方快递\",\"no\":\"coe\"},{\"com\":\"传喜物流\",\"no\":\"cxwl\"},{\"com\":\"城市100\",\"no\":\"cs\"},{\"com\":\"城市之星物流\",\"no\":\"cszx\"},{\"com\":\"安捷快递\",\"no\":\"aj\"},{\"com\":\"百福东方\",\"no\":\"bfdf\"},{\"com\":\"程光快递\",\"no\":\"chengguang\"},{\"com\":\"递四方快递\",\"no\":\"dsf\"},{\"com\":\"长通物流\",\"no\":\"ctwl\"},{\"com\":\"飞豹快递\",\"no\":\"feibao\"},{\"com\":\"马来西亚（大包EMS）\",\"no\":\"malaysiaems\"},{\"com\":\"安能快递\",\"no\":\"ane66\"}]" ;
        JSONArray jsonArray = JSONArray.parseArray(express);

        for(int i = 0;i<jsonArray.size();i++){
            String sql = "insert into express(name,com) values(";
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            sql += "'"+jsonObject.get("com")+"',";
            sql+="'"+jsonObject.get("no")+"');";
            SqlUtils.getInstance().update(sql);
        }
    }


}
