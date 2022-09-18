


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;



public class XlsR {

	@DataProvider(name="login")
//	public static   Object[][] main(String[] args) throws EncryptedDocumentException, IOException {
		
	public  Object[][] login() throws EncryptedDocumentException, IOException  {
		
		FileInputStream file =new FileInputStream("C:\\Users\\Admin\\Desktop\\seleniumEcel\\OrangeHRM Credentials.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh= wb.getSheet("Sheet1");
		
		int noofrows = sh.getPhysicalNumberOfRows();
		System.out.println(noofrows);
		int noofcolums = sh.getRow(0).getLastCellNum();
		System.out.println(noofcolums);
		
		Object[][] data = new Object[noofrows][noofcolums];
		
		for (int i = 1; i < noofrows; i++) {
			for (int j = 0; j < noofcolums; j++) {
				DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sh.getRow(i).getCell(j));
			
//		every cell may or may not contain string value so we need to use 
//		Dataformatter = it converts any type of data to normal data
//				System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
			}
		}
		
		wb.close();
		file.close();
		return data;
		
//		for (Object[] dataArr: data) {
//			System.out.println(Arrays.toString(dataArr));
//			
//		}
	}

}
