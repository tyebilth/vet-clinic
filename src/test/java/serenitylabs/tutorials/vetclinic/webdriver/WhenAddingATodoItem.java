package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Capabilities;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenAddingATodoItem {

    @Test
    public void should_add_new_item_to_list() {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\driver\\e\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://todomvc.com/examples/angularjs/#/");

        WebElement search = driver.findElement(By.xpath("//input[@ng-model='newTodo']"));
        search.sendKeys("Buy some milk");
        search.sendKeys(Keys.ENTER);

        WebElement list = driver.findElement(By.xpath("//label[@ng-dblclick ='editTodo(todo)']"));

        assertThat(list.getText(),containsString("Buy some milk"));
        driver.quit();

           }

}
