package TestComponents;

import org.openqa.selenium.WebDriver;
import stepDefinitions.hooks;
import webstore.pages.*;

import java.io.IOException;

public class TestContextSetup {

    public BaseTest baseTest;
    public PageObjectManager pageObjectManager;

    public TestContextSetup() throws IOException {
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.initializeDriver());

    }



}
