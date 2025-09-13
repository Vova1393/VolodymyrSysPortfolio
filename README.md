Portfolio Project: SauceDemo Test Automation

Automation testing project built with **Java**, **Selenium WebDriver**, and **TestNG** using the **Page Object Model (POM)** design pattern.  
This repository is part of my QA Automation portfolio and demonstrates skills in **UI test automation, reporting, and logging**.

---

Tech Stack
- **Java 17**
- **Maven** – build & dependency management
- **Selenium WebDriver** – browser automation
- **TestNG** – test framework
- **Allure Reports** – test reporting
- **Log4j2** – logging

---

Project Structure
```
src
 ├── main
 │   └── resources
 │       └── log4j2.xml       # Logging configuration
 └── test
     └── java
         ├── linear           # Simple linear tests
         ├── pages            # Page Object Model classes
         ├── pom              # Example of POM tests
         ├── saucedemo.base   # Base test setup
         ├── screenshot       # Screenshot utilities
         ├── tables           # Data models
         └── RelativeLocators # Example with relative locator
```

Implemented Features
- Login tests (valid/invalid credentials)
- Adding/removing products from the cart
- Validating cart summary
- UI interaction with Selenium locators
- Logging each step of execution
- Generating **Allure Reports**
- Taking screenshots on failures

---

Reports
After running the tests, generate an **Allure Report**:  
```bash
allure serve allure-results
