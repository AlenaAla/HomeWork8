package com.epam.taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='header-username']")
    private WebElement fullUserNameLabel;

    //@FindBy(xpath = "//div[@class='menu-header-item ui-state-default']/a[contains(text(),'Administrative')]")
    @FindBy (xpath = "//a[@href='/ctrack/menu.do?menuHeaderID=4']")
    private WebElement administrativeTopMenu;

    //@FindBy(xpath = "//div[@class='menu-header-dropdown menu-selected']/a[contains(text(),'Entity Management')]")
    //@FindBy (xpath = "//a[@href='/ctrack/actor/menu.jsp?action=readonly'][@class='first-menu'])")
    //private WebElement EntityManagementMenuUnderTopMenu;
    //private static final By ENTITY_MANAGEMENT_ITEM = By.xpath("//a[@href='/ctrack/actor/menu.jsp?action=readonly'][@class='first-menu'])");
    private static final By ENTITY_MANAGEMENT_ITEM = By.xpath("//a[@href='/ctrack/admin/menuUserAdmin.jsp?action=readonly'][@onclick='menuHeaderClose();']");
    // href="/ctrack/admin/menuUserAdmin.jsp?action=readonly
    //private static final By ENTITY_MANAGEMENT_ITEM = By.xpath("//div[@class='menu-header-dropdown menu-selected']/a[contains(text(),'Entity Management')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoggedInUserName() {
        return fullUserNameLabel.getText();
    }

    public void openEntityManagementViaTopMenu() {
        //administrativeTopMenu.click();

        //new Actions(driver).click(administrativeTopMenu).build().perform();
        new Actions(driver).moveToElement(administrativeTopMenu).click(driver.findElement(ENTITY_MANAGEMENT_ITEM)).build().perform();

        //waitForElementVisible(ENTITY_MANAGEMENT_ITEM);

        //new Actions(driver).moveToElement(driver.findElement(ENTITY_MANAGEMENT_ITEM)).build().perform();
        //new Actions(driver).moveToElement(administrativeTopMenu).click(EntityManagementMenuUnderTopMenu).build().perform();

          }


    }



