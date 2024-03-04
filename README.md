# Appium Mobile Automation Project

## Overview

This repository contains automated tests using Appium for mobile application testing. I used this android app for test purposes in automation tests [Android App](https://github.com/saucelabs/sample-app-mobile/releases)

## Tech Stack

- Java
- Appium
- Cucumber
- TestNG
- Extent Reports

## Project Structure

- **stepdefs**: Contains step definitions for Cucumber scenarios.
  
- **pages**: Contains page objects representing different pages of the mobile application.
  
- **utils**: Contains utility classes.
  - `AppiumDriverFactory.java`: Provides methods to initialize the Appium driver.
  - `CommonHelpers.java`: Provides common helper methods for interacting with elements on the mobile application.

## Running the Tests

To run the automated tests, follow these steps:

1. Set up your Appium environment and ensure the necessary dependencies are installed.
2. Clone this repository to your local machine.
3. Open the project in your preferred IDE.

## How to Run?

To install the dependencies in the project;

```bash
  mvn clean install
```
To run all the tests in the project;
```bash
  mvn test
```
To run scenarios with specific tags;
```bash
  mvn test  -Dcucumber.filter.tags="@Case1"
```


## How to Write Tests?

It would be better to look at the structure of the project in tree format to understand the structure of the project.

In this automation project written using Page Object Model, we create our modeled objects under "pages". For example, if the "LoginPage" page is to be modeled, we add it separately under "pages > page". However, if there is a common model, we move it to the "common" folder. As a common model, you can think of a menu in the header, for example.


```bash
Appium_Test_Automation_Project
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│   │   │   ├── stepdefs
│   │   │   │   └── ProductsStepDef.java
│   │   │   ├── pages
│   │   │   │   └── ProductsPage.java
│   │   │   └── utils
│   │   │       ├── AppiumDriverFactory.java
│   │   │       └── CommonHelpers.java│       
└── resources
│           └── Apps
│           └── Features
├── README.md
├── pom.xml
└── (other project files)

```

### Step Definition Structure
As noticed from the tree structure, each Step Definition file has a corresponding PageObject file. The approach we take here is to keep Step Definition files cleaner. For this, there are two different approaches in step definition files.

The first one is to access the PageObject file and take a specific action;
```bash
   @When("I log in with lockedout user credentials")
    public void iLogInWithLockedoutUserCredentials() {
        loginPage.inputUserCredentials(dataProperty.getLockedoutUsername(), dataProperty.getLockedoutPassword());}
```

The second one is to use Assert to verify the data in the method called from the PageObject file;
```bash
    @Then("I should see lockedout error message")
    public void iShouldSeeLockedoutErrorMessage() {
        Assert.assertEquals(dataProperty.getLockedoutUserErrorMessage(),loginPage.getLoginErrorMessage());}
```

### PageObject Structure
In PageObject files, we create a WebElement with a selector for the area we want to model as shown in the code block below.
```bash
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement LoginButton;
```
Then, we model the relevant page with PageFactory and return the page's part with the selected selector as a model.
```bash
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

```
And as in the example below, we can perform the relevant operations through this method we return.
```bash
    public void inputUserCredentials(String username, String password){
        Username.sendKeys(username);
        Password.sendKeys(password);
        LoginButton.click();
    }
```
### Reporting
I preferred [Extent Reports](https://www.extentreports.com/) for reporting test case results. You can check the test-output file after running test cases.


### Note
 According to the Page Object Model structure, validation (Assert) operations should not be performed in PageObject files. All of these should be in Step Definition files. This is the appropriate approach for clean code and to prevent irrelevant Assert operations from being repeated each time the object is called.

