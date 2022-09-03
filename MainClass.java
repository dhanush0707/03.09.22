package com.newletcode;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class MainClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void test1() throws InterruptedException {
		System.out.println("before class 1");
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://letcode.in/test");
		Thread.sleep(2);

	}
	@Before
	public void test2() {
		System.out.println("before 01");
		Date d =new Date();
		System.out.println(d);

	}
	//@Ignore
	@Test
	public void test01() throws AWTException {
		System.out.println("test 01______");
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[1]")).click();
		
		///////////////////////// input ///////////////////////////////////////////////
		driver.findElement(By.id("fullName")).click();
		driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("dhanush");
		
		// robot class  // tab operation
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"join\"]"));
		findElement.getAttribute("id");
		
		//driver.findElement(By.xpath("//*[@id=\\\"join\\\"]")).getAttribute("enter");
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		WebElement findElement2 = driver.findElement(By.xpath("//*[@id=\"getMe\"]"));
        System.out.println(findElement2.isEnabled()+"\n"+"yes ______is enable");	
        
        driver.navigate().back();
        
/////////////////////////////////// button ///////////////////////////////////////////
driver.findElement(By.xpath("(//a[@class='card-footer-item'])[2]")).click();
driver.findElement(By.id("position")).click();
boolean enabled = driver.findElement(By.id("isDisabled")).isEnabled();
System.out.println("button is not available -- yes"+enabled);driver.navigate().back();

/////////////////////////////////////// selects /////////////////////////////////////
                             ////switch to drop down

driver.findElement(By.xpath("(//a[@class='card-footer-item'])[3]")).click();
WebElement findElement3 = driver.findElement(By.id("fruits"));
findElement3.click();
Select s= new Select(findElement3);

// by index
s.selectByIndex(0);

// by visible text
s.selectByVisibleText("Banana");
 
// by value
s.selectByValue("2");

// is multiple
System.out.println("single drop down ___________________"+"\n"+s.isMultiple());

// multiple drop down
WebElement superHeros = driver.findElement(By.id("superheros"));
Select s1 = new Select(superHeros);
// select by value
s1.selectByValue("ta");

// by visible text
s1.selectByVisibleText("The Avengers");

//firstSelectedOption
System.out.println("first selected option");
WebElement firstSelectedOption = s1.getFirstSelectedOption();
System.out.println(firstSelectedOption);

//allSelectedOptions
List<WebElement> allSelectedOptions = s1.getAllSelectedOptions();
System.out.println(allSelectedOptions);

//all options
List<WebElement> options = s1.getOptions();
System.out.println(options);

WebElement lang = driver.findElement(By.id("lang"));
Select s2= new Select(lang);

// by visible text
s2.selectByVisibleText("C#");
WebElement countryName = driver.findElement(By.id("country"));
Select s3 =new Select(countryName);
s3.selectByValue("Brazil");
List<WebElement> options2 = s3.getOptions();
System.out.println("country selected options"+"\n"+options2);
driver.navigate().back();
////////////////////////////////////////// alerts ///////////////////////////////////////////

