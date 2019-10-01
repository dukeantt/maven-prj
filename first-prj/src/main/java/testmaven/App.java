package testmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("76.0.3809.126").setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //VAO GOOGLE SEARCH AUTOMATION TEST ROI ENTER
//        driver.get("https://www.google.com/");
//        driver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("automation test \n");
//        System.out.println("button: " + driver.findElement(By.xpath("//div[@class=\"FPdoLc VlcLAe\"]//input[@class=\"gNO89b\"]")));

        //TAO ACCOUNT TREN TRANG MAGENTO
//        driver.get("http://magento.hoangq.info/default/bloger/post/");
//        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']/a")).click();
//        driver.findElement(By.xpath("//a[@class='action create primary']/span")).click();
//        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Anh");
//        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Nguyen");
//        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("anhnd2@smartosc.com");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd1234");
//        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Abcd1234");
//        driver.findElement(By.xpath("//button[@class='action submit primary']")).click();

        //SIGN IN VAO ACCOUNT
        driver.get("http://magento.hoangq.info/default/bloger/post/");
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']/a")).click();
        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("anhnd2@smartosc.com");
        driver.findElement(By.xpath("//div[@id='remember-me-box']/preceding-sibling::div[@class=\"field password required\"]//input"))
                .sendKeys("Abcd1234");
        driver.findElement(By.xpath("//button[@class=\"action login primary\"]")).click();

    }
}
