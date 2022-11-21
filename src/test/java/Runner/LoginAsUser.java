package Runner;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D.Float;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way;
import TestBase.Base;

public class LoginAsUser extends Base{
	public POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way cb;
	
	@BeforeMethod
	public void lunchurl() throws InterruptedException {
		
		chromeAcces();
		LaunchUrl("https://www.carbravo.com/");
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		waitForSeconds(10);
		click(cb.getBanner());
		
		
	}
	
	@AfterMethod
	public void quite() {
		//driver.quit();
	}
	
	@Test(enabled=false)
	public void filters_BodyType() throws InterruptedException, AWTException {
		WebDriverWait wait= new WebDriverWait(driver, 8000);
		
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		int bodyTypeSize ;
		
		click(cb.getBanner());
		//click(cb.getMenu());
		//click(cb.getSigninLink());
		//fill(cb.getUserName(), "vinothkgs18@gmail.com");
		//fill(cb.getPassword(), "Spring@123");
		//click(cb.getSignButton());
		//Thread.sleep(8000);
		waitForSeconds(60);
		click(cb.getSearchCar());
		Thread.sleep(8000);
		String totalcount = cb.getTotalVechileCount().getText();
		System.out.println("Total veichle Count without filters=="+totalcount);
		String counts="";
		
		int a=0;
		do {
			
			System.out.println("Entry Loop a Count-->"+a);
			
			click(cb.getMenuBars().get(0));
			
		String bodyTypes=cb.getListOfBodyTypes().get(a).getText();
		bodyTypeSize = cb.getListOfBodyTypes().size();
		System.out.println("Body Type size=="+bodyTypeSize);
		if(cb.getClearButton().isEnabled()) {
			waitForSeconds(3);
			click(cb.getClearButton());
		}
		//Thread.sleep(1000);
		while(cb.getApplyButton().isEnabled()) {
		click(cb.getListOfBodyTypes().get(a));
		break;
		}
		Thread.sleep(1000);
		System.out.println("Vechile Type is=="+cb.getListOfBodyTypes().get(a).getText());
		if(cb.getClearButton().isEnabled()) {
			
		counts = cb.getCount().getText();
		System.out.println("Vechile Count=="+counts);
		
		}
		if(!counts.equals("0")) {
		click(cb.getApplyButton());
		//Thread.sleep(4000);
		System.out.println("Total Vechile Count=="+cb.getTotalVechileCount().getText());
		
		Assert.assertEquals(cb.getTotalVechileCount().getText(), counts);
		System.out.println("Filters Result for Body Type is=="+cb.getfiltersResultinBody().getText());
		Assert.assertEquals(cb.getfiltersResultinBody().getText(), bodyTypes);
		}
		else {
			click(cb.getClearButton());
			Robot r= new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		}
		a++;
		System.out.println("Exist Loop a Count-->"+a);
		System.out.println("************************************");
		}while(a<bodyTypeSize);
	}
	
