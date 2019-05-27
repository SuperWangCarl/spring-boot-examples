package com.carlme.easyexcel;

import com.carlme.easyexcel.service.ExcelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelTests {

    @Autowired
    private ExcelService excelService;

    /**
     * 表头基于注解
     */
    @Test
    public void writeExcelSimple() throws Exception{
        excelService.writeExcelSimple();
    }


    /**
     * 表头 动态生成
     */
    @Test
    public void writeExcelDynamic() throws Exception {
        excelService.writeExcelDynamic();
    }

    /**
     * 多个sheet写出
     */
    @Test
    public void writeExcelMultiSheet() throws Exception{
        excelService.writeExcelMultiSheet();
    }


}
