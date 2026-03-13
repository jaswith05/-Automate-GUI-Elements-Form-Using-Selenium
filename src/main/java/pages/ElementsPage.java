package pages;

import java.net.HttpURLConnection;

import java.net.URL;

import org.openqa.selenium.Alert;
import java.time.Month;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;






public class ElementsPage {
	
	WebDriver driver;
	
	
	
	
	
	public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	 	@FindBy(id="name")
	    WebElement name;

	    @FindBy(id="email")
	    WebElement email;

	    @FindBy(id="phone")
	    WebElement phone;

	    @FindBy(id="textarea")
	    WebElement address;
	    
	    //Enter the personal Details
	    
	    public void enterName(String username) {
	        name.sendKeys(username);
	    }

	    public void enterEmail(String useremail) {
	        email.sendKeys(useremail);
	    }

	    public void enterPhone(String userphone) {
	        phone.sendKeys(userphone);
	    }

	    public void enterAddress(String useraddress) {
	        address.sendKeys(useraddress);
	    }
	    
	    public void scrollToList() {
	    	
	    	JavascriptExecutor js= (JavascriptExecutor) driver;
	    	
	    	WebElement sortedList = driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[7]/label"));
	    	js.executeScript("arguments[0].scrollIntoView(true)", sortedList);
	    }
	    
	    
	    
	    //----------Select The Gender-------- 
	    
	    
	    @FindBy(id="male")
	    WebElement maleRadio;

	    @FindBy(id="female")
	    WebElement femaleRadio;

	    public void clickMale() {
	        maleRadio.click();
	    }

	    public void clickFemale() {
	        femaleRadio.click();
	    }

	    public boolean isMaleSelected() {
	        return maleRadio.isSelected();
	    }

	    public boolean isFemaleSelected() {
	        return femaleRadio.isSelected();
	    }
	    
	    
	    //-------Days Selection------
	    
	    @FindBy(xpath="//input[@type='checkbox']")
	    List<WebElement> daysCheckboxes;
	    
	    public void selectDay(String dayName) {

	        for(WebElement day : daysCheckboxes) {

	            String value = day.getAttribute("value");

	            if(value.equalsIgnoreCase(dayName)) {
	                day.click();
	                break;
	            }
	        }
	    }
	    
	    //-------To check if the required one is selected----------
	    
	    public boolean isDaySelected(String dayName) {

	        for(WebElement day : daysCheckboxes) {

	            String value = day.getAttribute("value");

	            if(value.equalsIgnoreCase(dayName)) {
	                return day.isSelected();
	            }
	        }

	        return false;
	    }
	    
	    
	    
	    
	    @FindBy(id="country")
	    WebElement countryDropdown;

	    @FindBy(id="colors")
	    WebElement colorsDropdown;

	    @FindBy(id="animals")
	    WebElement animalsDropdown;
	    
	    public String selectCountry(String countryName) {

	        Select select = new Select(countryDropdown);
	        select.selectByVisibleText(countryName);

	        return select.getFirstSelectedOption().getText();
	    }
	    
	    public String selectColor(String colorName) {

	        Select select = new Select(colorsDropdown);
	        select.selectByVisibleText(colorName);
	        return select.getFirstSelectedOption().getText();
	       
	       

	    }
	    
	    public String selectAnimal(String animalName) {

	        Select select = new Select(animalsDropdown);
	        select.selectByVisibleText(animalName);

	        return select.getFirstSelectedOption().getText();
	    }
	    
	    //---Date pickers---
	    
	    
	    @FindBy(id="datepicker")
	    WebElement dateformat;

	    public void selectDate1(String month, String day, String year)
	    {
	        dateformat.click();

	        while(true)
	        {
	            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

	            if(currentMonth.equals(month) && currentYear.equals(year))
	            {
	                break;
	            }

	          //--converting the months to integers--=
	            int currentMonthNum = Month.valueOf(currentMonth.toUpperCase()).getValue();
	            int targetMonthNum = Month.valueOf(month.toUpperCase()).getValue();
	            
	            //--same as years

	            int currentYearNum = Integer.parseInt(currentYear);
	            int targetYearNum = Integer.parseInt(year);
	            
	            //if current year and month are greater than given month and year going to previous or else next--

	            if(currentYearNum > targetYearNum || 
	               (currentYearNum == targetYearNum && currentMonthNum > targetMonthNum))
	            {
	                driver.findElement(By.xpath("//a[@title='Prev']")).click();
	            }
	            else
	            {
	                driver.findElement(By.xpath("//a[@title='Next']")).click();
	            }
	        }

	        driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
	    }
	    
