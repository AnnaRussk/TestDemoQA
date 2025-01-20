package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestDemoQA {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/");
        driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]")).click();
        //driver.findElement(By.cssSelector("h5:contains('Elements')")).click();
        driver.quit();
    }
}
