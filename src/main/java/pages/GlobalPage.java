package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.RandomDataGeneration;

import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GlobalPage {
    public static final SelenideElement addToCartBtn = $(By.xpath("//button[@class='sc-hGPBjI jGEyxU']"));
    public static final SelenideElement cartItemQty = $(By.xpath("//span[@class='genie--c-cHhEfr']"));
    public static final SelenideElement price = $(By.xpath("//div[contains(@class,'sc-gsDKAQ sc-dkPtRN bpEzvx ikczMY')]/p[contains(@class,'sc-hBUSln hTMRaK')]"));
    public static final SelenideElement getModalLaterBnt = $(By.xpath("//button[text()='Later']"));
    public static final SelenideElement logo = $(By.xpath("//*[contains(@width, '190px')][1]"));
    public static final ElementsCollection offerList = $$(By.xpath("//img[contains(@class,'product-image')]"));
    private static final Logger log = LogManager.getLogger(GlobalPage.class.getName());

    /**
     * Method is used to click on random element in a list of elements
     * @param elements - list of elements
     */

    @Step("Click on random element in the list")
    public static void clickOnRandomElementInCollection(ElementsCollection elements) {
        RandomDataGeneration dataGeneration = new RandomDataGeneration();
        int randomElement = dataGeneration.randomInt(elements.size()+1);
        elements.get(randomElement).click();
        log.log(Level.INFO, "clickOnRandomElementInCollection method");
    }

    /**
     * Method is used to click on the first element in a list of elements
     * @param elements - list of elements
     */

    @Step("Click on first element in the list")
    public static void clickOnFirstElementInCollection(ElementsCollection elements) {
        for (int i = 0; i < elements.size(); i++) {
            elements.get(0).click();
        }
        log.log(Level.INFO, "clickOnFirstElementInCollection method");
    }

    /**
     * Method is used to click on every element in a list of elements
     * @param elements - list of elements
     */

    @Step("Click on every element in the list")
    public static void clickOnEveryElementInCollection(ElementsCollection elements) {
        for (SelenideElement element : elements) {
            element.click();
        }
        log.log(Level.INFO, "clickOnEveryElementInCollection method");
    }

    /**
     * Method is used to perform action on Alert pop up:
     * if true - Accept click
     * if false - Dismiss click
     */

    @Step("Alert")
    public static void alertAcceptOrDismiss(Boolean isAccept) {
        if (isAccept ) {
            WebDriverRunner.driver().switchTo().alert(Duration.ofSeconds(5)).accept();
        } else {
            WebDriverRunner.driver().switchTo().alert(Duration.ofSeconds(5)).dismiss();
        }
        log.log(Level.INFO, "alertAcceptOrDismiss method");
    }

    /**
     * Method is used to extract price value
     * @param selenideElement - field with price
     */

    @Step("Extract price")
    public static double getPrice(SelenideElement selenideElement) {
        log.log(Level.INFO, "getPrice method");
        return Double.parseDouble(selenideElement.shouldBe(Condition.visible)
                .getText().replace("KWD ", ""));
    }

    public static void clickOutside() {
        Actions action = new Actions(getWebDriver());
        action.moveByOffset(0, 0).click().build().perform();
        log.log(Level.INFO, "clickOutside method");
    }
}



