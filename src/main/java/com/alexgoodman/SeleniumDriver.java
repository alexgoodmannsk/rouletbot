package com.alexgoodman;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeleniumDriver {

  private WebDriver driver;

  @PostConstruct
  private void init(){
    FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
    driver = new FirefoxDriver();
  }

  public WebDriver getDriver(){
    return driver;
  }
}
