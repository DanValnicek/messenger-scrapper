package main.java.com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GlobalVariable {
    public static ChromeOptions options;

    static {
        options = new ChromeOptions().addArguments("headless");
        options.addArguments("window-size=1920x1080");
    }

    public static WebDriver driver = new ChromeDriver(options);
//    public static WebDriver driver = new ChromeDriver();

}
