# Selenium CI

[![Selenium - CI](https://github.com/danialtavakoli/selenium-ci/actions/workflows/maven.yml/badge.svg)](https://github.com/danialtavakoli/selenium-ci/actions/workflows/maven.yml)
![Java 17](https://img.shields.io/badge/Java-17-blue)
![Selenium 4](https://img.shields.io/badge/Selenium-4.44-43B02A)
![JUnit 5](https://img.shields.io/badge/JUnit-5-25A162)

End-to-end UI test suite for a web login form, written with **Selenium WebDriver**, **JUnit 5** and the **Page Object Model**, and executed headlessly on every push through **GitHub Actions**.

The system under test is the public demo page
[bonigarcia.dev/selenium-webdriver-java/login-form.html](https://bonigarcia.dev/selenium-webdriver-java/login-form.html).

## What it demonstrates

- **Page Object Model**: locators and page interactions live in `POs/`, test intent lives in `tests/`.
- **Driver lifecycle management** in a reusable base class (`DriverLifeCycle`): a fresh headless Chrome per test, always cleaned up with `driver.quit()`.
- **Test scenarios**
  - valid credentials -> success message is shown
  - invalid credentials -> error message is shown
  - empty fields -> error message is shown
- **Continuous Integration**: GitHub Actions installs JDK 17 and Chrome, caches Maven dependencies and runs `mvn clean test` on each push and pull request.

## Project structure

```
src/test/java
├── POs
│   ├── LoginFormPO.java       # login page: fill form, submit, read error box
│   └── LoginSuccessPO.java    # post-login page: read success box
└── tests
    ├── DriverLifeCycle.java   # @BeforeEach / @AfterEach WebDriver setup and teardown
    └── LoginTest.java         # test cases
.github/workflows/maven.yml    # CI pipeline
```

## Tech stack

Java 17 · Maven · Selenium WebDriver 4 · JUnit Jupiter 5 · Headless Chrome · GitHub Actions

## Run locally

Prerequisites: JDK 17+, Maven 3.9+ and Google Chrome (Selenium Manager downloads a matching driver automatically).

```bash
git clone https://github.com/danialtavakoli/selenium-ci.git
cd selenium-ci
mvn clean test
```

Test reports are written to `target/surefire-reports/`.

## CI pipeline

`.github/workflows/maven.yml` runs on every push and pull request to `master`:

1. Check out the code
2. Set up Temurin JDK 17 with Maven dependency caching
3. Install Chrome
4. `mvn -B clean test`
