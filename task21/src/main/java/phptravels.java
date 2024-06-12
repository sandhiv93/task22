package com.Task22_guvi;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PHP_Travel {

    public static WebDriver driver;
    public static void main(String[] args) throws Throwable {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.navigate().to("https://phptravels.com/demo/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Last Name']"))).sendKeys("Anandh");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).sendKeys("Srinivasan");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Business Name']"))).sendKeys("Origin");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Email']"))).sendKeys("abc123@gmail.com");



        WebElement num1 = driver.findElement(By.xpath("//span[@id='numb1']"));
        WebElement num2 = driver.findElement(By.xpath("//span[@id='numb2']"));
        String A = num1.getText();
        String B = num2.getText();

        int valueA = Integer.parseInt(A);
        int valueB = Integer.parseInt(B);
        int total =valueA + valueB;
        String GrandTotal = Integer.toString(total);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='number']"))).sendKeys(GrandTotal);

        WebElement submit =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit']")));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",  submit);

        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[normalize-space()='Thank you!']")));
        String end = msg.getText();
        if (msg.isDisplayed()) {
            System.out.println("Verified");
        }
        Thread.sleep(1000);
        TakesScreenshot scs1 = (TakesScreenshot) driver;
        File ScreenshotAs = scs1.getScreenshotAs(OutputType.FILE);
        File Destination = new File("D:\\Files\\temp\\Task22.png");
        FileHandler.copy(ScreenshotAs, Destination);
        driver.close();

    }

}