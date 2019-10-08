package testmaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().version("76.0.3809.126").setup();
        WebDriverManager.chromedriver().version("77.0.3865.40").setup();
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
//        driver.get("http://magento.hoangq.info/default/bloger/post/");
//        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='authorization-link']/a")).click();
//        driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("anhnd2@smartosc.com");
//        driver.findElement(By.xpath("//div[@id='remember-me-box']/preceding-sibling::div[@class=\"field password required\"]//input"))
//                .sendKeys("Abcd1234");
//        driver.findElement(By.xpath("//button[@class=\"action login primary\"]")).click();



        // BUOI THU 4
        /*
        driver.get("https://www.toolsqa.com/automation-practice-form/");
        WebDriverWait waitCookies = new WebDriverWait(driver, 5);
        waitCookies.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-cli_action=\"accept\"]"))).click();
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Anh");
        driver.findElement(By.xpath("//input[@id=\"lastname\"]")).sendKeys("Nguyen");
        driver.findElement(By.xpath("//input[@id=\"sex-0\"]")).click();
        WebDriverWait waitYearsOfExp = new WebDriverWait(driver, 10);
        waitYearsOfExp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"exp-6\"]")));
        driver.findElement(By.xpath("//input[@id=\"exp-6\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("4/10/2019");
        driver.findElement(By.xpath("//input[@id=\"profession-1\"]")).click();
        driver.findElement(By.xpath("//input[@class=\"input-file\"]")).sendKeys("/home/ducanh/Pictures/Wallpapers/holH6MG.jpg");
        driver.findElement(By.xpath("//input[@id=\"tool-2\"]")).click();
        Select continents = new Select(driver.findElement(By.xpath("//select[@id=\"continents\"]")));
        continents.selectByVisibleText("Europe");
        Select continentsMultiple = new Select(driver.findElement(By.xpath("//select[@id=\"continentsmultiple\"]")));
        continentsMultiple.selectByVisibleText("Asia");
        continentsMultiple.selectByVisibleText("North America");
        Select seleniumCommands = new Select(driver.findElement(By.xpath("//select[@id=\"selenium_commands\"]")));
        seleniumCommands.selectByVisibleText("WebElement Commands");
        seleniumCommands.selectByVisibleText("Navigation Commands");
        WebDriverWait waitButton = new WebDriverWait(driver, 5);
        waitButton.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"submit1\"]")));
        WebElement beveragesUl = driver.findElement(By.xpath("//ul[@id=\"beverages\"]"));
        List<WebElement> beveragesList = beveragesUl.findElements(By.tagName("li"));
        for (WebElement li : beveragesList) {
            if (li.getText().equals("Milk")) {
                li.click();
            }
        }
        */
        // IFRAME
        driver.get("https://www.toolsqa.com/iframe-practice-page/");
        WebDriverWait waitCookies = new WebDriverWait(driver, 20);
        waitCookies.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-cli_action=\"accept\"]"))).click();
        WebElement firstIf = driver.findElement(By.xpath("//iframe[@id=\"IF1\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstIf);

        WebDriverWait waitFirstIf = new WebDriverWait(driver, 50);
        waitFirstIf.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id=\"IF1\"]")));
        waitFirstIf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstIf));
        Thread.sleep(5000);
        try {
            driver.switchTo().frame(firstIf);
        }catch (Exception e){
            System.out.println(driver.getPageSource());
        }
        driver.findElement
                (By.xpath("//header[@class=\"header-bar\"]//ul[@class=\"sub-nav level-arrows-on\"]/li[@class=\"menu-item menu-item-type-post_type menu-item-object-page menu-item-27307\"]/a")).click();
        driver.findElement(By.xpath("//li[@class=\"menu-item menu-item-type-post_type menu-item-object-post menu-item-35868\"]")).click();

    }
}
