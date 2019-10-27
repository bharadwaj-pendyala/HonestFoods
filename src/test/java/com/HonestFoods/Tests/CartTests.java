package com.HonestFoods.Tests;


import com.HonestFoods.Pages.HomePage;
import com.HonestFoods.utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class CartTests extends TestBase {

    public TestBase basePage;
    public WebDriver driver;
    public Properties prop;
    public HomePage homePage;

   @BeforeTest
    public void init() throws IOException {
       basePage = new TestBase();
       prop = TestBase.initializeProperties();
       driver = basePage.initialize_driver();
       homePage = new HomePage(driver);
       homePage.visitPage();
   }

   @Test
    public void navigateToHomePage() throws InterruptedException {
       homePage.validateLogo();
       homePage.addProduct(prop.getProperty("userDesiredProduct"), prop.getProperty("storeAddress"));
   }

   @AfterTest
    public void tearDown(){
       try {
           closeBrowser();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


}
