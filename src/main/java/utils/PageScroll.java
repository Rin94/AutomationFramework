package utils;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageScroll {

    private PageScroll()
    {
        throw new IllegalStateException("Utility class");
    }

    public static void scrollToElement(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollTillElementDisplay(WebElement element, WebDriver driver)
    {
        boolean scrollRequired = true;

        while (scrollRequired) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,300)");

            Boolean ifexist = element.isDisplayed();
            if (Boolean.TRUE.equals(ifexist)) {
                scrollRequired = false;
            }
        }
    }

    public static void scrollToBottomOfThePage(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public static void scrollToTopOfThePage(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public static void scroll(String value, WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        switch (value.toLowerCase()) {

            case "top":

                js.executeScript("window.scrollTo(0, 0)");
                break;

            case "bottom":

                js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
                break;

            default:

                js.executeScript("window.scrollTo(0, 0)");

        }

    }





}
