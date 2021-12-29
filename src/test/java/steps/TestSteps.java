package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import pages.*;
import pages.components.FooterComponents;
import pages.components.HeaderComponents;
import sun.rmi.runtime.Log;

public class TestSteps extends BaseTest {
    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String BROWSER_VERSION = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER_VERSION");
    String WAIT_TIME = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME");


    @Before
    public void setUp() {
        init(BROWSER, BROWSER_VERSION, WAIT_TIME);
    }

    @After
    public void tearDown() {
        takeScreenshot("Fiel."+System.currentTimeMillis());
        quit();
    }


    @Given("I am on Sauce Demo Login page")
    public void iAmOnSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }


    @And("I enter username {string}")
    public void iEnterUsername(String username) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterPassword(password);
    }

    @When("I click Login button")
    public void iClickLoginButton() {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("I should be on Inventory page {string}")
    public void iShouldBeOnInventoryPage(String url) {
        ProductsPage productsPage=new ProductsPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(),url);
        Assert.assertEquals(productsPage.getTextTitleProductsPage(),"PRODUCTS");
    }

    @Then("Check error message {string}")
    public void checkErrorMessage(String errorMsgLoginPage) {
        LoginPage loginPage=new LoginPage(driver);
        Assert.assertEquals(loginPage.getTextErrorMsgLoginPage(),errorMsgLoginPage);
        Assert.assertEquals(loginPage.errorMsgLoginPageDiv.getCssValue("background-color"),"rgba(226, 35, 26, 1)");
    }

    @When("I click button Menu and Item {string}")
    public void iClickButtonMenuAndItem(String item) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickMenuItem(item);
    }

    @Then("Compare actual and expected URL {string}")
    public void compareActualAndExpectedURL(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @And("Add Product to cart by name {string}")
    public void addProductToCartByName(String nameProduct) {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.addProductByName(nameProduct);
    }

    @When("Click to button Cart on header")
    public void clickToButtonCartOnHeader() {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        headerComponents.clickButtonCartHeader();
    }


    @Then("Check Product in cart {string}")
    public void checkProductInCart(String nameProduct) {
        CartPage cartPage=new CartPage(driver);
        Assert.assertEquals(cartPage.getNameProductInCart(nameProduct),nameProduct);
    }

    @Then("Check number Products in Cart {string}")
    public void checkNumberProductsInCart(String numProductCart) {
        HeaderComponents headerComponents=new HeaderComponents(driver);
        Assert.assertEquals(headerComponents.getNumProductCart(),numProductCart);
    }

    @And("Add Product to cart - random number")
    public void addProductToCartRandomNumber() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.addProductRandomNum();
    }

    @And("Click Checkout button")
    public void clickCheckoutButton() {
        CartPage cartPage=new CartPage(driver);
        cartPage.clickCheckoutButtonCartPage();
    }


    @And("I enter First Name {string}")
    public void iEnterFirstName(String firstName) {
        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        checkoutStepsPage.enterFirstName(firstName);
    }

    @And("i enter Last Name {string}")
    public void iEnterLastName(String lastName) {
        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        checkoutStepsPage.enterLastName(lastName);
    }

    @And("I enter ZIP code {string}")
    public void iEnterZIPCode(String zipCode) {
        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        checkoutStepsPage.enterZipCode(zipCode);
    }


    @And("I click Continue button")
    public void iClickContinueButton() {
        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        checkoutStepsPage.clickContinueButton();
    }

    @When("Check product in cart and click Finish button {string}")
    public void checkProductInCartAndClickFinishButton(String nameProduct) {
        CartPage cartPage=new CartPage(driver);
        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        Assert.assertEquals(cartPage.getNameProductInCart(nameProduct),nameProduct);
        checkoutStepsPage.clickFinishButton();
    }

    @Then("I bought Product {string}")
    public void iBoughtProduct(String buyProdMsg) {

        CheckoutStepsPage checkoutStepsPage=new CheckoutStepsPage(driver);
        Assert.assertEquals(checkoutStepsPage.getTextBuyProductMessage(),buyProdMsg);
        Assert.assertTrue(checkoutStepsPage.titleTextBuyProduct.isDisplayed());

    }

    @And("Add Product2 to cart - random number")
    public void addProduct2ToCartRandomNumber() {
        ProductsPage productsPage=new ProductsPage(driver);
        productsPage.addProductRandomNum();
    }
}
