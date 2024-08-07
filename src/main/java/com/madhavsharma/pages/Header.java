package com.madhavsharma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
    private WebDriver driver;

    public Header(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id="react-burger-menu-btn")
    WebElement menu;

    @FindBy(className = "shopping_cart_link")
    WebElement cart;

    public void clickMenu(){
        menu.click();
    }

    public void clickCart(){
        cart.click();
    }

    public boolean isCartEmpty(){
        try {
            return !driver.findElement(By.className("shopping_cart_badge")).isDisplayed();
        }catch (Exception e){
            return true;
        }
    }

    public int getCartItemCount(){
        if(!isCartEmpty()){
            String cartNumber = driver.findElement(By.className("shopping_cart_badge")).getText();
            return Integer.parseInt(cartNumber);
        }
        return 0;
    }
}
