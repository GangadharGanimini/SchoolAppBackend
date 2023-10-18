package net.javaguides.springboot.utilities;

//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;

//public class ImageToExcelConverter {
//    public static void main(String[] args) {
//        File imageFile = new File("D:\\school");
//
//        ITesseract tesseract = new Tesseract();
//
//        try {
//            String text = tesseract.doOCR(imageFile);
//
//            // Create a new Excel workbook and sheet
//            Workbook workbook = new XSSFWorkbook();
//            Sheet sheet = workbook.createSheet("ImageText");
//
//            // Create a cell and set the extracted text as its value
//            Row row = sheet.createRow(0);
//            Cell cell = row.createCell(0);
//            cell.setCellValue(text);
//
//            // Save the Excel file
//            FileOutputStream outputStream = new FileOutputStream("output.xlsx");
//            workbook.write(outputStream);
//            outputStream.close();
//
//            System.out.println("Text extracted from image and saved to Excel.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
