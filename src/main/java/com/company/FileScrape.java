package main.java.com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static main.java.com.company.Scrapper.*;
import static main.java.com.company.Scrapper.lastFind;

public class FileScrape extends Thread {
    public static String fileScrape(WebElement lastFind, String name) {
        try {
            WebElement timeStamp = lastFind.findElement(By.className("_ui9"));
            String justTime = timeStamp.getAttribute("data-tooltip-content");
            List<WebElement> img = lastFind.findElements(By.className("_4pcn"));
            for (WebElement a : img) {
                atachment = a.getAttribute("href");


                finMsg = justTime + " **" + name + "**: " + "[File] ";
                PostExample example = new PostExample();
                String json = "{\"token\": \"stabletest\",\n" +
                        "    \"type\": \"msg\",\n" +
                        "    \"body\":\"" + finMsg + atachment + "\"}";
                String response = null;
                try {
                    response = example.post("https://tea-bot.eu-gb.mybluemix.net/api/triggers/send", json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(finMsg + atachment);
                System.out.println(response);
            }
            System.out.println(finMsg);
        } catch (Exception e) {
            System.out.println("no file");
        }
        return finMsg;
    }
}
