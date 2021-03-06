import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Automate

{
	// output file location
	private static final String EXCEL_FILE_LOCATION = "C:\\Users\\vinay\\DT20195828044_workspace\\DT20195828044\\output.xls";

	public static void main(String args[])
			throws IOException, BiffException, InterruptedException, RowsExceededException, WriteException {

		/*
		 * Set chrome driver path in system properties
		 */
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinay\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");

		// intantiate chrome driver
		WebDriver driver = new ChromeDriver();

		// hit the url
		driver.get("http://automationpractice.com/index.php");

		// maximise the window
		driver.manage().window().maximize();

		// find element by link test having register and click
		/// driver.findElement(By.linkText("Register")).click();

		// create an arrayList to store the test cases
		ArrayList<String> test = new ArrayList<String>();

		// {"Mobile Number is required" ,"You did not confirm your password" ,"The
		// passwords you entered are not same"};
		// add all test cases to test array
		test.add("Mobile Number is required");
		test.add("You did not confirm your password");
		test.add("The passwords you entered are not same");

		// create a arraylist to store the result of tests
		ArrayList<String> result = new ArrayList<String>();

		/*
		 * 
		 * create a file called input.xls and insert the data manually in that file as
		 * given in problemm statement read the input file in 3 iterations and save
		 * details in variables as below in forloop
		 */
		// open the file
		File inputFile = new File("C:\\Users\\vinay\\DT20195828044_workspace\\DT20195828044\\input.xls");

		// get workbook
		Workbook workbook = Workbook.getWorkbook(inputFile);

		// select sheet
		Sheet sheet = workbook.getSheet(0);

		/*
		 * 
		 * to write test results in excel sheet use WritableWorkbook create a work boook
		 * with output file path
		 */

		WritableWorkbook myFirstWbook = null;
		myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));

		// create a sheet with name Sheet 1
		WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);

		// create a label test count which is a heading and
		Label label = new Label(0, 0, "Test count");

		// 0,0 are colmn number and row number
		excelSheet.addCell(label);

		// create a heading result
		label = new Label(1, 0, "result");
		excelSheet.addCell(label);

		//// *[@id="header"]/div[2]/div/div/nav/div[1]/a

		driver.findElement(By.className("login")).click();

		// SubmitCreate

		driver.findElement(By.id("email_create")).sendKeys("vinaykumarpoosala06@gmail.com");

		driver.findElement(By.id("SubmitCreate")).click();

		for (int i = 1; i <= sheet.getColumns(); i++) {

			// get the values from excel sheet and store in variables

			String fname = sheet.getCell(i, 1).getContents();
			String lname = sheet.getCell(i, 2).getContents();
			String password = sheet.getCell(i, 3).getContents();
			String dob = sheet.getCell(i, 4).getContents();
			String Address1 = sheet.getCell(i, 5).getContents();
			String city = sheet.getCell(i, 6).getContents();
			String state = sheet.getCell(i, 7).getContents();
			String zipcode = sheet.getCell(i, 8).getContents();
			String phone = sheet.getCell(i, 9).getContents();
			String error = sheet.getCell(i, 10).getContents();

			/*
			 * 
			 * customer_firstname customer_lastname passwd
			 * 
			 * firstname lastname company
			 * 
			 * address1
			 * 
			 * city id_state
			 * 
			 * postcode
			 * 
			 * id_country
			 * 
			 * phone_mobile
			 * 
			 * alias
			 */

			/*
			 * 
			 * find the elements in and clear the filed after pass the keys i have used
			 * xpath in particular cases
			 */

			Thread.sleep(3000);

			driver.findElement(By.id("customer_firstname")).clear();
			driver.findElement(By.id("customer_firstname")).sendKeys(fname);

			driver.findElement(By.id("customer_lastname")).clear();
			driver.findElement(By.id("customer_lastname")).sendKeys(lname);

			driver.findElement(By.id("passwd")).clear();
			driver.findElement(By.id("passwd")).sendKeys(password);

			driver.findElement(By.id("firstname")).clear();
			driver.findElement(By.id("firstname")).sendKeys(fname);

			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lname);

			driver.findElement(By.id("company")).clear();
			driver.findElement(By.id("company")).sendKeys("tcs");

//    		WebElement drp = driver.findElement(By.className("selected-dial-code"));
//    		drp.click();
//    		drp.findElement(By.xpath("//*[@id=\"containerNewUserSignup\"]/div[2]/div[4]/div/div/div/ul/li[102]")).click();
//    		
//    		
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys(phone);

			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(city);

			driver.findElement(By.id("postcode")).clear();
			driver.findElement(By.id("postcode")).sendKeys(zipcode);

			Select stateO = new Select(driver.findElement(By.id("id_state")));
			stateO.selectByVisibleText(state);;
			
			


			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(city);

			driver.findElement(By.id("phone_mobile")).clear();
			driver.findElement(By.id("phone_mobile")).sendKeys(phone);

			driver.findElement(By.id("alias")).clear();
			driver.findElement(By.id("alias")).sendKeys(Address1);

			// click on register
			driver.findElement(By.id("submitAccount")).click();

			// wait
			Thread.sleep(3000);

			// get error after submiting form and store it in a string
			String er = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).getText();

			// split the string based on new line character
			String[] aEr = er.split("\n");
			

			
			// take screenshot after and store it in unique[1 or 2 or 3].jpg
			TakesScreenshot tk = (TakesScreenshot) driver;
			File sr = tk.getScreenshotAs(OutputType.FILE);
			String f = String
					.format("C:\\Users\\vinay\\DT20195828044_workspace\\DT20195828044\\ScreenShots\\unique%s.jpg", i);
			File Qrfile = new File(f);
			FileHandler.copy(sr, Qrfile);

			// add number of test to excel
			Number number = new Number(0, i, i);
			excelSheet.addCell((WritableCell) number);

			// add error message in excel
			label = new Label(1, i, aEr[1]);
			excelSheet.addCell(label);

		}

		/*
		 * write all the cells close the workbook close the driver
		 */
		myFirstWbook.write();
		myFirstWbook.close();
		driver.close();

		/*
		 * 
		 * Display the test case as either 'Passed' or 'Failed' based on the comparison
		 * of actual message against the below given error messages actual messages are
		 * stored in test list results are stored in result compare the both and print
		 * result
		 * 
		 */

		
	}
}
