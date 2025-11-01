
# 📱 Givers - Cross-Platform Mobile Test Automation Framework

A *scalable and maintainable hybrid mobile UI automation framework* for *Android* and *iOS, built using **Java + Appium v3 + TestNG, designed with **Page Object Model (POM)* architecture and enhanced by *Allure reporting* and *Log4j2 logging*.

---

## 📦 Project Structure & Layered Architecture



## 🧠 Design Overview

- *Cross-Platform Support:* Unified architecture for Android and iOS.  
- *Page Object Model (POM):* Maintains separation between test logic and UI locators.  
- *Screen Factory Pattern:* Automatically initializes platform-specific screens at runtime.  
- *Thread-Safe Assertions & Logging:* Clean and isolated execution per test thread.  
- *Scalable Structure:* Easy to extend for new features or integrations.  


Givers/
│
├── pom.xml                       # Maven configuration and dependencies
│
├── test_runners/
│   ├── AndroidTestSuite.xml       # Android test suite
│   ├── CrossPlatformTestSuite.xml # Runs Android & iOS in parallel
│   └── IosTestSuite.xml           # iOS test suite
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── listeners/        # Retry logic, event listeners, reporting hooks
│   │       ├── screens/
│   │       │   ├── android/      # Android-specific screen implementations
│   │       │   ├── ios/          # iOS-specific screen implementations
│   │       │   ├── base/         # Common interfaces for both platforms
│   │       │   └── screenFactory/ # Factory to instantiate the correct screen
│   │       ├── utils/
│   │       │   ├── appium/       # Appium driver management and waits
│   │       │   ├── android/ios/  # Platform-specific utilities
│   │       │   └── common/       # Logging, assertions, file I/O
│   │
│   └── resources/
│       ├── Env/                  # Android & iOS config files
│       └── *.properties          # Allure, Log4j2, and test configuration
│
├── src/test/
│   ├── java/
│   │   ├── testClasses/          # (Reserved for TestNG test classes)
│   │   └── utils/                # DataProviders, data models, test factories
│   └── resources/
│       └── *.json                # (Reserved for test data files)



## 🧩 Core Components

- *Appium Driver Management*  
  - Supports Appium v3 server and drivers.  
  - Centralized driver setup for Android and iOS.

- *Listeners & Retry Logic*  
  - Retry mechanism for flaky tests.  
  - Custom TestNG listeners for lifecycle control.

- *Custom Logging (Log4j2)*  
  - Real-time console and file logs.  
  - Integrated with Allure for traceable execution.

- *Allure Reporting*  
  - Visual representation of test results.  
  - Dynamic test metadata (labels, story IDs, descriptions).

- *Configuration Management*  
  - Environment-specific setup under /Env.  
  - Test behavior configurable via .properties files.  

---

## ⚙ How to Run

### 🧩 Prerequisites

- Java JDK 23+  
- Maven 3.6+  
- Node.js  
- Appium v3 (CLI or Appium Desktop)  
- Android Emulator / iOS Simulator or real devices  

### 🚀 Commands

| Profile   | Description           | Test Suite                                |
|-----------|---------------------|------------------------------------------|
| default   | Cross-platform execution | test_runners/CrossPlatformTestSuite.xml |
| android   | Android-only suite      | test_runners/AndroidTestSuite.xml      |
| ios       | iOS-only suite          | test_runners/IosTestSuite.xml          |

Run from terminal:

```bash
# Cross-platform
mvn clean test

# Android only
mvn clean test -Pandroid

# iOS only
mvn clean test -Pios
