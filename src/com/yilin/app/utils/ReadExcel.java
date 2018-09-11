package com.yilin.app.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.collections.map.HashedMap;

import java.io.*;
import java.util.*;

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

                        innerList.add(cellinfo);
                    }
                    for (String s : innerList) {
                      //  System.out.print(s + " ");
                    }
                  //  System.out.println();
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

       // String fileName = "D:\\weishang\\格丽缇\\工作簿1.xls";
       // domain( "D:\\weishang\\格丽缇\\工作簿1.xls");
      //  commoDetail();
        inserExpress();
            //    domain("e:\\agent.xls");

    }


    public static void domain(String fileName) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File(fileName);
        List<List<List>> excelAllList = obj.readExcel(file);
        for (int n = 0; n < excelAllList.size(); n++) {
            //commodity(excelAllList.get(n), n);
            // price(excelAllList.get(n), n);
            user(excelAllList.get(n), n);
        }
    }
/*        '1': '股东',
                '2': '联创',
                '3': '执行董事',
                '4': '官方',
                '5': '总代理',
                '6': '一级代理',
                '7': '二级代理',
                '8': '特约'*/

    private static void user(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        Map<String,Integer> map1 = new HashedMap();
        map1.put("股东",1);
        map1.put("联合创始人",2);
        map1.put("执行董事",3);
        map1.put("官方",4);
        map1.put("总代",5);
        map1.put("一级",6);
        map1.put("二级",7);
        map1.put("特约代理",8);
        /*        '1': '股东',
                '2': '合伙人',
                '3': '经理',
                '4': '执行董事',
                '5': '官方',
                '6': '总代',
                '7': '体验'*/
        Map<String,Integer> map2 = new HashedMap();
        map2.put("股东",1);
        map2.put("合伙人",2);
        map2.put("经理",3);
        map2.put("执行董事",4);
        map2.put("官方",5);
        map2.put("总代",6);
/*        '1': '股东',
                '2': '合伙人',
                '3': '执行董事',
                '4': '官方',
                '5': '总代理',
                '6': '一级代理',
                '7': '体验'*/
        Map<String,Integer> map3 = new HashedMap();
        map3.put("股东",1);
        map3.put("合伙人",2);
        map3.put("执行董事",3);
        map3.put("官方",4);
        map3.put("总代",5);
        map3.put("一级",6);
        Set<String> set1  = new HashSet<>();
        Set<String> set2  = new HashSet<>();
        Set<String> set3  = new HashSet<>();
        String sql1 = "select max(id) from user";
        //E10ADC3949BA59ABBE56E057F20F883E
        StringBuilder sql2 ;
        int num = 0;
        for (int i = 1; i < 2234; i++) {

            StringBuilder sql = new StringBuilder(" insert into user (`name`, `login_name`, `login_pwd`, `pay_pwd`, `sex`, `sup_id`, `phone`, `wx_num`, `id_num`, `status`) values(  ");
            List l = excelList.get(i);
            boolean flag = false;
            Integer role1 = map1.get(((String) l.get(0)).trim());
            Integer role2 = map2.get(((String) l.get(1)).trim());
            Integer role3 = map2.get(((String) l.get(2)).trim());
            if (role1 != null && role1 < 3) {
                flag = true;
            }
            if (role2 != null && role2 < 3) {
                flag = true;
            }
            if (role2 != null && role2 < 3) {
                flag = true;
            }
            Integer supId = null;

/*            JSONArray array = SqlUtils.getInstance().search("(select id from user where name = '"+((String)l.get(6)).trim()+"')");
            if(array != null && array.size() > 0) {
                supId = (Integer) ((JSONObject) array.get(0)).get("id");
            }*/
            sql.append("'").append(((String) l.get(3)).trim()).append("'").append(",");
            sql.append("'").append(l.get(5)).append("'").append(",");
            sql.append("'").append("E10ADC3949BA59ABBE56E057F20F883E").append("'").append(",");
            sql.append("'").append("E10ADC3949BA59ABBE56E057F20F883E").append("'").append(",");
            sql.append("'").append("女").append("'").append(",");
            sql.append("").append(supId).append(",");
            sql.append("'").append(l.get(5)).append("'").append(",");
            sql.append("'").append(l.get(4)).append("'").append(",");
            sql.append("'").append(l.get(7)).append("'").append(",");
            if (flag) {
                sql.append("'").append(1).append("'").append(")");
            } else {
                sql.append("'").append(0).append("'").append(")");
            }
            // SqlUtils.getInstance().insert(sql.toString());
            sql2 = new StringBuilder("insert into user_role(user_id,role_id,serise) values(");
            StringBuilder sql3 = new StringBuilder("insert into wallet(user_id,serise) values(");
            if (role1 != null) {
                sql2.append("(").append(sql1).append("),");
                sql2.append(role1).append(",");
                sql2.append(1).append(")");
                //  SqlUtils.getInstance().insert(sql2.toString());
                sql3.append("(select id from user where login_name = '" + l.get(5)).append("'),").append(1).append(")");
                SqlUtils.getInstance().insert(sql3.toString());
            }
            sql2 = new StringBuilder("insert into user_role(user_id,role_id,serise) values(");
             sql3 = new StringBuilder("insert into wallet(user_id,serise) values(");
            if (role2 != null) {
                sql2.append("(").append(sql1).append("),");
                sql2.append(role2).append(",");
                sql2.append(2).append(")");
                //  SqlUtils.getInstance().insert(sql2.toString());
                sql3.append("(select id from user where login_name = '" + l.get(5)).append("'),").append(2).append(")");
                SqlUtils.getInstance().insert(sql3.toString());
            }
            sql2 = new StringBuilder("insert into user_role(user_id,role_id,serise) values(");
            sql3 = new StringBuilder("insert into wallet(user_id,serise) values(");
            if (role3 != null) {
                sql2.append("(").append(sql1).append("),");
                sql2.append(role3).append(",");
                sql2.append(3).append(")");
                // SqlUtils.getInstance().insert(sql2.toString());
                sql3.append("(select id from user where login_name = '" + l.get(5)).append("'),").append(3).append(")");
                SqlUtils.getInstance().insert(sql3.toString());
            }


/*                    set1.add((String) l.get(0));
                    set2.add((String) l.get(1));
                    set3.add((String) l.get(2));
               // SqlUtils.getInstance().update(sql.toString());
              //  System.out.println(sql);
        }
        System.out.println(num);
        System.out.println("\n系列1：");
        for(String s1 : set1){

            System.out.print(s1 + " ");
        }
        System.out.println("\n系列2：");
        for(String s2 : set2){

            System.out.print(s2 + " ");
        }
        System.out.println("\n系列3：");
        for(String s3 : set3){

            System.out.print(s3 + " ");
        }*/
        }
    }

    public static void inserExpress(){
        String express = "[{\"com\":\"顺丰\",\"no\":\"sf\"},{\"com\":\"申通\",\"no\":\"sto\"},{\"com\":\"圆通\",\"no\":\"yt\"},{\"com\":\"韵达\",\"no\":\"yd\"},{\"com\":\"天天\",\"no\":\"tt\"},{\"com\":\"EMS\",\"no\":\"ems\"},{\"com\":\"中通\",\"no\":\"zto\"},{\"com\":\"汇通\",\"no\":\"ht\"},{\"com\":\"全峰\",\"no\":\"qf\"},{\"com\":\"德邦\",\"no\":\"db\"},{\"com\":\"国通\",\"no\":\"gt\"},{\"com\":\"如风达\",\"no\":\"rfd\"},{\"com\":\"京东快递\",\"no\":\"jd\"},{\"com\":\"宅急送\",\"no\":\"zjs\"},{\"com\":\"EMS国际\",\"no\":\"emsg\"},{\"com\":\"Fedex国际\",\"no\":\"fedex\"},{\"com\":\"邮政国内（挂号信）\",\"no\":\"yzgn\"},{\"com\":\"UPS国际快递\",\"no\":\"ups\"},{\"com\":\"中铁快运\",\"no\":\"ztky\"},{\"com\":\"佳吉快运\",\"no\":\"jiaji\"},{\"com\":\"速尔快递\",\"no\":\"suer\"},{\"com\":\"信丰物流\",\"no\":\"xfwl\"},{\"com\":\"优速快递\",\"no\":\"yousu\"},{\"com\":\"中邮物流\",\"no\":\"zhongyou\"},{\"com\":\"天地华宇\",\"no\":\"tdhy\"},{\"com\":\"安信达快递\",\"no\":\"axd\"},{\"com\":\"快捷速递\",\"no\":\"kuaijie\"},{\"com\":\"AAE全球专递\",\"no\":\"aae\"},{\"com\":\"DHL\",\"no\":\"dhl\"},{\"com\":\"DPEX国际快递\",\"no\":\"dpex\"},{\"com\":\"D速物流\",\"no\":\"ds\"},{\"com\":\"FEDEX国内快递\",\"no\":\"fedexcn\"},{\"com\":\"OCS\",\"no\":\"ocs\"},{\"com\":\"TNT\",\"no\":\"tnt\"},{\"com\":\"东方快递\",\"no\":\"coe\"},{\"com\":\"传喜物流\",\"no\":\"cxwl\"},{\"com\":\"城市100\",\"no\":\"cs\"},{\"com\":\"城市之星物流\",\"no\":\"cszx\"},{\"com\":\"安捷快递\",\"no\":\"aj\"},{\"com\":\"百福东方\",\"no\":\"bfdf\"},{\"com\":\"程光快递\",\"no\":\"chengguang\"},{\"com\":\"递四方快递\",\"no\":\"dsf\"},{\"com\":\"长通物流\",\"no\":\"ctwl\"},{\"com\":\"飞豹快递\",\"no\":\"feibao\"},{\"com\":\"马来西亚（大包EMS）\",\"no\":\"malaysiaems\"},{\"com\":\"安能快递\",\"no\":\"ane66\"}]" ;
        JSONArray jsonArray = JSONArray.parseArray(express);
        String str = "[";
        for(int i = 0;i<jsonArray.size();i++){
            String sql = "insert into express(name,com) values(";
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            sql += "'"+jsonObject.get("com")+"',";
            sql+="'"+jsonObject.get("no")+"');";
            //SqlUtils.getInstance().update(sql);

            str +="{'no':'"+jsonObject.get("no")+"':'"+jsonObject.get("com")+"'},";

        }
        str += "]";
        System.out.println(express);
    }


}
