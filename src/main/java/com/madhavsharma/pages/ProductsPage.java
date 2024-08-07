package com.madhavsharma.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "title")
    private WebElement pageTitle;

    public boolean isProductPageLoaded(){
        try {
            logger.info("Trying to get page title: "+ pageTitle.getText());
            return pageTitle.getText().equalsIgnoreCase("products");
        }catch (Exception e){
            return false;
        }
    }
}
