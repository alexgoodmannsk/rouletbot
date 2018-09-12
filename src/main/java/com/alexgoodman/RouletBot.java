package com.alexgoodman;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RouletBot {
    private WebDriver driver;

    public RouletBot(){
        driver = ProcessStarter.getDriver();
    }

    public void login(){
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
