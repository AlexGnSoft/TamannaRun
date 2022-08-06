package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingBag {
    public static final SelenideElement shoppingBarBtn = $(By.xpath("//button[@aria-label='ShoppingBag']"));
    public static final SelenideElement totalPrice = $(By.xpath("//*[contains(@class,'sc-hBUSln gJZphy') and contains(text(),'KWD')]"));
    public static final SelenideElement shoppingBagItemsQty = $(By.xpath("//*[contains(@class,'sc-hBUSln fMmpST') and contains(text(),'item')]"));
    public static final ElementsCollection removeItemsBtn = $$(By.xpath("//button[@aria-label='Delete']"));

    private static final Logger log = LogManager.getLogger(ShoppingBag.class.getName());
}
