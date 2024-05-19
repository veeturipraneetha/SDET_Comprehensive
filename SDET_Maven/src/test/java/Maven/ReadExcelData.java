package Maven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	
	@Test
	
	public  void Data() throws IOException {
		
		
		FileInputStream file = new FileInputStream("C:\\Users\\lenovo\\Documents\\SDET_excelSheet.xlsx");

				XSSFWorkbook work = new XSSFWorkbook(file);
				XSSFSheet sheet = work.getSheetAt(0);
				Iterator i = sheet.iterator();
				while (i.hasNext()) {

				   XSSFRow r = (XSSFRow) i.next();
				   Iterator c=r.cellIterator();

				   while (c.hasNext()) {

				      XSSFCell cl = (XSSFCell) c.next();
				      System.out.print (cl+"   ");
				   }

				   System.out.println();
				}
	}



}
