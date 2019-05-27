package com.carlme.easyexcel.service;

import com.carlme.easyexcel.util.ClassUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;

/**
 * @ClassName: PdfService
 * @Description: pdf的操作
 * @Auther: SuperWang
 * @Email: carlme@aliyun.com
 * @Date: 2019/5/24 10:48
 * @Vsersion: 0.0.1
 */
@Component
public class PdfService {
	String path = "E:/";

	public void writePdfSimple() throws Exception {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + ClassUtils.getMethodName() + ".pdf"));
		document.open();
		document.add(new Paragraph("hello 世界"));
		document.close();
		writer.close();
	}
}
