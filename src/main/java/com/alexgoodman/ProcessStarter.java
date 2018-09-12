package com.alexgoodman;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProcessStarter {
    static private boolean shutdownFlag;
    static private WebDriver driver;

    static private void init(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        driver = new FirefoxDriver();
        shutdownFlag = false;
    }

    public static void main(String[] args){
        try
        {
            daemonize();
        }
        catch (Throwable e)
        {
            System.err.println("Startup failed. " + e.getMessage());
        }

        registerShutdownHook();

        doProcessing();
    }

    static public void setShutdownFlag() {shutdownFlag = true;}

    private static void registerShutdownHook()
    {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    public void run() {
                        ProcessStarter.setShutdownFlag();
                    }
                }
        );
    }

    static private void doProcessing()
    {
        init();
        RouletBot bot = new RouletBot();
        bot.login();
        while (false == shutdownFlag)
        {
            //Do some processing
        }
    }

    static private void daemonize() throws Exception
    {
        System.in.close();
        System.out.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
