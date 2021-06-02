package shopping;

import browserTesting.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingTest extends BaseClass {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker() throws InterruptedException {
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Sale'])[2]"));
        Thread.sleep(5000);
        verifyExpectedText(By.xpath("//h1[@id='page-title']"), "Sale");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name A - Z')]"));

        Thread.sleep(5000);
        mouseHoverAndClickElement(By.xpath("(//span[text()='Add to cart'])[1]"));
        verifyExpectedText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"),"Product has been added to your cart");
        clickOnElement(By.xpath("//a[@class='close']"));

        Thread.sleep(3000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]/div[3]/div[1]/a[1]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Your shopping cart - 1 item");

        Thread.sleep(3000);
        clearTextAndSendText(By.xpath("//span[@class='quantity-box-container']//input[@type='text']"),"2");

        Thread.sleep(5000);
        verifyExpectedText(By.xpath("(//span[@class='cart-subtotal']//span[@class='surcharge-cell'])[1]"),"$29.98");
        verifyExpectedText(By.xpath("//li[@class='total']//span[@class='surcharge-cell']"),"$36.00");

        Thread.sleep(5000);
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        verifyExpectedText(By.xpath("//h3[contains(text(),'Log in to your account')]"),"Log in to your account");

        Thread.sleep(5000);
        sendTextToElement(By.xpath("//input[@id='email']"),"jalpa23@gmail.com");
        clickOnElement(By.xpath("//tbody/tr[2]/td[1]/button[1]"));

        Thread.sleep(5000);
        verifyExpectedText(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]"),"Secure Checkout");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"),"jalpa");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"),"ganatra");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"),"42 abc");
        Thread.sleep(5000);
        clearTextAndSendText(By.xpath("//input[@id='shippingaddress-city']"),"corby");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"),"England");
        Thread.sleep(3000);
        clearTextAndSendText(By.xpath("//input[@id='shippingaddress-zipcode']"),"nn18 8fw");

        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        sendTextToElement(By.xpath("//input[@id='password']"),"J123abc1");
        mouseHoverAndClickElement(By.xpath("//label[@title='Local shipping']//input[@id='method128']"));

        Thread.sleep(3000);
        mouseHoverAndClickElement(By.xpath("//input[@value='6']"));
        Thread.sleep(2000);
        verifyExpectedText(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/span[2]/span[1]/span[1]"),"$37.03");
        clickOnElement(By.xpath("//span[contains(text(),'Place order:')]"));

        Thread.sleep(3000);
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Thank you for your order");
    }


    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Bestsellers'])[2]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Bestsellers");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name A - Z')]"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("(//span[text()='Add to cart'])[1]"));
        Thread.sleep(3000);
        verifyExpectedText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"),"Product has been added to your cart");
        clickOnElement(By.xpath("//a[@class='close']"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]/div[3]/div[1]/a[1]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Your shopping cart - 1 item");
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        alertAccept();

        Thread.sleep(3000);
        verifyExpectedText(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"),"Item(s) deleted from your cart");
        clickOnElement(By.xpath("//a[@class='close']"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Your cart is empty");
    }

    @After
    public void tearBrowser(){

        closeBrowser();
    }
}
