# Honest Foods Assignment

Kindly Naviagate to src/main/resources/testsettings.properties file for test data operations

### Architecture:

- Current framework follows Page Object Model design pattern.
- src/main/java - contains source code related to element locators and feature interactions.
- src/test/java - contains tests with pre and post conditions defined using TestNG annotations
- testng_test.xml is the entry point of execution
- TestBase has browser and run definitions. Used WebDriver Manager to overcome issues with conifguration of browser config related ambiguities

### Extended Implementations possible
(Could be configured and ignored for now due to time constraints):
    
    Reporting Schema.
    Data Providers.
    Configuring a pipeline and post build email trigger for getting automated updates over quality of the build.

### Execution

1. Clone repo and import the project into IntelliJ/ Import the project from GIT (VCS) in IntelliJ / IDE of your choice,=.
2. Open terminal and use below mvn command to kick start the execution

```sh
mvn test
```

### Artifacts

   [Please click here to view test execution video](https://drive.google.com/file/d/1sGMPN9aJ_tZYMMZtll_w68_sBh-elpsF/view?usp=sharing)