# Alza test framework in Selenium with Java. Using page object model.

## Test cases:

### E2E tests

TV test - adding the cheapest TV to the cart. In the cart, adding one more TV and checking that the price has doubled.

### Login and registration tests

Registration of a new user - a new user is successfully registered ("happy path").

Invalid format of an email in registration - a new user enters invalid format of email while filling in the registration form.

Login by an account of third parties - a user signing in with an account of a third party (Google, Apple, Seznam, MojeId) is directed to the correct login page.




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
