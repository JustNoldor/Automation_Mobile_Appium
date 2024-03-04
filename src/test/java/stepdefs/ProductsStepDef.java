package stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;
import utils.AppiumDriverFactory;
import java.net.MalformedURLException;

public class ProductsStepDef {
    ProductsPage productsPage;
    private AndroidDriver driver;
    public ProductsStepDef() throws MalformedURLException, InterruptedException {
        this.driver = AppiumDriverFactory.getDriver();
        productsPage = new ProductsPage(driver);
    }

    @Given("I go to the Products Page")
    public void iGoToTheProductsPage(){
        Assert.assertTrue(productsPage.isProductsPageExists());
    }

    @When("I add an item to the cart using a button")
    public void iAddAnItemToTheCartUsingAButton(){
        // add item with button
        productsPage.addToCart();
    }

    @When("I add an item to the cart by dragging")
    public void iAddAnItemToTheCartByDragging() {
        //add item with gesture
        productsPage.addToCartWithDrag();
    }

    @Then("I should see cart value increased")
    public void iShouldSeeCartValueIncreased(){
        // assert basket cart increased
        Assert.assertEquals("2",productsPage.getBasketCount());
    }

}
