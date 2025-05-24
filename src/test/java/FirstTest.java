import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FirstTest extends BaseTest {

    @Test
    public void zipCode3DigitsCheck() {
        //1.открыть браузер
        //2.зайти на сайт
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("123");
        browser.findElement(By.xpath("//*[@value = 'Continue']")).click();
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void zipCode5DigitsCheck() {
        //1.открыть браузер
        //2.зайти на сайт
        browser.get("https://sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//*[@name='zip_code']")).sendKeys("12345");
        browser.findElement(By.xpath("//*[@value = 'Continue']")).click();
        boolean regBtnIsPresent = browser.findElement(By.xpath("//*[@name ='password1' ]")).isDisplayed();
        assertTrue(regBtnIsPresent);
    }

}
