package com.HonestFoods.Pages;

import com.HonestFoods.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public static String url = prop.getProperty("baseURI");

    @FindBy(xpath = "//img[@alt='Clubkitchen - zur Startseite wechseln']")
    private WebElement homePageLogo;

    @FindBy(css = "a.btn.club-home-button.shop-menu-btn")
    private WebElement toMenuBtn;

    @FindBy(xpath = "(//a[@title='Mamacita'])[2]")
    private WebElement mamcitaLogo;

    @FindBy(css = "#address-input")
    private WebElement addressInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitBtn;

    @FindBy(css = "#topup-modal--close")
    private WebElement addToCartBtn;

    @FindBy(css = "button.agree-cookie")
    private WebElement agree;

    @FindBy(css= "div.alert.is--success.is--rounded > div.alert--icon")
    private  WebElement successMsg;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void validateLogo(){
        homePageLogo.isDisplayed();
    }

    public void validateMamacitaBrand() {
        mamcitaLogo.isDisplayed();
    }
    public void addProduct(String product, String storeAddress) throws InterruptedException {
        agree.click();
        toMenuBtn.click();
        addressInput.sendKeys(storeAddress);
        submitBtn.click();
        Thread.sleep(10000);
        validateMamacitaBrand();
        WebElement productEle = driver.findElement(By.xpath("(//img[@title='"+product+"'])"));
        Actions builder = new Actions(driver);
        builder.moveToElement(productEle).click(productEle).build().perform();
        Thread.sleep(10000);
        addToCartBtn.click();
        Thread.sleep(10000);
        successMsg.isDisplayed();
    }




}