	    @FindBy(id = "txtDate") 
	    WebElement datePickerInput;

	    @FindBy(className = "ui-datepicker-month")
	    WebElement monthDropdown;

	    @FindBy(className = "ui-datepicker-year")
	    WebElement yearDropdown;
	    public void selectDate2(String monthValue, String yearValue, String dayValue) {
	        datePickerInput.click();

	        Select month = new Select(monthDropdown);
	        month.selectByVisibleText(monthValue);
	        
	        // clicking and performing select by visisble text--

	        Select year = new Select(yearDropdown);
	        year.selectByVisibleText(yearValue);

	        String dayXpath = String.format("//a[text()='%s']", dayValue);
	        driver.findElement(By.xpath(dayXpath)).click();
	    }
	    
 public void scrollToList1() {
	    	
	    	JavascriptExecutor js= (JavascriptExecutor) driver;
	    	
	    	WebElement uploadfiles = driver.findElement(By.xpath("//*[@id=\"HTML15\"]/h2"));
	    	js.executeScript("arguments[0].scrollIntoView(true)", uploadfiles);
	    }
	    
	    
	    @FindBy(id="start-date")
	    WebElement startDate;
	    
	    @FindBy(id="end-date")
	    WebElement endDate;
	    
	    @FindBy(xpath="//button[@class='submit-btn']")
	    WebElement submit;
	    
	    @FindBy(id="result")
	    WebElement resultText;
	    
	    public void RangeDate(String start, String end) throws InterruptedException {

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        // splitting the calender format accordint to the input--	
	        String[] startParts = start.split("-");
	        
	        //now we store that formatted split date into an array
	        String formattedStart = startParts[2] + "-" + startParts[1] + "-" + startParts[0];

	        String[] endParts = end.split("-");
	        String formattedEnd = endParts[2] + "-" + endParts[1] + "-" + endParts[0];
	        
	        // and with js script we can enter the values into required format

	        js.executeScript("arguments[0].value = arguments[1];", startDate, formattedStart);
	        js.executeScript("arguments[0].value = arguments[1];", endDate, formattedEnd);

	        submit.click();

	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    //---Fileupload---
	    
	    @FindBy(id="singleFileInput")
	    WebElement singlefile;
	    
	    @FindBy(id="multipleFilesInput")
	    WebElement multifile;
	    
	    @FindBy(xpath="//*[@id=\"singleFileForm\"]/button")
	    WebElement uploadsingle;
	    
	    @FindBy(xpath="//*[@id=\"multipleFilesForm\"]/button")
	    WebElement uploadmulti;
	    
	    public void SingFile() {
	    	singlefile.sendKeys("C:\\Users\\ACER\\eclipse-workspace\\Project_UseCase\\src\\test\\resources\\singlefile.txt");
	    	uploadsingle.click();
	    }
	    
	    public void Multifile() {
	    	multifile.sendKeys("C:\\Users\\ACER\\eclipse-workspace\\Project_UseCase\\src\\test\\resources\\singlefile.txt\n"
	    			+"C:\\Users\\ACER\\eclipse-workspace\\Project_UseCase\\src\\test\\resources\\multifile.txt");
	    	
	    	uploadmulti.click();
	    	
	    }
	    
	    
	    //--Static web table----
	    
	    
	    @FindBy(xpath="//table[@name='BookTable']//tr")
	    List<WebElement> rows;
	    
	    @FindBy(xpath="//table[@name='BookTable']//th")
	    List<WebElement> cols;
	    
	    public int getRowCount() {
	        return rows.size();
	    }

	    public int getColumnCount() {
	        return cols.size();
	    }
	    
	    //-dynamic web table---
	    
	    public String getDynamicValue(String processName, String columnName) {
	        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='taskTable']//th"));
	        int colIndex = -1;

	        for (int i = 0; i < headers.size(); i++) {
	            String headerText = headers.get(i).getText().trim();
	            if (headerText.equalsIgnoreCase(columnName) || headerText.contains(columnName)) {
	                colIndex = i + 1; 
	                break;
	            }
	        }

	        if (colIndex == -1) {
	            throw new RuntimeException("Column not found: " + columnName);
	        }

	        String cellXPath = "//table[@id='taskTable']//tr[td[text()='" + processName + "']]/td[" + colIndex + "]";
	        return driver.findElement(By.xpath(cellXPath)).getText();
	    }
	    
	    
	    @FindBy(xpath = "//ul[@id='pagination']//a")
	    List<WebElement> paginationLinks;
	    
