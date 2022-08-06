# TamannaRun End2End test

# Approach to maven project: Page Object + Selenide + JUnit 5 + Allure + Log4j2

End2End flow:
- As a guest user add two items from different categories (Women, Men, Kids, Beauty, Home, or
Harvey Nichols) to the cart

- Navigate to the order summary page/screen (Go to the shopping bag) and then create validations
for the total price and quantity of items.

- Now remove the items from the cart and validate that the total price is zero.

- Finally, navigate back to the home/screen page and validate that you are there.


# Run description:

1. Clone public project to your PC
2. Run test locally
