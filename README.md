# 📝 Todo App – Automated Testing Project

A professional test automation project for the **QACart Todo Web Application**, built with **Selenium WebDriver**, **TestNG**, and **REST Assured** — covering both UI and API test scenarios with full **Allure reporting** and **GitHub Actions CI/CD** integration.

---

## 📌 Project Overview

| Property       | Details                                      |
|----------------|----------------------------------------------|
| **Application Under Test** | QACart Todo App                  |
| **Language**   | Java 21                                      |
| **Build Tool** | Maven                                        |
| **UI Framework** | Selenium WebDriver 4.43.0                  |
| **API Framework** | REST Assured 6.0.0                        |
| **Test Runner** | TestNG 7.12.0                               |
| **Reporting**  | Allure Reports 2.29.0                        |
| **Execution**  | Parallel (methods, 3 threads)                |
| **CI/CD**      | GitHub Actions                               |

---

## 🧪 Test Scope

### ✅ LoginTest
Covers all authentication-related scenarios including:
- Successful login with valid credentials
- Login failure with invalid username or password
- Login with empty fields
- Session handling and redirect validation

### ✅ TodoTest
Covers all core Todo functionality including:
- Add a new Todo item
- Mark a Todo item as complete
- Delete a Todo item
- Validate Todo list state after operations
- Boundary and negative test scenarios

---

## 🗂️ Project Structure

```
TodoAppProject/
├── .github/
│   └── workflows/              # GitHub Actions CI/CD pipeline
├── src/
│   └── test/
│       └── java/
│           └── com/qacart/todo/
│               ├── testcases/
│               │   ├── LoginTest.java
│               │   └── TodoTest.java
│               ├── pages/      # Page Object Model classes
│               ├── api/        # REST Assured API helpers
│               └── utils/      # Utilities and helpers
├── allure-results/             # Raw Allure test results
├── allure-report/              # Generated Allure HTML report
├── testng.xml                  # TestNG suite configuration
└── pom.xml                     # Maven dependencies and plugins
```

---

## 🛠️ Tech Stack & Dependencies

| Dependency              | Version   | Purpose                              |
|-------------------------|-----------|--------------------------------------|
| Selenium Java           | 4.43.0    | Browser automation                   |
| WebDriverManager        | 6.3.3     | Auto browser driver management       |
| TestNG                  | 7.12.0    | Test framework and runner            |
| REST Assured            | 6.0.0     | API test validation                  |
| Allure TestNG           | 2.29.0    | Test reporting                       |
| Java Faker              | 1.0.2     | Dynamic test data generation         |
| AspectJ Weaver          | 1.9.25.1  | Allure annotation support            |
| SLF4J Simple            | 2.0.17    | Logging                              |

---

## ⚙️ Prerequisites

Before running the project, make sure you have installed:

- ✅ **Java JDK 21** — [Download](https://www.oracle.com/java/technologies/downloads/)
- ✅ **Maven 3.8+** — [Download](https://maven.apache.org/download.cgi)
- ✅ **Allure CLI** (optional, for local report generation) — [Install Guide](https://docs.qameta.io/allure/#_installing_a_commandline)
- ✅ **Google Chrome** (or any supported browser)

---

## 🚀 How to Run

### Run all tests
```bash
mvn clean test
```

### Run a specific test class
```bash
mvn clean test -Dtest=LoginTest
mvn clean test -Dtest=TodoTest
```

### Run via TestNG suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 📊 Allure Report

### Generate and open the report locally
```bash
# After running tests
allure serve allure-results
```

### Generate a static report
```bash
allure generate allure-results --clean -o allure-report
allure open allure-report
```

The Allure report includes:
- Test execution summary (passed / failed / skipped)
- Step-by-step test breakdown
- Epic → Feature → Story hierarchy
- Screenshots on failure (if configured)
- Timeline and trend charts

---

## 🔄 CI/CD – GitHub Actions

This project includes a GitHub Actions workflow that automatically:

1. Triggers on every **push** or **pull request** to `main`
2. Sets up Java 21 and Maven
3. Runs the full test suite
4. Publishes the Allure report as a build artifact

The workflow file is located at:
```
.github/workflows/
```

---

## 🧵 Parallel Execution

Tests are configured to run in parallel at the **method level** with **3 threads** for faster execution:

```xml
<suite name="TodoApp Suite" parallel="methods" thread-count="3">
```

This is managed via `testng.xml` and the Maven Surefire plugin configuration in `pom.xml`.

---

## 🎯 Design Patterns Used

- **Page Object Model (POM)** — separates UI locators and actions from test logic
- **Data-Driven Testing** — dynamic test data generated using Java Faker
- **API + UI Hybrid** — REST Assured used alongside Selenium for end-to-end coverage

---

## 👤 Author

**Antonios Gerges Hakim Eskandar**  
Software QA Engineer  
📧 antoniosgerges94@gmail.com  
🔗 [linkedin.com/in/antonios-eskandar](https://linkedin.com/in/antonios-eskandar)  
🐙 [github.com/antoniosgerges94](https://github.com/antoniosgerges94)

---
