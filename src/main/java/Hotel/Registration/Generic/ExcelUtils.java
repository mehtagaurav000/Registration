package Hotel.Registration.Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

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
	
	

}
