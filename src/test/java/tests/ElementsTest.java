package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import utils.TestListener;
import base.BaseTest;
import pages.ElementsPage;

@Listeners(TestListener.class)

public class ElementsTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(ElementsTest.class);

    @Test
    public void elementsTest() throws InterruptedException {

        ElementsPage elementsPage = new ElementsPage(driver);

        log.info("======================================================");
        log.info("STARTING TEST: PERSONAL INFORMATION SECTION");
        log.info("======================================================");

        elementsPage.enterName("jaswith");
        elementsPage.enterEmail("jaswithJanjirala@gmail.com");
        elementsPage.enterPhone("7382991666");
        elementsPage.enterAddress("Hyderabad");
        
        //Assert.assertEquals(1, 2); //to test the fail case 

        log.info("PERSONAL INFORMATION TEST COMPLETED SUCCESSFULLY");
        log.info("======================================================");


        log.info("STARTING TEST: SCROLLING SECTION");
        elementsPage.scrollToList();
        log.info("SCROLL COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: GENDER SELECTION");

        elementsPage.clickMale();
        Assert.assertTrue(elementsPage.isMaleSelected(), "Male radio button should be selected!");

        elementsPage.clickFemale();
        Assert.assertTrue(elementsPage.isFemaleSelected(), "Female radio button should be selected!");

        log.info("GENDER SELECTION TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DAY CHECKBOX SELECTION");

        elementsPage.selectDay("sunday");
        Assert.assertTrue(elementsPage.isDaySelected("sunday"), "Sunday should be checked!");

        log.info("DAY CHECKBOX TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: COUNTRY DROPDOWN");

        String country = elementsPage.selectCountry("India");
        Assert.assertEquals(country, "India");

        log.info("COUNTRY DROPDOWN TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: COLOR DROPDOWN");

        String sel = elementsPage.selectColor("Green");
        log.info("Selected Color: {}", sel);

        log.info("COLOR DROPDOWN TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DATE PICKERS");

        elementsPage.selectDate1("April","15","2024");
        elementsPage.selectDate2("Apr","2024","15");

        log.info("DATE PICKER TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DATE RANGE VALIDATION");

        elementsPage.scrollToList1();
        elementsPage.RangeDate("09-03-2026", "12-03-2026");

        String msg = driver.findElement(By.id("result")).getText();

        Assert.assertFalse(msg.contains("End date must be after start date."),
                "Test Failed: Error message appeared");

        log.info("DATE RANGE TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: FILE UPLOAD");

        elementsPage.SingFile();
        elementsPage.Multifile();

        log.info("FILE UPLOAD TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: STATIC TABLE");

        Assert.assertEquals(elementsPage.getRowCount(),7);
        Assert.assertEquals(elementsPage.getColumnCount(),4);

        log.info("STATIC TABLE TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DYNAMIC TABLE");

        String ChCpu = elementsPage.getDynamicValue("Chrome","CPU (%)");
        Assert.assertTrue(ChCpu.contains("%"), "CPU value format is incorrect!");

        log.info("DYNAMIC TABLE TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: PAGINATION TABLE");

        boolean found = elementsPage.searchInPaginationTable("Desktop Computer");
        Assert.assertTrue(found, "Product not found in pagination table");

        log.info("PAGINATION TABLE TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: SHADOW DOM");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        elementsPage.fillShadowDOM("Testing Shadow DOM");

        log.info("SHADOW DOM TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DYNAMIC BUTTON");

        js.executeScript("window.scrollTo(0,0)");
        elementsPage.DynamicButton();

        log.info("DYNAMIC BUTTON TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: ALERT POPUPS");

        elementsPage.AlertPopups();

        log.info("ALERT POPUP TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: NEW TAB");

        elementsPage.NewTab();

        log.info("NEW TAB TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: POPUP WINDOW");

        elementsPage.popupWindow();

        log.info("POPUP WINDOW TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: MOUSE HOVER");

        elementsPage.PointMe();

        log.info("MOUSE HOVER TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DOUBLE CLICK");

        elementsPage.CpyText();

        log.info("DOUBLE CLICK TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: DRAG AND DROP");

        js.executeScript("window.scrollBy(0,500)");
        elementsPage.dragAndDropTest();

        log.info("DRAG AND DROP TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: SLIDER");

        elementsPage.moveSlider();

        log.info("SLIDER TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: SCROLLING DROPDOWN");

        elementsPage.selectScrollingDropdown("Item 5");

        log.info("SCROLLING DROPDOWN TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: MOBILE LABELS");

        elementsPage.verifyMobileLabels();

        log.info("MOBILE LABELS TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: LAPTOP LINKS");

        elementsPage.verifyLaptopLink(elementsPage.apple, "Apple");
        elementsPage.verifyLaptopLink(elementsPage.lenovo, "Lenovo");
        elementsPage.verifyLaptopLink(elementsPage.dell, "Dell");

        log.info("LAPTOP LINKS TEST COMPLETED");
        log.info("======================================================");


        log.info("STARTING TEST: BROKEN LINKS");

        js.executeScript("window.scrollBy(0,500)");
        elementsPage.verifyBrokenLinks();

        log.info("BROKEN LINK TEST COMPLETED");
        log.info("======================================================");


        log.info("ALL TESTS EXECUTED SUCCESSFULLY");

    }
}