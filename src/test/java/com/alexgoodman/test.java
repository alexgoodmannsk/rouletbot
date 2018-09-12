package com.alexgoodman;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
    private WebDriver driver;

    @BeforeTest
    public void getDriver(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        driver = new FirefoxDriver();
    }

//    @AfterTest
//    public void clear(){
//        if(driver != null){
//            driver.quit();
//        }
//    }

    @Test
    public void openPage(){
//        driver.get("https://heroeswm.ru");
        driver.get("http://www.heroeswm.ru");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        login.clear();
        login.sendKeys("Материалист");
        WebElement pass = driver.findElement(By.name("pass"));
        pass.click();
        pass.clear();
        pass.sendKeys("!QAZ2wsx");
        WebElement enter = driver.findElement(By.className("entergame"));
        enter.click();
    }
}