	@Test(enabled=false)
	public void filters_Price() throws InterruptedException, AWTException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		String counts="";
		String priceFrom="25,000";
		String priceTo="75,000";
		
		
		click(cb.getBanner());
		click(cb.getSearchCar());
		Thread.sleep(8000);
		click(cb.getMenuBars().get(1));
		
		
		/*
		 * int a1=cb.getSliderIcons().get(0).getRect().getPoint().x; int
		 * b1=cb.getSliderIcons().get(1).getRect().getPoint().x;
		 * System.out.println("Before Update Slider points for 1st=="+a1);
		 * System.out.println("Before Update Slider points for 2nd=="+b1);
		 */
		
		
		fill(cb.getPriceRangeTextBox().get(0), priceFrom);
		
		
		Thread.sleep(4000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		fill(cb.getPriceRangeTextBox().get(1), priceTo);
		
		
		/*
		 * int a=cb.getSliderIcons().get(0).getRect().getPoint().x; int
		 * b=cb.getSliderIcons().get(1).getRect().getPoint().x;
		 * System.out.println("After Update Slider points for 1st=="+a);
		 * System.out.println(																																					CCCCCCCCCVVVCC"After Update Slider points for 2nd=="+b);
		 */		
		
		
		System.out.println("Finding value of slider-1=="+cb.getSliderIcons().get(0).getAttribute("value"));
		System.out.println("Finding value of slider-2=="+cb.getSliderIcons().get(1).getAttribute("value"));
		System.out.println("Remove character in string=="+removeChatAtStrings(priceFrom, 2));
		Assert.assertEquals(cb.getSliderIcons().get(0).getAttribute("value"), removeChatAtStrings(priceFrom, 2));
		Assert.assertEquals(cb.getSliderIcons().get(1).getAttribute("value"), removeChatAtStrings(priceTo, 2));
		Thread.sleep(4000);
		
		
		if(cb.getClearbuttonsforprice().isEnabled()) {
			
		counts = cb.getCount().getText();
		System.out.println("Vechile Count in filter window=="+counts);
		
		}
		
		
		
		if(!counts.equals("0")) {
			click(cb.getApplyButton());
			Thread.sleep(3000);
			System.out.println("Total Vechile Count in Body section=="+cb.getTotalVechileCount().getText());
			
			Assert.assertEquals(cb.getTotalVechileCount().getText(), counts);
			String resultoffilters = cb.getfiltersResultinBody().getText();
			System.out.println(resultoffilters);
			Assert.assertTrue(resultoffilters.contains(priceFrom));
			Assert.assertTrue(resultoffilters.contains(priceTo));
			
			}
		
			else {
				click(cb.getClearButton());
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
			}
	}
	
	@Test(enabled=false)
	public void filters_Payment() throws InterruptedException, AWTException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		String counts="";
		String priceFrom="5,000";
		String priceTo="1,000";
		
		
		click(cb.getBanner());
		click(cb.getSearchCar());
		Thread.sleep(4000);
		
		
		/*
		 * WebDriverWait wait= new WebDriverWait(driver, 6000);
		 * wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.
		 * xpath("//button[@data-di-id='di-id-850af29e-10ab198']")))); Wait w= new
		 * FluentWait(driver).withTimeout(1, TimeUnit.MINUTES).pollingEvery(5,
		 * TimeUnit.SECONDS).ignoring(Exception.class);
		 * driver.findElement(By.xpath("//button[@data-di-id='di-id-850af29e-10ab198']")
		 * ).click();
		 */
		
		
		click(cb.getMenuBars().get(1));
		click(cb.getPaymentTab());
		
		
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		fill(cb.getDownPaymentElementTextBox(), priceFrom);
		
		
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		fill(cb.getMonthlyPamentTextbox(), priceTo);
		
		Assert.assertEquals(cb.getPaymentSlidersIcon().get(0).getAttribute("value"), removeChatAtStrings(priceFrom, 1));
		Assert.assertEquals(cb.getPaymentSlidersIcon().get(1).getAttribute("value"), removeChatAtStrings(priceTo, 1));
		
		//Thread.sleep(4000);
		waitForSeconds(10);
		if(cb.getPaymentClearButton().isEnabled()) {
		  counts = cb.getCount().getText();
		  System.out.println("Vechile Count in filter window=="+counts);
		  }
		 
			
			
			
			if(!counts.equals("0")) {
				click(cb.getApplyButton());
				Thread.sleep(3000);
				System.out.println("Total Vechile Count in Body section=="+cb.getTotalVechileCount().getText());
				
				Assert.assertEquals(cb.getTotalVechileCount().getText(), counts);
				String resultoffilters = cb.getfiltersResultinBody().getText();
				String downpaymentResult = cb.getDownpaymentresult().getText();
				System.out.println(resultoffilters);
				Assert.assertTrue(resultoffilters.contains(priceFrom));
				Assert.assertTrue(downpaymentResult.contains(priceTo));
				
				}
			