	    public boolean searchInPaginationTable(String itemName) {

	        for (int i = 1; i <= paginationLinks.size(); i++) {

	            driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='" + i + "']")).click();

	            try {
	                Thread.sleep(500);   // small wait for table update
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            List<WebElement> elements =
	                    driver.findElements(By.xpath("//table[@id='productTable']//td[text()='" + itemName + "']"));

	            if (elements.size() > 0)
	                return true;
	        }

	        return false;
	    }
	    
	    
	 @FindBy(id="input1")
	 WebElement Formsec1;
	 
	 @FindBy(css="#btn1")
	 WebElement Sub1;
	 
	 @FindBy(id="input2")
	 WebElement Formsec2;
	 
	 @FindBy(css="#btn2")
	 WebElement Sub2;
	 
	 @FindBy(id="input2")
	 WebElement Formsec3;
	 
	 @FindBy(css="#btn3")
	 WebElement Sub3;
	 
	 
	 public void FormFilling() {
		 Formsec1.sendKeys("This is a paragraph in Section 1.");
		 Sub1.click();		 
		 
		 Formsec2.sendKeys("This is a paragraph in Section 2.");
		 Sub2.click();
		 
		 Formsec3.sendKeys("This is a paragraph in Section 3.");
		 Sub3.click();
	 }
	 
	// --- Shadow DOM Section ---

	 public void fillShadowDOM(String textValue) {
		    WebElement shadowHost = driver.findElement(By.id("shadow_host"));

		    SearchContext shadowRoot = shadowHost.getShadowRoot();

		    WebElement shadowInput = shadowRoot.findElement(By.cssSelector("input[type='text']"));
		    shadowInput.clear();
		    shadowInput.sendKeys(textValue);

		    WebElement shadowCheckbox = shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
		    if (!shadowCheckbox.isSelected()) {
		        shadowCheckbox.click();
		    }
		}
	 
	 @FindBy(xpath="//*[@id=\"HTML5\"]/div[1]/button")
	 WebElement dynamicButton;
	 
	 public void DynamicButton() {
		 
		 String BefreButton= dynamicButton.getText();
		 System.out.println("Before dynamic button click: "+ BefreButton);
		 dynamicButton.click();
		 
		 String AfterButton=dynamicButton.getText();
		 System.out.println("After dynamic button click: "+AfterButton);
		
	 }
	    
	 
	 @FindBy(id="alertBtn")
	 WebElement AlertBtn;

	 @FindBy(id="confirmBtn")
	 WebElement ConfirmBtn;

	 @FindBy(id="promptBtn")
	 WebElement PromptBtn;

	 public void AlertPopups() {

	     AlertBtn.click();
	     Alert alert = driver.switchTo().alert();
	     System.out.println("Alert message: " + alert.getText());
	     alert.accept();

	     ConfirmBtn.click();
	     alert = driver.switchTo().alert();
	     System.out.println("Confirm message: " + alert.getText());
	     alert.dismiss();  

	     PromptBtn.click();
	     alert = driver.switchTo().alert();
	     System.out.println("Prompt message: " + alert.getText());
	     alert.sendKeys("Hello Jaswith");
	     alert.accept();
	 }
	    
	 @FindBy(xpath="//*[@id=\"HTML4\"]/div[1]/button")
	 WebElement newtab;

	 @FindBy(id="PopUp")
	 WebElement popups;

