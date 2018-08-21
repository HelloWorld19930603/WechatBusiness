package com.yilin.app.utils;

import com.alibaba.fastjson.JSONArray;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */
public class ReadExcel2 {



    public static void main(String[] args) {
        String fileName = "f:/信息统计模版(湖州市)汇总1.xls";
        //String fileName = "f:/1.xls";
        domain(fileName);
    }


    public static void domain(String fileName) {
        ReadExcel2 obj = new ReadExcel2();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File(fileName);
        List<List<List>> excelAllList = obj.readExcel(file);
        for (int n = 0; n < excelAllList.size(); n++) {

            enterpriseinfo(excelAllList.get(n), n);
           // nyzt(excelAllList.get(n), n);
           // commodity(excelAllList.get(n), n);
            //lsgnq(excelAllList.get(n), n);
           // nysfq(excelAllList.get(n),n);
           // enterpriseinfo(excelAllList.get(n), n);
/*            huahui(excelAllList.get(n),n);
            shiyongjun(excelAllList.get(n),n);
            canshang(excelAllList.get(n),n);
            chaye(excelAllList.get(n),n);
            shucai(excelAllList.get(n),n);
            suiguo(excelAllList.get(n),n);
            liangyou(excelAllList.get(n),n);
            suican(excelAllList.get(n),n);
            rjsr(excelAllList.get(n),n);
             nycz(excelAllList.get(n),n);
            yc(excelAllList.get(n),n);*/
        }

    }


    static void nysfq(List<List> excelList, int n) {
        if (n != 1) {
            return;
        }

        for (int i = 1; i < excelList.size(); i++) {
            List l = excelList.get(i);
            String str = "select count(*) num from res_stxhsfq where sfqmc = '%s'";
            str = String.format(str,l.get(0).toString().trim());
            JSONArray jsonArray = SqlUtils.getInstance().search(str);
            int num = (int) jsonArray.getJSONObject(0).get("num");
            System.out.println(l.get(0)+"  "+num);
            System.out.println(str);
            if(num == 0){
                System.out.println("1----"+l.get(0));
                StringBuilder sql = new StringBuilder(" insert into res_stxhsfq (sfqmc,area, areacode,cjmj) values(  ");
                sql.append("'").append(l.get(0)).append("'").append(",");
                sql.append("'").append(l.get(1)).append("'").append(",");
                sql.append("'").append(l.get(2)).append("'").append(",");
                sql.append("'").append(Float.valueOf(l.get(4).toString())).append("'");

                sql.append(")");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
            }else{
                StringBuilder sql = new StringBuilder(" update res_stxhsfq set  ");
                sql.append("jd_tdt=").append("'").append(l.get(5)).append("'").append(",");
                sql.append("wd_tdt=").append("'").append(l.get(6)).append("'");

                sql.append("where sfqmc = '").append(l.get(0)).append("'");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
            }
        }
    }


    static void nyzt(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }

