package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomeOfferPage {
    public static final SelenideElement viewAllBrandBtn = $(By.xpath("//button[text()='View All Brands A-Z']"));
    public static final SelenideElement acquadiParmaBtn = $(By.xpath("//a[text()='Acqua di Parma']"));
    public static final ElementsCollection homeOfferList = $$(By.xpath("//img[contains(@class,'product-image')]"));
    public static final SelenideElement addToCartBtn = $(By.xpath("//button[@class='sc-hGPBjI jGEyxU']"));
    public static final SelenideElement productPage = $(By.xpath("//div[@class='sc-gKclnd bBEaVQ']"));

    private static final Logger log = LogManager.getLogger(HomeOfferPage.class.getName());
}
