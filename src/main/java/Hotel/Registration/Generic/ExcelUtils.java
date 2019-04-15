package Hotel.Registration.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private HashMap<String,String> HM;
	private static ExcelUtils eu=null;
	
	private ExcelUtils()
	{
		
	}
	
	public static ExcelUtils euObj()
	{
		if(eu==null)
		{
			eu=new ExcelUtils();
		}
		return eu;
		
	}
	
	public Workbook getWorkbook(String filePath) throws IOException
	{
		Workbook wBook=null;
		FileInputStream fis=new FileInputStream(filePath);
		wBook=new XSSFWorkbook(fis);
		return wBook;
	} 
	
	public int getRowNumber(Sheet sheetObj,String testCaseId)
	{
		int lastRowNum=sheetObj.getLastRowNum();
		int finalRowNum=0;
		for(int i=0;i<=lastRowNum;i++)
		{
			Row rowObj=sheetObj.getRow(i);
			Cell cellObj=rowObj.getCell(0);
			String data=cellObj.getStringCellValue();
			if(data.equalsIgnoreCase(testCaseId))
			{
				finalRowNum=i;
				break;
			}
		}
		
		return finalRowNum;
		
	}
	
	public HashMap<String,String> getData(String filePath,String sheetName,String testCaseId) throws IOException
	{
		Workbook workbookObj=getWorkbook(filePath);
		
		HM=new HashMap<String, String>();
		
		Sheet sheetObj=workbookObj.getSheet(sheetName);
		
		int rowNum=getRowNumber(sheetObj, testCaseId);
		
		Row rowObj=sheetObj.getRow(rowNum);
		
		int cellNum=rowObj.getLastCellNum()-1;
		
		for(int i=2;i<=cellNum;i+=2)
		{
		Cell cellobj=rowObj.getCell(i,Row.CREATE_NULL_AS_BLANK);
			String key=cellobj.getStringCellValue();
			
			Cell cellobj1=rowObj.getCell(i,Row.CREATE_NULL_AS_BLANK);
			String value=cellobj1.getStringCellValue();
			HM.put(key, value);
		}
		
		
		return HM;
		
	}
	
	
	

}
