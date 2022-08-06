package pages;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static final SelenideElement homeCategoryTab = $(By.xpath("//div/a[text()='Home']"));
    public static final SelenideElement kidsCategoryTab = $(By.xpath("//div/a[text()='Kids']"));
    public static final SelenideElement DisneyStoreBrand = $(By.xpath("//h5[text()='Disney store']"));

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());
}
