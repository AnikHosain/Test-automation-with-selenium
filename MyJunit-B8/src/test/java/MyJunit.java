import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;
    @BeforeAll
    public void setup()
    {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void a_getTitle(){
        driver.get("https://www.dmoney.com.bd/");
        String titleActual =driver.getTitle();
        String titleExpected ="Dmoney";
        Assertions.assertEquals(titleExpected,titleActual);
    }

    @Test
    @DisplayName("Check if image is exists")
    public void b_checkIfImageExists(){
        driver.get("https://www.dmoney.com.bd/");
        boolean status= driver.findElements(By.tagName("img")).get(0).isDisplayed();
        Assertions.assertTrue(status);

    }
    @Test
    @DisplayName("Check if form is submitted properly")
    public void c_automateForm(){
        driver.get("https://wp.dmoney.com.bd:8081/");
        driver.findElement(By.id("mobileNumber")).sendKeys("anik");
        driver.findElement(By.id("pin")).sendKeys("12345678");
        driver.findElement(By.name("submit")).click();

    }
    @Test
    public void d_automaitionClick(){
        driver.get("https://www.dmoney.com.bd/index.html");
        driver.findElements(By.tagName("input")).get(7).isDisplayed();
        driver.findElements(By.tagName("input")).get(5).isDisplayed();
        driver.findElements(By.tagName("a")).get(8).isDisplayed();
    }

    @AfterAll
    public void quitBrowser(){
        driver.quit();
    }
}