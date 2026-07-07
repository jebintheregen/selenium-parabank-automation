# 🚀 Selenium Cucumber BDD Automation Framework - ParaBank

## 📌 Project Overview

This project is a **Hybrid Selenium Automation Framework** developed to automate the core functionalities of the **ParaBank Demo Banking Application**.

The framework follows the **Behavior Driven Development (BDD)** approach using **Cucumber**, making test scenarios easy to understand, maintain, and execute. It combines the power of **Selenium WebDriver**, **Java**, **TestNG**, **Cucumber**, and **Maven** to create a scalable automation testing solution.

---

## 🌐 Application Under Test

**ParaBank Demo Website**

🔗 https://parabank.parasoft.com

---

## 🛠️ Tech Stack

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- WebDriverManager
- ChromeDriver

---

## ✨ Framework Features

- ✅ Behavior Driven Development (BDD) using Cucumber
- ✅ Feature files written in Gherkin language
- ✅ Step Definition implementation
- ✅ TestNG integration
- ✅ Hooks for test setup and teardown
- ✅ Maven dependency management
- ✅ Reusable automation code
- ✅ Screenshot capture during test execution
- ✅ Organized project structure

---

## ✅ Automated Test Scenarios

- User Registration
- User Login
- Open New Account
- Fund Transfer
- Loan Request

---

## 📂 Project Structure

```text
selenium-parabank-automation
│
├── src
│   ├── main
│   │   └── java
│   │
│   └── test
│       ├── java
│       │   ├── hooks
│       │   │   └── Hooks.java
│       │   │
│       │   ├── runners
│       │   │   └── TestRunner.java
│       │   │
│       │   ├── stepdefinitions
│       │   │   ├── LoginSteps.java
│       │   │   ├── RegisterSteps.java
│       │   │   ├── FundTransferSteps.java
│       │   │   └── LoanRequestSteps.java
│       │   │
│       │   └── parabankTestCases
│       │       ├── LoginTest.java
│       │       ├── RegisterTest.java
│       │       ├── FundTransferTest.java
│       │       └── LoanRequestTest.java
│       │
│       └── resources
│           ├── Features
│           │   ├── login.feature
│           │   ├── register.feature
│           │   ├── fundtransfer.feature
│           │   └── loanrequest.feature
│           │
│           └── ScreenShots
│
├── pom.xml
└── README.md
```

---

## ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/jebintheregen/selenium-parabank-automation.git
```

### 2️⃣ Open the project

Open the project using Eclipse, IntelliJ IDEA, or any Java IDE.

### 3️⃣ Install Dependencies

Maven will automatically download the required dependencies.

### 4️⃣ Execute the Tests

Run the following Cucumber Test Runner:

```
TestRunner.java
```

or execute using Maven:

```bash
mvn clean test
```

---

## 📸 Test Execution

The framework captures screenshots during test execution.

Sample screenshots are available in:

```
src/test/resources/ScreenShots
```

---

## 🎯 Key Highlights

- Developed a Selenium Automation Framework using Java
- Integrated Cucumber for Behavior Driven Development (BDD)
- Automated multiple end-to-end banking workflows
- Implemented reusable Step Definitions and Hooks
- Structured Feature Files using Gherkin syntax
- Managed dependencies using Maven
- Improved readability and maintainability through BDD
- Captured execution screenshots for validation

---

## 🚀 Future Enhancements

- Extent Reports
- Allure Reports
- Jenkins CI/CD Integration
- Cross-browser testing
- Docker support
- GitHub Actions CI
- Parallel test execution

---

## 👨‍💻 Author

**Jebin S**

- 💼 LinkedIn: www.linkedin.com/in/jebin-s-61176b24a
- 💻 GitHub: https://github.com/jebintheregen

---

## ⭐ Conclusion

This project demonstrates a real-world Selenium Automation Framework built using Java, Selenium WebDriver, Cucumber BDD, TestNG, and Maven. It showcases automation framework design, reusable test development, and end-to-end functional testing of a banking application while following industry-standard automation practices.
