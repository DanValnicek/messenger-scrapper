package com.company;

import main.java.com.company.GetExample;
import main.java.com.company.GlobalVariable;
import main.java.com.company.Scrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main extends Scrapper {
    public static void main(String[] args) {
//        String eduPass = System.getenv("EduPass");
        String messPass = System.getenv("messPass");
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        JavascriptExecutor js = (JavascriptExecutor) GlobalVariable.driver;
        GetExample example = new GetExample();
        String response = null;
        try {
            response = example.run("https://tea-bot.eu-gb.mybluemix.net/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
//        DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
//        cap.setJavascriptEnabled(true);
        GlobalVariable.driver.manage().window().maximize();
        GlobalVariable.driver.manage().deleteAllCookies();

        GlobalVariable.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        GlobalVariable.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        GlobalVariable.driver.get("https://www.messenger.com/");

        System.out.println("title of the page is: " + GlobalVariable.driver.getCurrentUrl());

//        System.out.println(js.executeScript("return document.documentElement.outerHTML"));

//        GlobalVariable.usernameWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]")));
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"u_0_6\"]/div/button")).click();
        GlobalVariable.driver.findElement(By.id("email")).sendKeys("danvalnicek@gmail.com");
        GlobalVariable.driver.findElement(By.id("pass")).sendKeys(messPass);
        GlobalVariable.driver.findElement(By.id("loginbutton")).click();
//        finding channel
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"row_header_id_thread:2124606510942985\"]/a/div/div[2]")).click();
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"row_header_id_thread:2352986854724121\"]/a/div/div[2]")).click();
//        TODO: live reload

        Boolean True = true;

//        js event listener
        js.executeScript("console.log('start')");
        System.out.println("start");
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
        System.out.println("1");
        js.executeScript("console.log('1')");
        while (True) {
            Object newM = js.executeScript("return newMessage");
            boolean val = Boolean.parseBoolean(String.valueOf(newM));
            if (val) {
                Scrapper.lastMessage();

                js.executeScript("newMessage = false;");
            } else
                System.out.println("nothing happens");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // Stop immediately and go home
            }
        }


//        }

        //        finding name

//        TODO: scanning more msg from one user

        //        finding message


//        URL imgURL = new URL(imgSrc);
//        System.out.println(imgURL);


//        GlobalVariable.driver.findElement(By.name("username")).sendKeys("DanValnicek");
//        GlobalVariable.driver.findElement(By.name("password")).sendKeys(eduPass);
//        GlobalVariable.driver.findElement(By.);
//        GlobalVariable.driver.findElement(By.xpath("//input[@value='Prihlásiť sa']")).click();
//        try{
//            GlobalVariable.driver.findElement(By.xpath("//*[@id=\"docbody\"]/div[2]/div[1]/button")).click();
//        }catch (Exception e){
//            System.out.println("No X");
//        }


//        GlobalVariable.driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("Nela");
//        GlobalVariable.driver.findElement(By.xpath("//input[text()='Nela Valnickova']")).click();
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"js_1\"]/div[13]/div/div[2]/h5")).getAttribute("innerHTML");
    }

}
//          TODO: easter egg