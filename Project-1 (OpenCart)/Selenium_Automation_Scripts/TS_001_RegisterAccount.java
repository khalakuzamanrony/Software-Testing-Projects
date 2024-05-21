package oc_register;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TS_001_RegisterAccount {
	public static WebDriver driver;

	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost/oc/upload/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void TCwithMendatoryFields_TC_RF_001() throws InterruptedException {
		Setup();

		WebElement myAcc = driver.findElement(By.linkText("My Account"));
		myAcc.click();

		WebElement register = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
		register.click();

		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		firstName.sendKeys("Khalekuzzaman");

		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		lastName.sendKeys("Rony");

		Date date = new Date();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		email.sendKeys(date.getTime() + "@gmail.com");

		WebElement pass = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		pass.sendKeys("#Rony@7669!");

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);
		WebElement agr = driver.findElement(By.name("agree"));
		agr.click();

		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

//		Checking Part
		Thread.sleep(2000);

		WebElement myAcc2 = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span"));
		myAcc2.click();
		WebElement logout = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(logout.isDisplayed());

		WebElement h1 = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String exHeading = "Your Account Has Been Created!";
		Assert.assertEquals(exHeading, h1.getText());

		WebElement conUs = driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/a"));
		Assert.assertTrue(conUs.isDisplayed());

		Thread.sleep(3000);

		WebElement conBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		conBtn.click();

		Thread.sleep(3000);
		WebElement AccText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
		String RAccText = "My Account";
		Assert.assertEquals(RAccText, AccText.getText());

		Assert.assertEquals("My Account", driver.getTitle());

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 2)
	public void RegisterAccountWithallField_TC_RF_003() throws InterruptedException {
		Setup();

//		click my Account
		WebElement myAcc = driver.findElement(By.linkText("My Account"));
		myAcc.click();

//		click at register button
		WebElement register = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
		register.click();

//		input name
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		firstName.sendKeys("Khalekuzzaman");
//		input name
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		lastName.sendKeys("Rony");
//		input email
		Date date = new Date();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		email.sendKeys(date.getTime() + "@gmail.com");
//		input pass
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		pass.sendKeys("#Rony@7669!");

//		scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);

//		checking newsletter
		WebElement newslater = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));
		newslater.click();

//  	checking agreement
		WebElement agr = driver.findElement(By.name("agree"));
		agr.click();

//		Click Submit
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

//		Checking Part
		Thread.sleep(2000);

//		click on Account
		WebElement myAcc2 = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span"));
		myAcc2.click();
		WebElement logout = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(logout.isDisplayed());

//		cheking h1 text is present
		WebElement h1 = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		String exHeading = "Your Account Has Been Created!";
		Assert.assertEquals(exHeading, h1.getText());

//		Checking presence contactus link
		WebElement conUs = driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]/a"));
		Assert.assertTrue(conUs.isDisplayed());

		Thread.sleep(3000);

//		click on contact us btn
		WebElement conBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		conBtn.click();

		Thread.sleep(3000);

