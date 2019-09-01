package main.java.com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static main.java.com.company.Scrapper.attachment;
import static main.java.com.company.Scrapper.finMsg;

public class FileScrape extends Thread {
        public static volatile String duplCheck = null;
    public static String fileScrape(WebElement lastFind, String name) {
        try {
            List<WebElement> img = lastFind.findElements(By.className("title"));
            for (WebElement a : img) {

                String fileName = a.getText();
                if (!fileName.equals(duplCheck)) {
                    duplCheck = fileName;
                    a.click();
                    String preAttachment = GlobalVariable.driver.findElement(By.cssSelector("._56bz._54k8._5c9u._5caa")).getAttribute("href");
                    GlobalVariable.driver.navigate().back();
                    String[] preAttachment1 = preAttachment.split("=");
                    attachment = preAttachment1[1];
                    finMsg = Time.minutes() + " **" + name + "**: " + "[File]: " + fileName + " -> ";
                    PostExample example = new PostExample();
                    String json = "{\"token\": \"stabletest\",\n" +
                            "    \"type\": \"msg\",\n" +
                            "    \"body\":\"" + finMsg + attachment + "\"}";
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
            System.out.println(finMsg);
        } finally {
            try {
                WebElement audio = lastFind.findElement(By.className("_5nwk"));
                String attachment = audio.findElement(By.cssSelector("source")).getAttribute("src");
                if (!attachment.equals(duplCheck)) {
                    duplCheck = attachment;
                    finMsg = Time.minutes() + " **" + name + "**: " + "[audio]: ";
                    PostExample example = new PostExample();
                    String json = "{\"token\": \"stabletest\",\n" +
                                    "\"type\": \"msg\",\n" +
                                    "\"convertMp4ToAudio\": true,\n" +
                                    "\"file\": \" " + attachment + "\",\n"  +
                                    "\"body\":\"" + finMsg + "\"}";
                    String response = null;
                    try {
                        response = example.post("https://tea-bot.eu-gb.mybluemix.net/api/triggers/send", json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(finMsg + attachment);
                    System.out.println(response);
                }
            } catch (Exception el) {
                System.out.println("no file or audio");
            }
            System.out.println(finMsg);
        }
        return finMsg;
    }
}
