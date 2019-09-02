package com.epam.taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class CreateNewUserPage extends AbstractPage {
    public static final String URL = "http://appellatecmsmssql.demo.int.thomsonreuters.com/ctrack/admin/appuser.do?action=create";

    @FindBy(id ="userNm")
    private WebElement username;

    @FindBy(id ="password")
    private WebElement password;

    @FindBy(id ="firstNm")
    private WebElement firstName;

    @FindBy(id="lastNm")
    private WebElement lastName;

    @FindBy(id="loginPage")
    private  Select loginPage;
    //private  WebElement loginPage;

    //@FindBy(xpath = "//option[contains(text(), 'Main Case Search')]")
    //private WebElement mainCaseSearch;

    public static final By MAIN_CASE_SEARCH_LOCATOR = By.xpath("//option[contains(text(), 'Main Case Search')]");

    @FindBy(name ="submitValue")
    private WebElement saveButton;

    @FindBy(name="courtIDs")
    private  Select courts;//add implementions





    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void createUser() {
        new Actions(driver)
                .sendKeys(username, "testuser")
                .sendKeys(password, "Thomson!0")
                .sendKeys(firstName, "Alena")
                .sendKeys(lastName, "Alakayeva").build().perform();

                loginPage.selectByVisibleText("Main Case Search");
                //
                //waitForElementEnabled(MAIN_CASE_SEARCH_LOCATOR);

                //new Select(driver.findElement(MAIN_CASE_SEARCH_LOCATOR)).selectByVisibleText("Main Case Search");
               // .click((mainCaseSearch)).build().perform();

        List<WebElement> courtsOptions = courts.getOptions();

        ArrayList<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Court of Appeals");
        expectedOptions.add("Supreme Court");
        Actions actions = new Actions(driver);

       for (int i = 0; i <= courtsOptions.size(); i++)
       {
           WebElement optionElement = courtsOptions.get(i);
           String actualOption = optionElement.getText();
           if(expectedOptions.contains(actualOption))
           {
               actions.keyDown(Keys.CONTROL).click(optionElement).keyUp(Keys.CONTROL);
           }
       }

       actions.build().perform();




        //username.sendKeys();
        //saveButton.click();


    }
}
