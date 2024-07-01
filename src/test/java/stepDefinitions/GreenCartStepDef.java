package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class GreenCartStepDef {

    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\DRV\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        String browser = System.getProperty("browser", "chrome"); // Default to Chrome if no system property is set
//        driver = WebDriverSetup.getDriver(browser);
//        driver.manage().window().maximize();
//        driver.manage().timeouts();

    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page(){
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and extract the actual name of product")
    public void user_searched_with_shortname_and_extract_the_actual_name_of_product(String shortName) throws InterruptedException {


        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
//        Thread.sleep(3000);
        searchBox.sendKeys(shortName);
        landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
//        Thread.sleep(3000);
        System.out.println(landingPageProductName + " is extructed fom Home page");
        // Add code to extract the actual name of the product
    }

    @Then("user searched for the shortname {string} in offers to check product exist")
    public void user_searched_for_the_shortname_in_offers_to_check_product_exist(String shortName) throws InterruptedException {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
//        Thread.sleep(3000);
        offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }


    @Then("prodname in Offrer Page have to mathces with prodname Landing Page")
    public void prodname_in_offrer_page_have_to_mathces_with_prodname_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    // Tear down method to close WebDriver
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
