package testmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


/*
http://magento.hoangq.info/default/bloger/post/
 btvn: vao mot category -> add compare -> verify list dung 2 sp da add -> remove all -> verify da xoa
 */
public class BTVN2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://magento.hoangq.info/default/bloger/post/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int isPresent = driver.findElements(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/a")).size();
        WebElement menCategory;
        WebElement topCategory;
        WebElement hoodieCategory;
        if (isPresent > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/a")));
            menCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/a"));
            topCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/ul/li[@class=\"level1 nav-3-1 category-item first parent ui-menu-item\"]/a"));
            hoodieCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/ul/li[@class=\"level1 nav-3-1 category-item first parent ui-menu-item\"]//li[@class=\"level2 nav-3-1-2 category-item ui-menu-item\"]/a"));
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"level0 nav-3 category-item has-active level-top parent ui-menu-item\"]/a")));
            menCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item has-active level-top parent ui-menu-item\"]/a"));
            topCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item has-active level-top parent ui-menu-item\"]//a[@id=\"ui-id-24\"]"));
            hoodieCategory = driver.findElement(By.xpath("//li[@class=\"level0 nav-3 category-item has-active level-top parent ui-menu-item\"]//a[@id=\"ui-id-27\"]"));
        }

        wait.until(ExpectedConditions.elementToBeClickable(menCategory));
        Actions action = new Actions(driver);
        action.moveToElement(menCategory).perform();
        wait.until(ExpectedConditions.elementToBeClickable(topCategory));
        action.moveToElement(topCategory).perform();
        hoodieCategory.click();

        //add products
        List<String> productArray = new ArrayList<String>();
        WebElement firstProd = driver.findElement(By.xpath("//li[@class=\"item product product-item\"][1]//div[@class=\"product-item-inner\"]//a[@class=\"action tocompare\"]"));
        firstProd.click();
        WebElement secondProd = driver.findElement(By.xpath("//li[@class=\"item product product-item\"][3]//div[@class=\"product-item-inner\"]//a[@class=\"action tocompare\"]"));
        secondProd.click();

        //add products to arraylist
        productArray.add(driver.findElement(By.xpath("//li[@class=\"item product product-item\"][1]//a[@class=\"product-item-link\"]")).getText());
        productArray.add(driver.findElement(By.xpath("//li[@class=\"item product product-item\"][3]//a[@class=\"product-item-link\"]")).getText());
        Thread.sleep(2000);
        List<WebElement> compareProducts = new ArrayList<WebElement>();
        try {
            compareProducts = driver.findElements(By.xpath("//ol[@id=\"compare-items\"]//strong[@class=\"product-item-name\"]/*"));
        } catch (Exception e) {
            System.out.println("error");
        }
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        int isVerified = 0;
        for (int i = 1; i <= compareProducts.size(); i++) {
            wait2.until(ExpectedConditions.visibilityOf(compareProducts.get(i - 1)));
            if (!productArray.contains(compareProducts.get(i - 1).getText())) {
                System.out.println("Product not correct");
                isVerified = 0;
                break;
            } else {
                isVerified = 1;
            }
        }
        if (isVerified == 1) {
            driver.findElement(By.xpath("//a[@id=\"compare-clear-all\"]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(("//button[@class=\"action-primary action-accept\"]")))));
            driver.findElement(By.xpath("//button[@class=\"action-primary action-accept\"]")).click();
        }
        int isEmpty = driver.findElements(By.xpath("//div[@class=\"block block-compare\"]/div[@class=\"empty\"]")).size();
        if (isEmpty > 0) {
            System.out.println("Compare list clear");
        } else {
            System.out.println("Remove failed");
        }
    }
}
