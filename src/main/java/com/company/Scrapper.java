package main.java.com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Scrapper {
//          Scrapes text
    protected static void textScrapper(String[] args) {
        List<WebElement> textMessage = GlobalVariable.driver.findElements(By.className("_aok")) ;
        WebElement lastTextMessage = textMessage.get(textMessage.size()-1);
        System.out.println(lastTextMessage.getText());
//        TODO: image scrapper
    }
//    Scrapes images
    protected static void imgScrapper(String [] args){
        List<WebElement> img = GlobalVariable.driver.findElements(By.className("_4tsl"));
        List<String> allURLs = new ArrayList<String>();
        int listSize = img.size();
        for (WebElement a : img) {
            // Print out the URL of the anchor.
            System.out.println(a.getAttribute("href"));
        }
    }
//    Scrapes files
    protected static void fileScrapper(String[] args) {
        List<WebElement> file = GlobalVariable.driver.findElements(By.className("_4pcn"));
        List<String> allFiles = new ArrayList<String>();
        int numFiles = file.size();

        for (WebElement a : file) {
            // Print out the URL of the anchor.
            System.out.println(a.getAttribute("href"));
        }
    }
//      Scrapes names
    protected static void nameScrapper() {
        List<WebElement> name = GlobalVariable.driver.findElements(By.className("_ih3")) ;
        WebElement lastName = name.get(name.size()-1);
        System.out.println(lastName.getText());
    }
}

