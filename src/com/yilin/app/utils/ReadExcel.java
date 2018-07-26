package com.yilin.app.utils;

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
        for (int i = 0; i < 24; i++) {
            StringBuilder sql = new StringBuilder(" insert into commodity (name,e_name, series,scale, stock ) values(  ");
            List l = excelList.get(i);
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

    static void price(List<List> excelList, int n) {
        if (n != 0) {
            return;
        }
        for (int i = 17; i < 18; i++) {
            for(int j = 1; j<8;j++) {
                StringBuilder sql = new StringBuilder(" insert into price (comm_id,role_id, price) values(  ");
                List l = excelList.get(i);
                sql.append("").append(i-3).append("").append(",");
                sql.append("").append(j).append("").append(",");
                sql.append("").append(l.get(j+2)).append("");

                sql.append(")");
                SqlUtils.getInstance().update(sql.toString());
                System.out.println(sql);
            }
        }
    }


    public static void main(String[] args) {
        String fileName = "f:/ws.xls";
        domain(fileName);
    }


    public static void domain(String fileName) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File(fileName);
        List<List<List>> excelAllList = obj.readExcel(file);
        for (int n = 0; n < excelAllList.size(); n++) {
            // commodity(excelAllList.get(n), n);
            price(excelAllList.get(n), n);
        }

    }


}
