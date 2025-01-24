package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;


class TestDemoQA {

    String url = "https://demoqa.com/";

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void textFieldTest() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        WebElement tabElement = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);
        tabElement.click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]"));
        element.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='userName']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.sendKeys("Какое-то Имя");
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        buttonSubmit.click();
    }

    @Test
    public void checkBoxTest() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        WebElement tab = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
        tab.click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Check Box')]"));
        element.click();
        WebElement CheckBox = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
        CheckBox.click();
        String expectedText = "You have selected :";
        WebElement selectedTextElement = driver.findElement(By.xpath("//span[contains(text(), 'You have selected')]"));
        Assertions.assertEquals(expectedText, selectedTextElement.getText().trim());
    }

    @Test
    public void formTest() {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        WebElement tabForm = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabForm);
        tabForm.click();
        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'Practice Form')]"));
        element.click();
        WebElement inputName = driver.findElement(By.xpath("//input[@id='firstName']"));
        inputName.sendKeys("Имя");
        WebElement inputLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        inputLastName.sendKeys("Фамилия");
        WebElement selectGender = driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectGender);
        WebElement buttonSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        buttonSubmit.click();
        WebElement modalText = driver.findElement(By.xpath("//div[contains(text(), 'Thanks for submitting the form')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modalText);
        String modalExpectedText = "Thanks for submitting the form";
        Assertions.assertEquals(modalExpectedText, modalText.getText().trim());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}