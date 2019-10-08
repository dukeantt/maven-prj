package testmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
btvn: click 1 sp -> add to cart ->verify so 1 hien len o minicart (su dung ham get text) -> click vao minicart -> verify dung ten sp da add to cart
 */
public class BTVN1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.get("http://magento.hoangq.info/default/bloger/post/");
//        driver.findElement(By.xpath("//a[@id=\"ui-id-5\"]/span[@class=\"ui-menu-icon ui-icon ui-icon-carat-1-e\"]")).click();
//        driver.findElement(By.xpath("//a[@id=\"ui-id-5\"]")).click();
        //chon sp
        driver.get("http://magento.hoangq.info/default/men.html");
        driver.findElement(By.xpath("//ol[@class=\"product-items widget-product-grid\"]/li[3]//a[@class=\"product-item-photo\"]")).click();
        //chon options va add to cart
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"option-label-size-145-item-168\"]"))).click();
        driver.findElement(By.xpath("//div[@id=\"option-label-color-93-item-52\"]")).click();
        driver.findElement(By.xpath("//button[@id=\"product-addtocart-button\"]")).click();
        //verify
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"counter-number\"]")));
        WebElement countNumberElement = driver.findElement(By.xpath("//span[@class=\"counter-number\"]"));
        String countNumber = countNumberElement.getText();
        if (countNumber.equals("1")) {
            String productName = driver.findElement(By.xpath("//span[@data-ui-id=\"page-title-wrapper\"]")).getText();
            countNumberElement.click();
            String productNameMinicart = driver.findElement(By.xpath("//div[@class=\"product-item-details\"]/strong[@class=\"product-item-name\"]/a")).getText();
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