        for (int i = 1; i < excelList.size(); i++) {
            List l = excelList.get(i);
            String str = "select count(*) num from res_stxhsfzt where ztmc = '%s'";
            str = String.format(str,l.get(0).toString().trim());
            JSONArray jsonArray = SqlUtils.getInstance().search(str);
            int num = (int) jsonArray.getJSONObject(0).get("num");
            if(num == 0){
                System.out.println("1----"+l.get(0));
                StringBuilder sql = new StringBuilder(" insert into res_stxhsfzt (ztmc,ztlx, area,areacode,lqmc, cyjgm,zyys,sdyj) values(  ");
                sql.append("'").append(l.get(0)).append("'").append(",");
                sql.append("'").append(l.get(1)).append("'").append(",");
                sql.append("'").append(l.get(2)).append("'").append(",");
                sql.append("'").append(3305).append("'").append(",");
                sql.append("'").append(l.get(4)).append("'").append(",");
                sql.append("'").append(l.get(5)).append("'").append(",");
                sql.append("'").append(l.get(6)).append("'").append(",");
                sql.append("'").append(l.get(7)).append("'");
                sql.append(")");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
            }else{
                StringBuilder sql = new StringBuilder(" update res_stxhsfzt set ");
                sql.append("ztlx=").append("'").append(l.get(1)).append("'").append(",");
                sql.append("area=").append("'").append(l.get(2)).append("'").append(",");
                sql.append("lqmc=").append("'").append(l.get(4)).append("'").append(",");
                sql.append("cyjgm=").append("'").append(l.get(5)).append("'").append(",");
                sql.append("zyys=").append("'").append(l.get(6)).append("'").append(",");
                sql.append("sdyj=").append("'").append(l.get(7)).append("'").append(",");
                sql.append("areacode=").append(3305).append(",");
                sql.append("jd_tdt=").append("'").append(l.get(8)).append("'").append(",");
                sql.append("wd_tdt=").append("'").append(l.get(9)).append("'");
                sql.append(" where ztmc = ").append("'").append(l.get(0)).append("'");
                System.out.println(sql);
                SqlUtils.getInstance().update(sql.toString());
            }
        }
    }




    static void lsgnq(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 2; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder(" insert into res_lsgnq (rdmc,rdbh, ghmc,city, county,rdmj) values(  ");
            List l = excelList.get(i);

            sql.append("'").append(l.get(1)).append("'").append(",");
            sql.append("'").append(l.get(2)).append("'").append(",");
            sql.append("'").append(l.get(3)).append("'").append(",");
            sql.append("'").append(3305).append("'").append(",");
            sql.append("'").append(330523).append("'").append(",");
            sql.append("'").append(l.get(10)).append("'");

            sql.append(")");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }


    static void commodity(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 23; i < 24; i++) {
            StringBuilder sql = new StringBuilder(" insert into commodity (name,e_name, series,scale, stock ) values(  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null || l.get(0).equals("")) {
                continue;
            }
            sql.append("'").append(l.get(0)).append("'").append(",");
            sql.append("'").append(l.get(1)).append("'").append(",");
            sql.append("'").append(2).append("'").append(",");
            sql.append("'").append(l.get(11)).append("'").append(",");
            sql.append("'").append(99).append("'");

            sql.append(")");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }




    static void enterpriseinfo(List<List> excelList, int n) {
        if (n == 0 || n == 1) {
        }else {
            return;
        }

        for (int i = 1; i < excelList.size(); i++) {
            List l = excelList.get(i);
            String str = "select count(*) num from enterprise_info where en_name = '%s'";
            str = String.format(str, l.get(1).toString().trim());
            JSONArray jsonArray = SqlUtils.getInstance().search(str);
            int num = (int) jsonArray.getJSONObject(0).get("num");
            if (num == 0) {
                if (l.size() == 0 || l.get(0) == null || l.get(0).equals("")) {
                    continue;
                }
                StringBuilder sql = new StringBuilder("insert into  enterprise_info(en_name,en_contact,en_contact_num,en_lon,en_lat,en_address,status,subject_type,unite_credit_code,business_scope) values(  ");

                sql.append("'").append(l.get(1)).append("'").append(",");
                sql.append("'").append(l.get(3)).append("'").append(",");
                sql.append("'").append(l.get(4)).append("'").append(",");
                sql.append("'").append(l.get(5)).append("'").append(",");
                sql.append("'").append(l.get(6)).append("'").append(",");
                sql.append("'").append(l.get(9)).append("'").append(",");
                sql.append(1).append(",");
                if (n == 0) {
                    sql.append("'").append(199002).append("'").append(",");
                } else if (n == 1) {
                    sql.append("'").append(199003).append("'").append(",");
                }
                sql.append("'").append(l.get(12)).append("'").append(",");
                sql.append("'").append(l.get(13)).append("'");

                sql.append(")");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
        }else{
            if (l.size() == 0 || l.get(0) == null || l.get(0).equals("")) {
                continue;
            }
            StringBuilder sql = new StringBuilder("update enterprise_info set  ");

            sql.append("en_name='").append(l.get(1)).append("'").append(",");
            sql.append("en_contact='").append(l.get(3)).append("'").append(",");
            sql.append("en_contact_num='").append(l.get(4)).append("'").append(",");
            sql.append("en_lon='").append(l.get(5)).append("'").append(",");
            sql.append("en_lat='").append(l.get(6)).append("'").append(",");
            sql.append("en_address='").append(l.get(9)).append("'").append(",");
            sql.append("status=").append(1).append(",");
            if (n == 12) {
                sql.append("subject_type='").append(199002).append("'").append(",");
            } else if (n == 13) {
                sql.append("subject_type='").append(199003).append("'").append(",");
            }
            sql.append("unite_credit_code='").append(l.get(12)).append("'").append(",");
            sql.append("business_scope='").append(l.get(13)).append("'");

            sql.append(" where en_name='").append(l.get(1)).append("'");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
        }
    }

    static void huahui(List<List> excelList, int n) {
        if (n != 11) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  M_argicCyInfo set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("mj = ").append(l.get(1));

            sql.append(" where  type='132124' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

    static void shiyongjun(List<List> excelList, int n) {
        if (n != 8) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_nzwscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null || l.get(0).toString().length() == 0) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("syjzcl = ").append(l.get(1)).append(",");
            sql.append("syjzcz = ").append(l.get(2)).append(",");
            sql.append("xmgscgm = ").append(l.get(3)).append(",");
            sql.append("xmgcl = ").append(l.get(4)).append(",");
            sql.append("xpgscgm = ").append(l.get(6)).append(",");
            sql.append("xpgcl = ").append(l.get(7)).append(",");
            sql.append("xxgscgm = ").append(l.get(9)).append(",");
            sql.append("xxgcl = ").append(l.get(10)).append(",");
            sql.append("xhmescgm = ").append(l.get(12)).append(",");
            sql.append("xhmecl = ").append(l.get(13)).append(",");
            sql.append("xjzgscgm = ").append(l.get(15)).append(",");
            sql.append("xjzgcl = ").append(l.get(16)).append(",");
            sql.append("xxzgscgm = ").append(l.get(18)).append(",");
            sql.append("xxzgcl = ").append(l.get(19)).append(",");
            sql.append("qtsyjcl = ").append(l.get(21));

            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

    static void canshang(List<List> excelList, int n) {
        if (n != 7) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_sccyscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("syzmj = ").append(l.get(1)).append(",");
            sql.append("syczzs = ").append(l.get(2)).append(",");
            sql.append("cjzcl = ").append(l.get(3));

            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }


    static void chaye(List<List> excelList, int n) {
        if (n != 6) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_sccyscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("cymj = ").append(l.get(1)).append(",");
            sql.append("cycl = ").append(l.get(2));

            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

    static void shucai(List<List> excelList, int n) {
        //SELECT year,cl as cl,mj from M_argicCyInfo where type='132127' order by year
        if (n != 5) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  M_argicCyInfo set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("mj = ").append(l.get(3)).append(",");
            sql.append("cl = ").append(l.get(4));

            sql.append(" where type='132127' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }

        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_nzwscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("gyg_mj = ").append(l.get(1)).append(",");
            sql.append("gyg_zcl = ").append(l.get(2)).append(",");
            sql.append("sc_mj = ").append(l.get(3)).append(",");
            sql.append("sc_zcl = ").append(l.get(4));

            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }


    static void suiguo(List<List> excelList, int n) {
        if (n != 4) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_sgscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("hj_mj = ").append(l.get(1)).append(",");
            sql.append("hj_zcl = ").append(l.get(2)).append(",");
            sql.append("gjy_mj = ").append(l.get(3)).append(",");
            sql.append("gj_zcl = ").append(l.get(4)).append(",");
            sql.append("ymy_mj = ").append(l.get(5)).append(",");
            sql.append("ym_zcl = ").append(l.get(6)).append(",");
            sql.append("pty_mj = ").append(l.get(7)).append(",");
            sql.append("pt_zcl = ").append(l.get(8)).append(",");
            sql.append("ty_mj = ").append(l.get(9)).append(",");
            sql.append("tz_zcl = ").append(l.get(10)).append(",");
            sql.append("ppy_mj = ").append(l.get(11)).append(",");
            sql.append("pp_zcl = ").append(l.get(12)).append(",");
            sql.append("ly_mj = ").append(l.get(13)).append(",");
            sql.append("lt_zcl = ").append(l.get(14)).append(",");
            sql.append("mht_mj = ").append(l.get(15)).append(",");
            sql.append("mht_cl = ").append(l.get(16));
            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }

    }

    static void xumu(List<List> excelList, int n) {
        if (n != 10) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }

            //SELECT year,cl/10000 as cl,mj from M_argicCyInfo where type='132126' order by year
            String sql2 = "update M_argicCyInfo set mj = %s ,cl = %s where type = '132103' and year = %s";
            sql2 = String.format(sql2,l.get(1),l.get(9),l.get(0));
            SqlUtils.getInstance().update(sql2);
        }

    }


    static void liangyou(List<List> excelList, int n) {
        if (n != 3) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_nzwscqk set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            if(StringUtil.isEmpty(year)){
                return;
            }
            sql.append("lszw_hjmj = ").append(l.get(1)).append(",");
            sql.append("lszw_hjzcl = ").append(l.get(2)).append(",");
            sql.append("zd_mj = ").append(l.get(3)).append(",");
            sql.append("zd_zcl = ").append(l.get(4)).append(",");
            sql.append("wd_mj = ").append(l.get(5)).append(",");
            sql.append("wd_cl = ").append(l.get(6)).append(",");
            sql.append("xm_mj = ").append(l.get(7)).append(",");
            sql.append("xm_zcl = ").append(l.get(8)).append(",");
            sql.append("dm_mj = ").append(l.get(9)).append(",");
            sql.append("dm_zcl = ").append(l.get(10)).append(",");
            sql.append("dd_mj = ").append(l.get(12)).append(",");
            sql.append("dd_zcl = ").append(l.get(13)).append(",");
            sql.append("fs_mj = ").append(l.get(15)).append(",");
            sql.append("fs_zcl = ").append(l.get(16)).append(",");
            sql.append("mls_mj = ").append(l.get(17)).append(",");
            sql.append("mls_zcl = ").append(l.get(18)).append(",");
            sql.append("ycz_mj = ").append(l.get(19)).append(",");
            sql.append("ycz_zcl = ").append(l.get(20));

            sql.append(" where areacode='3305' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
            //SELECT year,cl/10000 as cl,mj from M_argicCyInfo where type='132126' order by year
            String sql2 = "update M_argicCyInfo set mj = %s ,cl = %s where type = '132126' and year = %s";
            sql2 = String.format(sql2,l.get(1),l.get(2),l.get(0));
            SqlUtils.getInstance().update(sql2);
        }

    }


    static void suican(List<List> excelList, int n) {
        if (n != 2) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  M_argicCyInfo set  ");
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql.append("mj = ").append(l.get(1)).append(",");
            sql.append("cl = ").append(l.get(2));
            sql.append(" where type='132127' and year =").append(year);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }

    }


    static void rjsr(List<List> excelList, int n) {
        if (n != 1) {
            return;
        }
        String sql2 = "delete from sys_zongshu where type=201803 or type = 201802";
        SqlUtils.getInstance().update(sql2);
        for (int i = 1; i < 11; i++) {

            StringBuilder sql = new StringBuilder("insert into  sys_zongshu(type,year,zongshu)  ");
            List l = excelList.get(i);
            String year = (String) l.get(0);
            sql.append("values('").append(201803);
            sql.append("','").append(year);
            sql.append("',").append(l.get(1));
            sql.append(" )");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
             sql = new StringBuilder("insert into  sys_zongshu(type,year,zongshu)  ");

            sql.append("values('").append(201802);
            sql.append("','").append(year);
            sql.append("',").append(l.get(2));
            sql.append(" )");
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }

    }


    static void nycz(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            //select year,zongshu as nlmyzcz from sys_zongshu where type='201801' order by year
            StringBuilder sql = new StringBuilder("update  sys_zongshu set  ");
            String sql2 = "delete from sys_zongshu where type = 201801 and year =";
            List l = excelList.get(i);
            if (l.size() == 0 || l.get(0) == null) {
                continue;
            }
            String year = (String) l.get(0);
            sql2 += year;
            SqlUtils.getInstance().update(sql2);
            sql.append("zongshu = ").append(Integer.parseInt((String)l.get(2))/10000).append(",");
            sql.append("type = ").append(201801);
            sql.append(" where  year = ").append(year);
            System.out.println(year);
            System.out.println(sql);
            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }

    }


    static void yc(List<List> excelList, int n) {
        if (n != 9) {
            return;
        }
        for (int i = 1; i < excelList.size(); i++) {
            StringBuilder sql = new StringBuilder("update  town_nzwscqk set  ");
            List l = excelList.get(i);
            String year = (String) l.get(0);
            if (year == null || year.trim().length() == 0) {
                continue;
            }
            sql.append("yc_mj = ").append(l.get(1)).append(",");
            sql.append("yc_zcl = ").append(l.get(2)).append(",");
            sql.append("yc_cz = ").append(l.get(3)).append(",");
            sql.append("hbj_mj = ").append(l.get(7)).append(",");
            sql.append("hbj_cl = ").append(l.get(8)).append(",");
            sql.append("zbm_mj = ").append(l.get(10)).append(",");
            sql.append("zbm_cl = ").append(l.get(11)).append(",");
            sql.append("bs_mj = ").append(l.get(13)).append(",");
            sql.append("bs_cl = ").append(l.get(14)).append(",");
            sql.append("yh_mj = ").append(l.get(16)).append(",");
            sql.append("yh_cl = ").append(l.get(17)).append(",");
            //	yc_mj,yc_zcl,yc_cz,hbj_mj,zbm_mj, bs_mj,yh_mj,xs_mj,wyj_mj,hbs_mj,mzd_mj,tpsh_mj,xhh_mj,lz_mj,qtzyc_mj,
            // hbj_cl,zbm_cl,bs_cl,yh_cl,xs_cl,wyj_cl,hbs_cl,mzd_cl,tpsh_cl,xhh_cl,lz_cl,qtzyc_cl
            sql.append("xs_mj = ").append(l.get(19)).append(",");
            sql.append("xs_cl = ").append(l.get(20)).append(",");
            sql.append("wyj_mj = ").append(l.get(22)).append(",");
            sql.append("wyj_cl = ").append(l.get(23)).append(",");
            sql.append("hbs_mj = ").append(l.get(25)).append(",");
            sql.append("hbs_cl = ").append(l.get(26)).append(",");
            sql.append("mzd_mj = ").append(l.get(28)).append(",");
            sql.append("mzd_cl = ").append(l.get(29)).append(",");
            sql.append("tpsh_mj = ").append(l.get(31)).append(",");
            sql.append("tpsh_cl = ").append(l.get(32)).append(",");

            sql.append("xhh_mj = ").append(l.get(34)).append(",");
            sql.append("xhh_cl = ").append(l.get(35)).append(",");
            sql.append("lz_mj = ").append(l.get(37)).append(",");
            sql.append("lz_cl = ").append(l.get(38)).append(",");
            sql.append("qtzyc_mj = ").append(l.get(49)).append(",");
            sql.append("qtzyc_cl = ").append(l.get(50));
            sql.append(" where areacode = '3305' and year = ").append(year);


            SqlUtils.getInstance().update(sql.toString());
            System.out.println(sql);
        }
    }

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
                            //continue;
                        }
                        innerList.add(cellinfo);
                    }
/*                    for (String s : innerList) {
                        System.out.print(s + " ");
                    }
                    System.out.println();*/
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

}
