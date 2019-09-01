package main.java.com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static main.java.com.company.Scrapper.attachment;
import static main.java.com.company.Scrapper.finMsg;

public class ImgScrape extends Thread {
    static List<WebElement> duplCheck = null;


    public static String imgScrape(WebElement lastFind, String name) {
        try {
            WebElement attachFind = lastFind.findElement(By.className("messageAttachments"));
            List<WebElement> img = attachFind.findElements(By.cssSelector(".img._675, .img._674"));
            if (!img.equals(duplCheck)) {
                duplCheck = img;
                for (WebElement a : img) {

                    attachment = a.getAttribute("src");
                    if (attachment == null) {
                        String stringImgSrc = a.getCssValue("background-image");
                        String[] parts = stringImgSrc.split("\"");
                        attachment = parts[1];

                    }

                    finMsg = Time.minutes() + " **" + name + "**: ";
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
            }
            //        posting message to tea-bot
        } catch (Exception e) {
            System.out.println("no photo");
        }

        return finMsg;
    }
}

