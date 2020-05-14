import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Automation {

	public static void main(String[] args) throws BiffException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vinay\\Downloads\\Selenium_Assessment_May_12\\Selenium_Assessment May 12\\Selenium_Supporting files\\Files\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.org/");
		driver.manage().window().maximize(); 
		driver.findElement(By.linkText("Register")).click();
        File inputFile=new File("C:\\Users\\vinay\\Documents\\input.xls");
        Workbook workbook = Workbook.getWorkbook(inputFile);
        ArrayList<String> iter1 = new ArrayList<String>();
        ArrayList<String> iter2 = new ArrayList<String>();
        ArrayList<String> iter3 = new ArrayList<String>();
        
        
        Sheet sheet = workbook.getSheet(0);
        System.out.println(sheet.getColumns());
        System.out.println(sheet.getRows());
        for(int i =1 ; i<sheet.getColumns();i++)
        {
        	for(int j =1;j<sheet.getRows();j++)
        	{
        		if(i==1)
        			iter1.add(sheet.getCell(i, j).getContents());
        		else if(i==2)
        			iter2.add(sheet.getCell(i, j).getContents());
        		else
        			iter3.add(sheet.getCell(i, j).getContents());
        	}
        }
        
        for(int i = 0;i<iter1.size();i++)
        	System.out.println(iter1.get(i));
		
//		driver.findElement(By.id("inputFirstName")).sendKeys("Nimisha");
//		inputLastName
//		inputEmail
        
        HashMap<String , ArrayList> hm = new HashMap<String , ArrayList>();
        hm.put("iter1", iter1);
        hm.put("iter2", iter2);
        hm.put("iter3", iter3);
        
        Set<String> itr = hm.keySet();
        
        for(int i =0;i<3;i++)
        {
        	if(i==0)
        	{
        		
        	}
        	
        }
//			
	
	}

}