//driver.findElement(By.xpath("(//a[@class='card-footer-item'])[4]")).click();



	}
	//@Ignore
	@Test
	public void test02() throws InterruptedException {
		System.out.println("test 02______");
		
		// simple alert
		
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[4]")).click();
		Thread.sleep(3);
		driver.findElement(By.id("accept")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String text = simpleAlert.getText();
		System.out.println("simple Alert"+"\n"+text);
		Thread.sleep(3);
		simpleAlert.accept();
		
		// conform alert
		
		driver.findElement(By.id("confirm")).click();
		Alert comformAlert = driver.switchTo().alert();
		String text2 = comformAlert.getText();
		Thread.sleep(3);
		comformAlert.dismiss();
		System.out.println(text2);
		
		// prompt alert
		
		driver.findElement(By.id("prompt")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("dhanush");
		System.out.println(prompt.getText());
		Thread.sleep(3);
		prompt.accept();
		driver.navigate().back();

	}
	//@Ignore
	@Test  ////////////////////////////////////// frames //////////////////////////////////////////
	public void test3() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[5]")).click();
       driver.switchTo().frame(1);
		//WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='firstFr']"));
		//driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("dhanush");
        driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("D");
        // switch to frame 2
          WebElement frame2 = driver.findElement(By.xpath("//iframe[@class='has-background-white']"));
  		driver.switchTo().frame(frame2);
  		
  		WebElement findElement2 = driver.findElement(By.xpath("/html/body/app-root/app-innerframe/div/div/div/div/div/input"));
  		
  		findElement2.sendKeys("dhanushdev");
  		
  		driver.switchTo().parentFrame();
  		Thread.sleep(2000);
  		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(" d");
  		driver.switchTo().defaultContent();
  		driver.navigate().back();
	}
	//////////////////////////////////////////////// radio button ///////////////////////////////////
	//@Ignore
	@Test  
	public void testt4() {
		// click icon
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[6]")).click();
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='yes']"));
		radiobtn.click();
		boolean selected = radiobtn.isSelected();
        System.out.println("isSelected   "+selected);	
        driver.findElement(By.id("one")).click();
        WebElement findElement = driver.findElement(By.id("nobug"));
        findElement.click();
        boolean enabled = findElement.isEnabled();
        System.out.println("isEnabled   "+enabled);
        WebElement findElement2 = driver.findElement(By.id("maybe"));
        findElement2.click();
        boolean enabled2 = findElement2.isEnabled();
        System.out.println("isEnabled  ~"+enabled2);
        driver.findElement(By.xpath("(//label[@class='checkbox'])[2]")).click();
driver.navigate().back();
	}
	//@Ignore
	@Test     ///////////////////////////////////////////// windows handling ////////////////////////////////////////
	public void testt5() throws InterruptedException {
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[7]")).click();
		// click to face window
		Thread.sleep(2);
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		driver.getWindowHandle();  
		String title = driver.getTitle();
		System.out.println("windows handling get title"+"\n"+title);
driver.quit();
		
//doubt		                                           // contain text concept x-path
//		WebElement containsText = driver.findElement(By.xpath("//h1[contains(text(),' pro in test automation')]"));
//		String text = containsText.getText();
//		System.out.println(text);
//		WebElement findElement = driver.findElement(By.xpath("//h1[text()=' Practice and become pro in test automation']"));
//		String text = findElement.getText();
//		System.out.println(text);
		
	}
	//@Ignore
	@Test                                     // multiple window
	public void test6() throws InterruptedException {
		driver.get("https://letcode.in/windows");
		// get multiple window
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Muiltiple windows']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> li =new ArrayList<String>();
		li.addAll(windowHandles);
		driver.switchTo().window(li.get(1));
		String title = driver.getTitle();
		System.out.println("multi windows title ---- "+title);
		WebElement findElement = driver.findElement(By.id("fruits"));
		Select s= new Select(findElement);
		Thread.sleep(3);
		s.selectByIndex(1);
		driver.switchTo().window(li.get(2));
		
		driver.findElement(By.xpath("//button[@id='confirm']")).click();
		Thread.sleep(3);
		driver.switchTo().alert().accept();
		driver.close();
		driver.switchTo().window(li.get(0));
        driver.navigate().back();
      
	}
	//@Ignore
	@Test
	public void test7() {
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[9]")).click();
		WebElement dragBlog = driver.findElement(By.xpath("//div[@class='cdk-drag example-box']"));
		Actions a =new Actions(driver);
		a.dragAndDropBy(dragBlog, 135, 134).perform();
		driver.navigate().back();
		driver.findElement(By.xpath("(//a[@class='card-footer-item'])[10]")).click();
		// drag and drop 
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		// target
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		a.dragAndDrop(source, target).perform();
		driver.navigate().back();

	}
		
   
	@After
	public void test4() {
		System.out.println("aftre 1");
		Date d= new Date();
		System.out.println(d);

	}
	@AfterClass
	public static void test5() {
    System.out.println("after class 1");
	}

}
