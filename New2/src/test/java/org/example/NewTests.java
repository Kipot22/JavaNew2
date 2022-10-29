package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NewTests {
    private WebDriver webDriver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tetiana\\IdeaProjects\\JavaNew2\\New2\\src\\test\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
        webDriver = new ChromeDriver();
        webDriver.get("https://rozetka.com.ua/");
          }

    @After
    public void cleanUp() {
        if(webDriver != null)
            webDriver.quit();
    }
    @Test
        public void chromeSession(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tetiana\\IdeaProjects\\JavaNew2\\New2\\src\\test\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.quit();
    }

    @Test
    public void newTest(){
        assertEquals("https://rozetka.com.ua/", webDriver.getCurrentUrl());
        assertEquals("Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине", webDriver.getTitle());
    }

    @Test
    public void openLoginModal(){

        webDriver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/rz-user[1]/button[1]")).click();
        assertTrue(webDriver.findElement(By.xpath("//h3[contains(text(),'Вход')]")).getText().contains("Вход"));
    }
}
