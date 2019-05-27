package com.carlme.easyexcel.util;

import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.TableStyle;
import com.carlme.easyexcel.model.WriteModelOrder;
import com.carlme.easyexcel.model.WriteModelUser;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据类型的封装
 */
public class DataUtil {

    /**
     * 封装usermode
     * @return
     */
    public static List<WriteModelUser> createModelList() {
        List<WriteModelUser> writeModels = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            WriteModelUser writeModel = WriteModelUser.builder()
                    .name("小哈学Java"+i).password("123456").age(i+1).build();
            writeModels.add(writeModel);
        }

        return writeModels;
    }

    /**
     * 动态生成表头
     * @return
     */
    public static List<List<String>> createTestListStringHead(){
        // 模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();

        headCoulumn1.add("第一列");headCoulumn1.add("第一列");headCoulumn1.add("第一列");
        headCoulumn2.add("第一列");headCoulumn2.add("第一列");headCoulumn2.add("第一列");

        headCoulumn3.add("第二列");headCoulumn3.add("第二列");headCoulumn3.add("第二列");
        headCoulumn4.add("第三列");headCoulumn4.add("第三列2");headCoulumn4.add("第三列2");
        headCoulumn5.add("第一列");headCoulumn5.add("第3列");headCoulumn5.add("第4列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        return head;
    }

    /**
     * 无注解的实体类
     *
     * @return
     */
    public static List<List<Object>> createDynamicModelList() {
        // 所有行数据
        List<List<Object>> rows = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            // 一行数据
            List<Object> row = new ArrayList<>();
            row.add("字符串" + i);
            row.add(Long.valueOf(187837834l + i));
            row.add(Integer.valueOf(2233 + i));
            row.add("犬小哈");
            row.add("微信公众号：小哈学Java");
            rows.add(row);
        }

        return rows;
    }

    /**
     * 设置表格样式
     * @return
     */
    public static TableStyle createTableStyle() {
        TableStyle tableStyle = new TableStyle();
        // 设置表头样式
        Font headFont = new Font();
        // 字体是否加粗
        headFont.setBold(true);
        // 字体大小
        headFont.setFontHeightInPoints((short)12);
        // 字体
        headFont.setFontName("楷体");
        tableStyle.setTableHeadFont(headFont);
        // 背景色
        tableStyle.setTableHeadBackGroundColor(IndexedColors.BLUE);


        // 设置表格主体样式
        Font contentFont = new Font();
        contentFont.setBold(true);
        contentFont.setFontHeightInPoints((short)12);
        contentFont.setFontName("黑体");
        tableStyle.setTableContentFont(contentFont);
        tableStyle.setTableContentBackGroundColor(IndexedColors.GREEN);
        return tableStyle;
    }



    public static List<WriteModelOrder> createModel2List() {
        List<WriteModelOrder> writeModels2 = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            WriteModelOrder writeModel2 = WriteModelOrder.builder().orderNo(String.valueOf(i)).name("犬小哈").createTime(LocalDateTime.now()).build();
            writeModels2.add(writeModel2);
        }

        return writeModels2;
    }

}
