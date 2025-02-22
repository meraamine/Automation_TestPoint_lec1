package Facebook;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class locators {

    SHAFT.GUI.WebDriver driver;

    //Locators
    By emailInput = By.id("email");
    By passInput = By.id("pass");
    By loginBtn = By.xpath("//button[@name='login']");
    By errorMsg = By.xpath("//div[@class='_9ay7']");





    //Test Methods
    @Test
    public void login() {
        driver.browser().navigateToURL("https://www.facebook.com/");
        driver.element().type(emailInput,"Test@Gmail.com").
                and().type(passInput,"P@ssw0rd").
                and().click(loginBtn);
        // driver.element().type(passInput,"P@ssword");
        driver.element().assertThat(errorMsg).exists().perform();
        driver.element().assertThat(errorMsg).text().contains("The password you've entered is incorrect.").perform();
    }


    @BeforeClass
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver ();
    }


    //After Method
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
