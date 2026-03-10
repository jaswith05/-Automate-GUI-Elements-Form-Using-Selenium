package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ElementsPage;


public class ElementsTest extends BaseTest {
	
	@Test
	public void elmentsTest() throws InterruptedException {
		ElementsPage elementsPage = new ElementsPage(driver);
		elementsPage.enterName("jaswith");
		elementsPage.enterEmail("jaswithJanjirala@gmail.com");
		elementsPage.enterPhone("7382991666");
		elementsPage.enterAddress("Hyderabad");
		//---Scrolling---
		
		elementsPage.scrollToList();
		
		//---Gender--
		
		elementsPage.clickMale();
		Assert.assertTrue(elementsPage.isMaleSelected(), "Male radio button should be selected!");
		
		elementsPage.clickFemale();
		Assert.assertTrue(elementsPage.isFemaleSelected(), "Female radio button should be selected!");
		
		//---Days---
		
		elementsPage.selectDay("sunday");
        Assert.assertTrue(elementsPage.isDaySelected("sunday"), "Sunday should be checked!");
        
        //--country--
        
        elementsPage.selectCountry("India");
        //--color--
		
		ElementsPage pageTest= new ElementsPage(driver);
		String sel=pageTest.selectColor("Green");
		System.out.println(sel);
		
		
		//--DatePicker--
		
		elementsPage.selectDate1("April","15","2024");

		elementsPage.selectDate2("Apr","2024","15");
		
		elementsPage.scrollToList1();
		
		
		elementsPage.RangeDate("09-03-2026", "12-03-2026");
		
		elementsPage.SingFile();
		elementsPage.Multifile();
		
		//--tables--
		
		elementsPage.verifyTableSize();
		
		
		String ChCpu=elementsPage.getDynamicValue("Chrome","CPU (%)");
		Assert.assertTrue(ChCpu.contains("%"), "CPU value format is incorrect!");
		
		// -- Pagination Table --
	    
	    elementsPage.searchInPaginationTable("Product 15");
	    
	    System.out.println("Successfully selected Product 15 from the pagination table.");
		
	 // -- Shadow DOM Testing --
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");

	    elementsPage.fillShadowDOM("Testing Shadow DOM");
	    
	    System.out.println("Shadow DOM input and checkbox interacted with successfully.");
		
	 // -- Dynamic Button Test --
	    
	    js.executeScript("window.scrollTo(0,0)");

	    
	    elementsPage.DynamicButton();
	    
	    //-Alerts--
	    elementsPage.AlertPopups();
	    
	    //--newtab---
	    
	    elementsPage.NewTab();
	    
	    //--popwindow--
	    
	    elementsPage.popupWindow();
	    
	    
	    //--pointme--
	    
	    elementsPage.PointMe();
	    
	    //--DoubleClick
	    
	    elementsPage.CpyText();
	    
	    //--drag and drop
	    
	    
	    js.executeScript("window.scrollBy(0,500)");
	    elementsPage.dragAndDropTest();
	    
	    //--slider
	    
	    elementsPage.moveSlider();
	    
	    //-scrolldown items
	    
	    elementsPage.selectScrollingDropdown("Item 5");
	    
	    
	    //--labels
	    
	    elementsPage.verifyMobileLabels();
	  
	    //-laptop-links
	    
	    elementsPage.verifyLaptopLink(elementsPage.apple, "Apple");
	    elementsPage.verifyLaptopLink(elementsPage.lenovo, "Lenovo");
	    elementsPage.verifyLaptopLink(elementsPage.dell, "Dell");
	    
	    
	    //-brokenLinks
	    
	    js.executeScript("window.scrollBy(0,500)");
	    
	    elementsPage.verifyBrokenLinks();

	}
	

}
