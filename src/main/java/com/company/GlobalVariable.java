package main.java.com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GlobalVariable {
    public static ChromeOptions options = new ChromeOptions().addArguments("headless");
    public static WebDriver driver = new ChromeDriver(options);

}
