package tests;

import com.codeborne.selenide.Condition;
import config.BaseTestConfiguration;
import io.qameta.allure.Flaky;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class End2EndTests extends BaseTestConfiguration {

    @Rule
    public RetryRule retry = new RetryRule(3);

    @DisplayName("Add random items to the cart > Delete items > Verify")
    @Flaky
    @Test
    public void testAddItemsToCart() {
        //Test data
        String expectedNumberOfItems = "2";
        String totalPriceAfterAllRemoval = "KWD 0.000";
        String expectedPageUrl = "https://www.tamanna.com/kids/overview";

        HomePage.homeCategoryTab.shouldBe(Condition.visible).click();
        HomeOfferPage.viewAllBrandBtn.shouldBe(Condition.visible).click();
        HomeOfferPage.acquadiParmaBtn.shouldBe(Condition.visible).click();

        sleep(2000);
        GlobalPage.clickOnRandomElementInCollection(HomeOfferPage.homeOfferList);

//      Verify that product page is visible
        Assertions.assertTrue(HomeOfferPage.productPage
                .shouldBe(Condition.visible)
                .isDisplayed(), "Product page wasn't loaded");

        double firstItemPrice = GlobalPage.getPrice(GlobalPage.price);

        //Add to cart
        HomeOfferPage.addToCartBtn.click();
        sleep(2000);

        //Verify that one item was added to the cart
        String cartQtyFirstItem = GlobalPage.cartItemQty.shouldBe(Condition.text("1")).getText();
        Assertions.assertEquals("1", cartQtyFirstItem, "Items was not added to the cart");

//      Press Later button from pop-up
        GlobalPage.getModalLaterBnt.click();

        //Navigate to Kids category
        HomePage.kidsCategoryTab.shouldBe(Condition.visible).click();
        HomePage.DisneyStoreBrand.shouldBe(Condition.visible).click();

        sleep(2000);
        GlobalPage.clickOnRandomElementInCollection(GlobalPage.offerList);

        double secondItemPrice = GlobalPage.getPrice(GlobalPage.price);
        GlobalPage.addToCartBtn.click();
        sleep(2000);
        //Verify that one item was added to the cart
        String cartQtySecondItem = GlobalPage.cartItemQty.shouldBe(Condition.text(expectedNumberOfItems)).getText();

        //Validation
        Assertions.assertEquals(expectedNumberOfItems, cartQtySecondItem, "Number of Items is Incorrect");

        /**
         *Navigate to the order summary page/screen (Go to the shopping bag) and then create validations
         * for the total price and quantity of items.
         */

        double expectedTotalPriceTemp = firstItemPrice + secondItemPrice;
        //Reformat price, in case we have not rounded prices during maven test run (like: 35,24899999999):
        double expectedTotalPrice = Double.parseDouble(String.format("%.3f", expectedTotalPriceTemp));

        ShoppingBag.shoppingBarBtn.shouldBe(Condition.visible).click();
        double actualTotalPrice = GlobalPage.getPrice(ShoppingBag.totalPrice);

        //Validation of total prices
        sleep(2000);
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice, "Failed to validate total price");
        Assertions.assertTrue(ShoppingBag.shoppingBagItemsQty.getText().contains(expectedNumberOfItems),
                "Expected and Actual Total Prices are Not Equal");

        /**
         *Now remove the items from the cart and validate that the total price is zero.
         */
        GlobalPage.clickOnEveryElementInCollection(ShoppingBag.removeItemsBtn);
        sleep(2000);
        Assertions.assertTrue(ShoppingBag.totalPrice.getText().contains(totalPriceAfterAllRemoval),
                "Total price is not zero");

        /**
         * Finally, navigate back to the home/screen page and validate that you are there.
         */
        GlobalPage.clickOutside();
        GlobalPage.logo.shouldBe(Condition.visible).click();
        sleep(2000);
        String actualPageUrl = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(expectedPageUrl, actualPageUrl,"Failed to navigate to home page");
    }
}
