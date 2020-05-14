import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

public class ExcelTesting 
{
    private static final String EXCEL_FILE_LOCATION = "C:\\Users\\vinay\\DT20195828044_workspace\\DT20195828044\\output.xls";
    static Workbook wbook;
    static WritableWorkbook wwbCopy;
    static String ExecutedTestCasesSheet;
    static WritableSheet shSheet;

	public static void main(String args[]) throws IOException, RowsExceededException, WriteException
	{
	        

	   

	        //1. Create an Excel file
	        WritableWorkbook myFirstWbook = null;
	        

	            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

	            // create an Excel sheet
	            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

	            // add something into the Excel sheet
	            Label label = new Label(0, 0, "Test Count");
	            excelSheet.addCell(label);

	            Number number = new Number(0, 1, 1);
	            excelSheet.addCell((WritableCell) number);

	            label = new Label(1, 0, "Result");
	            excelSheet.addCell(label);

	            label = new Label(1, 1, "Passed");
	            excelSheet.addCell(label);

	            number = new Number(0, 2, 2);
	            excelSheet.addCell(number);

	            label = new Label(1, 2, "Passed 2");
	            excelSheet.addCell(label);

	            myFirstWbook.write();
	            myFirstWbook.close();


	       
	            
	        }
	    }
	
