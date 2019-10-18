package btvn1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectAndAddProduct {
    WebDriver driver;
    String URL = "http://magento.hoangq.info/default/bloger/post/";
    String menCategoryXpath = "//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/a";
    String productXpath = "//ol[@class=\"product-items widget-product-grid\"]/li[3]//a[@class=\"product-item-photo\"]";
    String optionXpath1 = "//div[@id=\"option-label-size-145-item-168\"]";
    String optionXpath2 = "//div[@id=\"option-label-color-93-item-52\"]";
    String addToCartXpath = "//button[@id=\"product-addtocart-button\"]";
    String countNumberXpath = "//span[@class=\"counter-number\"]";
    String productNameXpath = "//span[@data-ui-id=\"page-title-wrapper\"]";
    String productNameMinicartXpath = "//div[@class=\"product-item-details\"]/strong[@class=\"product-item-name\"]/a";
    String loadingMaskXpath = "//div[@class=\"loading-mask\"]";

    public SelectAndAddProduct(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get(URL);
    }

    public void selectCategoryAndProduct() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.menCategoryXpath)));
        this.driver.findElement(By.xpath(this.menCategoryXpath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.productXpath)));
        this.driver.findElement(By.xpath(this.productXpath)).click();
    }

    public void selectOptionAndAdd() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath1))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath2))).click();
        this.driver.findElement(By.xpath(addToCartXpath)).click();
    }

    public void verify() {
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadingMaskXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(countNumberXpath)));
        WebElement countNumberElement = this.driver.findElement(By.xpath(countNumberXpath));
        String countNumber = countNumberElement.getText();
        if (countNumber.equals("1")) {
            String productName = this.driver.findElement(By.xpath(productNameXpath)).getText();
            countNumberElement.click();
            String productNameMinicart = this.driver.findElement(By.xpath(productNameMinicartXpath)).getText();
            if (productName.equals(productNameMinicart)) {
                System.out.println("Verified");
            } else {
                System.out.println("Product name: " + productNameMinicart);
                System.out.println("Error: Product in minicart is incorrect");
            }
        } else {
            System.out.println("Count number: " + countNumber);
            System.out.println("Error: Number of products in minicart is incorrect");
        }
    }
}
