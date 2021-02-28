package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {

	
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> array=new ArrayList<String>();
		
		FileInputStream file=new FileInputStream("G://exceldriven//datadrivenexcelfile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		int countofsheets=workbook.getNumberOfSheets();
		
		System.out.println(countofsheets);
		
		for(int i=0;i<countofsheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("One"))
			{
				XSSFSheet indexsheet=workbook.getSheetAt(i);
				
				Iterator<Row> noofrows=indexsheet.iterator(); // collection of rows in sheet
				
				Row firstrow=noofrows.next();
				
				Iterator<Cell> cellsinrows=firstrow.cellIterator(); // collection of cells in row
				
				int k=0;
				int columnindex = 0;
				while(cellsinrows.hasNext())
				{
					Cell cellvalue=cellsinrows.next();
					if(cellvalue.getStringCellValue().equalsIgnoreCase("testcase"))
					{
							columnindex=k;
					}
					
					k++;
				}
				System.out.println(columnindex);
				
				
				while(noofrows.hasNext())
				{
					Row rowvalue=noofrows.next();
				if(	rowvalue.getCell(columnindex).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
					Iterator<Cell> row1=rowvalue.cellIterator();
					
					while(row1.hasNext())
					{
						Cell integer=row1.next();
						
						if(integer.getCellType()==CellType.STRING)
						{
							array.add(integer.getStringCellValue());
						}
					
						else
						{
							array.add(NumberToTextConverter.toText((integer.getNumericCellValue())));
							
						}
					}
					
				}
				
			
					
				}
			
			}
			
		}
		return array;
		
	}
	
}