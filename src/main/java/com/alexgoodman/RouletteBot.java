package com.alexgoodman;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RouletteBot {

    private WebDriver driver;

    @Autowired
    public RouletteBot(SeleniumDriver driver){
        this.driver = driver.getDriver();
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

    public void updatePage(){
        driver.get("http://www.heroeswm.ru/map.php");
        driver.findElement(By.ByLinkText.linkText("Обработка")).click();
    }

    public String getLastSpin(){
        driver.get("http://www.heroeswm.ru/roulette.php");
        driver.findElement(By.ByLinkText.linkText("Прошлая игра")).click();
        return driver.findElement(By.xpath("//*[contains(text(), 'Выпало число')]")).getText().split(" ")[2];
    }

    public Integer getCurrentGold(){
        driver.get("http://www.heroeswm.ru/roulette.php");
        return Integer.parseInt(driver.findElement(By.xpath("//td/img[@title='Золото']/following::td[1]")).getText()
            .replace(",",""));
    }

    public void bet(String number, String quantity){
        driver.get("http://www.heroeswm.ru/roulette.php");
        WebElement field = driver.findElement(By.xpath("//img[@title='Straight up " + number + "']"));
        field.click();
        WebElement bet = driver.findElement(By.name("bet"));
        bet.clear();
        bet.sendKeys(quantity);
        WebElement submit = driver.findElement(By.xpath("//input[@value='Поставить!']"));
        submit.click();
    }
}