				else {
					click(cb.getClearButton());
					r.keyPress(KeyEvent.VK_ESCAPE);
					r.keyRelease(KeyEvent.VK_ESCAPE);
				}
	}
	
	@Test(enabled=true)
	public void MakeAndModel() throws InterruptedException, AWTException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		String counts="";
		//String priceFrom="5,000";
		//String priceTo="1,000";
		
		
		
		click(cb.getSearchCar());
		Thread.sleep(4000);
		click(cb.getMenuBars().get(2));
		int i= new Random().nextInt(cb.getMakelist().size());
		
		waitForSeconds(10);
		
		fill(cb.getSearchBar(),cb.getMakelist().get(i).getText());
		click(cb.getMakelist().get(0));
		click(cb.getModelList().get(0));
		 counts = cb.getCount().getText();
		System.out.println(cb.getCount().getText());
		click(cb.getApplyButton());
		Assert.assertEquals(cb.getTotalVechileCount().getText(),counts);
		
		//Verify Select All button
		click(cb.getMenuBars().get(2));
		 i= new Random().nextInt(cb.getMakelist().size());

		fill(cb.getSearchBar(), cb.getMakelist().get(i).getText());
		click(cb.getMakelist().get(0));
		click(cb.getClearButton());
		click(cb.getSelectAll());
		Thread.sleep(4000);
		counts = cb.getCount().getText();
		System.out.println(counts);
		if(!counts.equals("0")) {
		click(cb.getApplyButton());
		Assert.assertEquals(cb.getTotalVechileCount().getText(),counts);
		}
		
		else {
			Robot r= new Robot();
			click(cb.getClearButton());
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		}
		
		//Verify clear button once click the clear button then fillters value reset
		click(cb.getMenuBars().get(2));
		Thread.sleep(2000);
		fill(cb.getSearchBar(), cb.getMakelist().get(i).getText());
		click(cb.getMakelist().get(0));
		click(cb.getClearButton());
		String resetValue = cb.getCount().getText();
		click(cb.getApplyButton());
		Assert.assertEquals(cb.getTotalVechileCount().getText(), resetValue);
		
		
	}
	
	@Test(enabled=false)
	public void filters_Performance() throws InterruptedException, AWTException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		Robot r= new Robot();
		String counts="";
		String Drive_Type="";
		String Transmission_Type="";
		String Engine_Cylinders="";
		String Fuel_Type="";
		String Fuel_EconomyEndRange="";
		String Fuel_EconomyStartRange="";
		click(cb.getSearchCar());
		Thread.sleep(4000);
		click(cb.getMenuBars().get(4));
		
		 click(cb.getAllValueForPerformanceFilters().get(2));
		 Drive_Type=cb.getAllValueForPerformanceFilters().get(2).getText();
		 click(cb.getAllValueForPerformanceFilters().get(4));
		 Transmission_Type=cb.getAllValueForPerformanceFilters().get(4).getText();
		 click(cb.getAllValueForPerformanceFilters().get(8));
		 Engine_Cylinders=cb.getAllValueForPerformanceFilters().get(8).getText();
		 click(cb.getAllValueForPerformanceFilters().get(10));
		 Fuel_Type=cb.getAllValueForPerformanceFilters().get(10).getText();
		Actions action=new Actions(driver);
		action.dragAndDropBy(cb.getSliderFuelEcnomic().get(1),-300, 0).perform();
		Fuel_EconomyStartRange=cb.getSliderFuelEcnomic().get(0).getAttribute("value");
		Fuel_EconomyEndRange=cb.getSliderFuelEcnomic().get(1).getAttribute("value");
		System.out.println(Drive_Type+"\t"+Transmission_Type+"\t"+Engine_Cylinders+"\t"+Fuel_Type+"\t"+Fuel_EconomyStartRange+"\t"+Fuel_EconomyEndRange);
		
		
		Thread.sleep(2000);
		counts=cb.getCount().getText();
		System.out.println("Filters Vehicle Count=="+counts);
		if(!counts.equals("0")) {
			click(cb.getApplyButton());
			Thread.sleep(6000);
			System.out.println("Total Vechile Count in Body section=="+cb.getTotalVechileCount().getText());
			Assert.assertEquals(cb.getTotalVechileCount().getText(), counts);
			Assert.assertEquals(cb.getResultsForPreformanceFilters().get(0).getText(), Drive_Type);
			Assert.assertEquals(cb.getResultsForPreformanceFilters().get(1).getText(), Transmission_Type);
			Assert.assertEquals(cb.getResultsForPreformanceFilters().get(2).getText(), Engine_Cylinders);
			Assert.assertEquals(cb.getResultsForPreformanceFilters().get(3).getText(), Fuel_Type);
			String sliderResult = cb.getResultsForPreformanceFilters().get(4).getText();
			Assert.assertTrue(sliderResult.contains(Fuel_EconomyStartRange));
			Assert.assertTrue(sliderResult.contains(Fuel_EconomyEndRange));
			
			System.out.println(cb.getResultsForPreformanceFilters().size());
			for(int i=0;i<=cb.getResultsForPreformanceFilters().size()-1;i++) {
				System.out.println(i+"=="+cb.getResultsForPreformanceFilters().get(i).getText());
				
			}
}
			else {
				click(cb.getClearButton());
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
			     }
		// Verify clear button once click the clear button then fillters value reset
				click(cb.getMenuBars().get(4));
				Thread.sleep(5000);
				click(cb.getClearButton());
				String resetValue = cb.getCount().getText();
				click(cb.getApplyButton());
				Assert.assertEquals(cb.getTotalVechileCount().getText(), resetValue);
			
	}
	
	@Test(enabled=false)
	public void filters_Feature() throws AWTException, InterruptedException{
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		Robot r= new Robot();
		String counts="";
		String Technology="";
		String Safety_and_Driver_Assistance="";
		String Premium="";
		String Convenience="";
		String Utility="";
		
		
		waitForSeconds(10);
		
		click(cb.getBanner());
		click(cb.getSearchCar());
		Thread.sleep(4000);
		click(cb.getMenuBars().get(5));
		click(cb.getAllValueForFeatureFilters().get(0));
		Technology=cb.getAllValueForFeatureFilters().get(0).getText();
		click(cb.getAllValueForFeatureFilters().get(5));
		Safety_and_Driver_Assistance=cb.getAllValueForFeatureFilters().get(5).getText();
		click(cb.getAllValueForFeatureFilters().get(8));
		Premium=cb.getAllValueForFeatureFilters().get(8).getText();
		click(cb.getAllValueForFeatureFilters().get(12));
		Convenience=cb.getAllValueForFeatureFilters().get(12).getText();
		click(cb.getAllValueForFeatureFilters().get(15));
		Utility=cb.getAllValueForFeatureFilters().get(15).getText();
		System.out.println(Technology+"\t"+Safety_and_Driver_Assistance+"\t"+Premium+"\t"+Convenience+"\t"+Utility);
		Thread.sleep(8000);
		counts=cb.getCount().getText();
		System.out.println("COunts of Filters"+counts);
		
		if(!counts.equals("0")) {
			click(cb.getApplyButton());
			for(int i=0;i<cb.getResultsFeatureFilters().size();i++) {
				System.out.println(i+"=="+cb.getResultsFeatureFilters().get(i).getText());
			}
			Assert.assertEquals(cb.getResultsFeatureFilters().get(0).getText(), Technology);
			Assert.assertEquals(cb.getResultsFeatureFilters().get(4).getText(), Safety_and_Driver_Assistance);
			Assert.assertEquals(cb.getResultsFeatureFilters().get(1).getText(), Premium);
			Assert.assertEquals(cb.getResultsFeatureFilters().get(2).getText(), Convenience);
			Assert.assertEquals(cb.getResultsFeatureFilters().get(3).getText(), Utility);
		}
		else {
			
			click(cb.getClearButton());
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		     }
	// Verify clear button once click the clear button then fillters value reset
		click(cb.getMenuBars().get(5));
		Thread.sleep(5000);
		click(cb.getClearButton());
		String resetValue = cb.getCount().getText();
		click(cb.getApplyButton());
		Assert.assertEquals(cb.getTotalVechileCount().getText(), resetValue);
		
	}
	
	@Test(enabled= false)
	public void moreFilters() throws AWTException, InterruptedException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		Robot r= new Robot();
		String counts="";
		String Vehicle_History_Report="";
		String Exterior_Color="";
		String Interior_Color="";
		String Number_of_seats="";
		String Utility="";
		
		
		waitForSeconds(10);
		
		
		click(cb.getSearchCar());
		Thread.sleep(4000);
		click(cb.getMenuBars().get(6));
		
		//vechile history Report
		click(cb.getAllValuesforMoreFilters().get(1));
		Vehicle_History_Report=cb.getAllValuesforMoreFilters().get(1).getText();
		System.out.println(Vehicle_History_Report);
		
		// Exterior Color
		click(cb.getBodyColorsAll().get(0));
		Exterior_Color=cb.getBodyColorsAll().get(0).getText();
		System.out.println(Exterior_Color);
		
		//Interior Color
		click(cb.getBodyColorsAll().get(7));
		Interior_Color= cb.getBodyColorsAll().get(7).getText();
		System.out.println(Interior_Color);
		
		//Numbers of seats
		
		click(cb.getAllValuesforMoreFilters().get(5));
		Number_of_seats= cb.getAllValuesforMoreFilters().get(5).getText();
		System.out.println(Number_of_seats);
		Thread.sleep(5000);
		counts=cb.getCount().getText();
		System.out.println("Counts for filters"+counts);
		if(!counts.equals("0")) {
			click(cb.getApplyButton());
			for(int i=0;i<cb.getResultsFeatureFilters().size();i++) {
				System.out.println(i+"=="+cb.getResultsFeatureFilters().get(i).getText());
			}
			System.out.println("Result in Body Total Count=="+cb.getTotalVechileCount().getText());
			Assert.assertEquals(cb.getTotalVechileCount().getText(), counts);
			Assert.assertTrue(cb.getResultsFeatureFilters().get(3).getText().contains(Vehicle_History_Report));
			Assert.assertTrue(cb.getResultsFeatureFilters().get(0).getText().contains(Exterior_Color));
			Assert.assertTrue(cb.getResultsFeatureFilters().get(1).getText().contains(Interior_Color));
			Assert.assertTrue(cb.getResultsFeatureFilters().get(2).getText().contains(Number_of_seats));
			
			
		}
		else {
			
			click(cb.getClearButton());
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
		     }
		
		// Verify clear button once click the clear button then fillters value reset
				click(cb.getMenuBars().get(6));
				Thread.sleep(5000);
				click(cb.getClearButton());
				String resetValue = cb.getCount().getText();
				click(cb.getApplyButton());
				Assert.assertEquals(cb.getTotalVechileCount().getText(), resetValue);

		
	}
	
	public void loginUser() {
		fill(cb.getUserName(), "vinothkgs18@gmail.com");
		fill(cb.getPassword(), "Spring@123");
		click(cb.getSignButton());
	}
	@Test(enabled=false)
	
	public void wishList() throws InterruptedException, AWTException {
		cb= new POJO_CarBravo_Buying_and_Selling_Used_Cars_a_Brand_New_Way();
		String counts="";
		
		click(cb.getSearchCar());
		Thread.sleep(4000);
		int i= new Random().nextInt(cb.getListOfHartButton().size());
		System.out.println("Value of i=="+i);
		scrollToCenter(cb.getListOfHartButton().get(i));
		Thread.sleep(3000);
		click(cb.getListOfHartButton().get(i));
		Thread.sleep(2000);
		Assert.assertEquals(getColorFromElement(cb.getListOfHartButton().get(i)), "#6bc24a");
		String vinText = cb.getVinList().get(i).getText();
		System.out.println("VIN Text=="+vinText);
		Assert.assertEquals(getColorFromElement(cb.getHeaderWishListIcon()),"#6bc24a");
		click(cb.getHeaderWishListIcon());
		
		System.out.println("Fav VIN Text=="+cb.getFavVin().getText());
		Assert.assertEquals(cb.getFavVin().getText(),vinText);
		click(cb.getSaveFavoritesButton());
		Thread.sleep(5000);
		System.out.println("TitleOfPage=="+getPageTitle());
		if(getPageTitle().equals("Sign in to your Carbravo Account")) {
		loginUser();
		waitForSeconds(20);
		scrollToCenter(cb.getWinListOfMyAccount().get(0));
		System.out.println("VIN of my Account"+cb.getWinListOfMyAccount().get(0).getText());
		Assert.assertEquals(cb.getWinListOfMyAccount().get(0).getText(), vinText);
		}
		else {
			waitForSeconds(20);
			scrollToElement(cb.getWinListOfMyAccount().get(0));
			System.out.println("VIN of my Account"+cb.getWinListOfMyAccount().get(0).getText());
			Assert.assertEquals(cb.getWinListOfMyAccount().get(0).getText(), vinText);
		}
		
		
	}
	
	
	
}