//		check page title is My Account
		WebElement AccText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
		String RAccText = "My Account";
		Assert.assertEquals(RAccText, AccText.getText());

		Assert.assertEquals("My Account", driver.getTitle());

		Thread.sleep(2000);
		driver.quit();

	}

	@Test(priority = 3)
	public void CheckingMendatoryFieldsMessage_TC_RF_004() throws InterruptedException {
		Setup();

//		click my Account
		WebElement myAcc = driver.findElement(By.linkText("My Account"));
		myAcc.click();

//		click at register button
		WebElement register = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
		register.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
//		Click Submit
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

		WebElement firstname_Warning = driver.findElement(By.xpath("//*[@id=\"error-firstname\"]"));
		WebElement lastname_Warning = driver.findElement(By.xpath("//*[@id=\"error-lastname\"]"));
		WebElement email_Warning = driver.findElement(By.xpath("//*[@id=\"error-email\"]"));
		WebElement password_Warning = driver.findElement(By.xpath("//*[@id=\"error-password\"]"));
		WebElement privacypolicy_Warning = driver.findElement(By.xpath("//*[@id=\"alert\"]"));

//		Checking Part
		Assert.assertEquals(firstname_Warning.getText(), "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(lastname_Warning.getText(), "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(email_Warning.getText(), "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(password_Warning.getText(), "Password must be between 4 and 20 characters!");
		Assert.assertTrue(privacypolicy_Warning.getText().contains("You must agree to the Privacy Policy!"));

		Thread.sleep(2000);
		driver.quit();
	}

	@Test(priority = 4)
	public void NewslaterYes_TC_RF_005() throws InterruptedException {
		Setup();

//		click my Account
		WebElement myAcc = driver.findElement(By.linkText("My Account"));
		myAcc.click();

//		click at register button
		WebElement register = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
		register.click();

//		input name
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		firstName.sendKeys("Khalekuzzaman");
//		input name
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		lastName.sendKeys("Rony");
//		input email
		Date date = new Date();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		email.sendKeys(date.getTime() + "@gmail.com");
//		input pass
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		pass.sendKeys("#Rony@7669!");

//		scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);

//		checking newsletter
		WebElement newslater = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));
		newslater.click();

//  	checking agreement
		WebElement agr = driver.findElement(By.name("agree"));
		agr.click();

//		Click Submit
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

//		Checking Part
		Thread.sleep(1000);
//		click on contact us btn
		WebElement conBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		conBtn.click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
//		clicking on newsletter btn
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[4]/li/a")).click();

		WebElement isChcked = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));

		Assert.assertTrue(isChcked.isSelected());

		driver.quit();

	}

	@Test(priority = 5)
	public void NewslaterNo_TC_RF_006() throws InterruptedException {
		Setup();

//		click my Account
		WebElement myAcc = driver.findElement(By.linkText("My Account"));
		myAcc.click();

//		click at register button
		WebElement register = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a"));
		register.click();

//		input name
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
		firstName.sendKeys("Khalekuzzaman");
//		input name
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
		lastName.sendKeys("Rony");
//		input email
		Date date = new Date();
		WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		email.sendKeys(date.getTime() + "@gmail.com");
//		input pass
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
		pass.sendKeys("#Rony@7669!");

//		scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);

//		checking newsletter
//		WebElement newslater = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));
//		newslater.click();

//  	checking agreement
		WebElement agr = driver.findElement(By.name("agree"));
		agr.click();

//		Click Submit
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

//		Checking Part
		Thread.sleep(1000);
//		click on contact us btn
		WebElement conBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		conBtn.click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
//		clicking on newsletter btn
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul[4]/li/a")).click();

		WebElement isChcked = driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]"));

		Assert.assertFalse(isChcked.isSelected());

		driver.quit();

	}

	@Test(priority = 6)
	public void Search_RegisterPage_TC_RF_007() throws InterruptedException {
		Setup();

//		click my Account
		driver.findElement(By.linkText("My Account")).click();

//		click at register button
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();
		String RA3 = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(RA3.contains("Register Account"));

//		click my Account
		driver.findElement(By.linkText("My Account")).click();

//		click at login button
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[2]/a")).click();

//		click at continue btn under New Customer Tab
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/a")).click();
		String RA = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(RA.contains("Register Account"));

//		click at register button at sidebar
		driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[2]")).click();
		String RA2 = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertTrue(RA2.contains("Register Account"));

		driver.quit();

	}

	@Test(priority = 7)
	public void DuplicateAccountRegister_TC_RF_009() throws InterruptedException {
		Setup();

//		click my Account
		driver.findElement(By.linkText("My Account")).click();

//		click at register button
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();

//		input First name
		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Khalekuzzaman");

//		input Last name
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Rony");

//		input email
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("khalakuzzamanrony@gmail.com");

//		input pass
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345");

//		scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);

//		checking newsletter
		driver.findElement(By.xpath("//*[@id=\"input-newsletter\"]")).click();

//  	checking agreement
		driver.findElement(By.name("agree")).click();

//		Click Submit
		driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

		Thread.sleep(1000);
		String Warning = driver.findElement(By.xpath("//*[@id=\"alert\"]/dirv")).getText();
		Assert.assertTrue(Warning.contains("E-Mail Address is already registered!"));

		driver.quit();
	}

	@Test(priority = 8)
	public void AccountRegisterwithInvalidEmail_TC_RF_010() throws InterruptedException {
		Setup();

//		click my Account
		driver.findElement(By.linkText("My Account")).click();

//		click at register button
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/ul/li[2]/div/ul/li[1]/a")).click();

//		input First name
		driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("Khalekuzzaman");

//		input Last name
		driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("Rony");

//		input pass
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345");
		
//		scrolling down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		js.executeScript("window.scrollBy(0,700)", "");
		
		
//		input email
		List<String> emails = Arrays.asList("rony", "rony@", "rony@gmail", "rony@gmail.co");
		for (String email : emails) {
			WebElement em = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
			em.clear();
			em.sendKeys(email);

//	  	checking agreement
			driver.findElement(By.name("agree")).click();

//			Click Submit
			driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button")).click();

			System.out.println(driver.findElement(By.xpath("//*[@id=\"error-email\"]")).getText());
		}

		String txt = driver.findElement(By.xpath("//*[@id=\"error-email\"]")).getText();


		Assert.assertTrue(txt.contains("E-Mail Address does not appear to be valid"));
		driver.quit();
	}

}
