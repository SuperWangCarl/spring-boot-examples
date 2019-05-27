package com.carlme.easyexcel.service;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.carlme.easyexcel.model.WriteModelOrder;
import com.carlme.easyexcel.model.WriteModelUser;
import com.carlme.easyexcel.util.ClassUtils;
import com.carlme.easyexcel.util.DataUtil;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @ClassName: ExcelService
 * @Description: excel的service
 * @Auther: SuperWang
 * @Email: carlme@aliyun.com
 * @Date: 2019/5/24 10:48
 * @Vsersion: 0.0.1
 */
@Service
public class ExcelService {

	String path = "E:/";

	/**
	 * 简单的excel写出
	 * 表头根据注解生成
	 * @throws Exception
	 */
	public void writeExcelSimple() throws Exception {
		// 文件输出位置
		OutputStream out = new FileOutputStream(path + ClassUtils.getMethodName() + ".xlsx");

		ExcelWriter writer = EasyExcelFactory.getWriter(out);

		// 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
		Sheet sheet1 = new Sheet(1, 0, WriteModelUser.class);

		// 第一个 sheet 名称
		sheet1.setSheetName("第一个sheet");

		// 写数据到 Writer 上下文中
		// 入参1: 创建要写入的模型数据
		// 入参2: 要写入的目标 sheet
		writer.write(DataUtil.createModelList(), sheet1);

		// 将上下文中的最终 outputStream 写入到指定文件中
		writer.finish();

		// 关闭流
		out.close();
	}

	/**
	 * 表头动态生成
	 * @throws Exception
	 */
	public void writeExcelDynamic() throws Exception {
		// 文件输出位置
		OutputStream out = new FileOutputStream(path + ClassUtils.getMethodName() + ".xlsx");

		ExcelWriter writer = EasyExcelFactory.getWriter(out);

		// 动态添加表头，适用一些表头动态变化的场景
		Sheet sheet1 = new Sheet(1, 0);

		sheet1.setSheetName("第一个sheet");

		// 创建一个表格，用于 Sheet 中使用
		Table table1 = new Table(1);

		// 自定义表格样式
        table1.setTableStyle(DataUtil.createTableStyle());

		// 无注解的模式，动态添加表头
		table1.setHead(DataUtil.createTestListStringHead());
		// 写数据
		writer.write1(DataUtil.createDynamicModelList(), sheet1, table1);

		// 合并单元格
		writer.merge(5, 6, 0, 4);

		// 将上下文中的最终 outputStream 写入到指定文件中
		writer.finish();

		// 关闭流
		out.close();
	}

	/**
	 * 多个 sheet写出
	 * @throws Exception
	 */
	public void writeExcelMultiSheet() throws Exception {
		OutputStream out = new FileOutputStream(path + ClassUtils.getMethodName() + ".xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
		// ==================================== Start ====================================
		// 写仅有一个 Sheet 的 Excel, 此场景较为通用
		Sheet sheet1 = new Sheet(1, 0, WriteModelOrder.class);
		sheet1.setSheetName("第一个sheet");
		writer.write(DataUtil.createModel2List(), sheet1);
		// ===================================== End =====================================


		// ==================================== Start ====================================
		// 合并单元格
		Sheet sheet3 = new Sheet(3, 0, WriteModelUser.class, "第三个sheet", null);
		//writer.write1(null, sheet2);
		writer.write(DataUtil.createModelList(), sheet3);
		// 需要合并单元格
		writer.merge(5, 6, 1, 5);
		// ===================================== End =====================================


		// ==================================== Start ====================================
		// 单个 Sheet 中包含多个 Table
		Sheet sheet4 = new Sheet(4, 0);
		sheet4.setSheetName("第四个sheet");

		Table sheet4table1 = new Table(1);
		sheet4table1.setClazz(WriteModelUser.class);
		writer.write(DataUtil.createModelList(), sheet4, sheet4table1);

		Table sheet4table2 = new Table(2);
		sheet4table2.setClazz(WriteModelOrder.class);
		writer.write(DataUtil.createModel2List(), sheet4, sheet4table2);
		// ===================================== End =====================================

		writer.finish();
		out.close();
	}

}
