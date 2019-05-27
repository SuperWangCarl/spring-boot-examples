package com.carlme.easyexcel;

/**
 * @ClassName: WebTest
 * @Description: web下载
 * @Auther: SuperWang
 * @Email: carlme@aliyun.com
 * @Date: 2019/5/27 11:21
 * @Vsersion: 0.0.1
 */
public class WebTest {
	/*
	public class Down {
    @GetMapping("/a.htm")
    public void cooperation(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream out = response.getOutputStream();
         response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .getBytes(), "UTF-8");
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("第一个sheet");
        writer.write0(getListString(), sheet1);
        writer.finish();

        out.flush();
        }
    }
	}
	 */
}
