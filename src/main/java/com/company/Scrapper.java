package main.java.com.company;


import main.TextScrape;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Scrapper {
    //      Scrapes names
    public static volatile String name;
    public static volatile WebElement lastFind;
    public static volatile String finMsg;
    public static volatile String atachment;

    public static String nameReturn() {
        GlobalVariable.driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        List<WebElement> nameSrape = GlobalVariable.driver.findElements(By.className("_ih3"));
        WebElement lastName = nameSrape.get(nameSrape.size() - 1);
        String name = lastName.getText();
        return name;
    }

    public static WebElement lastMessage() {
//        finding last message
        List<WebElement> find = GlobalVariable.driver.findElements(By.cssSelector(".clearfix ._o46"));
        WebElement lastFind = find.get(find.size() - 1);
        return lastFind;
    }

    public static void asyncText() throws Exception {
        final CompletableFuture<String> textAsync = CompletableFuture.supplyAsync(() ->
                TextScrape.textScrape(lastFind, name));

        System.out.println(finMsg);
    }

    public static void asyncFile() throws Exception {
        final CompletableFuture<String> fileAsync = CompletableFuture.supplyAsync(() ->
                FileScrape.fileScrape(lastFind, name));
    }

    public static void asyncImg() throws Exception {
        final CompletableFuture<String> imgAsync = CompletableFuture.supplyAsync(() ->
                ImgScrape.imgScrape(lastFind, name));
    }
}

