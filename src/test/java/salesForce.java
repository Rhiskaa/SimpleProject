import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class salesForce {
    private static RemoteWebDriver driver;
    @Test
    public void login() throws IOException, InterruptedException {
        By inpUserName = By.xpath("//input[@aria-label='Login_UserName_TxtField']");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1600,1024");
        final URL remoteAddress = new URL("http://localhost:4444/wd/hub");
        driver = new RemoteWebDriver(remoteAddress, options);
        driver.manage().window().maximize();
        driver.get("https://igbeyewo.allianz.co.id/inspire-regionalization/web/#/login");
        Thread.sleep(10000);//wait for 10 second
        refreshHtml();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(inpUserName));
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(inpUserName));
        //step to click and typing
        driver.findElement(inpUserName).click();
        driver.findElement(inpUserName).sendKeys("00000147");
    }

    public void refreshHtml(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('flt-glass-pane').shadowRoot.querySelector('flt-semantics-placeholder').click({force:true})");
    }

    public void disableTextField(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"input[aria-label='Login_UserName_TxtField']\").disabled = false");
    }
}