	 public void NewTab() {

	     String parentWindow = driver.getWindowHandle();

	     newtab.click();
	     
	     // we are using set because, there has to be only unique tabs, now duplicate tabs should be stored.

	     Set<String> allWindows = driver.getWindowHandles();

	     for(String window : allWindows) {
	         if(!window.equals(parentWindow)) {
	             driver.switchTo().window(window);
	             System.out.println("New tab title: " + driver.getTitle());
	             driver.close();
	         }
	     }

	     driver.switchTo().window(parentWindow);
	 }
	 //--popupwindow--
	 public void popupWindow() {

		    String parentWindow = driver.getWindowHandle();

		    popups.click();
		    

		    Set<String> windows = driver.getWindowHandles();

		    for(String window : windows) {

		        if(!window.equals(parentWindow)) {

		            driver.switchTo().window(window);

		            System.out.println("Popup Title: " + driver.getTitle());

		            if(driver.getTitle().contains("Selenium")) {
		                System.out.println("Popup opened successfully");
		            }

		            driver.close();
		        }
		    }

		    driver.switchTo().window(parentWindow);
		}
	 
	 
	 //--pointme-=
	 
	 @FindBy(xpath="//*[@id=\"HTML3\"]/div[1]/div/button")
	 WebElement pointme;

	 public void PointMe() {

	     Actions act = new Actions(driver);

	     act.moveToElement(pointme).perform();

	     System.out.println("Mouse hovered on Point Me button");

	 }
	 
	 //-double click to paste==
	 
	 @FindBy(xpath="//*[@id=\"HTML10\"]/div[1]/button")
	 WebElement cpytext;

	 public void CpyText() {

	     Actions act = new Actions(driver);

	     act.doubleClick(cpytext).perform();

	 }
	 //-drag and drop
	 
	 @FindBy(id="draggable")
	 WebElement drag;

	 @FindBy(id="droppable")
	 WebElement drop;

	 public void dragAndDropTest() {

	     Actions act = new Actions(driver);

	     act.dragAndDrop(drag, drop).perform();

	     System.out.println("Drag and Drop performed successfully");

	 }
	 
	 //--Slider--
	 
	 @FindBy(xpath="//*[@id='slider-range']/span[1]")
	 WebElement minSlider;

	 @FindBy(xpath="//*[@id='slider-range']/span[2]")
	 WebElement maxSlider;

	 public void moveSlider() {

	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,500)");

	     Actions act = new Actions(driver);

	     act.clickAndHold(minSlider).moveByOffset(40,0).release().perform();

	     act.clickAndHold(maxSlider).moveByOffset(-40,0).release().perform();

	     System.out.println("Slider moved successfully");
	 }
	 
	 
	 //--Scrolling items
	 
	 @FindBy(id="comboBox")
	 WebElement dropdownInput;

	 public void selectScrollingDropdown(String itemName) {

	     dropdownInput.click();

	     List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"dropdown\"]"));

	     for(WebElement item : items) {

	         if(item.getText().equals(itemName)) {

	             item.click();
	             break;
	         }
	     }

	     System.out.println("Selected item: " + itemName);
	 }
	 
	 //--labels
	 
	 @FindBy(xpath="//div[@id='mobiles']//label")
	 List<WebElement> mobileLabels;

	 public void verifyMobileLabels() {

	     for(WebElement label : mobileLabels) {

	         System.out.println("Mobile Label: " + label.getText());

	     }
	 }
	 
	 //--laptop-links--=
	 
	 @FindBy(id="apple")
	public
	 WebElement apple;

	 @FindBy(id="lenovo")
	public
	 WebElement lenovo;

	 @FindBy(id="dell")
	public
	 WebElement dell;
	 
	 public void verifyLaptopLink(WebElement link, String expectedTitle) {

		    link.click();

		    String actualTitle = driver.getTitle();

		    if(actualTitle.contains(expectedTitle)) {
		        System.out.println("Title verified for " + expectedTitle);
		    } else {
		        System.out.println("Title mismatch for " + expectedTitle);
		    }

		    driver.navigate().back();
		}
	 
	 //--Brokern Links
	 
	 
	 
	 @FindBy(className="link")
	 List<WebElement> brokenLinks;
	 
	 public void verifyBrokenLinks() {

		    for(WebElement link : brokenLinks) {

		        String url = link.getAttribute("href");

		        try {

		            URL linkUrl = new URL(url);
		            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();

		            connection.setRequestMethod("GET");
		            connection.connect();

		            int responseCode = connection.getResponseCode();

		            System.out.println(url + " --> " + responseCode);

		        } 
		        catch (Exception e) {

		            System.out.println(url + " --> Error occurred");

		        }

		    }

		}
	    

}
