package com.carlme.easyexcel;

import com.carlme.easyexcel.service.ExcelService;
import com.carlme.easyexcel.service.PdfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfTests {


	@Autowired
	private PdfService pdfService;


	@Test
	public void writePdfSimple() throws Exception{
		pdfService.writePdfSimple();
	}


}
