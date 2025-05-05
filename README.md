# Selenium TestNG Web Automation Framework for SauceLab E-Commerce Site

This is a Java-based Selenium web automation framework using **TestNG** for test execution, **Maven** for build management, and **Allure** for generating rich test reports. The framework is also integrated with **GitHub Actions** for continuous integration and reporting.

## 📂 Project Structure

├── src
│ ├── main
│   └── java
│    └── pages # Locators and Method Implementations
│    └── utils # Custom Methods
│   └── resources # log
│ ├── test
│   └── java
│     └── tests # Test classes
│     └── utils # Config Reader and Listeners
|   └── resources 
│     └── testng.xml # TestNG suite configuration
|     └── config.properties # Stored Data
├── pom.xml
├── .github
│ └── workflows
│ └── main.yml # GitHub Actions workflow

## ⚙️ Features

- 🚀 Automated smoke test suite using **Selenium WebDriver**
- 🧪 Test management with **TestNG**
- 📦 Dependency management with **Maven**
- 📊 Beautiful test reports with **Allure**
- 🔁 Continuous Integration with **GitHub Actions**
- 🧹 Clean, modular base test structure for easy scalability

## 🛠️ Prerequisites

- Java 8 or above
- Maven
- Node.js (optional, for serving reports locally)
- Allure CLI (see below)

## 🧪 Running Tests Locally

## 1. Clone the repository  
## 2. Run tests:
      mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
## 3. Install Allure CLI
      brew install allure
## 4. Generate and Serve Report
      allure generate allure-results --clean -o allure-report
      allure serve allure-results

⚙️ GitHub Actions CI
Every push or PR to the main branch triggers the workflow:

1. Installs Java, Maven, browsers, and drivers
2. Runs Selenium tests
3. Generates and uploads Allure test report as an artifact
4. You can find the results under the Actions tab on GitHub.

📁 Allure Artifacts
allure-results: Raw test data files

allure-report: Generated HTML report

## Download the artifacts from GitHub → unzip → run locally with:
    allure serve allure-results




 
