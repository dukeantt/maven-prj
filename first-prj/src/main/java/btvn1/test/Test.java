package btvn1.test;

import btvn1.pages.SelectAndAddProduct;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        SelectAndAddProduct selectAndAddProduct = new SelectAndAddProduct(driver);

        selectAndAddProduct.open();
        selectAndAddProduct.selectCategoryAndProduct();
        selectAndAddProduct.selectOptionAndAdd();
        selectAndAddProduct.verify();


    }
}
