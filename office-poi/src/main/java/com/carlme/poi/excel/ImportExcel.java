package com.carlme.poi.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @ClassName: ImportExcel
 * @Description: 导入excel
 * @Auther: SuperWang
 * @Email: carlme@aliyun.com
 * @Date: 2019/5/15 17:14
 * @Vsersion: 0.0.1
 */
public class ImportExcel {

	public void queryMsdsModelList() throws Exception {
		InputStream is = new FileInputStream("");
		Workbook workbook = WorkbookFactory.create(is);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			//获取多少行
			int rows = sheet.getPhysicalNumberOfRows();
			//遍历每一行，注意：第 0 行为标题
			for (int j = 1; j < rows; j++) {
				//获得第 j 行
				Row row = sheet.getRow(j);
				if (null != row.getCell(0)) {
					row.getCell(0).setCellType(CellType.STRING);
					String value = row.getCell(0).getStringCellValue();
					System.out.println(value);
				}
			}
		}
	}
}
