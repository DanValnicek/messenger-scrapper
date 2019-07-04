package com.company;

import main.java.com.company.GlobalVariable;
import main.java.com.company.Scrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class Main extends Scrapper {
    public static void main(String[] args) {
        String messPass = System.getenv("messPass");
//      system path to chromedriver
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

        JavascriptExecutor js = (JavascriptExecutor) GlobalVariable.driver;
//      deleting cookies
        GlobalVariable.driver.manage().deleteAllCookies();
//      setting timeouts
        GlobalVariable.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        GlobalVariable.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//      finding URL
        GlobalVariable.driver.get("https://www.messenger.com/");

        System.out.println("title of the page is: " + GlobalVariable.driver.getCurrentUrl());

//        System.out.println(js.executeScript("return document.documentElement.outerHTML"));

//        logging to messenger
        GlobalVariable.driver.findElement(By.id("email")).sendKeys("danvalnicek@gmail.com");
        GlobalVariable.driver.findElement(By.id("pass")).sendKeys(messPass);
        GlobalVariable.driver.findElement(By.id("loginbutton")).click();
//        accessing channel
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"row_header_id_thread:2352986854724121\"]/a/div/div[2]")).click();
//        js event listener
        js.executeScript("console.log('trying to implement event listener to page')");
        System.out.println("trying to implement event listener to page");
        boolean ready = false;
        while (!ready) {
            try {
                js.executeScript("newMessage = false;");
                js.executeScript(" document.querySelector('#js_1').addEventListener('DOMSubtreeModified', ()=>{newMessage=true})");
                ready = true;
            } catch (Exception e) {
                ready = false;
            }
        }
        System.out.println("event listener is implemented");
        js.executeScript("console.log('event listener is implemented')");

//        Live reload
        Boolean True = true;
        while (True) {
            Object newM = js.executeScript("return newMessage");
            boolean val = Boolean.parseBoolean(String.valueOf(newM));
            if (val) {
                Scrapper.lastMessage();

                js.executeScript("newMessage = false;");
            } else {
                System.out.println("nothing happens");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    System.out.println("Stop immediately and go home");
                }
            }
        }
    }
}
//          TODO: easter egg