# Alza test framework in Selenium with Java. Using page object model.

## Test cases:

### E2E tests

TV test - adding the cheapest TV to the cart. In the cart, adding one more TV and checking that the price has doubled.

### Login and registration tests

Registration of a new user - a new user is successfully registered ("happy path").

Invalid format of an email in registration - a new user enters invalid format of email while filling in the registration form and gets a propre notification.

Login by an account of third parties - a user signing in with an account of a third party (Google, Apple, Seznam, MojeId) is directed to the correct login page.

### My Alza tests

Navigation of the MyAlza menu works correctly  - when navigating to the Comparison page.

### Comparison page tests

Products can be searched, added for a comparison and deleted from.

### Cart tests

A charity item can be selected and added to the cart.




### Concept of the inheritance of classes and tests applied.

### Waits methods used:

Thread.sleep

Explicit Waits

### JU unit assertion methods used:

assertTrue

assertEquals

### Unique situations:

Scrolling (JavaScriptExecutor)

Cookie Management

### Other Selenium concepts:

Navigation .to, .back

Element interactions .click, .sendKeys, . getText, .getAttribute

Element Information .isDisplayed, .isSelected

Menu Handling (creating a select object for dropdowns, select by index)


