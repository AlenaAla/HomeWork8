package com.epam.taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


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
    private  WebElement loginPage;

    //@FindBy(xpath = "//option[contains(text(), 'Main Case Search')]")
    //private WebElement mainCaseSearch;

    public static final By MAIN_CASE_SEARCH_LOCATOR = By.xpath("//option[contains(text(), 'Main Case Search')]");

    @FindBy(name ="submitValue")
    private WebElement saveButton;



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

                loginPage.click();
                waitForElementEnabled(MAIN_CASE_SEARCH_LOCATOR);
                new Select(driver.findElement(MAIN_CASE_SEARCH_LOCATOR)).selectByVisibleText("Main Case Search");
               // .click((mainCaseSearch)).build().perform();

        //username.sendKeys();
        //saveButton.click();
    }
}
