// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.*;
public class AboutTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public void loginsuccessful() {
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().setSize(new Dimension(606, 692));
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
    driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
    vars.put("pageUrl", js.executeScript("return  window.location.href"));
    assertEquals(vars.get("pageUrl").toString(), "https://www.saucedemo.com/inventory.html");
  }
  @Test
  public void about() {
    loginsuccessful();
    driver.findElement(By.id("react-burger-menu-btn")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("about_sidebar_link")))); 
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("about_sidebar_link"))));
    driver.findElement(By.id("about_sidebar_link")).click();
    vars.put("pageUrl", js.executeScript("return  window.location.href"));
    assertEquals(vars.get("pageUrl").toString(), "https://saucelabs.com/");
  }
}
