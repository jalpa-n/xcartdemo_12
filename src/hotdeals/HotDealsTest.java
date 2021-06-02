package hotdeals;

import browserTesting.BaseClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HotDealsTest extends BaseClass {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void openBrowser() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        Thread.sleep(5000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Sale'])[2]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Sale");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name A - Z')]"));

        Thread.sleep(3000);
        List <WebElement> productName = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::h5"));
        verifyProductNameSortedAscendingAlphabeticalOrder("(//ul[@class='products-grid grid-list']/descendant::h5)",productName);
    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Sale'])[2]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Sale");
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Price Low - High')]"));

        Thread.sleep(3000);
        List <WebElement> productPrice = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::span[@class='price product-price']"));
        verifyProductSortedAsPerPriceLowToHighFilter("(//ul[@class='products-grid grid-list']/descendant::span[@class='price product-price'])",productPrice);

    }

    @Test
    public void  verifySaleProductsArrangeByRates() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Sale'])[2]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"), "Sale");
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));

        clickOnElement(By.xpath("//a[contains(text(),'Rates')]"));
        List<WebElement> productRating = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::div[contains(text(),'Score')]"));
        verifyProductSortedAsPerRatesFilter("(//ul[@class='products-grid grid-list']/descendant::div[contains(text(),'Score')])",productRating);
    }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Bestsellers'])[2]"));
        Thread.sleep(3000);
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Bestsellers");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name Z - A')]"));

        List <WebElement> productName = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::h5"));
        verifyProductNameSortedDescendingOrder("(//ul[@class='products-grid grid-list']/descendant::h5)",productName);
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Bestsellers'])[2]"));
        Thread.sleep(3000);
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Bestsellers");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Price High - Low')]"));
        List <WebElement> productPrice = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::span[@class='price product-price']"));
        verifyProductSortedAsPerPriceHighToLowFilter("(//ul[@class='products-grid grid-list']/descendant::span[@class='price product-price'])",productPrice);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("(//span[@class='primary-title'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Bestsellers'])[2]"));
        verifyExpectedText(By.xpath("//h1[@id='page-title']"),"Bestsellers");
        mouseHoverToElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Rates ')]"));
        Thread.sleep(3000);
        List <WebElement> productRating = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/descendant::div[contains(text(),'Score')]"));
        verifyProductSortedAsPerRatesFilter("(//ul[@class='products-grid grid-list']/descendant::div[contains(text(),'Score')])",productRating);
    }

    @After
    public void tearBrowser(){

        closeBrowser();
    }
}

