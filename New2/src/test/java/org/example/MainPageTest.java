package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class MainPageTest {
    private WebDriver webDriver;
   // private WebDriver driver;

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tetiana\\IdeaProjects\\JavaNew2\\New2\\src\\test\\resources\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
      //  ChromeDriver driver = new ChromeDriver();
     //   driver.quit();
        webDriver = new ChromeDriver();
        webDriver.get("https://rozetka.com.ua/");
    }

    @Test
    public void login(){

        MainPage mainPage = new MainPage(webDriver);

        //1.Відкрити головну сторінку
        webDriver.get("https://rozetka.com.ua/");
        //2.Натиснути кнопку входу до особистого кабінету
        mainPage.clickLogin();
        //3.У вікні логіна натиснути кнопку "Зареєструватися"

            webDriver.findElement(By.cssSelector("auth-modal__register-link button")).click();
            assertTrue(webDriver.findElement(By.cssSelector("body.overflow-hidden:nth-child(2) app-root:nth-child(1) rz-single-modal-window.ng-star-inserted:nth-child(2) div.modal__holder.modal__holder_show_animation.modal__holder--medium:nth-child(3) div.modal__header > h3.modal__heading")).getText().contains("Регистрация"));
        //4.Заповнити поля валідними даними
            webDriver.findElement(By.cssSelector(".registerUserName")).sendKeys("Тетяна");
            webDriver.findElement(By.cssSelector(".registerUserSurname")).sendKeys("Кіпоть");
            webDriver.findElement(By.cssSelector(".registerUserPhone")).sendKeys("95 629 92 02");
            webDriver.findElement(By.cssSelector(".registerUserEmail")).sendKeys("k4872319@yahoo.com");
            webDriver.findElement(By.cssSelector(".registerUserPassword")).sendKeys("V280116ika");
        //5.Натиснути кнопку зареєструватися
            webDriver.findElement(By.xpath("//button[contains(text(),'Зарегистрироваться')]")).click();
        //6.Перевіряємо текст про реєстрацію
            assertTrue(webDriver.findElement(By.xpath("//h1[contains(text(),'Подтверждение номера телефона')]")).getText().contains("Подтверждение номера телефона"));
        }
    @After
    public void cleanUp() {
        if(webDriver != null)
            webDriver.quit();
    }

    }
