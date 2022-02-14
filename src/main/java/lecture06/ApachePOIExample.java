package lecture06;

import java.io.File;
import java.io.FileOutputStream;

// import java.io.*;
import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi;

public class ApachePOIExample  {
   public static void main(String[] args)throws Exception {
      //Create Blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();

      workbook.createSheet("sheet1");
      
      //Create file system using specific name
      FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));

      //write operation workbook using file out object
      workbook.write(out);
      out.close();
      System.out.println("createworkbook.xlsx written successfully");
   }
} 
