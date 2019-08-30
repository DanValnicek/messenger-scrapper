package com.company;

import main.java.com.company.GlobalVariable;
import main.java.com.company.Scrapper;
import main.java.com.company.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;


public abstract class Main extends Scrapper implements Runnable {

    public static void main(String[] args) throws Exception {

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
//        GlobalVariable.driver.get("https://www.messenger.com/");
        GlobalVariable.driver.get("https://m.facebook.com/messages/");

        System.out.println("title of the page is: " + GlobalVariable.driver.getCurrentUrl());

//                            System.out.println(js.executeScript("return document.documentElement.outerHTML"));

//                            logging to messenger
        GlobalVariable.driver.findElement(By.id("m_login_email")).sendKeys("danvalnicek@gmail.com");
        GlobalVariable.driver.findElement(By.id("m_login_password")).sendKeys(messPass);
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"u_0_5\"]")).click();
//                                            accessing channel
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"threadlist_row_thread_fbid_2352986854724121\"]/div[4]/div/a")).click();
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"threadlist_row_thread_fbid_2124606510942985\"]/div[4]/div/a")).click();
//                                                js event listener
        js.executeScript("console.log('trying to implement event listener to page')");
        System.out.println("trying to implement event listener to page");
        boolean ready = false;
        while (!ready) {
            try {
                js.executeScript("newMessage = false;");
                js.executeScript(" document.querySelector('#messageGroup').addEventListener('DOMSubtreeModified', ()=>{newMessage=true})");
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
                lastFind = Scrapper.lastMessage();
                name = Scrapper.nameReturn();
//                timeSend = Time.minutes();
                Scrapper.asyncText();
                Scrapper.asyncImg();
                Scrapper.asyncFile();

                js.executeScript("newMessage = false;");
            } else {
                Time.time();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println("Stop immediately and go home");
                }
            }
        }
    }
}
//          TODO: easter egg