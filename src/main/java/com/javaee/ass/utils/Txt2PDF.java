package com.javaee.ass.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.w3c.dom.Text;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.Charset;

public class Txt2PDF {
    private static final String FONT = "C:\\Windows\\Fonts\\simhei.ttf";

    public static void text2pdf(String text, String pdf) throws DocumentException, IOException {
        Document document = new Document();
        OutputStream os = new FileOutputStream(new File(pdf));
        PdfWriter.getInstance(document, os);
        document.open();
        //使用Windows系统字体(TrueType)
        BaseFont baseFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(text)), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String str = "";
        while ((str = bufferedReader.readLine()) != null) {
            document.add(new Paragraph(str, font));
        }
        document.close();
    }
    public static void exportPDF( HttpServletResponse response, String title, String text,String pdf) {
        Document document = new Document();

        try {
            OutputStream os = new FileOutputStream(new File(pdf));
            PdfWriter.getInstance(document, os);
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment;filename=" +
                    new String( (title + ".pdf").getBytes(),  "utf-8"));
            PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            //在下面，body中设置了style，设置了默认字体为宋体，这样导出时的html语言就默认带有了字体，汉字才会导出成功
            String content="<html><body style=\"font-family: 宋体, SimHei;\">" +
                    "<p style=\"text-align: center;\"><span style=\"font-family: 黑体, SimHei; font-size: 24px;\">"
                    + title + "</span></p>" + text + "</body></html>";
            byte b[] = content.getBytes("utf-8");  //这里是必须要设置编码的，不然导出中文就会乱码。
            ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, bais, Charset.forName("UTF-8"));
            document.add(new Phrase(bais.toString()));
            bais.close();
            document.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String PDFTIMEDIR = "F:/pdf/";
        String text = PDFTIMEDIR + "1.txt";
        String pdf = PDFTIMEDIR + "1_txt.pdf";
        text2pdf(text, pdf);
    }
}
