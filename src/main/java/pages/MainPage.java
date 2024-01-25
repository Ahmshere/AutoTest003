package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import settings.BasePage;

import java.util.LinkedList;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@id='query']")
    WebElement searchField;
    @FindBy(xpath = "//input[@id='location_str']")
    WebElement locationField;

    public MainPage(WebDriver driver){
        setDriver(driver);
        driver.get("https://startup.jobs");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

//****************************************Fields and methods********************************************

public MainPage searchItem(String item){
        searchField.sendKeys(item);
    System.out.println("*** ATTRIBUTE : "+searchField.getAttribute("class"));
        return this;
}
public  MainPage locationItem(String location){
        locationField.sendKeys(location);
        return this;
}

public int locationCount(){

    List<WebElement> result =
            driver.findElements(By.xpath("//div[@class='content']//div[@data-post-template-target='location']"));
    for (WebElement e : result) {
        System.out.println("ELEMENT : "+e.getText());

    }
        return result.size();
}
}
