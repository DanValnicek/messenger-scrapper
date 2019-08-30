package main;

import main.java.com.company.PostExample;
import main.java.com.company.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class TextScrape {
    Time myClass = new Time();

    public static String textScrape(WebElement lastFind, String name) {
        WebElement send = lastFind.findElement(By.className("_34ej"));
        String finMsg = Time.minutes() + " **" + name + "**: " + send.getText();
        if (send != null) {
            //        posting message to tea-bot
            PostExample example = new PostExample();
            String json = "{\"token\": \"stabletest\",\n" +
                    "    \"type\": \"msg\",\n" +
                    "    \"body\":\"" + finMsg + "\"}";
            String response = null;

            try {
                response = example.post("https://tea-bot.eu-gb.mybluemix.net/api/triggers/send", json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(finMsg);
            System.out.println(response);
        } else {
            System.out.println("no text");
        }

        return finMsg;
    }
//    public static String response(String finMsg){
//
//    }
}

