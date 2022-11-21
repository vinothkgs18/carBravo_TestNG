package TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public static WebDriver driver;
	
	
	public static  WebDriver chromeAcces() {
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static  WebDriver edgeAcces() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();				
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static  WebDriver firefoxAcces() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	
	
	public static  WebDriver getDriverAccesFireFox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VIJILA\\eclipse-workspace\\Testng\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		return driver;
		
	}
	
	//-------------------------------------------------------------
	public static void LaunchUrl(String url) {
		driver.get(url);
		
	}
	
	//--------------------------------------------------------------
	public static void fill(WebElement loc, String value) {
		loc.sendKeys(value);
	}
	//-------------------------------------------------------------
	
	public static void click(WebElement loc) {
		loc.click();

	}
	//--------------------------------------------------------------
	public static void windowHandles(int i) {
		Set<String>a=driver.getWindowHandles();
		List<String> l=new ArrayList();
		l.addAll(a);
		String s=l.get(i);
		driver.switchTo().window(s);
	}
	
	//------------------------------------------------------
	public static void windowsHandle() {
		String a=driver.getWindowHandle();
		Set<String> b=driver.getWindowHandles();
		for(String c:b) {
			if(!a.equals(c)) {
				driver.switchTo().window(c);
			}
		}
	}
	public static void dropDown(WebElement i, String a) { 
		Select s=new Select(i);
		s.selectByValue(a);
	}
	public static void getAtibute(WebElement i) {
		 String a = i.getAttribute("value");
		System.out.println(a);
		
	}
	
	public static void mouseover(WebElement i) {
		Actions acc=new Actions(driver);
				acc.moveToElement(i).perform();
	}
	
	public static String getText(WebElement i) {
		String text = i.getText();
		System.out.println(text);
		return text;
	}
	
	public static void waitForSeconds(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	
	public static void datePickesFromCalender(WebElement a1, String d, String e) {
		a1.click();
		
		int c=1;
		
		while(c<11) {
		
		WebElement nextButton = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[2]/div[1]/a[1]/span[1]/span[1]"));
		nextButton.click();
		
		c++;
		}
		WebElement drops = driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/div[1]/select[1]"));
		Select sc= new Select(drops);
		List<WebElement> options = sc.getOptions();
		System.out.println(options.size());
		sc.selectByVisibleText(d);
		
		List<WebElement> calendar1 = driver.findElements(By.xpath("//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"));
		for(int i=0; i<calendar1.size();i++) {
		System.out.println(calendar1.get(i).getText());
		if(calendar1.get(i).getText().equals(e)) {
			calendar1.get(i).click();
			break;
		}
		
		
		}

			
			
		}
		
		

	
	public static void datePick(String a) {
		
		List<WebElement> calendar = driver.findElements(By.xpath("//body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"));
		for(int i=0; i<calendar.size();i++) {
			System.out.println(calendar.get(i).getText());
			if(calendar.get(i).getText().equals(a)) {
				calendar.get(i).click();
				break;
			}
			
			}
	}
public static String removeChatAtStrings(String a, int pos) {
		
		
		return a.substring(0, pos)+ a.substring(pos+1);
	}

public static String getColorFromElement(WebElement elem) {
	
	String cssValue = elem.getCssValue("color");
	System.out.println("rgbaCode=="+cssValue);
	String fromString = Color.fromString(cssValue).asHex();
	System.out.println("HexCode=="+fromString);
	return fromString;	
}

public static String getPageTitle() {
	String title = driver.getTitle();
	return title;
	
}

public static void scrollToElement(WebElement ele) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",ele);	
}

public static boolean scrollToCenter(WebElement ele) {
	if(ele==null) {
		return false;
	}
	boolean SUCCESS= false;
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto',"+"block: 'center',"+"inline: 'center'});", ele);
	SUCCESS =true;
	return SUCCESS;
	
}

	
	
	/*
	 * public static String dataDriven(int row, int cell) throws IOException {
	 * 
	 * File loc =new
	 * File("C:\\Users\\VIJILA\\eclipse-workspace\\Testng\\Excel\\Book1.xlsx");
	 * FileInputStream f= new FileInputStream(loc); Workbook w= new XSSFWorkbook(f);
	 * Sheet s = w.getSheet("sheet1"); Row r = s.getRow(row); Cell c =
	 * r.getCell(cell); String value=null; int type = c.getCellType(); if(type==1) {
	 * value = c.getStringCellValue(); } else if(type==0) {
	 * if(DateUtil.isCellDateFormatted(c)) { Date date = c.getDateCellValue();
	 * SimpleDateFormat sim=new SimpleDateFormat("mm/dd/yyyy"); value =
	 * sim.format(date); } else { double l = c.getNumericCellValue(); long
	 * l1=(long)l; value=String.valueOf(l1); } } return value;}
	 * 
	 */




}
