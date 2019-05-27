package com.carlme.easyexcel.service;

/**

* @Description:    PDF工具

* @Author:         noahw

* @CreateDate:     2019-02-15 17:28

* @Version:        1.0

*/
public class PdfUtils {

  /*  public static String turnToPdf(EmergencyAccidentRecord record, String date, String location, String locationPoint, String chemicalName, String typeName, String levelName, String firstAid, String fireProtection
            , String leakageHandle, String properties, PlanDetailData planDetailData){

        String path = "";
        String fileName = UUID.randomUUID().toString() + ".pdf";

        try {
            String basePath = PathUtil.getProjectPath();
            File file = new File(basePath + "/pdf");
            if(!file.exists()){
                file.mkdirs();
            }

            //创建文件
            Document document = new Document();

            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            Font fontBigBold = new Font(bfChinese, 20, Font.BOLD, BaseColor.RED);//标题
            Font font = new Font(bfChinese, 6);//备注字体
            Font titleFont = new Font(bfChinese, 13);//标题字体
            Font contentFont = new Font(bfChinese, 8);//正文字体

            //建立一个书写器
            path = file.getPath() + "/" + fileName;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            //添加主题
            Paragraph theme = new Paragraph("应急处置方案", fontBigBold);
            theme.setAlignment(Element.ALIGN_CENTER);
            document.add(theme);

            document.addAuthor(CommonConstant.CHANGSHU_EMERGENCY_DEPART_NAME);
            document.addCreationDate();

            Paragraph authorInfo = new Paragraph();
            //单位
            Chunk authorChunk = new Chunk(CommonConstant.CHANGSHU_EMERGENCY_DEPART_NAME, font);
            //时间
            Chunk dateChunk = new Chunk(StringUtils.isBlank(date)?DateTimeUtil.formatDatetoString(record.getAccidentDate()):date, font);
            authorInfo.add(authorChunk);
            authorInfo.add(new Chunk("                                                                                         "));
            authorInfo.add(dateChunk);
            authorInfo.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
            document.add(authorInfo);

            LineSeparator line = new LineSeparator(2f,100, BaseColor.RED, Element.ALIGN_CENTER,-5f);
            document.add(line);

            location = StringUtils.isBlank(location)?record.getLocation():location;
            locationPoint = StringUtils.isBlank(locationPoint)?CommonUtil.subZeroAndDot(record.getX().toString()) + "," + CommonUtil.subZeroAndDot(record.getY().toString()):locationPoint;
            inintAccidentInfo(document, location, locationPoint, chemicalName, typeName, levelName, titleFont, contentFont);
            initContent(document, "二、危化品信息", properties, titleFont, contentFont);
            initContent(document, "三、急救措施", firstAid, titleFont, contentFont);
            initContent(document, "四、消防措施", fireProtection, titleFont, contentFont);
            initContent(document, "五、泄露处置", leakageHandle, titleFont, contentFont);

            //救援物资
            Paragraph jywz = new Paragraph();
            jywz.add(new Chunk("六、救援物资:", titleFont));
            jywz.setSpacingAfter(5);
            jywz.setLeading(25f);
            document.add(jywz);
            document.add(initEquipmentForm(planDetailData.getEquipmentList(), contentFont));

            //救援队伍
            Paragraph jydw = new Paragraph();
            jydw.add(new Chunk("七、救援队伍:", titleFont));
            jydw.setSpacingAfter(5);
            jydw.setLeading(25f);
            document.add(jydw);
            document.add(initTeamForm(planDetailData.getTeamList(), contentFont));

            //救援专家
            Paragraph jyzj = new Paragraph();
            jyzj.add(new Chunk("八、救援专家:", titleFont));
            jyzj.setSpacingAfter(5);
            jyzj.setLeading(25f);
            document.add(jyzj);
            document.add(initExpertForm(planDetailData.getExpertList(), contentFont));

            //保障措施
            Paragraph bzcs = new Paragraph();
            bzcs.add(new Chunk("九、保障措施:", titleFont));
            bzcs.setSpacingAfter(5);
            bzcs.setLeading(25f);
            document.add(bzcs);
            document.add(initTaskForm(planDetailData.getSafeguardList(), contentFont));

            //后期处置
            Paragraph hqcz = new Paragraph();
            hqcz.add(new Chunk("十、后期处置:", titleFont));
            hqcz.setSpacingAfter(5);
            hqcz.setLeading(25f);
            document.add(hqcz);
            document.add(initTaskForm(planDetailData.getDispositionList(), contentFont));

            //关闭文档
            document.close();
            //关闭书写器
            writer.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return fileName;
    }

    private static void initContent(Document document, String titleContent, String content, Font titleFont, Font contentFont) throws DocumentException {
        Paragraph title = new Paragraph();
        title.setLeading(25f);
        title.add(new Chunk(titleContent + ":", titleFont));
        document.add(title);

        Paragraph fxContent = new Paragraph(content, contentFont);

        initPart(document, fxContent);
    }

    private static void inintAccidentInfo(Document document, String location, String locationPoint, String chemicalName, String typeName
            , String levelName, Font titleFont, Font contentFont) throws DocumentException {
        Paragraph title = new Paragraph();
        title.setLeading(25f);
        title.add(new Chunk("一、事故信息:", titleFont));
        document.add(title);

        Paragraph fxContent = new Paragraph("事故地点：" + location, contentFont);
        initPart(document, fxContent);
        Paragraph fxContent1 = new Paragraph("事故地点坐标：" + locationPoint, contentFont);
        initPart(document, fxContent1);
        Paragraph fxContent2 = new Paragraph("危化品：" + chemicalName, contentFont);
        initPart(document, fxContent2);
        Paragraph fxContent3 = new Paragraph("事故类型：" + typeName, contentFont);
        initPart(document, fxContent3);
        Paragraph fxContent4 = new Paragraph("事故等级：" + levelName, contentFont);
        initPart(document, fxContent4);
    }

    private static void initPart(Document document, Paragraph fxContent) throws DocumentException {
        fxContent.setAlignment(Element.ALIGN_JUSTIFIED);
        fxContent.setIndentationLeft(1 * 15f);
        fxContent.setIndentationRight((5 - 1) * 15f);
        document.add(fxContent);
    }

    private static PdfPTable initEquipmentForm(List<PlanEquipmentData> equipmentDataList, Font contentFont){
        PdfPTable table = new PdfPTable(new float[] {10, 110});// 5列的表格以及单元格的宽度。
        table.setPaddingTop(20);// 顶部空白区高度
        table.setTotalWidth(120);//表格整体宽度

        table.addCell(new Paragraph("序号", contentFont));
        table.addCell(new Paragraph("设备名称", contentFont));
        equipmentDataList.forEach(planEquipmentData -> {
            table.addCell(new Paragraph(planEquipmentData.getSequence(), contentFont));
            table.addCell(new Paragraph(planEquipmentData.getEquipmentName(), contentFont));
        });

        return table;
    }

    private static PdfPTable initExpertForm(List<PlanExpertData> expertDataList, Font contentFont){
        PdfPTable table = new PdfPTable(new float[] {10, 25, 35, 25, 25});// 5列的表格以及单元格的宽度。
        table.setPaddingTop(20);// 顶部空白区高度
        table.setTotalWidth(120);//表格整体宽度

        table.addCell(new Paragraph("序号", contentFont));
        table.addCell(new Paragraph("专家姓名", contentFont));
        table.addCell(new Paragraph("所属单位", contentFont));
        table.addCell(new Paragraph("职位/职称", contentFont));
        table.addCell(new Paragraph("电话", contentFont));

        expertDataList.forEach(planExpertData -> {
            table.addCell(new Paragraph(planExpertData.getSequence(), contentFont));
            table.addCell(new Paragraph(planExpertData.getExpertName(), contentFont));
            table.addCell(new Paragraph(planExpertData.getEnterpriseName(), contentFont));
            table.addCell(new Paragraph(planExpertData.getProTitle(), contentFont));
            table.addCell(new Paragraph(planExpertData.getPhone(), contentFont));
        });

        return table;
    }

    private static PdfPTable initTeamForm(List<PlanTeamData> teamDataList, Font contentFont){
        PdfPTable table = new PdfPTable(new float[] {10, 25, 35, 25, 25});// 5列的表格以及单元格的宽度。
        table.setPaddingTop(20);// 顶部空白区高度
        table.setTotalWidth(120);//表格整体宽度

        table.addCell(new Paragraph("序号", contentFont));
        table.addCell(new Paragraph("队伍名称", contentFont));
        table.addCell(new Paragraph("组织名称", contentFont));
        table.addCell(new Paragraph("联系人", contentFont));
        table.addCell(new Paragraph("电话", contentFont));

        teamDataList.forEach(planTeamData -> {
            table.addCell(new Paragraph(planTeamData.getSequence(), contentFont));
            table.addCell(new Paragraph(planTeamData.getTeamName(), contentFont));
            table.addCell(new Paragraph(planTeamData.getOrganName(), contentFont));
            table.addCell(new Paragraph(planTeamData.getLinkman(), contentFont));
            table.addCell(new Paragraph(planTeamData.getContact(), contentFont));
        });

        return table;
    }

    private static PdfPTable initTaskForm(List<TaskInfo> taskInfoList, Font contentFont){
        PdfPTable table = new PdfPTable(new float[] {10, 25, 35, 25, 25});// 5列的表格以及单元格的宽度。
        table.setPaddingTop(20);// 顶部空白区高度
        table.setTotalWidth(120);//表格整体宽度

        table.addCell(new Paragraph("序号", contentFont));
        table.addCell(new Paragraph("任务名称", contentFont));
        table.addCell(new Paragraph("负责单位", contentFont));
        table.addCell(new Paragraph("负责人", contentFont));
        table.addCell(new Paragraph("电话", contentFont));

        taskInfoList.forEach(taskInfo -> {
            table.addCell(new Paragraph(taskInfo.getSequence(), contentFont));
            table.addCell(new Paragraph(taskInfo.getName(), contentFont));
            table.addCell(new Paragraph(taskInfo.getDepartName(), contentFont));
            table.addCell(new Paragraph(taskInfo.getLinkman(), contentFont));
            table.addCell(new Paragraph(taskInfo.getContact(), contentFont));
        });

        return table;
    }*/
}