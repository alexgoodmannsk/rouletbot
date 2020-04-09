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
        checkLastSpin();
//        driver.get("http://www.heroeswm.ru/roulette.php");
//        WebElement field = driver.findElement(By.xpath("//img[@title='Straight up 19']"));
//        field.click();
//        WebElement bet = driver.findElement(By.name("bet"));
//        bet.clear();
//        bet.sendKeys("150");
//        WebElement submit = driver.findElement(By.xpath("//input[@value='Поставить!']"));
//        submit.click();
    }

    public String checkLastSpin(){
        driver.get("http://www.heroeswm.ru/roulette.php");
        String currentGold = driver.findElement(By.xpath("//td/img[@title='Золото']/following::td[1]")).getText();
        driver.findElement(By.ByLinkText.linkText("Прошлая игра")).click();
        return driver.findElement(By.xpath("//*[contains(text(), 'Выпало число')]")).getText().split(" ")[2];
    }
}
