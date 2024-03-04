package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonHelpers;

public class ProductsPage {

    AndroidDriver driver;
    CommonHelpers commonHelpers;
    public ProductsPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        commonHelpers = new CommonHelpers(driver);
        commonHelpers.waitElementExistence(ProductsPage);
    }

    @AndroidFindBy(id = "com.swaglabsmobileapp:id/action_bar_root")
    WebElement ProductsPage;
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    WebElement item;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"]")
    WebElement itemForDrag;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement basketCount;


    public boolean isProductsPageExists(){
        commonHelpers.waitElementExistence(ProductsPage);
        return ProductsPage.isDisplayed();
    }

    public void addToCart(){
        commonHelpers.waitElementExistence(item);
        item.click();
    }

    public void addToCartWithDrag(){
        commonHelpers.waitElementExistence(itemForDrag);
        commonHelpers.dragElement(itemForDrag,720,420);
    }
    public String getBasketCount(){
        commonHelpers.waitElementExistence(basketCount);
        return basketCount.getText();
    }


}
