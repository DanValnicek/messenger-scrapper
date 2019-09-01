package main.java.com.company;


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
    public static volatile String attachment;

    public static String nameReturn() {
        GlobalVariable.driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        String nameFind = lastFind.findElement(By.cssSelector(".darkTouch.l")).getAttribute("href");
        String[] nameFind1 = nameFind.split("/");
        String nameFind2 = nameFind1[3];
        String[] nameFind3 = nameFind2.split("\\W+");
        String name = nameFind3[1].substring(0,1).toUpperCase() + nameFind3[1].substring(1);

        return name;
    }

    public static WebElement lastMessage() {
//        finding last message
        List<WebElement> find = GlobalVariable.driver.findElements(By.cssSelector(".voice.acw"));
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

