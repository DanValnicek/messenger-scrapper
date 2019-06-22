package com.company;

import main.java.com.company.GlobalVariable;
import main.java.com.company.Scrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main extends Scrapper {
    public static void main(String[] args) {
//        String eduPass = System.getenv("EduPass");
        String messPass = System.getenv("messPass");

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

        GlobalVariable.driver.manage().window().maximize();
        GlobalVariable.driver.manage().deleteAllCookies();

        GlobalVariable.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        GlobalVariable.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        GlobalVariable.driver.get("https://spseadlerka.edupage.org/login/index.php?out=1");
        GlobalVariable.driver.get("https://www.messenger.com/");


        System.out.println("title of the page is: " + GlobalVariable.driver.getCurrentUrl());

        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("danvalnicek@gmail.com");
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(messPass);
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
//        finding channel
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"row_header_id_thread:2124606510942985\"]/a/div/div[2]")).click();
        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"row_header_id_thread:2352986854724121\"]/a/div/div[2]")).click();
//        TODO: live reload

        Boolean True = true;
        JavascriptExecutor js = (JavascriptExecutor) GlobalVariable.driver;
//        js event listener
        js.executeScript("console.log('start')");
        System.out.println("start");
        js.executeScript("newMessage = false;");
        js.executeScript(" document.querySelector('#js_1').addEventListener('DOMSubtreeModified', ()=>{newMessage=true})");
        System.out.println("1");
        //                        "document.querySelector(\"#js_1\").addEventListener('DOMSubtreeModified', ()=>{newMessage=true})");
//      Object newMsg = js.executeScript("return newMessage");
        js.executeScript("console.log('1')");
        while (True) {

            Object newM = js.executeScript("return newMessage");
            System.out.println(newM.getClass());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                // Stop immediately and go home
            }
        }
        Object newM = js.executeScript("newMessage");
        List<WebElement> message = GlobalVariable.driver.findElements(By.className("clearfix"));
        WebElement lastMessage = message.get(message.size() - 1);
        if (newM == "True") ;

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

        System.out.println("title of the page is: " + GlobalVariable.driver.getCurrentUrl());

//        GlobalVariable.driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("Nela");
//        GlobalVariable.driver.findElement(By.xpath("//input[text()='Nela Valnickova']")).click();
//        GlobalVariable.driver.findElement(By.xpath("//*[@id=\"js_1\"]/div[13]/div/div[2]/h5")).getAttribute("innerHTML");
    }

}
//          TODO: easter egg