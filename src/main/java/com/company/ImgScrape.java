package main.java.com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static main.java.com.company.Scrapper.finMsg;
import static main.java.com.company.Scrapper.*;

public class ImgScrape extends Thread{

   public static String imgScrape(WebElement lastFind, String name) {

            try {
                WebElement timeStamp = lastFind.findElement(By.className("_3zvs"));
                String justTime = timeStamp.getAttribute("data-tooltip-content");
                List<WebElement> img = lastFind.findElements(By.className("_4tsk"));
                for (WebElement a : img) {
                    String stringImgSrc = a.getAttribute("style");
                    String[] parts = stringImgSrc.split("\"");
                    attachment = parts[1];
                    finMsg = justTime + " **" + name + "**: ";
                    PostExample example = new PostExample();
                    String json = "{\"token\": \"stabletest\",\n" +
                            "    \"type\": \"msg\",\n" +
                            "    \"body\":\"" + finMsg + "\"," +
                            "     \"file\":\"" + attachment + "\"}";
                    String response = null;
                    try {
                        response = example.post("https://tea-bot.eu-gb.mybluemix.net/api/triggers/send", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finMsg + attachment);
                    System.out.println(response);
                }
                //        posting message to tea-bot
            } catch (Exception e) {
                System.out.println("no photo");
            }
       return finMsg;
   }
    }

