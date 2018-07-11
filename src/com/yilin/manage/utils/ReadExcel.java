package com.yilin.manage.utils;

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

    public static void main(String[] args) {

        for(int i = 2014;i<2018;i++){
            domain(i);
        }
    }


    public static void domain(int year){
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("D:/中药材数据/"+year+"年中药材.xls");
        List<List> excelList = obj.readExcel(file);
        StringBuilder sql = new StringBuilder("update  town_nzwscqk set  ");

        List l =  excelList.get(3);
        sql.append("yc_mj = ").append(l.get(2)).append(",");
        sql.append("yc_zcl = ").append(l.get(3)).append(",");
        sql.append("yc_cz = ").append(l.get(4)).append(",");
        l = excelList.get(4);
        sql.append("hbj_mj = ").append(l.get(2)).append(",");
        sql.append("hbj_cl = ").append(l.get(3)).append(",");
        l = excelList.get(5);
        sql.append("zbm_mj = ").append(l.get(2)).append(",");
        sql.append("zbm_cl = ").append(l.get(3)).append(",");
        l = excelList.get(6);
        sql.append("bs_mj = ").append(l.get(2)).append(",");
        sql.append("bs_cl = ").append(l.get(3)).append(",");
        l = excelList.get(7);
        sql.append("yh_mj = ").append(l.get(2)).append(",");
        sql.append("yh_cl = ").append(l.get(3)).append(",");
        l = excelList.get(8);

        //	yc_mj,yc_zcl,yc_cz,hbj_mj,zbm_mj, bs_mj,yh_mj,xs_mj,wyj_mj,hbs_mj,mzd_mj,tpsh_mj,xhh_mj,lz_mj,qtzyc_mj,
        // hbj_cl,zbm_cl,bs_cl,yh_cl,xs_cl,wyj_cl,hbs_cl,mzd_cl,tpsh_cl,xhh_cl,lz_cl,qtzyc_cl
        sql.append("xs_mj = ").append(l.get(2)).append(",");
        sql.append("xs_cl = ").append(l.get(3)).append(",");
        l = excelList.get(9);
        sql.append("wyj_mj = ").append(l.get(2)).append(",");
        sql.append("wyj_cl = ").append(l.get(3)).append(",");
        l = excelList.get(10);
        sql.append("mzd_mj = ").append(l.get(2)).append(",");
        sql.append("mzd_cl = ").append(l.get(3)).append(",");
        l = excelList.get(11);
        sql.append("tpsh_mj = ").append(l.get(2)).append(",");
        sql.append("tpsh_cl = ").append(l.get(3)).append(",");

        l = excelList.get(12);
        sql.append("xhh_mj = ").append(l.get(2)).append(",");
        sql.append("xhh_cl = ").append(l.get(3)).append(",");
        l = excelList.get(13);
        sql.append("lz_mj = ").append(l.get(2)).append(",");
        sql.append("lz_cl = ").append(l.get(3)).append(",");
        l = excelList.get(17);
        sql.append("qtzyc_mj = ").append(l.get(2)).append(",");
        sql.append("qtzyc_cl = ").append(l.get(3));
        sql.append(" where areacode = '330183' and year = ").append(year);

        SqlUtils.getInstance().update(sql.toString());
        System.out.println(sql);
        System.out.println();
    }


    /**
     * 去读Excel的方法，该方法的入口参数为一个File对象
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
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                return outerList;
            }
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
