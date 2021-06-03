package serenitylabs.tutorials.vetclinic;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenLookingForAPetStore {

    @Test
    public void should_find_pet_store(){

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\driver\\e\\chromedriver.exe");

        WebDriver chrome = new ChromeDriver();
        chrome.get("https://duckduckgo.com");

        chrome.findElement(By.id("search_form_input_homepage")).sendKeys("pet store");
        chrome.findElement(By.id("search_button_homepage")).click();

        assertThat(chrome.getTitle(),equalTo("pet store at DuckDuckGo"));

        chrome.quit();


    }
}
