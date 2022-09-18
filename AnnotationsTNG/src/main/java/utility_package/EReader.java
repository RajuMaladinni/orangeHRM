package utility_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EReader {
	
	public static String LoginCred(int Row, int Cell) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\seleniumEcel\\OrangeHRM Credentials.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet("Sheet2");
	 String data = sh.getRow(Row).getCell(Cell).getStringCellValue();
	return data;
	

	}
}
