package testmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class BTVN3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://magento.hoangq.info/default/");
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        int isPresent = driver.findElements(By.xpath("//li[@class=\"level0 nav-5 category-item level-top parent ui-menu-item\"]/a")).size();
        if (isPresent > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"level0 nav-3 category-item level-top parent ui-menu-item\"]/a")));
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"level0 nav-5 category-item level-top parent ui-menu-item\"]/a")));
        WebElement training = driver.findElement(By.xpath("//li[@class=\"level0 nav-5 category-item level-top parent ui-menu-item\"]/a"));
        actions.moveToElement(training).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class=\"level1 nav-5-1 category-item first last ui-menu-item\"]/a")));
        driver.findElement(By.xpath("//li[@class=\"level1 nav-5-1 category-item first last ui-menu-item\"]/a")).click();

        Select sortBy = new Select(driver.findElement(By.xpath("//div[@class=\"products wrapper list products-list\"]/preceding-sibling::div[@class=\"toolbar toolbar-products\"]//select[@id=\"sorter\"]")));
        sortBy.selectByVisibleText("Price");

        WebElement directionSwitcher = driver.findElement(By.xpath("//div[@class=\"products wrapper list products-list\"]/preceding-sibling::div[@class=\"toolbar toolbar-products\"]//a[@data-role=\"direction-switcher\"]"));
        String sortOption = directionSwitcher.getAttribute("data-value");
        if (sortOption.equals("desc")) {
            ArrayList<Float> priceAmountArray = new ArrayList<Float>();
            List<WebElement> productsPrice = driver.findElements(By.xpath("//div[@class=\"product details product-item-details\"]"));
            for (int i = 0; i < productsPrice.size(); i++) {
                String priceAmountString = productsPrice.get(i).findElements(By.xpath("//span[@data-price-type=\"finalPrice\"]")).get(i).getAttribute("data-price-amount");
                float priceAmount = Float.parseFloat(priceAmountString);
                priceAmountArray.add(priceAmount);
                if (priceAmountArray.size() > 1) {
                    if (priceAmountArray.get(i - 1) > priceAmountArray.get(i)) {
                        System.out.println("Error: " + productsPrice.get(i).findElements(By.xpath("//a[@class=\"product-item-link\"]")).get(i).getText());
                    }
                }
            }
        }
    }
}
