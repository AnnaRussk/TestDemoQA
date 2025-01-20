package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestDemoQA {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.findElement(By.cssSelector("#app > div > div > div > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-right > div.icon > svg")).click();
        driver.quit();
    }
}
