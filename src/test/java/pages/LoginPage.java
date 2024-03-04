package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonHelpers;
public class LoginPage {
    AndroidDriver driver;
    CommonHelpers commonHelpers;
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonHelpers = new CommonHelpers(driver);
        commonHelpers.waitElementExistence(loginModal);
    }
    @AndroidFindBy(accessibility = "test-Login")
    private WebElement loginModal;

    @AndroidFindBy(accessibility = "test-Username")
    private WebElement Username;

    @AndroidFindBy(accessibility = "test-Password")
    private WebElement Password;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement LoginButton;

    @AndroidFindBy(accessibility = "test-PRODUCTS")
    private WebElement ProductsPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private WebElement LoginErrorMessage;

    public boolean isLoginPageExists(){
        return loginModal.isDisplayed();
    }

    public void inputUserCredentials(String username, String password){
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginButton.click();
    }

    public boolean isProductsPageExists(){
        commonHelpers.waitElementExistence(ProductsPage);
        return ProductsPage.isDisplayed();
    }
    public String getLoginErrorMessage(){
        commonHelpers.waitElementExistence(LoginErrorMessage);
        return LoginErrorMessage.getText();
    }
}
