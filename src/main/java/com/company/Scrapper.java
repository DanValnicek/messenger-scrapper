package main.java.com.company;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scrapper {
    //      Scrapes names


    protected static void lastMessage() {
        GlobalVariable.driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        List<WebElement> nameSrape = GlobalVariable.driver.findElements(By.className("_ih3"));
        WebElement lastName = nameSrape.get(nameSrape.size() - 1);
        String name = lastName.getText();
//        finding last message
        List<WebElement> find = GlobalVariable.driver.findElements(By.cssSelector(".clearfix ._o46"));
        WebElement lastFind = find.get(find.size() - 1);

//      printing text messages
        boolean msgSent = false;
        String finMsg = null;
        try {
            WebElement timeStamp = lastFind.findElement(By.className("_ui9"));
            String justTime = timeStamp.getAttribute("data-tooltip-content");
            WebElement send = lastFind.findElement(By.className("_aok"));
            finMsg = justTime + " **" + name + "**: " + send.getText();
            System.out.println(finMsg);
            msgSent = true;
        } catch (Exception e) {
            System.out.println("no text");
        }
//          printing img messages
        if (!msgSent) {
            try {
                WebElement timeStamp = lastFind.findElement(By.className("_3zvs"));
                String justTime = timeStamp.getAttribute("data-tooltip-content");
                List<WebElement> img = lastFind.findElements(By.className("_5pf5"));
                for (WebElement a : img) {
                    finMsg = justTime + " **" + name + "**: " + a.getAttribute("src");
                }
                System.out.println(finMsg);
                msgSent = true;
            } catch (Exception e) {
                System.out.println("no photo");
            }
        }
//          printing file messages
        if (!msgSent) {
            try {
                WebElement timeStamp = lastFind.findElement(By.className("_ui9"));
                String justTime = timeStamp.getAttribute("data-tooltip-content");
                List<WebElement> img = lastFind.findElements(By.className("_4pcn"));
                for (WebElement a : img) {
                    finMsg = justTime + " **" + name + "**: " + a.getAttribute("href");
                }
                System.out.println(finMsg);
            } catch (Exception e) {
                System.out.println("something is wrong");
            }
        }
//        if message wasn't found nothing will be sent to tea-bot
        if (finMsg == null) {
            System.out.println("null");
            return;
        }
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
        System.out.println(response);
    }
}




