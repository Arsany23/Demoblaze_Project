# Demoblaze Project

## Overview
Demoblaze_Project is a **test automation framework** designed for web UI testing using **Selenium WebDriver, TestNG, and Cucumber**. The project integrates **ExtentReports** for test reporting and follows **Behavior-Driven Development (BDD)** principles using **Cucumber**.

## Tech Stack
- **Java** (JDK 23)
- **Maven** (Project Management & Dependency Management)
- **Selenium WebDriver** (Web UI Testing)
- **TestNG** (Test Execution & Assertions)
- **Cucumber** (Behavior-Driven Development)
- **ExtentReports** (Test Reporting)

## Prerequisites
Ensure you have the following installed before setting up the project:
- Java Development Kit (**JDK 23** or higher)
- Apache **Maven** (latest version)
- An **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)
- Google Chrome (or any preferred browser)

## Installation & Setup
### 1. Clone the Repository
```bash
git clone https://github.com/your-repo/Demoblaze_Project.git
cd Demoblaze_Project
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run Tests
#### Using Maven
```bash
mvn test
```

#### Using TestNG
Run the `testng.xml` file in your IDE.

#### Using Cucumber
Execute:
```bash
mvn test -Dcucumber.options="src/test/resources/features"
```

## Project Structure
```
Demoblaze_Project/
│-- src/
│   ├── main/java/               # Application code (if any)
│   ├── test/java/
│   │   ├── stepDefinitions/     # Cucumber step definitions
│   │   ├── testRunners/         # Test execution runners
│   │   ├── pages/               # Page Object Model (POM) classes
│   ├── test/resources/
│   │   ├── features/            # Cucumber feature files
│   │   ├── config/              # Configuration files
│-- pom.xml                      # Maven dependencies
│-- README.md                    # Project documentation
```

## Dependencies
The `pom.xml` file includes the following dependencies:
- **Selenium Java** `4.27.0`
- **TestNG** `7.10.2`
- **Cucumber Java & TestNG** `7.20.1`
- **ExtentReports Cucumber Adapter** `1.14.0`
- **SLF4J Simple Logger** `2.0.9`

## Reporting
- Test execution reports are generated using **ExtentReports**.
- Reports can be found in the `target/reports/` directory after test execution.

## Contribution Guidelines
1. Fork the repository.
2. Create a new feature branch (`feature-branch-name`).
3. Commit your changes (`git commit -m "Add new feature"`).
4. Push to your forked repository (`git push origin feature-branch-name`).
5. Create a pull request.

## License
This project is licensed under the MIT License.

## Contact
For any issues, feel free to create a GitHub issue or reach out to **Arsany** at **arsanyelkess12@gmail.com**.

