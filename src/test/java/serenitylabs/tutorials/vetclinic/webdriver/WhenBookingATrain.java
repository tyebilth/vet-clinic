package serenitylabs.tutorials.vetclinic.webdriver;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class WhenBookingATrain {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\driver\\e\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
        driver.manage().window().maximize();

    }

    @Test
    public void should_be_able_to_plan_a_trip() {
        driver.findElement(By.id("tniFromTripLocation")).sendKeys("Town Hall");
        driver.findElement(By.id("tniToTripLocation")).sendKeys("Parramatta");

        driver.findElement(By.xpath("//*[contains(text(),'More options')]")).click();
        driver.findElement(By.cssSelector("#time-tab")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Arriving')]")).click();

       new Select(driver.findElement(By.cssSelector("#search-select-date"))).selectByIndex(1);

        Select hour = new Select(driver.findElement(By.cssSelector("#search-select-hour")));
        hour.selectByVisibleText("10");

        Select minute = new Select(driver.findElement(By.cssSelector("#search-select-minute")));
        minute.selectByVisibleText("15");

        WebElement applyBtn = driver.findElement(By.xpath("//*[@id='time-tab-panel']//button[contains(text(),'Apply')]"));
        applyBtn.click();

        String arrivalDetails = driver.findElement(By.xpath("//*[@id='time-tab']//span[@class='tab-title']")).getText();
        assertThat(arrivalDetails,containsString("Arr 10:15, tomorrow"));

        List<String> items= Stream.of(arrivalDetails.split("[,|\\s*]"))
                .map(String::trim)
                .collect(toList());

        String tripType = items.get(0);
        String arrivalTime = items.get(1);
        String arrivalDay = items.get(2);


        assertThat(tripType,equalTo("Arr"));
        assertThat(arrivalTime,equalTo("10:15"));
        assertThat(arrivalDay,equalTo("tomorrow"));

//        List<WebElement> tripOptions = driver.findElements(By.cssSelector(".journeyValue"));
//
//        String arriveOrDepart = new Select(driver.findElement(By.id("SelectArriveDepart"))).getFirstSelectedOption().getText();
//        String displayedOrigin = driver.findElement(By.id("name_origin")).getAttribute("value");
//        String displayedDestination = driver.findElement(By.id("name_destination")).getAttribute("value");
//        String arrivalDay = new Select(driver.findElement(By.id("itdDateDayMonthYear"))).getFirstSelectedOption().getText();
//        String arrivalHour = new Select(driver.findElement(By.id("selectHour"))).getFirstSelectedOption().getText();
//        String arrivalMinute = new Select(driver.findElement(By.id("selectMinute"))).getFirstSelectedOption().getText();
//
//        assertThat(tripOptions.size(), is(greaterThan(0)));
//
//        assertThat(arriveOrDepart, equalTo("arrive before"));
//        assertThat(displayedOrigin, containsString("Town Hall"));
//        assertThat(displayedDestination, containsString("Parramatta"));
//        assertThat(arriveOrDepart, equalTo("arrive before"));
//        assertThat(arrivalDay, containsString("Tomorrow"));
//        assertThat(arrivalHour, equalTo("10"));
//        assertThat(arrivalMinute, equalTo("15"));
    }


    @After
    public void shutdown() {
        driver.quit();
    }
}
