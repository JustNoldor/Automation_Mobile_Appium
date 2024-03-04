package stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.AppiumDriverFactory;
import utils.DataProperty;
import java.net.MalformedURLException;

public class LoginStepDef {
    LoginPage loginPage;
    DataProperty dataProperty;
    private AndroidDriver driver;
    public LoginStepDef() throws MalformedURLException {
        this.driver = AppiumDriverFactory.getDriver();
        loginPage =  new LoginPage(driver);
        dataProperty = new DataProperty();
    }

    @Given("I am on the Login Page")
    public void iGoToTheLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageExists());
    }

    @When("I log in with standard user credentials")
    public void iLogInWithStandardUserCredentials() {
        loginPage.inputUserCredentials(dataProperty.getStandardUsername(),dataProperty.getStandardPassword());
    }

    @Then("I should be in the products list page")
    public void iShouldBeInTheProductsListPage() {
        Assert.assertTrue(loginPage.isProductsPageExists());
    }

    @When("I log in with lockedout user credentials")
    public void iLogInWithLockedoutUserCredentials() {
        loginPage.inputUserCredentials(dataProperty.getLockedoutUsername(), dataProperty.getLockedoutPassword());
    }

    @Then("I should see lockedout error message")
    public void iShouldSeeLockedoutErrorMessage() {
        Assert.assertEquals(dataProperty.getLockedoutUserErrorMessage(),loginPage.getLoginErrorMessage());
    }
}
