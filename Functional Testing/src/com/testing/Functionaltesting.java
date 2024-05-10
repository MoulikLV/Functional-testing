package com.testing;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Functionaltesting {

    public static void main(String[] args) throws Exception {
      
    	WebDriverManager.chromedriver().setup();

       WebDriver driver = new ChromeDriver();
        
        driver.get("https://demo.dealsdray.com/");
        
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20)); 
        
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mui-1")));
        usernameField.sendKeys("prexo.mis@dealsdray.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mui-2")));
        passwordField.sendKeys("prexo.mis@dealsdray.com");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Login')]")));
        loginButton.click();
        
        wait.until(ExpectedConditions.urlContains("dashboard")); 
        
        Thread.sleep(2000);
        
        WebElement order=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/button")));
        order.click();
        
        WebElement ordersbutton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button")));
       ordersbutton.click();

      
       WebElement bulkOrders=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[2]/button"))) ;
       bulkOrders.click();
      
      WebElement uploadFile=wait.until(ExpectedConditions.elementToBeClickable(By.id("mui-7")));
      
      Thread.sleep(1000);

      String filePath = "C:/Users/Moulik LV/Downloads/demo-data.xlsx"; 

      
      Thread.sleep(2000);
      
      uploadFile.sendKeys(filePath);
      
      
      Thread.sleep(3000);
      
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/button")).click();
      
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/button")).click();
      Thread.sleep(3000);
      driver.switchTo().alert().accept();
      
      Thread.sleep(2000);
      

      Actions actions = new Actions(driver);
      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

   
      File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

     
      String directoryPath = "D:/functional testing/Screenshot/";

     
      File directory = new File(directoryPath);
      if (!directory.exists()) {
          directory.mkdirs();
      }

 
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
      String timestamp = dateFormat.format(new Date());
      String screenshotPath = directoryPath + "Screenshot-" + timestamp + ".png";

     
      Files.move(screenshotFile.toPath(), new File(screenshotPath).toPath());

     
      System.out.println("Screenshot saved: " + screenshotPath);

    }
      
   
}

