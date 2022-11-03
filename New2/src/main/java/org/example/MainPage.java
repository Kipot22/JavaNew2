package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver webDriver;

    private final String SearchButtonId = "button_search";
    private final String SearchFieldId = "search_field";
    private final String GoodsTitleId = "goods_title";
    private final String CatalogId = "catalog";
    private final String BinId = "bin_button";
    private final String LoginId = "li.header-actions__item--user button";

    public MainPage(WebDriver driver) {

        this.webDriver = driver;
    }

    public void clickLogin(){
    webDriver.findElement(By.cssSelector(LoginId)).click();
    }

    public void clickSearch(){
    webDriver.findElement(By.xpath(SearchButtonId)).click();
    }

    public void clickGoodsTitle(){
        webDriver.findElement(By.xpath(GoodsTitleId)).click();
    }

    public void clickCatalog(){
        webDriver.findElement(By.xpath(CatalogId)).click();
    }
    public void addBin(){
        webDriver.findElement(By.xpath(BinId)).click();
    }

}