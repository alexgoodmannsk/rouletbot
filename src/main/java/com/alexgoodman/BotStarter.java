package com.alexgoodman;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BotStarter {
    public static void main(String[] arg){
        initSystemSettings();
    }

    private static void initSystemSettings(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        WebDriver driver = new FirefoxDriver();
    }
}
